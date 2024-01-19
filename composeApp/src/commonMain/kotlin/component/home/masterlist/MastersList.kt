package component.home.masterlist

import com.arkivanov.decompose.value.Value
import data.ServicesModel

interface MastersList {
  val model: Value<Model>

  data class Model(
    val orders: List<ServicesModel>,
    val selectOrderId: Long?,
  )
}
