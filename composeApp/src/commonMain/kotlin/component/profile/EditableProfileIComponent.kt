package component.profile

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import network.DefaultDatabase

class EditableProfileIComponent(
  context: ComponentContext,
  private val userId: Int,
  private val database: DefaultDatabase,
  val onBack: () -> Unit,
  val onSave: () -> Unit,
) : EditableProfile, ComponentContext by context {
  private val profileInfo = database.getUserInfo(userId)
  private val _model =
    MutableValue(
      EditableProfile.Model(
        name = profileInfo.name,
        email = profileInfo.email ?: "",
        phoneNumber = profileInfo.phoneNumber ?: "",
        city = profileInfo.city ?: "",
        birthDate = profileInfo.birthdate.toString(),
        address = profileInfo.address ?: "",
      ),
    )
  override val model: Value<EditableProfile.Model>
    get() = _model

  override fun onClickBack() {
    onBack()
  }

  override fun onClickSave() {
    database.updateProfileInfo(
      userId = userId,
      name = _model.value.name,
      city = _model.value.city,
      address = _model.value.address,
      email = _model.value.email,
      phone = _model.value.phoneNumber,
      birthDate = _model.value.birthDate
    )
    onSave()
  }

  override fun onChangeName(name: String) {
    _model.update { it.copy(name = name) }
  }

  override fun onChangeEmail(email: String) {
    _model.update { it.copy(email = email) }
  }

  override fun onChangeDateBirth(date: String) {
    _model.update { it.copy(birthDate = date) }
  }

  override fun onChangeCity(city: String) {
    _model.update { it.copy(city = city) }
  }

  override fun onChangeAddress(address: String) {
    _model.update { it.copy(address = address) }
  }

  override fun onChangePhone(phone: String) {
    _model.update { it.copy(phoneNumber = phone) }
  }
}
