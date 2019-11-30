package Buildings

import kotlin.reflect.full.findAnnotation

@IAMPlant
class Plant {
    fun trim() {}

    @get: OnGet
    val isGrowing: Boolean = true

    @set: OnSet
    var needsFood: Boolean = true
}

annotation class IAMPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun main() {
    val classObj = Plant::class
    for (annotation in classObj.annotations) {
        println(annotation.annotationClass.simpleName)
    }
    val annotated = classObj.findAnnotation<IAMPlant>()
    annotated?.apply { println("Find IAMPlant") }
}