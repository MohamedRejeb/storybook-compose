package components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import component.component
import story.story

@Composable
fun Task(
    id: String,
    title: String,
    state: String,
) {
    Column {
        Text(
            text = title,
        )

        Text(
            text = state,
        )
    }
    TaskWithTheDefaultState.content
}

val TaskWithTheDefaultState by story(
    title = "Task with the default state",
) {
    Task(
        id = "1",
        title = "Task 1",
        state = "To Do",
    )
}

val TaskWithTheDoneState by story(
    title = "Task with the done state",
) {
    Task(
        id = "2",
        title = "Task 2",
        state = "Done",
    )
}

val TaskWithTheInProgressState by story(
    title = "Task with the in progress state",
) {
    Task(
        id = "3",
        title = "Task 3",
        state = "In Progress",
    )
}

val TaskComponent by component(
    name = "Task",
    TaskWithTheDefaultState,
    TaskWithTheDoneState,
    TaskWithTheInProgressState,
)