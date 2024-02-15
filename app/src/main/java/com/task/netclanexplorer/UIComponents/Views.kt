package com.task.netclanexplorer.UIComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.task.netclanexplorer.Model.PersonalViewData
import com.task.netclanexplorer.R
import com.task.netclanexplorer.ui.theme.NetclanExplorerTheme

@Composable
fun PersonSwipableView(modifier: Modifier = Modifier, viewData: PersonalViewData) {
    Surface(modifier = modifier.fillMaxSize()) {
        PersonalView(viewData)
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
                .shadow(4.dp, shape = RoundedCornerShape(30.dp))
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
                        text = viewData.oneLineIntro,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = viewData.message,
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
                        text = viewData.message,
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
                    "Howdy Chirag Nikam!!",
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
                Icon(
                    painter = painterResource(id = R.drawable.refine),
                    contentDescription = "refine",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    )
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