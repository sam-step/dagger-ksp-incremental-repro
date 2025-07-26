package app

import javax.inject.Inject

class OtherClass @Inject constructor() {
    fun doWork() {
        // Making any change here after build to trigger incremental compilation.
        // We see the following files are dirty:
        //  src/main/kotlin/app/OtherClass.kt
        //  src/main/kotlin/app/MyComponent.kt
        //  src/main/kotlin/app/Server.kt
        println("Doing work in OtherClass")
    }
}
