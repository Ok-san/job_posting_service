package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.ServiceModel
import theme.BaseFont
import theme.BaseLayer
import theme.FavoriteButtonTint
import theme.FirstFont
import theme.SecondFont

@Composable
fun MasterItem(item: ServiceModel) {
  Card(
    elevation = 5.dp,
    shape = RoundedCornerShape(15.dp),
    modifier =
      Modifier
        .fillMaxWidth()
        // .requiredWidth(350.dp)
        .padding(bottom = 8.dp)
        .background(color = BaseLayer, shape = RoundedCornerShape(15.dp)),
  ) {
    Column(
      // horizontalArrangement = Arrangement.SpaceBetween,
      modifier =
        Modifier
          .fillMaxSize()
          .padding(bottom = 12.dp, top = 12.dp, start = 9.dp, end = 9.dp),
    ) {
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =
          Modifier
            .fillMaxSize(),
      ) {
        Text(
          modifier = Modifier.fillMaxSize(0.7f),
          text = item.master.name,
          color = BaseFont,
          fontSize = 18.sp,
          fontWeight = FontWeight(600),
        )
        when (item.favorite) {
          false ->
            Icon(
              Icons.Default.Favorite,
              contentDescription = null,
              tint = FavoriteButtonTint,
              modifier = Modifier.clickable { },
            )

          true ->
            Icon(
              Icons.Filled.Favorite,
              contentDescription = null,
              tint = FavoriteButtonTint,
              modifier = Modifier.clickable { },
            )
        }
      }
      Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier =
          Modifier
            .fillMaxSize()
            .padding(vertical = 7.dp),
      ) {
        item.description?.let {
          Text(
            modifier = Modifier.weight(1f),
            text = it,
            color = BaseFont,
            fontSize = 14.sp,
          )
        }
        Image(
          alignment = Alignment.CenterEnd,
          modifier =
            Modifier
              .requiredSize(50.dp)
              .fillMaxSize(),
          painter = painterResource("drawable/logo.png"),
          contentDescription = "image description",
        )
      }
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =
          Modifier
            .fillMaxSize(),
      ) {
        Column {
          if (item.coast != null) {
            Text(
              text = "${item.coast} P",
              fontSize = 14.sp,
              fontWeight = FontWeight(700),
              color = SecondFont,
              modifier = Modifier.requiredWidth(175.dp),
            )
          }
          Text(
            text = "Published: ${item.publicationDate}",
            color = FirstFont,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            modifier = Modifier.requiredWidth(169.dp),
          )
        }
        item.city?.let {
          Text(
            text = it,
            color = FirstFont,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            textAlign = TextAlign.End,
          )
        }
      }
    }
  }
}
