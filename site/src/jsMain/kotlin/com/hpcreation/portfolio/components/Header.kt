package com.hpcreation.portfolio.components

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.models.Section
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.styles.LogoStyle
import com.hpcreation.portfolio.styles.NavigationItemStyle
import com.hpcreation.portfolio.util.Constants.FONT_FAMILY
import com.hpcreation.portfolio.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Header(onMenuClicked: () -> Unit) {
    val breakpoint = rememberBreakpoint()
    Row(
        modifier = Modifier.fillMaxWidth(if (breakpoint > Breakpoint.MD) 80.percent else 90.percent)
            .margin(topBottom = 50.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide(
            breakpoint = breakpoint, onMenuClicked = onMenuClicked
        )
        if (breakpoint > Breakpoint.MD) {
            RightSide()
        }
    }
}


@Composable
fun LeftSide(
    breakpoint: Breakpoint, onMenuClicked: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (breakpoint <= Breakpoint.MD) {
            FaBars(
                modifier = Modifier.margin(right = 15.px).onClick {
                    onMenuClicked()
                }, size = IconSize.XL
            )
        }
        Image(
            modifier = LogoStyle.toModifier(), src = Res.Image.LOGO, alt = "Logo Image"
        )
    }
}

@Composable
fun RightSide() {
    Row(
        modifier = Modifier.fillMaxWidth().borderRadius(r = 30.px)
            .backgroundColor(Theme.LighterGray.rgb).padding(topBottom = 2.px, leftRight = 30.px),
        horizontalArrangement = Arrangement.End
    ) {
        Section.entries.forEach { section ->
            /*Link(
                modifier = NavigationItemStyle.toModifier().padding(15.px).fontFamily(FONT_FAMILY)
                    .fontSize(18.px).fontWeight(
                        FontWeight.Normal
                    ).textDecorationLine(TextDecorationLine.None),
                path = section.path,
                text = section.title
            )*/
            Link(
                path = section.path,
                openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
                modifier = Modifier.padding(leftRight = 15.px, top = 15.px)
                    .textDecorationLine(TextDecorationLine.None)
            ) {
                P(
                    attrs = NavigationItemStyle.toModifier().fontFamily(FONT_FAMILY).fontSize(18.px)
                        .fontWeight(
                            FontWeight.Normal
                        ).textDecorationLine(TextDecorationLine.None).toAttrs()
                ) {
                    Text(value = section.title)
                }
            }
        }
    }
}