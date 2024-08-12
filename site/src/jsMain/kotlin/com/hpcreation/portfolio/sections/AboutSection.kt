package com.hpcreation.portfolio.sections

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.components.SectionTitle
import com.hpcreation.portfolio.components.TechSkillGrid
import com.hpcreation.portfolio.models.Section
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.styles.AboutImageStyle
import com.hpcreation.portfolio.styles.AboutTextStyle
import com.hpcreation.portfolio.styles.ResumeButtonStyle
import com.hpcreation.portfolio.util.Constants.ABOUT_ME
import com.hpcreation.portfolio.util.Constants.DOWNLOAD_RESUME
import com.hpcreation.portfolio.util.Constants.FONT_FAMILY
import com.hpcreation.portfolio.util.Constants.RESUME_URL
import com.hpcreation.portfolio.util.Constants.SECTION_WIDTH
import com.hpcreation.portfolio.util.Res
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
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
fun AboutSection() {
    Column(
        modifier = Modifier.id(Section.About.id).maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 150.px), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AboutContent()
        P(
            attrs = Modifier.margin(top = 30.px, bottom = 0.px).fontFamily(FONT_FAMILY)
                .fontSize(25.px).fontWeight(
                    FontWeight.Bold
                ).color(Theme.Primary.rgb).toAttrs()
        ) { Text(value = "Skills") }
        Box(
            modifier = Modifier.height(8.px).width(80.px).margin(top = 5.px, bottom = 20.px)
                .backgroundColor(Theme.Primary.rgb).borderRadius(r = 50.px)
        )
        TechSkillGrid()
    }
}

@Composable
fun AboutContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent
        ).maxWidth(1200.px), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 90.percent
                else 100.percent
            ), numColumns = numColumns(base = 1, md = 2)
        ) {
            if (breakpoint >= Breakpoint.MD) {
                AboutImage()
            }
            AboutMe()
        }
    }
}

@Composable
fun AboutImage() {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = AboutImageStyle.toModifier().fillMaxWidth(80.percent),
            src = Res.Image.PROFILE,
            alt = "About Image"
        )
    }
}

@Composable
fun AboutMe() {
    Column(
        modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center
    ) {
        SectionTitle(section = Section.About)
        val paragraphs = ABOUT_ME.split("\n")

        paragraphs.forEachIndexed { index, paragraph ->
            P(
                attrs = AboutTextStyle.toModifier().margin(
                    top = if (index == 0) 20.px else 5.px, bottom = if (index == 0) 5.px else 20.px
                ).maxWidth(500.px).fontFamily(FONT_FAMILY).fontSize(18.px)
                    .fontWeight(FontWeight.Normal).fontStyle(FontStyle.Normal)
                    .color(Theme.Secondary.rgb).toAttrs()
            ) {
                Text(value = paragraph)
            }
        }

        Button(
            attrs = ResumeButtonStyle.toModifier().height(40.px)
                .padding(leftRight = 10.px, topBottom = 5.px).borderRadius(r = 5.px)
                .cursor(Cursor.Pointer).toAttrs()
        ) {
            Link(
                modifier = Modifier.color(Theme.Primary.rgb)
                    .textDecorationLine(TextDecorationLine.None),
                text = DOWNLOAD_RESUME,
                path = RESUME_URL
            )
        }
    }
}
