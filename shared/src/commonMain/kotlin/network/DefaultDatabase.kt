package network

import data.CommentsModel
import data.OrderModel
import data.ProfileModel
import data.ServiceModel
import data.comments
import data.orders
import data.profiles
import data.services
import data.users

class DefaultDatabase : Database {
  override fun searchUser(login: String, password: String): Int? {
    var userId: Int? = null
    users.forEach {
      if (it.login == login && it.password == password)
        userId = it.userId
    }
    return userId
  }

  override fun getUserInfo(userId: Int): ProfileModel? {
    profiles.forEach {
      if (it.userId == userId)
        return it
    }
    return null
  }

  override fun getUserOrders(userId: Int): List<OrderModel> {
    val userOrders: MutableList<OrderModel> = mutableListOf()

    profiles[userId].orders?.forEach forOrders@{ idOrders ->
      orders.forEach {
        if (it.orderId == idOrders) {
          userOrders.add(it)
          return@forOrders
        }
      }
    }
    return userOrders
  }

  override fun getUserServices(userId: Int): List<ServiceModel> {
    val userServices: MutableList<ServiceModel> = mutableListOf()

    profiles[userId].services?.forEach forService@{ idService ->
      services.forEach {
        if (it.id == idService) {
          userServices.add(it)
          return@forService
        }
      }
    }
    return userServices
  }

  override fun getOrders(): List<OrderModel> = orders
  override fun getOrdersById(orderId: Int): OrderModel = orders[orderId]
  override fun getUserName(userId: Int): String {
    profiles.forEach {
      if (it.userId == userId)
        return it.name

    }
    return ""
  }

  override fun getComments(orderId: Int): List<CommentsModel> = comments
  override fun getServices(): List<ServiceModel> = services
  override fun createComment(orderId: Int, newComment: CommentsModel) {
    comments.add(newComment)

    orders.forEach {
      if (it.orderId == orderId)
        it.comments?.add(comments.size)
    }
  }

  override fun deleteOrder(orderId: Int, userId: Int) {

  }

  override fun addOrder(userId: Int, newOrder: OrderModel) {
    TODO("Not yet implemented")
  }

  override fun updateProfileInfo(userId: Int, newData: ProfileModel) {
    profiles.forEach { profile ->
      if (profile.userId == userId) {
        profile.copy(
          userId = newData.userId,
          name = newData.name,
          phoneNumber = newData.phoneNumber,
          email = newData.email,
          city = newData.city,
          birthdate = newData.birthdate,
          address = newData.address,
          avatar = newData.avatar,
          isMaster = newData.isMaster,
        )
        return
      }
    }
  }
}
