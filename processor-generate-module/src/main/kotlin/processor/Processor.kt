package processor

import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import kotlin.sequences.forEach

class ProcessorProvider : SymbolProcessorProvider {
    override fun create(
        environment: SymbolProcessorEnvironment,
    ): SymbolProcessor = Processor(environment)
}

internal class Processor(
    private val environment: SymbolProcessorEnvironment,
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        resolver
            .getSymbolsWithAnnotation("app.TargetAnnotation")
            .filterIsInstance<KSClassDeclaration>()
            .forEach { declaration ->
                val generatedName = "Generated_${declaration.simpleName.asString()}Module"
                environment
                    .codeGenerator
                    .createNewFile(
                        dependencies = Dependencies(aggregating = false, declaration.containingFile!!),
                        packageName = "app.generated",
                        fileName = generatedName,
                    )
                    .writer()
                    .use {
                        it.write(
                            """
                                package app.generated

                                @dagger.Module
                                class $generatedName {
                                  @dagger.Provides
                                  fun provide(): app.ClassProvidedByGeneratedModule = app.ClassProvidedByGeneratedModule()
                                }
                            """.trimIndent()
                        )
                    }
            }
        return emptyList()
    }
}
