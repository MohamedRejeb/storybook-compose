package component

import story.Story

class Component(
    val name: String,
    val stories: List<Story>,
)

fun component(
    name: String,
    vararg stories : Story,
): Lazy<Component> =
    lazy {
        Component(
            name = name,
            stories = stories.toList(),
        )
    }