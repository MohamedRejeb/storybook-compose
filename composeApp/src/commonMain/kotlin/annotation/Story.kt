package annotation

@Target(AnnotationTarget.FUNCTION)
annotation class Story(
    val title: String = "",
)
