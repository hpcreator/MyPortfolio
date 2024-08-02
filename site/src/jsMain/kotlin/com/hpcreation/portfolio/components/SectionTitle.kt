package com.hpcreation.portfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.hpcreation.portfolio.models.Section
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.util.Constants
import com.hpcreation.portfolio.util.ObserveViewPortEntered
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    alignment: Alignment.Horizontal = Alignment.Start
) {

    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf(50.px) }
    var subtitleMargin by remember { mutableStateOf(50.px) }

    ObserveViewPortEntered(sectionId = section.id, distanceFromTop = 700.0, onViewportEntered = {
        scope.launch {
            subtitleMargin = 0.px
            if (alignment == Alignment.Start) {
                delay(25)
            }
            titleMargin = 0.px
        }
    })

    Column(modifier = modifier, horizontalAlignment = alignment) {
        P(
            attrs = Modifier.fillMaxWidth().margin(left = titleMargin, top = 0.px, bottom = 0.px)
                .textAlign(
                    when (alignment) {
                        Alignment.CenterHorizontally -> TextAlign.Center
                        Alignment.End -> TextAlign.End
                        else -> TextAlign.Start
                    }
                ).fontFamily(Constants.FONT_FAMILY).fontSize(25.px).fontWeight(
                    FontWeight.Normal
                ).color(Theme.Primary.rgb)
                .transition(Transition.of(property = "margin", duration = 300.ms)).toAttrs()
        ) { Text(value = section.title) }
        P(
            attrs = Modifier.fillMaxWidth().margin(
                top = 0.px,
                bottom = 10.px,
                left = if (alignment == Alignment.Start) subtitleMargin else 0.px,
                right = if (alignment == Alignment.CenterHorizontally) subtitleMargin else 0.px
            ).textAlign(
                when (alignment) {
                    Alignment.CenterHorizontally -> TextAlign.Center
                    Alignment.End -> TextAlign.End
                    else -> TextAlign.Start
                }
            ).fontFamily(Constants.FONT_FAMILY).fontSize(36.px).fontWeight(
                FontWeight.Bold
            ).color(Theme.Secondary.rgb)
                .transition(Transition.of(property = "margin", duration = 300.ms)).toAttrs()
        ) { Text(value = section.subtitle) }
        Box(
            modifier = Modifier.height(2.px).width(80.px).backgroundColor(Theme.Primary.rgb)
                .borderRadius(r = 50.px)
        )
    }
}