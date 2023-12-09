package org.example.job_posting_service.screens

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import org.example.job_posting_service.R
import data.CommentModel
import data.comment1
import data.order1
import org.example.job_posting_service.ui.theme.BaseFont
import org.example.job_posting_service.ui.theme.BaseLayer
import org.example.job_posting_service.ui.theme.FirstLayer
import org.example.job_posting_service.ui.theme.richYellow
import org.example.job_posting_service.ui.theme.textGrey

val item = order1

@Composable
fun OrderScreen() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BaseLayer)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 47.dp, start = 20.dp, end = 20.dp)
        ) {
            BackButton()
        }
        Box(
            modifier = Modifier
//                .height(mainIconSize/2)
                .fillMaxWidth()
                .zIndex(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .size(mainIconSize)
                    .offset(y = 40.dp)
                    .clip(RoundedCornerShape(mainIconSize / 2))
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                //.padding(top = 27.dp)
                .background(
                    color = FirstLayer,
                    shape = RoundedCornerShape(topStart = 47.dp, topEnd = 47.dp)
                )
                .padding(top = 22.dp, start = 20.dp, end = 20.dp, bottom = 8.dp)
        ) {

            CardItem()
            Text(
                text = "Comments:",
                fontSize = 16.sp,
//        fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(400),
                color = Color(0xFF3F6359),
                modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
            )
            LazyColumn {
                itemsIndexed(
                    listOf(comment1, comment1)
                ) { _, comment ->
                    CommentItem(comment)
                }
            }
            TextField(
                value = text,
                shape = RoundedCornerShape(size = 10.dp),
                modifier = Modifier
                    .padding(top = 7.dp)
                    .fillMaxWidth()
                    .height(117.dp)
                    .background(
                        color = Color(0x85FFFFFF),
                        shape = RoundedCornerShape(size = 15.dp)
                    ),
                onValueChange = { newText ->
                    text = newText
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,

//                fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = BaseFont
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0x308A9994),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                maxLines = 1,
            )
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .padding(top = 5.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = BaseLayer,
                    contentColor = BaseFont
                )

            ) {
                Text(text = "Add comment")
            }
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = BaseFont,
                // thickness = 1.dp
            )
        }
    }
}

@Composable
fun CardItem() {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .background(color = BaseLayer, RoundedCornerShape(15.dp))
    ) {
        Column(
            //horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp, top = 12.dp, start = 9.dp, end = 9.dp),
        ) {
            Text(
                text = "Author Name",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(7.dp),
                style = TextStyle(
                    fontSize = 18.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF3F6359),
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = item.title,
                color = BaseFont,
                fontSize = 18.sp,
                fontWeight = FontWeight(600)
            )
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxWidth()
                    .padding(top = 7.dp, bottom = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.description,
                    color = BaseFont,
                    fontSize = 14.sp,
                    modifier = Modifier.requiredWidth(202.dp)
                )
                if (item.price != null) {
                    Text(
                        text = "${item.price} P",
                        fontWeight = FontWeight(700),
                        color = Color(0xFFE8B100),
                        textAlign = TextAlign.End
                    )
                }
            }
            Text(
                text = "Specialization: Item Specialization",
                style = TextStyle(
                    fontSize = 14.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF3F6359),
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
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

@Composable
fun CommentItem(comment: CommentModel) {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            // .requiredWidth(350.dp)
            .padding(bottom = 8.dp)
            .background(color = BaseFont, RoundedCornerShape(15.dp))
        //.clickable { OrderScreen(item) }
    ) {
        Column(
            //horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 12.dp, top = 12.dp, start = 9.dp, end = 9.dp),
        ) {
            Text(
                text = comment.author,
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    fontSize = 16.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF3F6359),
                )
            )
            Text(
                text = comment.description,
                color = BaseFont,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(top = 7.dp)
                    .fillMaxWidth()
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column {
                    Text(
                        text = "Published: ${item.publicationDate}",
                        color = textGrey,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        modifier = Modifier.requiredWidth(158.dp)

                    )
                }
                Text(
                    text = "To answer",
                    textAlign = TextAlign.End,
                    color = richYellow,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                )

            }
        }
    }
}

@Composable
@Preview
fun OrderScreenPreview() {
    OrderScreen()
}