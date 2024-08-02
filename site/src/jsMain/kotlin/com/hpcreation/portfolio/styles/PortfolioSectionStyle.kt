package com.hpcreation.portfolio.styles

import com.hpcreation.portfolio.models.Theme
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


val PortfolioSectionStyle = CssStyle {
    cssRule(" > #columnParent > #boxParent > #greenOverlay") {
        Modifier.width(0.px).transition(Transition.of(property = "width", duration = 500.ms))
    }

    cssRule(":hover > #columnParent > #boxParent > #greenOverlay") {
        Modifier.width(300.px)
    }

    cssRule(" > #columnParent > #boxParent > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Hidden)
    }

    cssRule(":hover > #columnParent > #boxParent > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Visible)
    }

    cssRule(" > #columnParent > #portfolioTitle") {
        Modifier.color(Theme.Secondary.rgb).translateX(5.percent).transition(
            Transition.of(property = "color", duration = 200.ms),
            Transition.of(property = "translate", duration = 200.ms)
        )
    }

    cssRule(":hover > #columnParent > #portfolioTitle") {
        Modifier.color(Theme.Primary.rgb).translateX(8.percent)
    }

    cssRule(" > #columnParent > #portfolioDesc") {
        Modifier.translateX(5.percent)
            .transition(Transition.of(property = "translate", duration = 200.ms))
    }

    cssRule(":hover > #columnParent > #portfolioDesc") {
        Modifier.translateX(6.percent)
    }
}

val PortfolioArrowIconStyle = CssStyle {
    base {
        Modifier.color(Theme.Gray.rgb)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
    }
}