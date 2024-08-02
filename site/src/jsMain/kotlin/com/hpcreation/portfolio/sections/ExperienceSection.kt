package com.hpcreation.portfolio.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hpcreation.portfolio.components.ExperienceCard
import com.hpcreation.portfolio.components.SectionTitle
import com.hpcreation.portfolio.models.Experience
import com.hpcreation.portfolio.models.Section
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.util.Constants.SECTION_WIDTH
import com.hpcreation.portfolio.util.ObserveViewPortEntered
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceSection() {
    Box(
        modifier = Modifier.id(Section.Experience.id).fillMaxWidth().maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px).backgroundColor(Theme.LighterGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        ExperienceContent()
    }
}

@Composable
fun ExperienceContent() {
    val breakpoint = rememberBreakpoint()
    var animatedMargin by remember { mutableStateOf(200.px) }

    ObserveViewPortEntered(sectionId = Section.Experience.id, distanceFromTop = 500.0) {
        animatedMargin = 50.px
    }

    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent
        ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 60.percent else 90.percent)
                .margin(bottom = 25.px),
            section = Section.Portfolio,
        )

        Experience.entries.forEachIndexed { index, experience ->
            ExperienceCard(
                breakpoint = breakpoint,
                experience = experience,
                active = index == 0,
                animatedMargin = animatedMargin
            )
        }
    }
}
