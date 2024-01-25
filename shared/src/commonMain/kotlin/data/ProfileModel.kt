package data

import java.time.LocalDate


data class ProfileModel(
  var userId: Int,
  var name: String,
  var phoneNumber: String?,
  var email: String?,
  var city: String?,
  var birthdate: LocalDate?,
  var address: String?,
  val avatar: String?,
  val isMaster: Boolean = false,
  var services: MutableList<Int>,
  var orders: MutableList<Int>,
)
