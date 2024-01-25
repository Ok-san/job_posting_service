package component.profile

import com.arkivanov.decompose.value.Value

interface EditableProfile {
  val model: Value<Model>

  data class Model(
    val name: String,
    val email: String,
    val phoneNumber: String,
    val city: String,
    val birthDate: String,
    val address: String
  )

  fun onClickBack()

  fun onClickSave()

  fun onChangeName(name: String)
  fun onChangeEmail(email: String)
  fun onChangeDateBirth(date: String)
  fun onChangeCity(city: String)
  fun onChangeAddress(address: String)
  fun onChangePhone(phone: String)

}
