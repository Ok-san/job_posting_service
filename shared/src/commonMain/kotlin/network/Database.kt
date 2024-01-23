package network

import data.CommentsModel
import data.OrderModel
import data.ProfileModel
import data.ServiceModel

interface Database {

  fun searchUser(login: String, password: String): Int?
  fun getUserInfo(userId: Int): ProfileModel?
  fun getUserOrders(userId: Int): List<OrderModel>
  fun getUserServices(userId: Int): List<ServiceModel>
  fun getOrders(): List<OrderModel>
  fun getOrdersById(orderId: Int): OrderModel
  fun getUserName(userId: Int): String
  fun getComments(orderId: Int): List<CommentsModel>
  fun getServices(): List<ServiceModel>
  fun createComment(orderId: Int, newComment: CommentsModel)
  fun deleteOrder(orderId: Int, userId: Int)
  fun addOrder(userId: Int, newOrder: OrderModel)
  fun updateProfileInfo(userId: Int, newData: ProfileModel)
}
