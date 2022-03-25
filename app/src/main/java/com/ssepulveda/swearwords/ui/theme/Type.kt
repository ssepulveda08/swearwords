package com.ssepulveda.swearwords.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ssepulveda.swearwords.R

// Set of Material typography styles to start with
val Typography by lazy {
    Typography(
        body1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        body2 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        h1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        h2 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        ),
        h3 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        ),
        caption = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Thin,
            fontSize = 10.sp
        ),
        button = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp
        ),
        overline = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp
        )
    )
}

val fonts = FontFamily(
    Font(R.font.roboto_black),
    Font(R.font.roboto_bold, weight = FontWeight.Bold),
    Font(R.font.roboto_light, weight = FontWeight.Light),
    Font(R.font.roboto_thin, weight = FontWeight.Thin),
    Font(R.font.roboto_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.roboto_bold_italic, weight = FontWeight.SemiBold),
)