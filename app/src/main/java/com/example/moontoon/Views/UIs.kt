package com.example.moontoon.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moontoon.R
import com.example.moontoon.viewModel_files.ItemsViewModel


@Composable
fun Todobody(databaseviewmodel: ItemsViewModel = viewModel(), modifier: Modifier=Modifier) {

    Box(modifier = modifier.fillMaxSize()) {


        LargeFloatingActionButton(
            onClick = { /*Click Implementation*/ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.floating_edit_todo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(155.dp)
                    .clip(CircleShape)
            )
        }

    }

}

@Composable
fun TodoCard(modifier: Modifier=Modifier) {
    Card(
        modifier = modifier
            .padding(horizontal = 14.dp, vertical = 4.dp)

    ){
        Row{
            Column {
                Image(
                    painter = painterResource(R.drawable.image_done),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(R.drawable.image_cancel),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier=Modifier.padding(7.dp)) {
                Text("NAME")
                Text("In modern education, the integration of media and instructional" +
                        " materials has significantly transformed the way science is taught. " +
                        "The incorporation of multimedia resources such as. ")
                Image(
                    painter = painterResource(R.drawable.item_priority2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                )

            }
        }
    }


}

@Preview
@Composable
fun TodoCardPreview(){
    TodoCard()
}

/*
@Preview
@Composable
fun TodobodyPreview(){
    Todobody()
}*/