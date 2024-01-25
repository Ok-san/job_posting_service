package theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.sp

val InterFamily =
  FontFamily(
    Font("font/inter_black.ttf", FontWeight.Black),
    Font("font/inter_bold.ttf", FontWeight.Bold),
    Font("font/inter_extrabold.ttf", FontWeight.ExtraBold),
    Font("font/inter_extralight.ttf", FontWeight.ExtraLight),
    Font("font/inter_light.ttf", FontWeight.Light),
    Font("font/inter_medium.ttf", FontWeight.Medium),
    Font("font/inter_regular.ttf", FontWeight.Normal),
    Font("font/inter_semibold.ttf", FontWeight.SemiBold),
    Font("font/inter_thin.ttf", FontWeight.Thin),
  )

val InterTypography =
  Typography(
    titleLarge =
      TextStyle(
        color = BaseFont,
        fontFamily = InterFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
      ),
    titleMedium =
      TextStyle(
        color = BaseFont,
        fontFamily = InterFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
      ),
    titleSmall =
      TextStyle(
        color = BaseFont,
        fontFamily = InterFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
      ),
    labelMedium =
      TextStyle(
        color = BaseFont,
        fontFamily = InterFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
      ),
    labelSmall =
      TextStyle(
        color = BaseFont,
        fontFamily = InterFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
      ),
    bodyMedium =
      TextStyle(
        color = BaseFont,
        fontFamily = InterFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
      ),
    bodySmall =
      TextStyle(
        color = FirstFont,
        fontFamily = InterFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
      ),
  )
