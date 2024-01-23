package component.home.serviceslist

import com.arkivanov.decompose.value.Value
import data.ServiceModel

interface ServicesList {
  val model: Value<Model>

  data class Model(
    val orders: List<ServiceModel>,
    val selectOrderId: Long?,
  )
}
