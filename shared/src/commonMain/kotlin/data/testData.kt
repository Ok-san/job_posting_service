package data

val order1 = OrdersModel(
    title = "I need help I need help I need help I need help",
    description = "Very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. ",
    price = "100 000 000",
    favorite = true,
    publicationDate = "Oct 22, 2023",
    specialization = "Manicure",
    city = "San Vicente de Tagua Tagua",
    deadline = "Deadline: Nov 11, 2023"
)
val order2 = OrdersModel(
    title = "I need help I need help I need help I need help",
    description = "Very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. ",
    price = "100 000 000",
    favorite = true,
    publicationDate = "Oct 22, 2023",
    specialization = "Java",
    city = "San Vicente de Tagua Tagua",
    deadline = null
)
val profile1 = ProfileModel(
    name = "Oksanus",
    city = "San Vicente de Tagua Tagua",
    address = null,
    email = null,
    phoneNumber = null,
    services = null
)
val profile2 = ProfileModel(
    name = "Oksanus",
    city = "San Vicente de Tagua Tagua",
    address = null,
    email = null,
    phoneNumber = null,
    services = null
)

val service1 = ServicesModel(
    category = "Beauty",
    description = "I'm very smart and cool. I’ve been working for a thousand years and in general everything is great for me.\n" +
            "I prefer to work remotely. But I can also come to you. \n" +
            "Call and write any time",
    specialization = "Manicure",
    city = "null",
    master = profile1,
    publicationDate = "Oct 22, 2023"
)
val service2 = ServicesModel(
    category = "Beauty",
    description = "I'm very smart and cool. I’ve been working for a thousand years and in general everything is great for me.\n" +
            "I prefer to work remotely. But I can also come to you. \n" +
            "Call and write any time",
    specialization = "Manicure",
    city = "null",
    master = profile2,
    publicationDate = "Oct 22, 2023"
)
val comment1 = CommentModel(
    author = "Oksanus",
    description = "I'll do it in an hour during the week",
    publicationDate ="Oct 22, 2023"
)