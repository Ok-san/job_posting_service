package org.example.job_posting_service.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import data.ServiceModel
import theme.BaseLayer
import theme.InterTypography

@Composable
fun MasterItem(item: ServiceModel) {
  var favorite by remember { mutableStateOf(item.favorite) }

  Card(
    elevation = 5.dp,
    shape = RoundedCornerShape(15.dp),
    modifier =
      Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp)
        .background(color = BaseLayer, shape = RoundedCornerShape(15.dp)),
  ) {
    Column(
      modifier =
        Modifier
          .fillMaxSize()
          .padding(bottom = 12.dp, top = 12.dp, start = 9.dp, end = 9.dp),
    ) {
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize(),
      ) {
        Text(
          modifier =
            Modifier.weight(1f),
          text = item.master.name,
          style = InterTypography.labelMedium,
        )
        IconButton(
          modifier = Modifier.size(30.dp),
          onClick = {
//            component.onLikeClicked(item.orderId)
            favorite = !favorite
          },
        ) {
          when (favorite) {
            false ->
              Image(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "favorite false",
              )

            true ->
              Image(
                imageVector = Icons.Default.Favorite,
                contentDescription = "favorite true",
              )
          }
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
            modifier =
              Modifier.weight(1f),
            text = it,
            style = InterTypography.bodyMedium,
          )
        }
        Image(
          alignment = Alignment.CenterEnd,
          modifier =
            Modifier
              .requiredSize(50.dp)
              .fillMaxSize(),
          painter = painterResource("drawable/logo.xml"),
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
              style = InterTypography.bodyMedium,
              modifier = Modifier.requiredWidth(175.dp),
            )
          }
          Text(
            text = "Published: ${item.publicationDate}",
            style = InterTypography.bodyMedium,
            modifier = Modifier.requiredWidth(169.dp),
          )
        }
        item.city?.let {
          Text(
            text = it,
            style = InterTypography.bodyMedium,
            textAlign = TextAlign.End,
          )
        }
      }
    }
  }
}
