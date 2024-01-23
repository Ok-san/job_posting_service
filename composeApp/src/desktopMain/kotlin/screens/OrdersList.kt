package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import component.home.orderlist.OrdersList
import data.OrderModel
import data.service1
import data.service2
import theme.BaseFont
import theme.BaseLayer
import theme.FavoriteButtonTint
import theme.FirstLayer
import theme.FirstFont
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
      modifier =
        Modifier.padding(top = 0.dp, bottom = 12.dp)
          .height(40.dp),
      selectedTabIndex = tabIndex,
      contentColor = SecondFont,
      divider = {},
    ) {
      tabs.forEachIndexed { index, title ->
        Tab(
          text = {
            Text(
              title,
              color = BaseFont,
              fontSize = 16.sp,
              modifier = Modifier.padding(bottom = 5.dp),
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
            shape = RoundedCornerShape(topStart = 47.dp, topEnd = 47.dp),
          )
          .padding(top = 22.dp, start = 20.dp, end = 20.dp),
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
  val favorite = model.ordersList[index].favorite

  Card(
    modifier =
      Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp),
    elevation = 5.dp,
    shape = RoundedCornerShape(15.dp),
  ) {
    Column(
      modifier =
        Modifier
          .fillMaxSize()
          .background(BaseLayer)
          .clickable { component.onItemClicked(index) }
          .padding(bottom = 12.dp, top = 12.dp, start = 9.dp, end = 9.dp),
    ) {
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =
          Modifier
            .fillMaxWidth(),
      ) {
        Text(
          text = item.title,
          color = BaseFont,
          fontSize = 18.sp,
          fontWeight = FontWeight(600),
        )
        when (favorite) {
          false ->
            Icon(
              Icons.Default.FavoriteBorder,
              contentDescription = null,
              tint = FavoriteButtonTint,
              modifier = Modifier.clickable { component.onLikeClicked(item.orderId) },
            )

          true ->
            Icon(
              Icons.Default.Favorite,
              contentDescription = null,
              tint = FavoriteButtonTint,
              modifier = Modifier.clickable { component.onLikeClicked(item.orderId) },
            )
        }
      }

      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =
          Modifier
            .fillMaxSize()
            .padding(top = 7.dp, bottom = 7.dp),
      ) {
        item.description?.let {
          Text(
            modifier = Modifier.fillMaxSize(0.8f),
            text = it,
            color = BaseFont,
            fontSize = 14.sp,
          )
        }
        Text(
          text = "${item.price} P",
          fontWeight = FontWeight(700),
          color = Color(0xFFE8B100),
        )
      }
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =
          Modifier
            .fillMaxSize(),
      ) {
        Column {
          Text(
            modifier = Modifier.fillMaxSize(0.7f),
            text = "Deadline: ${item.deadline}",
            color = FirstFont,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
          )
          Text(
            text = "Published: ${item.publicationDate}",
            color = FirstFont,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
          )
        }
        item.city?.let {
          Text(
            text = it,
            textAlign = TextAlign.End,
            color = FirstFont,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
          )
        }
      }
    }
  }
}
