package data

import kotlinx.serialization.Serializable

@Serializable
data class OrdersList(val result: List<OrdersModel>)
