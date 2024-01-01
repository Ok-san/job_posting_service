package component.home.orderlist

import data.OrdersModel

interface OrderDetails {
    val item: OrdersModel
    fun onBackClicked()
}