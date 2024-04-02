import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import components.MyButtonComponent
import components.TaskComponent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val components = remember {
        listOf(
            TaskComponent,
            MyButtonComponent,
        )
    }

    var selectedComponent by remember {
        mutableStateOf(components.first())
    }

    MaterialTheme {
        Row(
            verticalAlignment = Alignment.Top,
            modifier= Modifier
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(20.dp)
            ) {
                components.forEach { component ->
                    val isSelected = component == selectedComponent

                    ClickableText(
                        text = AnnotatedString(component.name),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color =
                            if (isSelected)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.onSurface,
                            textDecoration =
                            if (isSelected)
                                TextDecoration.Underline
                            else
                                TextDecoration.None,
                        ),
                        onClick = {
                            selectedComponent = component
                        },
                    )
                }
            }

            VerticalDivider()

            LazyColumn(
                modifier = Modifier
                    .weight(5f)
                    .padding(20.dp)
            ) {
                item {
                    Text(
                        text = selectedComponent.name,
                        style = MaterialTheme.typography.headlineLarge,
                    )
                    HorizontalDivider()
                }

                items(selectedComponent.stories) { story ->
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = story.title,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 10.dp),
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(start = 10.dp),
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.medium)
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(20.dp)
                    ) {
                        story.content()
                    }
                }
            }
        }
    }
}