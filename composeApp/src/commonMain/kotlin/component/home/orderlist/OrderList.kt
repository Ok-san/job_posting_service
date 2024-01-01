package component.home.orderlist

import data.OrdersModel

interface OrderList {
    val itemList: List<OrdersModel>
    fun onItemClicked(id: Long)
}