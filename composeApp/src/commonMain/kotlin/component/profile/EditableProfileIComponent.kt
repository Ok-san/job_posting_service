package component.profile

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import data.ProfileModel
import network.DefaultDatabase

class EditableProfileIComponent(
  context: ComponentContext,
  private val userId: Int,
  private val database: DefaultDatabase,
  val onBack: () -> Unit,
) : EditableProfile, ComponentContext by context {

  private val _model = MutableValue(
    EditableProfile.Model(
      profileInfo = database.getUserInfo(userId)!!
    )
  )
  override val model: Value<EditableProfile.Model>
    get() = _model

  override fun onClickBack() {
    onBack()
  }

  override fun onClickSave(newData: ProfileModel) {
    _model.update { it.copy(profileInfo = newData) }
    database.updateProfileInfo(userId, _model.value.profileInfo)
  }
}
