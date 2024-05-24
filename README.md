
# Contextual Flow Row

This project demonstrates the implementation of a ContextualFlowRow using Jetpack Compose.

 ContextualFlowRow is a specialized version of the FlowRow layout. It is designed to enable users to make contextual decisions during the construction of FlowRow layouts. 
 
The ContextualFlowRow component is designed to be used with :

androidx.compose.foundation:foundation:1.7.0-beta01.

Note that it requires version 1.7.0-beta01 and will not work with earlier versions.



## Features

- This component is particularly advantageous when dealing with a large collection of items, allowing for efficient management and display.
- Unlike traditional FlowRow that composes all items regardless of their visibility, ContextualFlowRow smartly limits composition to only those items that are visible within its constraints, such as maxLines or maxHeight.
- This approach ensures optimal performance and resource utilization by composing fewer items than the total number available, based on the current context and display parameters.

## Screenshots

<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://github.com/Bhavyansh03-tech/ContextualFlowRow/assets/96388594/3bc4414b-058b-4b84-8e91-58f566d7625e" alt="First Flow Row" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/Bhavyansh03-tech/ContextualFlowRow/assets/96388594/4304fb7b-78a7-40af-a1aa-36c11555d0ed" alt="Second Flow Row" style="width: 200px; height: auto;">
</div>

## Getting Started

### Prerequisites
- Android Studio installed on your computer.
- An Android device or emulator to run the app.
### Installation

To use the `ContextualFlowRow` in your project, follow these steps:

1.> Ensure that your project is set up to use Jetpack Compose.

2.> Add the necessary dependency to your build.gradle file:

```bash
  dependencies {
    implementation "androidx.compose.foundation:foundation:1.7.0-beta01"
}

```
## Usage

Here is an example of how to use ContextualFlowRow in your composable functions:

```bash
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

const val DEFAULT_MAX_LINES = 2

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RowFlow() {

    val languages = listOf(
        "Kotlin",
        "Java",
        "Python",
        "C++",
        "C#",
        "JavaScript",
        "Swift",
        "Ruby",
        "Go",
        "Rust",
        "PHP",
        "Scala",
        "TypeScript",
        "Objective-C",
        "Perl"
    )

    // Creating state to remember lines displayed :->
    var maxLines by remember { mutableIntStateOf(DEFAULT_MAX_LINES) }

    // Creating flow now :->
    ContextualFlowRow(
        modifier = Modifier
            .animateContentSize()
            .padding(8.dp),
        itemCount = languages.size,
        maxLines = maxLines,
        overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
            expandIndicator = {
                TextButton(
                    onClick = { maxLines += 1 },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.surfaceVariant,
                        containerColor = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    Text(text = "${this@expandOrCollapseIndicator.totalItemCount - this@expandOrCollapseIndicator.shownItemCount}+ more")
                }
            },
            collapseIndicator = {
                TextButton(
                    onClick = {maxLines = DEFAULT_MAX_LINES},
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.errorContainer,
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                    Text(text = "Hide")
                }
            }
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) { index ->
        Button(onClick = {}){
            Text(text = languages[index])
        }
    }
}
```

## Code Snippet

Here is the example of how to use ContextualFlowRow:

```bash
  ContextualFlowRow(
        modifier = Modifier
            .animateContentSize()
            .padding(8.dp),
        itemCount = languages.size,
        maxLines = maxLines,
        overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
            expandIndicator = {
                TextButton(
                    onClick = { maxLines += 1 },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.surfaceVariant,
                        containerColor = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    Text(text = "${this@expandOrCollapseIndicator.totalItemCount - this@expandOrCollapseIndicator.shownItemCount}+ more")
                }
            },
            collapseIndicator = {
                TextButton(
                    onClick = {maxLines = DEFAULT_MAX_LINES},
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.errorContainer,
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                    Text(text = "Hide")
                }
            }
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) { index ->
        Button(onClick = {}){
            Text(text = languages[index])
        }
    }
```


## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

1.> Fork the Project.\
2.> Create your Feature Branch `git checkout -b feature/AmazingFeature`.\
3.> Commit your Changes `git commit -m 'Add some AmazingFeature'`.\
4.> Push to the Branch `git push origin feature/AmazingFeature`.\
5.> Open a Pull Request

## Acknowledgements

- Inspiration from various Android development tutorials and documentation.
## Contact

For questions or feedback, please contact [@Bhavyansh03-tech](https://github.com/Bhavyansh03-tech).
