package com.peterstaranchuk.composeplayground.ui.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.peterstaranchuk.composeplayground.Message

@Composable
fun ConversationView(messages: List<Message>) {
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