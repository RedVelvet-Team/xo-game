package com.redvelvet.xogame.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.xogame.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Tester() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    HomeScreenContent()
}

//modifier = Modifier

@Composable
fun HomeScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.home_background),
            contentDescription = "Home Screen Image With blur effect",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .clipToBounds()
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)) {
                Image(alignment = Alignment.Center,
                    painter = painterResource(id = R.drawable.home_header),
                    contentDescription = "Home Screen Image With blur effect",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clipToBounds()
                        .fillMaxWidth()
                        .fillMaxHeight(0.3f)
                )
                Column(modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 72.dp)) {
                    UsersSearchBar(
                        modifier = Modifier
                    )
                    TabRow(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp),
                        selectedTabIndex = 0,
                        containerColor = Color(0x20F5F5F5),
                        contentColor = Color.White,
                    ) {
                        Tab(selected = false, onClick = { /*TODO*/ },
                            text = {
                                Text(text = "Online Players")
                            },)
                        Tab(selected = true, onClick = { /*TODO*/ },
                            text = {
                                Text(text = "Your Friends")
                            })
                    }
                }

            }
            UsersSection()
        }
    }
}


@Composable
fun UsersSection() {
    LazyColumn(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(3){
            OneUserRow()
        }
    }
}

@Composable
fun OneUserRow() {
    Card(
        modifier = Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0x66F5F5F5)
        ),
        shape = RectangleShape
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_circle_24),
                contentDescription = "user image",
                modifier = Modifier
                    .size(60.dp)
                    .padding(vertical = 8.dp)
                    .padding(start = 8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Hassan Wasfy",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Card(
                    modifier = Modifier
                        .size(width = 64.dp, height = 25.dp)
                        .border(
                            border = BorderStroke(1.dp, Color(0x66F5F5F5)),
                            shape = RoundedCornerShape(
                                corner = CornerSize(4.dp)
                            )
                        ),
                    shape = RoundedCornerShape(corner = CornerSize(4.dp)),
                    colors = CardDefaults.cardColors(
                        contentColor = Color.White,
                        containerColor = Color.Transparent
                    ),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "invite", fontSize = 8.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun UsersSearchBar(modifier: Modifier) {
    Card(
        modifier = modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0x66F5F5F5)
        ),
        shape = RoundedCornerShape(corner = CornerSize(32.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_circle_24),
                contentDescription = "user image",
                modifier = Modifier
                    .size(60.dp)
                    .padding(vertical = 8.dp)
                    .padding(start = 8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Hassan Wasfy",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = R.drawable.search_5_svgrepo_com_1),
                    contentDescription = "search icon")
            }
        }
    }
}