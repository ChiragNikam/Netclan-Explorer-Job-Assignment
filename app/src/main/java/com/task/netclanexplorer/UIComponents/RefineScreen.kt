package com.task.netclanexplorer.UIComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.io.path.Path

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefineScreen(modifier: Modifier = Modifier) {

    val listofAvailablity = listOf<String>(
        "Available | Hey Let Us Connect",
        "Away | Stay Discrete And Watch",
        "Busy | Do Not Disturb | Will catch up later",
        "SOS | Emergency! Need assistance HELP"
    )
    Surface(modifier = modifier) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Select Your Availability",
                fontWeight = MaterialTheme.typography.labelMedium.fontWeight,
                fontSize = MaterialTheme.typography.labelMedium.fontSize
            )
            Spacer(modifier = Modifier.height(8.dp))
            // dropdown
            var availableSelectedMenus by rememberSaveable { mutableStateOf(listofAvailablity[0]) }
            DorpDownAvailablity(
                items = listofAvailablity,
                selectedItem = availableSelectedMenus,
                onItemSelected = {
                    availableSelectedMenus = it
                },
                extractLabel = { it }
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Add Your Status",
                fontWeight = MaterialTheme.typography.labelMedium.fontWeight,
                fontSize = MaterialTheme.typography.labelMedium.fontSize
            )
            // status text field
            Spacer(modifier = Modifier.height(8.dp))
            var statusText by rememberSaveable {
                mutableStateOf("Hi community! I am open to new connections.")
            }
            BasicTextField(modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
                textStyle = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize),
                value = statusText,
                onValueChange = { statusText = it }) {
                Box(    // decoration box
                    modifier = Modifier
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.primary,
                            RoundedCornerShape(8.dp)
                        )
                        .height(48.dp)
                        .padding(top = 6.dp, bottom = 6.dp, start = 12.dp, end = 12.dp)
                ) {
                    it()
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Select Hyper local Distance",
                fontWeight = MaterialTheme.typography.labelMedium.fontWeight,
                fontSize = MaterialTheme.typography.labelMedium.fontSize
            )
            // slider for km range
            var sliderPosition by rememberSaveable {
                mutableFloatStateOf(0f)
            }
            Slider(
                modifier = Modifier.fillMaxWidth(),
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                thumb = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .padding(bottom = 40.dp)
                                .background(MaterialTheme.colorScheme.primary)
                                .size(width = 33.dp, height = 28.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    textAlign = TextAlign.Center,
                                    text = (sliderPosition * 100).toInt().toString(),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            }

                        }
                    }
                })
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(modifier = Modifier.weight(1f), text = "1 Km")
                Text(text = "100 Km")
            }

            // purpose
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Select Purpose",
                fontWeight = MaterialTheme.typography.labelMedium.fontWeight,
                fontSize = MaterialTheme.typography.labelMedium.fontSize
            )
            Spacer(modifier = Modifier.height(8.dp))

            // list of options for select purpose
            val optionsList = listOf<String>("Coffee", "Business", "Hobbies", "Friendship", "Movies")

            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(5) {
                    var itemSelected by rememberSaveable {
                        mutableStateOf(false)
                    }
                        Box(    // select options for purpose
                        modifier = Modifier
                            .background(
                                if (itemSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary,
                                RoundedCornerShape(30.dp)
                            )
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .clickable {
                                itemSelected = !itemSelected
                            }
                            .padding(10.dp), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = optionsList[it],
                            fontSize = 12.sp,
                            color = if (itemSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(onClick = {

                }) {
                    Text(modifier = Modifier.padding(horizontal = 40.dp), text = "Save & Explore")
                }
            }
        }

    }
}

// custom text field with drop down
@Composable
fun <T> DorpDownAvailablity(
    items: List<T>,
    selectedItem: T,
    onItemSelected: (T) -> Unit,
    extractLabel: (T) -> String
) {
    var isDropdownExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp))
            .clickable { isDropdownExpanded = true }
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onPrimary, shape = RoundedCornerShape(8.dp))
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = extractLabel(selectedItem),
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = Color.Black
            )
        }

        DropdownMenu(
            expanded = isDropdownExpanded,
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterVertically),
            onDismissRequest = { isDropdownExpanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(text = {
                    Text(
                        text = extractLabel(item),
                        fontSize = 16.sp
                    )
                }, onClick = {
                    onItemSelected(item)
                    isDropdownExpanded = false
                })
            }
        }
    }

}