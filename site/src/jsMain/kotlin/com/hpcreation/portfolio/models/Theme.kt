package com.hpcreation.portfolio.models

import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val rgb: CSSColorValue
) {
    Primary(rgb = rgb(r = 0, g = 167, b = 142)), Secondary(
        rgb = rgb(r = 18, g = 29, b = 52)
    ),
    Gray(rgb = rgb(r = 207, g = 207, b = 207)), LighterGray(
        rgb = rgb(r = 249, g = 249, b = 249)
    ),
    White(
        rgb = rgb(r = 255, g = 255, b = 255)
    ),
    LightGray(rgb = rgb(r = 237, g = 237, b = 237)), Black50(
        rgb = argb(a = 0.5f, r = 0.0f, g = 0.0f, b = 0.0f)
    )
}