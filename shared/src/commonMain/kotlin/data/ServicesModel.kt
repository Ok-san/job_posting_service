package data

data class ServicesModel(
    val id: Long,
    val category: String,
    val specialization: String,
    val coast: String? = null,
    val description: String,
    val master: ProfileModel,
    val favorite: Boolean = false,
    val publicationDate: String,
    val city: String?,
)
