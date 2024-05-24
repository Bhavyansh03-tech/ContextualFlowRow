package com.example.contextualflowrow

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