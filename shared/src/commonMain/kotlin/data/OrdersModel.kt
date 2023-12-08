package data

data class OrdersModel(
    val title: String = "I need help",
    val description: String = "I need help I need help",
    val price: String? = "500",
    val publicationDate: String = "Nov 11, 2023",
    val deadline: String = "Oct 22, 2023",
    val city: String = "Santiago",
    val favorite: Boolean = false
)
