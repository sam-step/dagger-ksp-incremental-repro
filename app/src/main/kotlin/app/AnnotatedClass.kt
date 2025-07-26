package app

/**
 * `:processor-generate-module` will take this class and generate:
 *
 * ```
 * package app.generated
 *
 * @dagger.Module
 * class Generated_AnnotatedClassModule {
 *   @dagger.Provides
 *   fun provide(): app.ClassProvidedByGeneratedModule = app.ClassProvidedByGeneratedModule()
 * }
 * ```
 *
 * which is installed in MyComponent.
 */
@TargetAnnotation
class AnnotatedClass
