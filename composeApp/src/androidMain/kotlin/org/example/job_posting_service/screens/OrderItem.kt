package org.example.job_posting_service.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.job_posting_service.R
import data.OrdersModel
import org.example.job_posting_service.ui.theme.BaseFont
import org.example.job_posting_service.ui.theme.BaseLayer
import org.example.job_posting_service.ui.theme.textGrey

@Composable
fun OrderItem(item: OrdersModel) {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            // .requiredWidth(350.dp)
            .padding(bottom = 8.dp)
            .background(color = BaseLayer, RoundedCornerShape(15.dp))
            .clickable {}
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

                when (item.favorite) {
                    false ->
                        Image(
                            alignment = Alignment.TopEnd,
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable { },
                            painter = painterResource(id = R.drawable.ic_favorite_false),
                            contentDescription = "favorite false",
                            //contentScale = ContentScale.None
                        )

                    true -> Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable { },
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