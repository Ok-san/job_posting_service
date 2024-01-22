package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderModel(
  @SerialName("id") val orderId: Int = 0,
  @SerialName("user_id") val userId: Int = 0,
  @SerialName("publication_date") val publicationDate: String,
  val title: String,
  val specialization: String,
  val price: String? = null,
  val deadline: String? = null,
  val city: String? = null,
  val description: String? = null,
  val comments: List<Int> = emptyList(),
  var favorite: Boolean = false,
)
