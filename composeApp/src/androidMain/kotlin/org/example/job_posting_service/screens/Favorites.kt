package org.example.job_posting_service.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.BaseFont
import theme.BaseLayer
import theme.FirstLayer
import theme.richYellow

@Composable
fun FavoritesScreen() {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Orders", "Masters")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BaseLayer)
    ) {
        Text(
            text = "Favorites",
            style = TextStyle(
                fontSize = 20.sp,
                //fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(700),
                color = BaseFont,
            ),
            modifier = Modifier
                .padding(top = 47.dp, start = 20.dp, end = 20.dp)
                .height(50.dp)
                .fillMaxWidth()
        )

        TabRow(
            modifier = Modifier
                .padding(top = 42.dp, bottom = 12.dp)
                .height(22.dp),
            selectedTabIndex = tabIndex,
            contentColor = richYellow,
            divider = {},
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(text = {
                    Text(
                        title,
                        color = BaseFont,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                },
                    modifier = Modifier
                        .background(color = BaseLayer),
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = FirstLayer,
                    shape = RoundedCornerShape(topStart = 47.dp, topEnd = 47.dp)
                )
                .padding(top = 22.dp, start = 20.dp, end = 20.dp, bottom = 8.dp),

            ) {
//            when (tabIndex) {
//                0 -> {
//                    itemsIndexed(
//                        listOf(order1, order2, order2, order2)
//                    ) { _, item ->
//                        if (item.favorite) {
//                            OrderItem(item = item)
//                        }
//                    }
//                }
//
//                1 -> {
//                    itemsIndexed(
//                        listOf(service1, service1, service2, service2)
//                    ) { _, item ->
//                        if (item.favorite) {
//                            MasterItem(item = item)
//                        }
//                    }
//                }
//            }
        }
    }
}


@Composable
@Preview
fun FavoritesScreenPreview() {
    FavoritesScreen()
}