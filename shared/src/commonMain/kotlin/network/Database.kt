package network

import data.OrdersModel

interface Database {

    fun getOrders(): List<OrdersModel>
    fun getOrdersById(id: Long): OrdersModel
}

class DefaultDatabase : Database {
    override fun getOrders(): List<OrdersModel> {
        TODO("Not yet implemented")
    }

    override fun getOrdersById(id: Long): OrdersModel {
        TODO("Not yet implemented")
    }

}