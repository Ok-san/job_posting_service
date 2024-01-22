package component.home.masterlist

import com.arkivanov.decompose.value.Value
import data.ServiceModel

interface MastersList {
  val model: Value<Model>

  data class Model(
      val orders: List<ServiceModel>,
      val selectOrderId: Long?,
  )
}
