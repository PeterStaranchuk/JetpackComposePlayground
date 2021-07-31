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
import com.peterstaranchuk.composeplayground.ui.views.ConversationView
import com.peterstaranchuk.composeplayground.ui.views.MessageCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                ConversationView(messages = SampleData.conversationSample)
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
            ConversationView(messages = SampleData.conversationSample)
        }
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        JetpackComposePlaygroundTheme {
            MessageCard(
                Message(
                    "Jetpack Compose Playground Test",
                    "Here is the example of JC usage Test",
                    R.drawable.photo
                )
            )
        }
    }
}

