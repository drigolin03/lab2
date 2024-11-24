package kg.iuca.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kg.iuca.lab2.ui.theme.Lab2Theme
import androidx.compose.foundation.lazy.LazyColumn



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                ToDoApp()
            }
        }
    }
}

@Composable
fun ToDoApp() {
    var taskText by remember { mutableStateOf("") }
    var taskList by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextField(
                value = taskText,
                onValueChange = { taskText = it },
                label = { Text("Введите задачу") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if (taskText.isNotBlank()) {
                        taskList = taskList + taskText
                        taskText = ""
                    }
                }
            ) {
                Text("Добавить")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(taskList.size) { index ->
                Text(
                    text = taskList[index],
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun ToDoApp() {
    var isDarkTheme by remember { mutableStateOf(false) }

    Lab2Theme(darkTheme = isDarkTheme) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Темная тема", style = MaterialTheme.typography.bodyLarge)
                    Switch(
                        checked = isDarkTheme,
                        onCheckedChange = { isDarkTheme = it }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text("Текст в текущей теме", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
