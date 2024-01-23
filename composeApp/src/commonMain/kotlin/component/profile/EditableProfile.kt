package component.profile

import com.arkivanov.decompose.value.Value
import data.ProfileModel

interface EditableProfile {
  val model: Value<Model>

  data class Model(
    val profileInfo: ProfileModel,
  )

  fun onClickBack()

  fun onClickSave(newData: ProfileModel)
}
