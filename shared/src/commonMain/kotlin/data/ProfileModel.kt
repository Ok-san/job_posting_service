package data

import java.time.LocalDate

data class ProfileModel(
  val id: Int,
  val name: String,
  val phoneNumber: String,
  val email: String?,
  val city: String,
  val birthdate: LocalDate?,
  val address: String?,
  val avatar: String?,
  val isMaster: Boolean = false,
  val services: ArrayList<ServiceModel>?,
//    val orders: ArrayList<OrdersModel>?,
//    val comment: ArrayList<CommentModel>?
)
