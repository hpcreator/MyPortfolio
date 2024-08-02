package com.hpcreation.portfolio.sections

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.components.SocialBar
import com.hpcreation.portfolio.models.Section
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.styles.NavigationItemStyle
import com.hpcreation.portfolio.util.Constants.FONT_FAMILY
import com.hpcreation.portfolio.util.Constants.SECTION_WIDTH
import com.hpcreation.portfolio.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun FooterSection() {
    Box(
        modifier = Modifier.fillMaxWidth().maxWidth(SECTION_WIDTH.px).padding(topBottom = 60.px)
            .backgroundColor(Theme.LighterGray.rgb), contentAlignment = Alignment.Center
    ) {
        FooterContent()
    }
}

@Composable
fun FooterContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent
        ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(100.px), src = Res.Image.LOGO, alt = "Logo Image"
        )
        if (breakpoint > Breakpoint.SM) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                FooterMenu()
            }
        } else {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FooterMenu(row = false)
            }
        }
        SocialBar(row = true)
    }
}

@Composable
fun FooterMenu(row: Boolean = true) {
    Section.entries.forEach { section ->
        Link(
            modifier = NavigationItemStyle.toModifier().fontFamily(FONT_FAMILY).padding(
                right = if (row) 20.px else 0.px, bottom = if (row) 0.px else 20.px
            ).fontSize(14.px).fontWeight(FontWeight.Normal)
                .textDecorationLine(TextDecorationLine.None),
            path = section.path,
            text = section.title
        )
    }
}

