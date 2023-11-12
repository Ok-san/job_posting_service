package org.example.job_posting_service.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.job_posting_service.R
import org.example.job_posting_service.data.master1
import org.example.job_posting_service.data.master2
import org.example.job_posting_service.data.order1
import org.example.job_posting_service.data.order2
import org.example.job_posting_service.ui.theme.BaseFont
import org.example.job_posting_service.ui.theme.BaseLayer
import org.example.job_posting_service.ui.theme.FirstLayer
import org.example.job_posting_service.ui.theme.richYellow

@Composable
fun HomeScreen() {

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
                .padding(top = 22.dp, start = 20.dp, end = 20.dp, bottom = 8.dp),

            ) {
            when (tabIndex) {
                0 -> {
                    itemsIndexed(
                        listOf(order1, order2, order2, order2)
                    ) { _, item ->
                        OrderItem(item = item)
                    }
                }

                1 -> {
                    itemsIndexed(
                        listOf(master1, master2, master2, master2)
                    ) { _, item ->
                        MasterItem(item = item)
                    }
                }
            }
        }
    }
}

@Composable
fun SettingBar() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 47.dp, start = 20.dp, end = 20.dp)
            .height(50.dp)
//            .requiredWidth(361.dp)
            .fillMaxWidth(),
    ) {

        TextField(
            value = text,
            shape = RoundedCornerShape(size = 10.dp),
            //          modifier = Modifier.requiredHeight(39.dp),
//                .requiredWidth(292.dp),
            onValueChange = { newText ->
                text = newText
            },
            textStyle = TextStyle(
                fontSize = 16.sp,

//                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(400),
                color = BaseFont
            ),

            placeholder = {
                Text(
                    text = "Search",
                    fontSize = 16.sp,
//                fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = BaseFont
                    //modifier = Modifier.padding(0.dp)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0x308A9994),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            maxLines = 1,
        )
        IconButton(
            onClick = {},
            modifier = Modifier
                .width(39.dp)
                .fillMaxSize()
                .padding(6.dp)
                .background(color = Color(0x308A9994), shape = RoundedCornerShape(size = 10.dp))
        ) {
            Image(
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(39.dp),
                painter = painterResource(id = R.drawable.icon_filter),
                contentDescription = "image description",
                //contentScale = ContentScale.None
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
