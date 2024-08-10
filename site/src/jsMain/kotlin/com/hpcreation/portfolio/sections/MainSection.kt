package com.hpcreation.portfolio.sections

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.components.Header
import com.hpcreation.portfolio.components.SocialBar
import com.hpcreation.portfolio.models.Section
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.styles.MainButtonStyle
import com.hpcreation.portfolio.styles.MainImageStyle
import com.hpcreation.portfolio.util.Constants.FONT_FAMILY
import com.hpcreation.portfolio.util.Constants.HELLO_TEXT
import com.hpcreation.portfolio.util.Constants.HIRE_ME
import com.hpcreation.portfolio.util.Constants.MY_BIO
import com.hpcreation.portfolio.util.Constants.MY_DESIGNATION
import com.hpcreation.portfolio.util.Constants.MY_NAME
import com.hpcreation.portfolio.util.Constants.SECTION_WIDTH
import com.hpcreation.portfolio.util.Res
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
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
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection(onMenuClicked: () -> Unit) {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.id(Section.Home.id).maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        MainBackground(breakpoint = breakpoint)
        MainContent(onMenuClicked = onMenuClicked, breakpoint)
    }
}

@Composable
fun MainBackground(breakpoint: Breakpoint) {
    Image(
        modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover),
        src = if (breakpoint < Breakpoint.MD) Res.Image.BG2 else Res.Image.BG1,
        description = "Background Image"
    )
}


@Composable
fun MainContent(onMenuClicked: () -> Unit, breakpoint: Breakpoint) {
    //val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(onMenuClicked = onMenuClicked)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleGrid(
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 80.percent
                    else 90.percent
                ), numColumns = numColumns(base = 1, md = 2)
            ) {
                MainText(breakpoint = breakpoint)
                MainImage()
            }
        }
    }
}

@Composable
fun MainText(breakpoint: Breakpoint) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint > Breakpoint.MD) SocialBar()
        Column(Modifier.padding(10.px)) {
            P(
                attrs = Modifier.margin(topBottom = 0.px).fontFamily(FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 45.px else 20.px)
                    .fontWeight(FontWeight.Normal).color(Theme.Primary.rgb).toAttrs()
            ) {
                Text(value = HELLO_TEXT)
            }
            P(
                attrs = Modifier.margin(top = 20.px, bottom = 0.px).fontFamily(FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 64.px else 40.px)
                    .fontWeight(FontWeight.Bolder).color(Theme.Secondary.rgb).toAttrs()
            ) {
                Text(value = MY_NAME)
            }
            P(
                attrs = Modifier.margin(top = 10.px, bottom = 5.px).fontFamily(FONT_FAMILY)
                    .fontSize(20.px).fontWeight(FontWeight.Bold).color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(value = MY_DESIGNATION)
            }
            P(
                attrs = Modifier.margin(bottom = 25.px).maxWidth(400.px).fontFamily(FONT_FAMILY)
                    .fontSize(15.px).fontWeight(FontWeight.Normal).fontStyle(FontStyle.Italic)
                    .color(Theme.Secondary.rgb).toAttrs()
            ) {
                Text(
                    value = MY_BIO
                )
            }
            Button(
                attrs = MainButtonStyle.toModifier().height(40.px).border(width = 0.px)
                    .borderRadius(r = 5.px).padding(leftRight = 10.px, topBottom = 5.px)
                    .backgroundColor(Theme.Primary.rgb).color(Colors.White).cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Link(
                    modifier = Modifier.color(Colors.White)
                        .textDecorationLine(TextDecorationLine.None),
                    text = HIRE_ME,
                    path = Section.Contact.path
                )
            }
        }
    }
}

@Composable
fun MainImage() {
    Column(
        modifier = Modifier.fillMaxSize(80.percent).fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = MainImageStyle.toModifier().fillMaxWidth(),
            src = Res.Image.PROFILE,
            alt = "Main Image"
        )
    }
}