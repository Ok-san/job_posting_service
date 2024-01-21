package org.example.job_posting_service.screen

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.ServicesModel
import org.example.job_posting_service.R
import theme.BaseFont
import theme.BaseLayer
import theme.richYellow
import theme.textGrey

@Composable
fun MasterItem(item: ServicesModel) {
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
          text = item.master.name,
          color = BaseFont,
          fontSize = 18.sp,
          fontWeight = FontWeight(600),
          modifier = Modifier.requiredWidth(288.dp),
        )
        when (item.favorite) {
          false ->
            Image(
              alignment = Alignment.TopEnd,
              modifier =
                Modifier
                  .fillMaxSize()
                  .clickable { },
              painter = painterResource(id = R.drawable.ic_favorite_false),
              contentDescription = "favorite false",
              // contentScale = ContentScale.None
            )

          true ->
            Image(
              modifier =
                Modifier
                  .fillMaxSize()
                  .clickable { },
              alignment = Alignment.TopEnd,
              painter = painterResource(id = R.drawable.ic_favorite_true),
              contentDescription = "favorite true",
              // contentScale = ContentScale.None
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
        Text(
          text = item.description,
          color = BaseFont,
          fontSize = 14.sp,
          modifier = Modifier.requiredWidth(202.dp),
        )
        Image(
          alignment = Alignment.CenterEnd,
          modifier =
            Modifier
              .requiredSize(50.dp)
              .fillMaxSize(),
          painter = painterResource(id = R.drawable.logo),
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
              color = richYellow,
              modifier = Modifier.requiredWidth(175.dp),
            )
          }
          Text(
            text = "Published: ${item.publicationDate}",
            color = textGrey,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            modifier = Modifier.requiredWidth(169.dp),
          )
        }
        item.city?.let {
          Text(
            text = it,
            color = textGrey,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            textAlign = TextAlign.End,
          )
        }
      }
    }
  }
}