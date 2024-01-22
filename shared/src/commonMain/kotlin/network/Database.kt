package network

import data.CommentsModel
import data.OrderModel
import data.ServiceModel
import data.comments
import data.orders
import data.services

interface Database {

  fun getOrders(): List<OrderModel>
  fun getOrdersById(orderId: Int): OrderModel
  fun getComments(orderId: Int): List<CommentsModel>
  fun getServices(): List<ServiceModel>

  fun createComment(orderId: Int, newComment: CommentsModel)
}

class DefaultDatabase : Database {
  override fun getOrders(): List<OrderModel> = orders
  override fun getOrdersById(orderId: Int): OrderModel = orders[orderId]
  override fun getComments(orderId: Int): List<CommentsModel> = comments
  override fun getServices(): List<ServiceModel> = services
  override fun createComment(orderId: Int, newComment: CommentsModel) {
    comments.add(newComment)
  }
}
