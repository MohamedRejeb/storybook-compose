package components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import component.component
import story.story

@Composable
fun MyButton(
    text: String,
) {
    Button(
        onClick = {}
    ) {
        Text(
            text = text,
        )
    }
}

val MyButtonWithTheDefaultText by story(
    title = "My button with the default text",
) {
    MyButton(
        text = "Click me",
    )
}

val MyButtonComponent by component(
    name = "MyButton",
    MyButtonWithTheDefaultText,
)
