package component.profile

import com.arkivanov.decompose.value.Value
import data.OrderModel
import data.ProfileModel
import data.ServiceModel

interface ViewableProfile {
  val model: Value<Model>

  data class Model(
    val ordersList: List<OrderModel>,
    val servicesList: List<ServiceModel>,
    val profileInfo: ProfileModel,
  )

  fun onClickLogOut()

  fun onClickEditProfile()

  fun onClickEditOrder(orderId: Int)

  fun onClickAddOrder(newOrder: OrderModel)

  fun onClickArchiveOrder(orderId: Int)

  fun onClickDeleteOrder(orderId: Int)

//  fun onClickFavoriteProfile()
//  fun onClickOrder(idOrder: Int)
//  fun onClickService(id: Int)
//  fun onClickEditService(id: Int)
}
