package app

fun main() {
    val component = MyComponent.create()
    component.classProvidedByGeneratedModule().doSomething()
    component.otherClass().doWork()
}
