package com.example.moontoon.Views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moontoon.Data_Entities.Item_Entity
import com.example.moontoon.R
import com.example.moontoon.viewModel_files.ItemsViewModel


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Todobody(databaseviewmodel: ItemsViewModel, modifier: Modifier=Modifier) {
 val dbitem=databaseviewmodel.listofitems.collectAsState(initial = emptyList())
 val _dbitem = dbitem.value.sortedBy { it.priority }.filter { it.doneTime==it.madeTime }
    LazyColumn(
        verticalArrangement = Arrangement.SpaceEvenly,
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 15.dp),
        modifier = modifier
    ) {
        items(
            items = _dbitem,
            /**
             * Use key param to define unique keys representing the items in a mutable list,
             * instead of using the default key (list position). This prevents unnecessary
             * recompositions.
             */
            key = { task -> task.uid }
        ) { task ->
            //ElevatedCardExample(databaseviewmodel,task)
            TodoDisplayCards(databaseviewmodel,task)
    }

        item{Spacer(modifier = Modifier.padding(35.dp))}

}
}

@Composable
fun DoneDisplayCards(databaseviewmodel: ItemsViewModel, item_entity:Item_Entity) {

    var selectedcard by rememberSaveable {
        mutableStateOf(false)
    }

    @DrawableRes  var item_priorityImage: Int=0
    if(item_entity.priority==1){
        item_priorityImage=R.drawable.item_priority1
    }
    else if(item_entity.priority==2){
        item_priorityImage=R.drawable.item_priority2
    }
    else{
        item_priorityImage=R.drawable.item_priority3
    }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)


    ){
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)) {
            Row {
                Column( modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 4.dp),
                    verticalArrangement = Arrangement.Center)
                {
                    Text(
                        text = item_entity.name?:"No Name Given",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )


                    Text(text = databaseviewmodel.convertTimestampToFormattedDate(item_entity.madeTime),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        textAlign = TextAlign.Center,
                    )
                }

                Column(verticalArrangement = Arrangement.SpaceBetween) {

                    Icon(
                        imageVector = Icons.Default.Close,
                        modifier = Modifier.clickable { databaseviewmodel.deleteItem(item_entity) },
                        contentDescription = "Cancel"
                    )

                    Text(text = databaseviewmodel.convertTimestampToFormattedDate(item_entity.doneTime),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        textAlign = TextAlign.Center,
                    )


                }

            }

            Text(text = item_entity.description?:"No Content", fontSize=15.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center)


            Image(
                painter = painterResource(item_priorityImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(35.dp)
                    .clip(CircleShape)
                    .padding(top = 7.dp)
            )

        }
    }
}

@Composable
fun TodoDisplayCards(databaseviewmodel: ItemsViewModel, item_entity:Item_Entity) {

var selectedcard by rememberSaveable {
    mutableStateOf(false)
}

    @DrawableRes  var item_priorityImage: Int=0
    if(item_entity.priority==1){
        item_priorityImage=R.drawable.item_priority1
    }
    else if(item_entity.priority==2){
        item_priorityImage=R.drawable.item_priority2
    }
    else{
        item_priorityImage=R.drawable.item_priority3
    }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)


    ){
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)) {
            Row {
                Column( modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 4.dp),
                    verticalArrangement = Arrangement.Center) 
                {
                    Text(
                        text = item_entity.name?:"No Name Given",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )


                    Text(text = databaseviewmodel.convertTimestampToFormattedDate(item_entity.madeTime),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        textAlign = TextAlign.Center,
                        )
                }

                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    if(!selectedcard)
                    { Icon(
                        imageVector = Icons.Default.TaskAlt,
                        tint = Color.Green,
                        modifier = Modifier.clickable {
                            selectedcard=true
                            item_entity.madeTime = System.currentTimeMillis()
                            databaseviewmodel.updateItem(item_entity)
                        },
                        contentDescription = "Done"
                    )}

                    Icon(
                        imageVector = Icons.Default.Close,
                        modifier = Modifier.clickable { databaseviewmodel.deleteItem(item_entity) },
                        contentDescription = "Cancel"
                    )
                }
                
            }
            
            Text(text = item_entity.description?:"No Content", fontSize=15.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center)


            Image(
                painter = painterResource(item_priorityImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(35.dp)
                    .clip(CircleShape)
                    .padding(top = 7.dp)
            )

        }
    }
    
}







/*
@Preview
@Composable
fun TodoCardPreview(){
    ElevatedCardExample()
}
*/

/*
@Preview
@Composable
fun TodobodyPreview(){
    Todobody()
}*/