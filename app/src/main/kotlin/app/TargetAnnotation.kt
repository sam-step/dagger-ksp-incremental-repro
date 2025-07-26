package app

import kotlin.annotation.AnnotationRetention.BINARY
import kotlin.annotation.AnnotationTarget.CLASS

@Target(CLASS)
@Retention(BINARY)
annotation class TargetAnnotation