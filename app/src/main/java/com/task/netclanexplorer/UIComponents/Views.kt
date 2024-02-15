package com.task.netclanexplorer.UIComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.task.netclanexplorer.Model.PersonalViewData
import com.task.netclanexplorer.R

@Composable
fun PersonSwipableView(modifier: Modifier = Modifier, viewData: PersonalViewData) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            SearchBox()
            LazyColumn(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                items(5) {
                    PersonalView(viewData)
                }
            }
        }
    }
}

@Composable
fun PersonalView(viewData: PersonalViewData) {
    Box(
        modifier = Modifier
            .padding(start = 20.dp)
            .fillMaxWidth()
            .background(
                Color.Transparent
            )
    ) {
        Row(
            modifier = Modifier
                .padding(start = 30.dp, end = 8.dp)
                .heightIn(min = 166.dp, max = 250.dp)
                .fillMaxWidth()
                .shadow(2.dp, shape = RoundedCornerShape(30.dp))
                .background(
                    MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(bottom = 10.dp)
        ) {
            Column {

                Column(modifier = Modifier.padding(top = 6.dp, bottom = 10.dp, start = 68.dp)) {
                    // invite button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(modifier = Modifier.height(36.dp), onClick = { }) {
                            Text(text = "+INVITE")
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                    }

                    // name
                    Text(
                        text = viewData.name,
                        fontWeight = FontWeight(700),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    // single line description
                    Text(
                        text = "${viewData.location} | ${viewData.jobType}",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    // location range
                    Text(
                        text = viewData.withinKm,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Progress bar
                    Row(
                        modifier = Modifier
                            .width(130.dp)
                            .height(12.dp)
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        Row(
                            Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .background(color = MaterialTheme.colorScheme.secondary)
                        ) {}
                        Row(
                            Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                        ) {}
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }
                // Intro
                Column(
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = viewData.purpose,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = viewData.status,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = viewData.completeDescription,
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 14.sp,
                        maxLines = 3,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        // Profile Picture
        Box(
            modifier = Modifier
                .padding(top = 30.dp)
                .shadow(8.dp, shape = RoundedCornerShape(12.dp))
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(start = 20.dp, end = 20.dp, top = 25.dp, bottom = 20.dp)
        ) {
            Text(
                text = "KG",
                fontSize = 26.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun SearchBox() {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    BasicTextField(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 8.dp, top = 18.dp),
        value = text,
        maxLines = 1,
        singleLine = true,
        onValueChange = { text = it },
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .border(
                        1.dp,
                        Color.Gray,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .height(30.dp)
                    .background(
                        MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .padding(start = 20.dp, end = 10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "search",
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(modifier = Modifier.widthIn(min = 290.dp, max = 290.dp)) {
                        innerTextField()
                    }
                    if (text.isNotEmpty()) {
                        IconButton(
                            onClick = { text = "" }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Clear,
                                contentDescription = "clear all",
                                tint = Color.Gray
                            )
                        }
                    }
                }
            }
        })
}

@Composable
fun BusinessView(viewData: PersonalViewData) {
    Box(
        modifier = Modifier
            .padding(start = 20.dp)
            .fillMaxWidth()
            .background(
                Color.Transparent
            )
    ) {
        Row(
            modifier = Modifier
                .padding(start = 30.dp, end = 8.dp)
                .heightIn(min = 166.dp, max = 250.dp)
                .fillMaxWidth()
                .shadow(4.dp, shape = RoundedCornerShape(30.dp))
                .background(
                    MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(bottom = 10.dp)
        ) {
            Column {

                Column(modifier = Modifier.padding(start = 68.dp)) {
                    // invite button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(modifier = Modifier.height(36.dp), onClick = { }) {
                            Text(text = "+INVITE")
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                    }

                    // name
                    Text(
                        text = viewData.name,
                        fontWeight = FontWeight(700),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    // location and within km range
                    Text(
                        text = "${viewData.location}, ${viewData.withinKm}",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Status bar
                    Row(
                        modifier = Modifier
                            .width(130.dp)
                            .height(12.dp)
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        Row(
                            Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .background(color = MaterialTheme.colorScheme.secondary)
                        ) {}
                        Row(
                            Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                        ) {}
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // phone and profile
                    Row {
                        Spacer(modifier = Modifier.width(16.dp))
                        Box(
                            modifier = Modifier
                                .size(22.dp)
                                .background(MaterialTheme.colorScheme.primary, shape = CircleShape)
                                .padding(2.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.call),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Box(
                            modifier = Modifier
                                .size(22.dp)
                                .background(MaterialTheme.colorScheme.primary, shape = CircleShape)
                                .padding(2.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                }
                // Intro
                Column(
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "${viewData.jobType} | ${viewData.experience} years of experience",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = viewData.status,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = viewData.completeDescription,
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 14.sp,
                        maxLines = 3,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        // Profile Picture
        Box(
            modifier = Modifier
                .padding(top = 30.dp)
                .shadow(8.dp, shape = RoundedCornerShape(12.dp))
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(start = 20.dp, end = 20.dp, top = 25.dp, bottom = 20.dp)
        ) {
            Text(
                text = "KG",
                fontSize = 26.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

// Toolbar with refine option menu
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarHome(onClickRefine: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        title = {
            Column {
                Text(
                    " Howdy Chirag Nikam!!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.width(18.dp),
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "location"
                    )
                    Text(text = "Manewada, Nagpur", fontSize = 14.sp)
                }
            }
        },
        actions = {
            IconButton(onClick = { onClickRefine() }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.refine),
                        contentDescription = "refine",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = "Refine",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    )
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarRefine() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onSecondary
        ), title = { Text(text = "Refine") },
        navigationIcon = {
             Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "go back", tint = MaterialTheme.colorScheme.onSecondary)
        })
}

@Preview
@Composable
fun PersonViewPreview() {
    PersonalView(
        viewData = PersonalViewData(
            name = "Kalpesh Ghorse",
            jobType = "Fresher Not Applicable",
            withinKm = "400-500 m",
            completeDescription = ""
        )
    )
}

@Preview
@Composable
fun BusinessViewPreview() {
    BusinessView(
        viewData = PersonalViewData(
            name = "Kalpesh Ghorse",
            jobType = "Fresher Not Applicable",
            withinKm = "400-500 m",
            completeDescription = ""
        )
    )
}

@Preview
@Composable
fun ToolbarPreview() {
    ToolbarHome {}
}

@Preview
@Composable
fun SearchBoxPreview() {
    SearchBox()
}