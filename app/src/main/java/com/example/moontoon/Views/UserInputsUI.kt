package com.example.moontoon.Views


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalComposeUiApi
@Composable
fun  AuthScreen() {


    var emailText by remember { mutableStateOf("") }
    var passwordtext by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current
    val (focusDetails) = remember { FocusRequester.createRefs() }

    Column() {

        OutlinedTextField(
            value = emailText,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally),
            onValueChange = { emailText = it },
            label = { Text("Name", fontSize = 20.sp) },
            placeholder = { Text("Wash Cloths") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { focusDetails.requestFocus() }),
        )

        OutlinedTextField(
            value = passwordtext,
            modifier = Modifier
                .padding(top = 7.dp)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusDetails),
            onValueChange = { passwordtext = it },
            label = { Text("Details", fontSize = 20.sp) },
            placeholder = { Text("I need to wash all my ....") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction =  ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
        )

        Spacer(modifier = Modifier.padding(3.dp))

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
            )
        ) {
            Text(text = "Create Todo Item", modifier = Modifier.padding(6.dp))

        }
    }



}


@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun AuthPreview() {
    AuthScreen()
}