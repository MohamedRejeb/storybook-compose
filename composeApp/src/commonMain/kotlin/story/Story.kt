package story

import androidx.compose.runtime.Composable

interface Story {
    val title: String

    val content: @Composable () -> Unit
}

class StoryImpl(
    override val title: String,
    override val content: @Composable () -> Unit,
) : Story

fun story(
    title: String,
    content: @Composable () -> Unit,
): Lazy<Story> =
    lazy {
        StoryImpl(
            title = title,
            content = content,
        )
    }
