package com.hpcreation.portfolio.components

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.models.Experience
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.times
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    breakpoint: Breakpoint,
    active: Boolean = false,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    SimpleGrid(
        modifier = Modifier.fillMaxWidth()
            .maxWidth(if (breakpoint >= Breakpoint.MD) 60.percent else 90.percent),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        ExperienceDescription(active = active, description = experience.description)
        ExperienceDetail(
            breakpoint = breakpoint,
            active = active,
            experience = experience,
            animatedMargin = animatedMargin
        )
    }
}

@Composable
fun ExperienceDescription(active: Boolean, description: String) {
    Box(
        modifier = Modifier.fillMaxWidth().margin(topBottom = 15.px).borderRadius(10.px)
            .padding(14.px).backgroundColor(
                if (active) Theme.Primary.rgb else Theme.Gray.rgb
            )
    ) {
        P(
            attrs = Modifier.margin(topBottom = 0.px).fontFamily(FONT_FAMILY).fontSize(14.px)
                .fontWeight(FontWeight.Normal).lineHeight(1.6)
                .color(if (active) Colors.White else Theme.Secondary.rgb).toAttrs()
        ) {
            Text(value = description)
        }
    }
}

@Composable
fun ExperienceDetail(
    breakpoint: Breakpoint,
    active: Boolean,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .margin(left = if (breakpoint >= Breakpoint.MD) 14.px else 0.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint >= Breakpoint.MD) {
            ExperienceNumber(active = active, experience = experience)
        }
        Column(
            modifier = Modifier.fillMaxSize()
                .margin(left = if (breakpoint <= Breakpoint.SM) 0.px else animatedMargin)
                .transition(
                    Transition.of(
                        property = "margin", duration = 500.ms, delay = experience.ordinal * 100.ms
                    )
                ), verticalArrangement = Arrangement.Center
        ) {
            P(
                attrs = Modifier.margin(topBottom = 0.px).fontFamily(FONT_FAMILY).fontSize(16.px)
                    .fontWeight(FontWeight.Bold).color(Theme.Secondary.rgb).textDecorationLine(
                        TextDecorationLine.Underline
                    ).toAttrs()
            ) {
                Text(value = experience.jobPosition)
            }
            P(
                attrs = Modifier.margin(topBottom = 0.px).fontFamily(FONT_FAMILY).fontSize(14.px)
                    .fontWeight(FontWeight.SemiBold).fontStyle(FontStyle.Italic)
                    .color(Theme.Primary.rgb).toAttrs()
            ) {
                Text(value = experience.companyName)
            }
            P(
                attrs = Modifier.margin(topBottom = 0.px).fontFamily(FONT_FAMILY).fontSize(14.px)
                    .fontWeight(FontWeight.Normal).color(Theme.Secondary.rgb).toAttrs()
            ) {
                Text(value = "${experience.startDate} - ${experience.endDate}")
            }
        }
    }
}

@Composable
fun ExperienceNumber(active: Boolean, experience: Experience) {
    Box(
        modifier = Modifier.margin(right = 14.px).fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.fillMaxHeight().width(3.px).backgroundColor(Theme.Primary.rgb)
        )
        Box(
            modifier = Modifier.size(40.px)
                .border(width = 3.px, style = LineStyle.Double, color = Theme.Primary.rgb)
                .backgroundColor(if (active) Theme.Primary.rgb else Colors.White)
                .borderRadius(50.percent), contentAlignment = Alignment.Center
        ) {
            P(
                attrs = Modifier.margin(topBottom = 0.px).fontFamily(FONT_FAMILY).fontSize(14.px)
                    .fontWeight(FontWeight.Bold)
                    .color(if (active) Colors.White else Theme.Secondary.rgb).toAttrs()
            ) {
                Text(value = experience.number)
            }
        }
    }
}