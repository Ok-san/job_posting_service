package data

data class ProfileModel(
    val id: Long,
    val name: String,
    val city: String,
    val address: String?,
    val avatar: String = "avatar",
    val phoneNumber: String?,
    val email: String?,
    val isMaster: Boolean = false,
    val services: ArrayList<ServicesModel>?,
//    val orders: ArrayList<OrdersModel>?,
//    val comment: ArrayList<CommentModel>?
)
