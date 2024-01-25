package network

import data.CommentsModel
import data.OrderModel
import data.ProfileModel
import data.ServiceModel
import data.UserModel
import data.comment1
import data.order1
import data.order2
import data.order3
import data.profile1
import data.profile2
import data.service1
import data.service2
import data.user1
import data.user2
import java.time.LocalDate

class DefaultDatabase : Database {
  override var ordersTable: MutableList<OrderModel> = mutableListOf(order1, order2, order3)
  override var commentsTable: MutableList<CommentsModel> = mutableListOf(comment1, comment1)
  override var servicesTable: MutableList<ServiceModel> = mutableListOf(service1, service2, service2)
  override var usersTable: MutableList<UserModel> = mutableListOf(user1, user2)
  override var profilesTable: MutableList<ProfileModel> = mutableListOf(profile1, profile2)
  override fun searchUser(login: String, password: String): Int? {
    var userId: Int? = null
    usersTable.forEach forUser@{
      if (it.login == login && it.password == password) {
        userId = it.userId
        return@forUser
      }
    }
    return userId
  }

  override fun addUser(login: String, password: String, name: String): Int {
    val userId: Int = usersTable.size
    usersTable.add(
      UserModel(
        userId = userId,
        login = login,
        password = password
      )
    )
    profilesTable.add(
      ProfileModel(
        userId = userId,
        name = name,
        phoneNumber = null,
        email = null,
        city = null,
        birthdate = null,
        address = null,
        avatar = null,
        services = mutableListOf(),
        orders = mutableListOf()
      )
    )
    return userId
  }

  override fun getUserInfo(userId: Int): ProfileModel {
    var idProfile = 0
    profilesTable.forEachIndexed profileFor@{ index, it ->
      if (it.userId == userId) {
        idProfile = index
        return@profileFor
      }
    }
    return profilesTable[idProfile]
  }

  override fun getUserOrders(userId: Int): List<OrderModel> {
    val userOrders: MutableList<OrderModel> = mutableListOf()

    profilesTable[userId].orders.forEach forOrders@{ idOrders ->
      ordersTable.forEach {
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

    profilesTable[userId].services.forEach forService@{ idService ->
      servicesTable.forEach {
        if (it.id == idService) {
          userServices.add(it)
          return@forService
        }
      }
    }
    return userServices
  }

  override fun getOrders(): List<OrderModel> = ordersTable
  override fun getOrdersById(orderId: Int): OrderModel = ordersTable[orderId]
  override fun getUserName(userId: Int): String {
    profilesTable.forEach {
      if (it.userId == userId)
        return it.name

    }
    return ""
  }

  override fun getComments(orderId: Int): MutableList<CommentsModel> {
    val orderComments: MutableList<CommentsModel> = mutableListOf()
    ordersTable[orderId].comments?.forEach { orderIt ->
      commentsTable.forEach /*forComments@*/{ commentIt ->
        if (commentIt.id == orderIt) {
          orderComments.add(commentIt)
          /*return@forComments*/
        }
      }
    }
    return orderComments
  }

  override fun getServices(): List<ServiceModel> = servicesTable
  override fun createComment(orderId: Int, author: String, description: String): CommentsModel {
    val idComment = commentsTable.size
    val newComment =
      CommentsModel(
        id = idComment,
        author = author,
        description = description,
        publicationDate = LocalDate.now().toString(),
      )

    commentsTable.add(newComment)

    ordersTable.forEach forOrders@{
      if (it.orderId == orderId) {
        it.comments?.add(idComment)
        return@forOrders
      }
    }
    return newComment
  }

  override fun deleteOrder(orderId: Int, userId: Int) {

  }

  override fun addOrder(userId: Int, newOrder: OrderModel) {
    TODO("Not yet implemented")
  }

  override fun updateProfileInfo(
    userId: Int,
    name: String,
    city: String,
    address: String,
    email: String,
    phone: String,
    birthDate: String
  ) {

    profilesTable.forEach { profile ->
      if (profile.userId == userId) {
        profile.userId = userId
        profile.name = name
        profile.phoneNumber = phone
        profile.email = email
        profile.city = city
        profile.birthdate = LocalDate.parse(birthDate)
        profile.address = address
      }
      return
    }
  }
}
