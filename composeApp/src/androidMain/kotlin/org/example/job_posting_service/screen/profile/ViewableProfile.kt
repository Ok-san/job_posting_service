package org.example.job_posting_service.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import data.OrderModel
import data.ProfileModel
import data.ServiceModel
import data.order1
import data.order2
import data.profile1
import data.service1
import data.service2
import org.example.job_posting_service.R
import org.example.job_posting_service.module.BackButton
import org.example.job_posting_service.module.BasicTextButton
import org.example.job_posting_service.module.CompoundButton
import org.example.job_posting_service.module.FavoritesButton
import org.example.job_posting_service.ui.theme.ProfileTypography
import org.example.job_posting_service.ui.theme.mainIconSize
import org.jetbrains.compose.resources.ExperimentalResourceApi
import theme.BaseLayer
import theme.FirstLayer
import theme.PlaceholderBackground
import theme.SecondLayer
import theme.first_layer_shape


@OptIn(ExperimentalResourceApi::class, ExperimentalLayoutApi::class)
@Composable
fun ViewableProfileScreen() {
  // / вот тут чтото нормальное должно быть
  val user: ProfileModel = profile1
//  val services: ArrayList<ServicesModel> = arrayListOf()
  val services: ArrayList<ServiceModel> = arrayListOf(service1, service2)
  val orders: ArrayList<OrderModel> = arrayListOf(order1, order2)
  // /

  val message = remember { mutableStateOf("") }

  Box(
    modifier =
    Modifier
      .fillMaxSize()
      .background(BaseLayer)
  ) {
    Box(
      modifier =
      Modifier
        .fillMaxWidth()
        .zIndex(1f),
      contentAlignment = Alignment.Center,
    ) {
      Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        modifier =
        Modifier
          .size(mainIconSize)
          .offset(y = 80.dp)
          .clip(RoundedCornerShape(mainIconSize / 2)),
      )
    }
    Column {
      Row(
        modifier =
        Modifier
          .padding(20.dp)
          .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        BackButton({})
        BasicTextButton("Log Out", {})
        BasicTextButton("Edit", {})
        FavoritesButton()
      }
      Column(
        modifier =
        Modifier
          .fillMaxSize()
          .padding(top = mainIconSize / 2 - 10.dp)
          .clip(RoundedCornerShape(40.dp, 40.dp))
          .background(FirstLayer)
          .padding(20.dp)
      ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
          Column(
            modifier =
            Modifier
              .padding(bottom = 10.dp)
              .shadow(
                elevation = 6.dp,
                shape = first_layer_shape,
                spotColor = Color.Black,
              )
              .clip(first_layer_shape)
              .background(SecondLayer)
              .padding(10.dp),
          ) {
            Box(
              modifier =
              Modifier
                .fillMaxWidth()
                .padding(top = mainIconSize / 2 - 20.dp),
              contentAlignment = Alignment.Center,
            ) {
              Text(
                text = user.name,
                style = ProfileTypography.titleMedium,
              )
            }
            Column {
              PersonalInfoField("Email: " + user.email)
              PersonalInfoField("Date of birth: " + user.birthdate)
              PersonalInfoField("City: " + user.city)
              PersonalInfoField("Phone number: " + user.phoneNumber)
            }
          }

          Row(
            modifier =
            Modifier
              .fillMaxWidth()
              .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
          ) {
            Text(
              "Order",
              modifier = Modifier
                .shadow(
                  elevation = 6.dp,
                  shape = first_layer_shape,
                  spotColor = Color.Black,
                )
                .clip(first_layer_shape)
                .background(BaseLayer)
                .padding(20.dp, 6.dp),
              style = ProfileTypography.titleMedium,
            )
            CompoundButton("Add order", Icons.Default.AddCircleOutline, {}, BaseLayer)
          }

          orders?.forEach { order ->
            OrderItem(order = order)
          }

          Row(
            modifier =
            Modifier
              .fillMaxWidth()
              .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
          ) {
            Text(
              "Services",
              modifier = Modifier
                .shadow(
                  elevation = 6.dp,
                  shape = first_layer_shape,
                  spotColor = Color.Black,
                )
                .clip(first_layer_shape)
                .background(BaseLayer)
                .padding(20.dp, 6.dp),
              style = ProfileTypography.titleMedium,
            )

            CompoundButton("Add service", Icons.Default.AddCircleOutline, {}, BaseLayer)
          }

          services?.forEach { service ->
            ServiceItem(service = service)
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OrderItem(order: OrderModel) {
  Column(
    modifier =
    Modifier
      .padding(bottom = 10.dp)
      .shadow(
        elevation = 6.dp,
        shape = first_layer_shape,
        spotColor = Color.Black,
      )
      .clip(first_layer_shape)
      .background(SecondLayer)
      .padding(10.dp),
  ) {


    Column {
      Row(
        modifier =
        Modifier
          .fillMaxWidth()
          .padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = order.title,
          modifier =
          Modifier
            .padding(horizontal = 6.dp)
            .weight(1f),
          style = ProfileTypography.titleSmall,
        )
        FavoritesButton()
      }

      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
          .fillMaxWidth()
          .padding(bottom = 10.dp)
      ) {
        OrderInfoField(order.specialization)
        order.city?.let {
          OrderInfoField(order.city!!)
        }
        OrderInfoField("Publication: " + order.publicationDate)
        order.deadline?.let {
          OrderInfoField("Deadline: " + order.deadline!!)
        }
        order.price?.let {
          OrderInfoField("Payment: " + order.price!!)
        }
      }
      order.description?.let {
        OrderInfoField(order.description!!)
      }
    }

    Row(
      modifier =
      Modifier
        .fillMaxWidth()
        .padding(top = 10.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      BasicTextButton("Edit", {})
      CompoundButton("Delete", Icons.Default.Delete, {})
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ServiceItem(service: ServiceModel) {
  Column(
    modifier =
    Modifier
      .padding(bottom = 10.dp)
      .shadow(
        elevation = 6.dp,
        shape = first_layer_shape,
        spotColor = Color.Black,
      )
      .clip(first_layer_shape)
      .background(SecondLayer)
      .padding(10.dp),
  ) {
    Column {
      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
          .fillMaxWidth()
          .padding(bottom = 10.dp)
      ) {
        OrderInfoField(service.category)
        OrderInfoField(service.specialization)
        service.city?.let {
          OrderInfoField(service.city!!)
        }
        OrderInfoField("Publication Date: " + service.publicationDate)
        service.coast?.let {
          OrderInfoField(service.coast!!)
        }
      }
      service.description?.let {
        OrderInfoField(service.description!!)
      }
    }

    Row(
      modifier =
      Modifier
        .fillMaxWidth()
        .padding(top = 10.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      BasicTextButton("Edit", {})
      CompoundButton("Delete", Icons.Default.Delete, {})
    }
  }
}

@Composable
fun PersonalInfoField(text: String) {
  Text(
    text = text,
    modifier = Modifier.padding(6.dp, 2.dp),
    style = ProfileTypography.bodyMedium,
  )
}

@Composable
fun OrderInfoField(text: String) {
  Text(
    text = text,
    modifier =
    Modifier
      .clip(RoundedCornerShape(20.dp))
      .background(PlaceholderBackground)
      .padding(12.dp, 4.dp),
    style = ProfileTypography.bodyMedium,
  )
}

@Preview
@Composable
fun ViewableProfileScreenPreview() {
  ViewableProfileScreen()
}
