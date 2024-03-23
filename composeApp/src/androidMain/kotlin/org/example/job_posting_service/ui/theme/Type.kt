package org.example.job_posting_service.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.example.job_posting_service.R
import theme.BaseFont
import theme.FirstFont

val InterFamily =
  FontFamily(
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold),
    Font(R.font.inter_extralight, FontWeight.ExtraLight),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_thin, FontWeight.Thin),
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
