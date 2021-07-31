package com.peterstaranchuk.composeplayground

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.peterstaranchuk.composeplayground.ui.theme.JetpackComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                Conversation(messages = SampleData.conversationSample)
            }
        }
    }

    @Composable
    fun MessageCard(message: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.photo),
                contentDescription = "This is my photo",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor : Color by animateColorAsState(
                targetValue = if(isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
            )
            Column(
                modifier = Modifier.clickable {
                    isExpanded = !isExpanded
                }
            ) {
                Text(
                    text = message.title,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp),
                    elevation = 1.dp) {
                    Text(
                        text = message.description,
                        color = if(isExpanded) Color.White else Color.Black,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(all = 8.dp),
                        maxLines = if(isExpanded) Int.MAX_VALUE else 1
                    )
                }

            }
        }
    }

    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark mode"
    )

    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_NO,
        showBackground = true,
        name = "Light mode"
    )

    @Preview
    @Composable
    fun PreviewConversation() {
        JetpackComposePlaygroundTheme {
            Conversation(messages = SampleData.conversationSample)
        }
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        JetpackComposePlaygroundTheme {
            MessageCard(
                Message(
                    "Jetpack Compose Playground Test",
                    "Here is the example of JC usage Test"
                )
            )
        }
    }

    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(
                count = messages.size,
                { index -> index },
                { index ->
                    MessageCard(messages[index])
                }
            )
        }
    }
}

