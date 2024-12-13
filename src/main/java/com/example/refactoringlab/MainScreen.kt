// MainScreen.kt

package com.example.refactoringlab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(userManager: UserManager = UserManager()) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        TextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                userManager.registerUser(
                    firstName,
                    lastName,
                    email,
                    password,
                    age.toIntOrNull() ?: 0,
                    onSuccess = { message = "Registration Successful" },
                    onError = { error -> message = error }
                )
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Register")
        }
        Text(
            text = message,
            modifier = Modifier.padding(top = 16.dp),
            color = if (message == "Registration Successful") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
        )
    }
}
