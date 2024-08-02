package com.hpcreation.portfolio.sections

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.components.PortfolioCard
import com.hpcreation.portfolio.components.SectionTitle
import com.hpcreation.portfolio.models.Portfolio
import com.hpcreation.portfolio.models.Section
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.styles.PortfolioArrowIconStyle
import com.hpcreation.portfolio.util.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun PortfolioSection() {
    Box(
        modifier = Modifier.id(Section.Portfolio.id).fillMaxWidth().maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px).backgroundColor(Theme.LightGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        PortfolioContent()
    }
}

@Composable
fun PortfolioContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent
        ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth().margin(bottom = 25.px),
            section = Section.Portfolio,
            alignment = Alignment.CenterHorizontally
        )
        PortfolioCards(breakpoint = breakpoint)
        PortfolioNavigation()
    }
}

@Composable
fun PortfolioCards(breakpoint: Breakpoint) {
    Row(
        modifier = Modifier.id("scrollableContainer").fillMaxWidth().margin(bottom = 25.px)
            .maxWidth(
                if (breakpoint > Breakpoint.MD) 980.px
                else if (breakpoint > Breakpoint.SM) 645.px
                else 310.px
            ).overflow(Overflow.Hidden).scrollBehavior(ScrollBehavior.Smooth)
    ) {
        Portfolio.entries.forEachIndexed { index, portfolio ->
            PortfolioCard(
                modifier = Modifier.margin(
                    right = if (index != Portfolio.entries.lastIndex) 25.px else 0.px
                ), portfolio = portfolio
            )
        }
    }
}

@Composable
fun PortfolioNavigation() {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        FaArrowLeft(
            modifier = PortfolioArrowIconStyle.toModifier().margin(right = 40.px)
                .cursor(Cursor.Pointer).onClick {
                    document.getElementById("scrollableContainer")?.scrollBy(x = (-340.0), y = 0.0)
                }, size = IconSize.LG
        )
        FaArrowRight(
            modifier = PortfolioArrowIconStyle.toModifier().cursor(Cursor.Pointer).onClick {
                document.getElementById("scrollableContainer")?.scrollBy(x = 340.0, y = 0.0)
            }, size = IconSize.LG
        )
    }
}