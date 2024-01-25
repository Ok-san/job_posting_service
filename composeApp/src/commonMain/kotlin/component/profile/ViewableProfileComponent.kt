package component.profile

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import data.OrderModel
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
        profileInfo = database.getUserInfo(userId),
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

  override fun onClickArchiveOrder(orderId: Int) {
    val order = database.getOrdersById(orderId)
//    getAllCategories()
    database.deleteOrder(orderId, userId)
  }

  override fun onClickAddOrder(newOrder: OrderModel) {
    database.addOrder(userId, newOrder)
  }

  override fun onClickDeleteOrder(orderId: Int) {
    database.deleteOrder(orderId, userId)
  }
}
