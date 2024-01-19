package data

val orders: MutableList<OrdersModel>
    get() = mutableListOf(order1, order2, order3, order2)

val comments: MutableList<CommentsModel> by lazy { mutableListOf(comment1, comment1) }

val order1 =
    OrdersModel(
        title = "I need help I need help I need help I need help",
        description = "Very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. ",
        price = "100 000 000",
        favorite = true,
        publicationDate = "Oct 22, 2023",
        specialization = "Manicure",
        city = "San Vicente de Tagua Tagua",
        deadline = "Nov 11, 2023",
    )
val order2 =
    OrdersModel(
        title = "I need help",
        description = "Very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. ",
        price = "100 000",
        favorite = true,
        publicationDate = "Oct 14, 2023",
        specialization = "Java",
        city = "Santiago",
        deadline = "March 11, 2024",
    )
val order3 = order2.copy(description = "")

val profile1 =
    ProfileModel(
        id = 0,
        name = "Oksanus",
        city = "San Vicente de Tagua Tagua",
        address = null,
        email = null,
        phoneNumber = null,
        services = null,
    )
val profile2 =
    ProfileModel(
        id = 1,
        name = "Oksanus",
        city = "San Vicente de Tagua Tagua",
        address = null,
        email = null,
        phoneNumber = null,
        services = null,
    )

val service1 =
    ServicesModel(
        id = 0,
        category = "Beauty",
        description =
        "I'm very smart and cool. I’ve been working for a thousand years and in general everything is great for me.\n" +
            "I prefer to work remotely. But I can also come to you. \n" +
            "Call and write any time",
        specialization = "Manicure",
        city = "null",
        master = profile1,
        publicationDate = "Oct 22, 2023",
    )
val service2 =
    ServicesModel(
        id = 1,
        category = "Beauty",
        description =
        "I'm very smart and cool. I’ve been working for a thousand years and in general everything is great for me.\n" +
            "I prefer to work remotely. But I can also come to you. \n" +
            "Call and write any time",
        specialization = "Manicure",
        city = "null",
        master = profile2,
        publicationDate = "Oct 22, 2023",
    )
val comment1 =
    CommentsModel(
        id = 0,
        author = "Oksanus",
        description = "I'll do it in an hour during the week",
        publicationDate = "Oct 22, 2023",
    )
