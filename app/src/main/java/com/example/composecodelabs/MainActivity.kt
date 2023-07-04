package com.example.composecodelabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecodelabs.ui.theme.ComposeCodeLabsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodeLabsTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if(expanded.value) 18.dp else 0.dp

    Surface(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)){
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier.weight(1f).padding(bottom = extraPadding)) {
                Text(
                    text = "Hello,"
                )
                Text(
                    text = "$name!"
                )
            }
            Button(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Show less" else "Show more")

            }
        }
    }

}

@Composable
private fun MyApp(modifier: Modifier = Modifier,
                  names: List<String> = listOf("World", "Compose")) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier) {
            for (name in names){
                Greeting(name)
            }
        }
    }
}

@Preview(name= "Primeira implementação - Compose", showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    ComposeCodeLabsTheme {
        MyApp()
    }
}