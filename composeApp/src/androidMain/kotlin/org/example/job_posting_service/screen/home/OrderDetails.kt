package org.example.job_posting_service.screen.home

// import org.example.job_posting_service.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import component.home.orderlist.OrderDetails
import data.CommentsModel
import data.OrderModel
import org.example.job_posting_service.R
import org.example.job_posting_service.module.BackButton
import org.example.job_posting_service.ui.theme.Typography
import org.example.job_posting_service.ui.theme.buttonSize
import org.example.job_posting_service.ui.theme.mainIconSize
import theme.BackButtonTint
import theme.BaseFont
import theme.BaseLayer
import theme.ButtonBackground
import theme.FirstLayer
import theme.SecondFont
import theme.first_layer_shape
import theme.second_layer_shape

@Composable
fun OrderDetailsScreen(component: OrderDetails) {
  val model by component.model.subscribeAsState()
  val order = model.order

  Column(
    modifier =
    Modifier
      .fillMaxSize()
      .background(BaseLayer),
  ) {
    Box(
      modifier =
      Modifier
        .fillMaxWidth()
        .padding(20.dp),
    ) {
      BackButton(component::onBackClick)
    }
    Column(
      modifier =
      Modifier
        .background(
          color = FirstLayer,
          shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        )
        .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 10.dp),
    ) {
      LazyColumn {
        item {
          CardItem(order)
        }

        item {
          Text(
            text = "Comments:",
            style = Typography.labelMedium,
            modifier = Modifier.padding(vertical = 10.dp),
          )
        }

        item {
          Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier =
              Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .background(color = BaseFont, RoundedCornerShape(15.dp)),
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
            ) {
              TextField(
                value = model.commentText.toString(),
                modifier = Modifier.weight(1f),
                placeholder = { Text(text = "Оставьте свой комментарий...") },
                onValueChange = component::onChangeTextComment,
                textStyle = Typography.bodyMedium,
                colors =
                  TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                  ),
                maxLines = 1,
              )

              Button(
                onClick = component::onSendCommentClick,
                modifier = Modifier.padding(10.dp).size(buttonSize),
                shape = second_layer_shape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground),
              ) {
                Icon(
                  Icons.Default.ArrowForward,
                  contentDescription = "",
                  tint = BackButtonTint,
                )
              }
            }
          }
        }

        itemsIndexed(
          model.comments,
        ) { _, comment ->
          CommentItem(comment)
        }
      }
    }
  }
}

@Composable
fun CardItem(order: OrderModel) {
  Card(
    elevation = 5.dp,
    shape = first_layer_shape,
    modifier =
      Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp)
        .shadow(
          elevation = 6.dp,
          shape = first_layer_shape,
          spotColor = Color.Black,
        ),
  ) {
    Column(
      modifier =
        Modifier
          .fillMaxWidth()
          .padding(20.dp),
    ) {
      Row(
        modifier =
          Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Image(
          painter = painterResource(id = R.drawable.logo),
          contentDescription = null,
          modifier =
            Modifier
              .size(mainIconSize)
              .clip(RoundedCornerShape(mainIconSize / 2)),
        )
        Text(
          text = "AUTHOR",
          modifier =
            Modifier
              .fillMaxWidth()
              .padding(10.dp),
          textAlign = TextAlign.Center,
          style = Typography.titleMedium,
        )
      }

      Text(
        text = order.title,
        modifier = Modifier.fillMaxWidth(),
        style = Typography.titleMedium,
      )

      order.description?.let {
        Text(
          text = it,
          style = Typography.bodyMedium,
        )
      }

      if (order.price != null) {
        Text(
          text = "Price: ${order.price} P",
          style = Typography.bodyMedium,
          color = SecondFont,
          textAlign = TextAlign.End,
        )
      }

      Text(
        text = order.specialization,
        style = Typography.bodyMedium,
        modifier = Modifier.fillMaxWidth(),
      )
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
      ) {
        Column {
          Text(
            text = "Deadline: ${order.deadline}",
            style = Typography.bodySmall,
          )
          Text(
            text = "Published: ${order.publicationDate}",
            style = Typography.bodySmall,
          )
        }
        order.city?.let {
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

@Composable
fun CommentItem(comment: CommentsModel) {
  Card(
    elevation = 5.dp,
    shape = RoundedCornerShape(15.dp),
    modifier =
      Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp)
        .background(color = BaseFont, RoundedCornerShape(15.dp)),
  ) {
    Column(
      modifier =
        Modifier
          .fillMaxSize()
          .padding(10.dp),
    ) {
      Text(
        text = comment.author,
        style = Typography.titleSmall,
      )
      Text(
        text = comment.description,
        style = Typography.bodyMedium,
        modifier =
          Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(),
      )

      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize(),
      ) {
        Text(
          text = "Published: ${comment.publicationDate}",
          style = Typography.bodyMedium,
          modifier = Modifier.weight(1f),
        )
        Text(
          text = "To answer",
          style = Typography.bodyMedium,
          textAlign = TextAlign.End,
          color = SecondFont,
        )
      }
    }
  }
}
