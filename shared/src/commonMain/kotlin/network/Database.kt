package network

import data.CommentsModel
import data.OrderModel
import data.ProfileModel
import data.ServiceModel
import data.UserModel

interface Database {

  var ordersTable: MutableList<OrderModel>
  var commentsTable: MutableList<CommentsModel>
  var servicesTable: MutableList<ServiceModel>
  var usersTable: MutableList<UserModel>
  var profilesTable: MutableList<ProfileModel>
  fun searchUser(login: String, password: String): Int?
  fun addUser(login: String, password: String, name: String): Int
  fun getUserInfo(userId: Int): ProfileModel
  fun getUserOrders(userId: Int): List<OrderModel>
  fun getUserServices(userId: Int): List<ServiceModel>
  fun getOrders(): List<OrderModel>
  fun getOrdersById(orderId: Int): OrderModel
  fun getUserName(userId: Int): String
  fun getComments(orderId: Int): MutableList<CommentsModel>?
  fun getServices(): List<ServiceModel>
  fun createComment(orderId: Int, author: String, description: String) : CommentsModel
  fun deleteOrder(orderId: Int, userId: Int)
  fun addOrder(userId: Int, newOrder: OrderModel)
  fun updateProfileInfo(userId: Int,
                        name: String,
                        city: String,
                        address: String,
                        email: String,
                        phone: String,
                        birthDate: String
                        )
}
