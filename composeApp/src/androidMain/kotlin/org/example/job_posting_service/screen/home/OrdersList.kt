package org.example.job_posting_service.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import component.home.orderlist.OrdersList
import data.OrderModel
import data.service1
import data.service2
import org.example.job_posting_service.R
import org.example.job_posting_service.ui.theme.Typography
import theme.BaseLayer
import theme.FirstLayer
import theme.SecondFont

@Composable
fun OrdersListScreen(component: OrdersList) {
  var tabIndex by remember { mutableIntStateOf(0) }
  val tabs = listOf("Orders", "Masters")

  Column(
    modifier =
    Modifier
      .fillMaxSize()
      .background(BaseLayer),
  ) {
//        SettingBar()
    TabRow(
      modifier = Modifier.padding(bottom = 10.dp),
      selectedTabIndex = tabIndex,
      contentColor = SecondFont,
      divider = {},
    ) {
      tabs.forEachIndexed { index, title ->
        Tab(
          text = {
            Text(
              title,
              style = Typography.titleMedium,
            )
          },
          modifier =
          Modifier
            .background(color = BaseLayer),
          selected = tabIndex == index,
          onClick = { tabIndex = index },
        )
      }
    }

    LazyColumn(
      modifier =
      Modifier
        .fillMaxSize()
        .background(
          color = FirstLayer,
          shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        )
        .padding(top = 20.dp, start = 20.dp, end = 20.dp),
    ) {
      when (tabIndex) {
        0 -> {
          itemsIndexed(
            component.model.value.ordersList,
          ) { index, item ->
            OrderItem(item, component, index)
          }
        }

        1 -> {
          itemsIndexed(
            listOf(service1, service2, service2, service2),
          ) { _, item ->
            MasterItem(item = item)
          }
        }
      }
    }
  }
}

@Composable
fun OrderItem(
  item: OrderModel,
  component: OrdersList,
  index: Int,
) {
  val model by component.model.subscribeAsState()
  var favorite by remember { mutableStateOf(model.ordersList[index].favorite) }

  Card(
    modifier =
    Modifier
      .fillMaxWidth()
      .padding(bottom = 8.dp)
      .background(color = BaseLayer, RoundedCornerShape(15.dp))
      .clickable { component.onItemClicked(index) },
    elevation = 5.dp,
    shape = RoundedCornerShape(15.dp),
  ) {
    Column(
      modifier =
      Modifier
        .fillMaxSize()
        .padding(10.dp),
    ) {
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =
        Modifier.fillMaxWidth(),
      ) {
        Text(
          modifier = Modifier.weight(1f),
          text = item.title,
          style = Typography.titleSmall,
        )

        IconButton(
          modifier = Modifier.size(30.dp),
          onClick = {
            component.onLikeClicked(item.orderId)
            favorite = !favorite
          }
        ) {
          when (favorite) {
            false ->
              Image(
                painter = painterResource(R.drawable.ic_favorite_false),
                contentDescription = "favorite false",
              )
            true ->
              Image(
                painter = painterResource(R.drawable.ic_favorite_true),
                contentDescription = "favorite true",
              )
          }
        }
      }
      item.description?.let {
        Text(
          text = it,
          style = Typography.bodyMedium,
        )
      }
      Text(
        text = "Price: ${item.price} P",
        style = Typography.bodyMedium,
        color = SecondFont,
      )
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
      ) {
        Column {
          Text(
            text = "Deadline: ${item.deadline}",
            style = Typography.bodySmall,
          )
          Text(
            text = "Published: ${item.publicationDate}",
            style = Typography.bodySmall,
          )
        }
        item.city?.let {
          Text(
            modifier = Modifier.weight(1f),
            text = it,
            textAlign = TextAlign.End,
            style = Typography.bodyMedium,
          )
        }
      }
    }
  }
}
