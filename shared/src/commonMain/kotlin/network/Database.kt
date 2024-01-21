package network

import data.CommentsModel
import data.OrdersModel
import data.ServicesModel
import data.comments
import data.orders
import data.services

interface Database {

  fun getOrders(): List<OrdersModel>
  fun getOrdersById(orderId: Int): OrdersModel
  fun getComments(orderId: Int): List<CommentsModel>
  fun getServices(): List<ServicesModel>

  fun createComment(orderId: Int, newComment: CommentsModel)
}

class DefaultDatabase : Database {
  override fun getOrders(): List<OrdersModel> = orders
  override fun getOrdersById(orderId: Int): OrdersModel = orders[orderId]
  override fun getComments(orderId: Int): List<CommentsModel> = comments
  override fun getServices(): List<ServicesModel> = services
  override fun createComment(orderId: Int, newComment: CommentsModel) {
    comments.add(newComment)
  }
}
