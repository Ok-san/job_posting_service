package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrdersModel(
    @SerialName("id") val orderId: Long = 0,
    @SerialName("user_id") val userId: Long = 0,
    val title: String,
    val description: String,
    val price: String?,
    @SerialName("publication_date") val publicationDate: String,
    val deadline: String?,
    val city: String,
    val specialization: String,
    var favorite: Boolean = false
)
