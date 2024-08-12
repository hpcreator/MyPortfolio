package com.hpcreation.portfolio.styles

import com.hpcreation.portfolio.models.Theme
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val AboutImageStyle = CssStyle {
    base {
        Modifier.borderRadius(r = 0.px).rotate(0.deg).transition(
            Transition.of(
                property = TransitionProperty.of("opacity"), duration = 200.ms
            )
        )
    }
    hover {
        Modifier.borderRadius(r = 100.px)
    }
}

val AboutTextStyle = CssStyle {
    base {
        Modifier.opacity(70.percent)
            .transition(Transition.of(property = "opacity", duration = 200.ms))
    }
    hover {
        Modifier.opacity(100.percent)
    }
}

val SkillImageStyle = CssStyle {
    base {
        Modifier.width(80.px).height(80.px)
            .transition(Transition.of(property = "width", duration = 200.ms))
    }
    hover {
        Modifier.width(100.px).height(90.px)
    }
}
val ResumeButtonStyle = CssStyle {
    base {
        Modifier.width(140.px).transition(Transition.of(property = "width", duration = 200.ms))
            .border(width = 2.px, color = Theme.Primary.rgb, style = LineStyle.Solid)
            .backgroundColor(Colors.Transparent)
    }
    hover {
        Modifier.width(150.px)
    }
}