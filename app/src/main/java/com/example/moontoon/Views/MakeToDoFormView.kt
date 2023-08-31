package com.example.moontoon.Views


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.moontoon.Data_Entities.Item_Entity
import com.example.moontoon.R
import com.example.moontoon.viewModel_files.ItemsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalComposeUiApi
@Composable
fun  MakeToDoForm(databaseviewmodel: ItemsViewModel,navController: NavController, ) {

    val context = LocalContext.current
    var emailText by remember { mutableStateOf("") }
    var passwordtext by remember { mutableStateOf("") }
    var priorityNumber by remember { mutableStateOf(0) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val (focusDetails) = remember { FocusRequester.createRefs() }

    Column() {

       Button(onClick = { navController.navigate("To_Do") {
           popUpTo(navController.graph.findStartDestination().id)
           launchSingleTop = true
       }
       } ) {
           Text(text = "Close")
       }

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

        Row(modifier=Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
            Image(
                painter = painterResource(R.drawable.item_priority1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape).clickable { priorityNumber=1}
            )
            Image(
                painter = painterResource(R.drawable.item_priority2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape).clickable { priorityNumber=2 }
            )
            Surface(
                shadowElevation = 9.dp, // play with the elevation values
            ) {
                Image(
                    painter = painterResource(R.drawable.item_priority3),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(4.dp, Color.Yellow),
                            CircleShape
                        )
                )
            }

        }
        Spacer(modifier = Modifier.padding(3.dp))

        Button(
            onClick = { databaseviewmodel.insertItem(Item_Entity(name = emailText, description = passwordtext, priority = priorityNumber))
                Toast.makeText(context,"To Do Item Created", Toast.LENGTH_LONG).show()

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


/*
@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun AuthPreview() {
    MakeToDoForm({true})
}*/