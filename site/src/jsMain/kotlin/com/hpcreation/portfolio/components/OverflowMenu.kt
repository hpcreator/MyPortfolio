package com.hpcreation.portfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.hpcreation.portfolio.models.Section
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.styles.NavigationItemStyle
import com.hpcreation.portfolio.util.Constants.FONT_FAMILY
import com.hpcreation.portfolio.util.Res
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Composable
fun OverflowMenu(onMenuClosed: () -> Unit) {
    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }

    LaunchedEffect(breakpoint) {
        translateX = 0.percent
        opacity = 100.percent
        if (breakpoint > Breakpoint.MD) {
            scope.launch {
                translateX = (-100).percent
                opacity = 0.percent
                delay(500)
                onMenuClosed()
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth().height(100.vh).position(Position.Fixed).zIndex(2)
            .opacity(opacity).backgroundColor(Theme.Black50.rgb)
            .transition(Transition.of(property = "opacity", duration = 500.ms))
    ) {
        Column(
            modifier = Modifier.fillMaxHeight().padding(all = 25.px)
                .width(if (breakpoint < Breakpoint.MD) 50.percent else 25.percent)
                .overflow(Overflow.Auto).scrollBehavior(ScrollBehavior.Smooth)
                .backgroundColor(Colors.White).translateX(tx = translateX)
                .transition(Transition.of(property = "translate", duration = 500.ms))
        ) {
            Row(
                modifier = Modifier.margin(bottom = 25.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaXmark(
                    modifier = Modifier.cursor(Cursor.Pointer).margin(right = 20.px).onClick {
                        scope.launch {
                            translateX = (-100).percent
                            opacity = 0.percent
                            delay(500)
                            onMenuClosed()
                        }
                    }, size = IconSize.LG
                )
                Image(
                    modifier = Modifier.size(80.px), src = Res.Image.LOGO, alt = "Logo Image"
                )
            }
            Section.entries.forEach { section ->
                Link(
                    modifier = NavigationItemStyle.toModifier().margin(bottom = 10.px)
                        .fontFamily(FONT_FAMILY).fontSize(16.px).fontWeight(FontWeight.Normal)
                        .textDecorationLine(TextDecorationLine.None).onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(500)
                                onMenuClosed()
                            }
                        },
                    path = section.path,
                    text = section.title,
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                )
            }
        }
    }
}