package annotation

@Target(AnnotationTarget.FUNCTION)
annotation class Component(
    val title: String = "",
)
