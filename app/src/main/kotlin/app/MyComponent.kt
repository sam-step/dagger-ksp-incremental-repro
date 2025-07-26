package app

import dagger.Component

@Component(modules = [app.generated.Generated_AnnotatedClassModule::class])
interface MyComponent {
    fun classProvidedByGeneratedModule(): ClassProvidedByGeneratedModule
    fun otherClass(): OtherClass

    companion object {
        fun create(): MyComponent = DaggerMyComponent.create()
    }
}
