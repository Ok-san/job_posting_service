package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import component.home.orderlist.OrderDetails
import data.CommentsModel
import data.OrderModel
import org.example.job_posting_service.module.BackButton
import theme.BaseFont
import theme.BaseLayer
import theme.FirstLayer
import theme.SecondFont
import ui.theme.ProfileTypography
import ui.theme.mainIconSize

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
          .padding(top = 47.dp, start = 20.dp, end = 20.dp),
    ) {
      BackButton(component::onBackClick)
    }
    Box(
      modifier =
        Modifier
//                .height(mainIconSize/2)
          .fillMaxWidth()
          .zIndex(1f),
      contentAlignment = Alignment.Center,
    ) {
      Image(
        painter = painterResource("drawable/logo.xml"),
        contentDescription = null,
        modifier =
          Modifier
            .size(mainIconSize)
            .offset(y = 40.dp)
            .clip(RoundedCornerShape(mainIconSize / 2)),
      )
    }
    Column(
      modifier =
        Modifier
          .fillMaxSize()
          // .padding(top = 27.dp)
          .background(
            color = FirstLayer,
            shape = RoundedCornerShape(topStart = 47.dp, topEnd = 47.dp),
          )
          .padding(top = 22.dp, start = 20.dp, end = 20.dp, bottom = 8.dp),
    ) {
      LazyColumn {
        item { CardItem(order) }
        item {
          Text(
            text = "Comments:",
            style = ProfileTypography.titleMedium,
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp),
          )
        }

        itemsIndexed(
          component.model.value.comments,
        ) { _, comment ->
          CommentItem(comment)
        }
      }
      Box(
        modifier =
          Modifier
            .padding(top = 7.dp)
            .fillMaxSize()
            .fillMaxWidth(),
      ) {
        TextField(
          value = model.commentText.toString(),
          modifier =
            Modifier
              .fillMaxWidth()
              .height(44.dp)
              .background(
                color = BaseLayer,
                shape = RoundedCornerShape(size = 15.dp),
              ),
          onValueChange = component::onChangeTextComment,
          textStyle =
            TextStyle(
              fontSize = 16.sp,
//                fontFamily = FontFamily(Font(R.font.inter)),
              fontWeight = FontWeight(400),
              color = BaseFont,
            ),
          colors =
            TextFieldDefaults.textFieldColors(
              backgroundColor = SecondFont,
              focusedIndicatorColor = Color.Transparent,
              unfocusedIndicatorColor = Color.Transparent,
              disabledIndicatorColor = Color.Transparent,
            ),
          maxLines = 1,
        )
        Button(
          onClick = component::onSendCommentClick,
          modifier =
            Modifier
              .width(44.dp)
              .height(44.dp)
              .padding(top = 5.dp),
          shape = RectangleShape,
          colors =
            ButtonDefaults.buttonColors(
              backgroundColor = BaseLayer,
              contentColor = BaseFont,
            ),
        ) {
        }
      }
    }
  }
}

//@Composable
//fun BackButton(component: OrderDetails) {
//  Button(
//    onClick = component::onBackClick,
//    modifier = Modifier.size(buttonSize),
//    shape = second_layer_shape,
//    contentPadding = PaddingValues(0.dp),
//    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground),
//  ) {
//    Icon(
//      Icons.Default.ArrowBack,
//      contentDescription = "",
//      tint = BackButtonTint,
//    )
//  }
//}

@Composable
fun CardItem(order: OrderModel) {
  Card(
    elevation = 5.dp,
    shape = RoundedCornerShape(15.dp),
    modifier =
      Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp)
        .background(color = BaseLayer, RoundedCornerShape(15.dp)),
  ) {
    Column(
      // horizontalArrangement = Arrangement.SpaceBetween,
      modifier =
        Modifier
          .fillMaxWidth()
          .padding(bottom = 12.dp, top = 12.dp, start = 9.dp, end = 9.dp),
    ) {
      Text(
        text = "AUTHOR",
        modifier =
          Modifier
            .fillMaxWidth()
            .padding(7.dp),
        style =
          TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFF3F6359),
            textAlign = TextAlign.Center,
          ),
      )
      Text(
        modifier =
          Modifier
            .fillMaxWidth(),
        text = order.title,
        color = BaseFont,
        fontSize = 18.sp,
        fontWeight = FontWeight(600),
      )
      Row(
        modifier =
          Modifier
            .wrapContentWidth()
            .fillMaxWidth()
            .padding(top = 7.dp, bottom = 7.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        order.description?.let {
          Text(
            text = it,
            color = BaseFont,
            fontSize = 14.sp,
            modifier = Modifier.requiredWidth(202.dp),
          )
        }
        if (order.price != null) {
          Text(
            text = "${order.price} P",
            fontWeight = FontWeight(700),
            color = Color(0xFFE8B100),
            textAlign = TextAlign.End,
          )
        }
      }
      Text(
        text = order.specialization,
        style = ProfileTypography.bodyMedium,
        modifier = Modifier.fillMaxWidth(),
      )
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
      ) {
        Column {
          Text(
            text = "Deadline: ${order.deadline}",
            style = ProfileTypography.bodyMedium,
            modifier = Modifier.requiredWidth(169.dp),
          )
          Text(
            text = "Published: ${order.publicationDate}",
            style = ProfileTypography.bodyMedium,
            modifier = Modifier.requiredWidth(169.dp),
          )
        }
        order.city?.let {
          Text(
            text = it,
            textAlign = TextAlign.End,
            style = ProfileTypography.bodyMedium,
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
        // .requiredWidth(350.dp)
        .padding(bottom = 8.dp)
        .background(color = BaseFont, RoundedCornerShape(15.dp)),
    // .clickable { OrderScreen(item) }
  ) {
    Column(
      // horizontalArrangement = Arrangement.SpaceBetween,
      modifier =
        Modifier
          .fillMaxSize()
          .padding(bottom = 12.dp, top = 12.dp, start = 9.dp, end = 9.dp),
    ) {
      Text(
        text = comment.author,
        modifier =
          Modifier
            .fillMaxWidth(),
        style =
          TextStyle(
            fontSize = 16.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(700),
            color = Color(0xFF3F6359),
          ),
      )
      Text(
        text = comment.description,
        color = BaseFont,
        fontSize = 14.sp,
        modifier =
          Modifier
            .padding(top = 7.dp)
            .fillMaxWidth(),
      )

      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =
          Modifier
            .fillMaxSize(),
      ) {
        Column {
          Text(
            text = "Published: ${comment.publicationDate}",
            style = ProfileTypography.bodyMedium,
            modifier = Modifier.requiredWidth(158.dp),
          )
        }
        Text(
          text = "To answer",
          textAlign = TextAlign.End,
          color = SecondFont,
          fontWeight = FontWeight(400),
          fontSize = 14.sp,
        )
      }
    }
  }
}

// @Composable
// @Preview
// fun OrderScreenPreview() {
//    OrderDetailsScreen()
// }
