package com.task.netclanexplorer.UIComponents

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.task.netclanexplorer.ui.theme.NetclanExplorerTheme

@Composable
fun PersonView(modifier: Modifier = Modifier) {
    Surface (modifier = modifier.fillMaxSize()){
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

                    Column(modifier = Modifier.padding(bottom = 10.dp, start = 68.dp)) {
                        // invite button
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                            TextButton(modifier = Modifier.height(36.dp), onClick = { }) {
                                Text(text = "+INVITE")
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                        }

                        // name
                        Text(
                            text = "Kalpesh Ghorse",
                            fontWeight = FontWeight(700),
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        // single line description
                        Text(
                            text = "Nagpur | Fresher Not Applicable",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        // location range
                        Text(
                            text = "Within 400-500 m",
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
                    Column(modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp)
                        .fillMaxWidth()) {
                        Text(text = "Coffee | Business | Friendship", fontSize = 12.sp, fontWeight = FontWeight(700), color = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "Hi community! I am open to new connections\"\uD83D\uDE0A\"", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "I have recently completed training on \nJava Full Stack \ndevelopment. I have done my Bachelor's of Engineering in Computer Science", overflow = TextOverflow.Ellipsis, lineHeight = 14.sp , maxLines = 3,fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
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
}

@Preview
@Composable
fun PersonViewPreview() {
    PersonView()
}