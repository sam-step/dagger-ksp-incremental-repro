plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kspPlugin)
    application
}

dependencies {
    implementation(project(":processor-generate-module"))
    implementation(libs.dagger)

    ksp(project(":processor-generate-module"))
    ksp(libs.daggerCompiler)
}

application {
    mainClass = "app.AppKt"
}
