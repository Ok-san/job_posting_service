package data

import java.time.LocalDate

val order1 =
  OrderModel(
    orderId = 0,
    title = "I need help I need help I need help I need help",
    description = "Very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. I can't. It's very urgent. ",
    price = "100 000 000",
    favorite = false,
    publicationDate = "Oct 22, 2023",
    specialization = "Manicure",
    city = "San Vicente de Tagua Tagua",
    deadline = "Nov 11, 2023",
    comments = mutableListOf(0)
  )

val order2 =
  OrderModel(
    orderId = 1,
    title = "I need help",
    description = "I'm very smart and cool. I’ve been working for a thousand years and in general everything is great for me.I'm very smart and cool. I’ve been working for a thousand years and in general everything is great for me.I'm very smart and cool. I’ve been working ...",
    price = "100",
    favorite = true,
    publicationDate = "Oct 14, 2023",
    specialization = "Java",
    city = "Santiago",
    deadline = "March 11, 2024",
    comments = mutableListOf(),
  )

val order3 = order1.copy(description = "", orderId = 2)

val profile1 =
  ProfileModel(
    userId = 0,
    name = "Oksanus",
    phoneNumber = "+70123456789",
    email = "example@gmail.com",
    city = "San Vicente de Tagua Tagua",
    birthdate = LocalDate.parse("2000-12-12"),
    address = null,
    avatar = null,
    services = mutableListOf(0, 1),
    orders = mutableListOf(0, 1),
  )

val profile2 =
  ProfileModel(
    userId = 1,
    name = "Vladboba",
    phoneNumber = "+79990123456",
    email = "example1@gmail.com",
    city = "Santiago",
    birthdate = LocalDate.parse("1994-10-03"),
    address = null,
    avatar = null,
    services = mutableListOf(),
    orders = mutableListOf(2),
  )

val service1 =
  ServiceModel(
    id = 0,
    category = "Beauty",
    description =
    "I'm very smart and cool. I’ve been working for a thousand years and in general everything is great for me.\n" +
      "I prefer to work remotely. But I can also come to you. \n" +
      "Call and write any time",
    specialization = "Manicure",
    city = null,
    master = profile1,
    publicationDate = "Oct 22, 2023",
  )
val service2 =
  ServiceModel(
    id = 1,
    category = "Beauty",
    description =
    "I'm very smart and cool. I’ve been working for a thousand years and in general everything is great for me.\n" +
      "I prefer to work remotely. But I can also come to you. \n" +
      "Call and write any time",
    specialization = "Manicure",
    city = null,
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

val user1 = UserModel(
  userId = 0,
  login = "user1",
  password = "user1"
)
val user2 = UserModel(
  userId = 1,
  login = "user2",
  password = "user2"
)
