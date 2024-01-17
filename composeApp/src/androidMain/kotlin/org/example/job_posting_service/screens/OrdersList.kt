package org.example.job_posting_service.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import component.home.orderlist.OrdersList
import org.example.job_posting_service.R
import data.OrdersModel
import data.service1
import data.service2
import org.example.job_posting_service.ui.theme.BaseFont
import org.example.job_posting_service.ui.theme.BaseLayer
import org.example.job_posting_service.ui.theme.FirstLayer
import org.example.job_posting_service.ui.theme.richYellow
import org.example.job_posting_service.ui.theme.textGrey

@Composable
fun OrdersListScreen(component: OrdersList) {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Orders", "Masters")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BaseLayer)
    ) {

        SettingBar()

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
                .padding(top = 22.dp, start = 20.dp, end = 20.dp),

            ) {
            when (tabIndex) {
                0 -> {
                    itemsIndexed(
                        component.model.value.ordersList
                    ) { index, item ->
                        OrderItem(item, component, index.toLong())
                    }
                }

                1 -> {
                    itemsIndexed(
                        listOf(service1, service2, service2, service2)
                    ) { _, item ->
                        MasterItem(item = item)
                    }
                }
            }
        }
    }
}

@Composable
fun OrderItem(item: OrdersModel, component: OrdersList, index: Long) {
    val model by component.model.subscribeAsState()
    val favorite = model.ordersList.get(index.toInt()).favorite

    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            // .requiredWidth(350.dp)
            .padding(bottom = 8.dp)
            .background(color = BaseLayer, RoundedCornerShape(15.dp))
            .clickable { component.onItemClicked(index) }
    ) {
        Column(
            //horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 12.dp, top = 12.dp, start = 9.dp, end = 9.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = item.title,
                    color = BaseFont,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.requiredWidth(288.dp)
                )

                when (favorite) {
                    false ->
                        Image(
                            alignment = Alignment.TopEnd,
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable { component.onLikeClicked(item.orderId) },
                            painter = painterResource(id = R.drawable.ic_favorite_false),
                            contentDescription = "favorite false",
                            //contentScale = ContentScale.None
                        )

                    true -> Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable { component.onLikeClicked(item.orderId) },
                        alignment = Alignment.TopEnd,
                        painter = painterResource(id = R.drawable.ic_favorite_true),
                        contentDescription = "favorite true",
                        //contentScale = ContentScale.None
                    )
                }

            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 7.dp, bottom = 7.dp)
            ) {
                Text(
                    text = item.description,
                    color = BaseFont,
                    fontSize = 14.sp,
                    modifier = Modifier.requiredWidth(202.dp)
                )
                Text(
                    text = "${item.price} P",
                    fontWeight = FontWeight(700),
                    color = Color(0xFFE8B100)
                )

            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column {
                    Text(
                        text = "Deadline: ${item.deadline}",
                        color = textGrey,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        modifier = Modifier.requiredWidth(169.dp)

                    )
                    Text(
                        text = "Published: ${item.publicationDate}",
                        color = textGrey,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        modifier = Modifier.requiredWidth(169.dp)
                    )
                }
                Text(
                    text = item.city,
                    textAlign = TextAlign.End,
                    color = textGrey,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,

                    )
            }
        }
    }
}