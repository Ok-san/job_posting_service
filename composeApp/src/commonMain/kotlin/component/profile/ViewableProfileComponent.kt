package component.profile

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import data.OrderModel
import data.ProfileModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.runBlocking
import network.DefaultDatabase

class ViewableProfileComponent(
  context: ComponentContext,
  private val database: DefaultDatabase,
  private val userId: Int,
  val onLogOut: () -> Unit,
  val onEdit: () -> Unit,
) : ComponentContext by context, ViewableProfile {
  private val _model =
    MutableValue(
      ViewableProfile.Model(
        profileInfo = runBlocking { gets("api/getinfo") },
        //database.getUserInfo(userId),
        ordersList = database.getUserOrders(userId),
        servicesList = database.getUserServices(userId),
      ),
    )

  override val model: Value<ViewableProfile.Model> get() = _model



  override fun onClickLogOut() {
    onLogOut()
  }

  override fun onClickEditProfile() {
    onEdit()
  }

  //  override fun onClickFavoriteProfile() {
//    TODO("Not yet implemented")
//  }
  override fun onClickEditOrder(orderId: Int) {
    TODO("Not yet implemented")
  }

  override fun onClickAddOrder(newOrder: OrderModel) {
    database.addOrder(userId, newOrder)
  }

  override fun onClickDeleteOrder(orderId: Int) {
    database.deleteOrder(orderId, userId)
  }

  suspend fun gets(url: String): ProfileModel {
    val client = HttpClient()
    val response: ProfileModel = client.get("http://localhost:8080/$url").body()
    return response
  }

  suspend fun post(url: String, tables: ProfileModel): HttpResponse {
    val client = HttpClient()
    val response: HttpResponse = client.post("http://localhost:8080/$url") {
      contentType(ContentType.Application.Json)
      setBody(tables)
    }
    return response
  }
}
