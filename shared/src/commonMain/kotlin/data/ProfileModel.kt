package data

import java.time.LocalDate

data class ProfileModel(
  val id: Long,
  val name: String,
  val phoneNumber: String,
  val email: String?,
  val city: String?,
  val birthdate: LocalDate?,
  val address: String?,
  val avatar: String?,
  val isMaster: Boolean = false,
  val services: ArrayList<ServicesModel>?,
//    val orders: ArrayList<OrdersModel>?,
//    val comment: ArrayList<CommentModel>?
)
