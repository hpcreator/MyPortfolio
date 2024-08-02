package com.hpcreation.portfolio.components

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.models.Portfolio
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.styles.PortfolioSectionStyle
import com.hpcreation.portfolio.util.Constants.FONT_FAMILY
import com.hpcreation.portfolio.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier, portfolio: Portfolio
) {
    Link(
        modifier = PortfolioSectionStyle.toModifier().margin(5.px)
            .textDecorationLine(TextDecorationLine.None).borderRadius(20.px),
        path = portfolio.url,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Column(
            modifier = modifier.id("columnParent").width(Width.MaxContent)
                .backgroundColor(Theme.LighterGray.rgb).borderRadius(20.px)
        ) {
            Box(
                modifier = Modifier.id("boxParent").fillMaxWidth().maxWidth(300.px)
                    .margin(bottom = 20.px)
            ) {
                Image(
                    modifier = Modifier.size(300.px).borderRadius(20.px).objectFit(ObjectFit.Cover),
                    src = portfolio.image,
                    alt = "Portfolio Image"
                )
                Box(
                    modifier = Modifier.id("greenOverlay").fillMaxHeight()
                        .backgroundColor(argb(a = 0.5f, r = 0, g = 167, b = 142))
                        .borderRadius(20.px), contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.id("linkIcon").size(32.px),
                        src = Res.Icon.LINK,
                        alt = "Link Icon"
                    )
                }
            }
            P(
                attrs = Modifier.id("portfolioTitle").fillMaxWidth().maxWidth(280.px)
                    .margin(topBottom = 0.px).fontFamily(FONT_FAMILY).fontSize(18.px)
                    .fontWeight(FontWeight.Bold).toAttrs()
            ) {
                Text(portfolio.title)
            }
            P(
                attrs = Modifier.id("portfolioDesc").fillMaxWidth().maxWidth(280.px)
                    .margin(bottom = 10.px, right = 5.px).fontFamily(FONT_FAMILY).fontSize(14.px)
                    .fontWeight(FontWeight.Normal).color(Theme.Secondary.rgb).opacity(50.percent)
                    .toAttrs()
            ) {
                Text(portfolio.description)
            }
        }
    }
}