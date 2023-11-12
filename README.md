Приложение является аналогом сервиса Профи.ру, которое реализует функционал подбора людей для исполнения определенных задач в быту и не только.
Люди – заказчики могут размещать объявления с просьбой о помощи и самостоятельно искать исполнителя, просматривая соответствующую доску.
Люди – исполнители могу размещать информацию о своих навыках и подбирать для себя подходящие заказы.

This is a Kotlin Multiplatform project targeting Android, Desktop, Server.

* `/server` is for the Ktor server application.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
