package com.example.composetutorialdevelopers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorialdevelopers.ui.theme.ComposeTutorialDevelopersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialDevelopersTheme {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    //Adiciona padding envolta da mensagem
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Default Image launcher Android",
            modifier = Modifier
                //Define o tamanho da imagem
                .size(40.dp)
                //Define o formato da imagem
                .clip(CircleShape)
                //Define Borda MaterialTheme
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        //Adiciona espaco horizontal entre a imagem e acoluna
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author,
            color = MaterialTheme.colors.secondaryVariant)
            //Adiciona espaco vertical entre as mensagens
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialDevelopersTheme {
        MessageCard(
            msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
        )
    }

}