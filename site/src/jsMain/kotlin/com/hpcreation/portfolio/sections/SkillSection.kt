package com.hpcreation.portfolio.sections

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.components.SectionTitle
import com.hpcreation.portfolio.components.TechSkillGrid
import com.hpcreation.portfolio.models.Section
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.util.Constants.SECTION_WIDTH
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
fun SkillSection() {
    Box(
        modifier = Modifier.id(Section.Skill.id).fillMaxWidth().maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px).backgroundColor(Theme.LightGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        SkillContent()
    }
}

@Composable
fun SkillContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent
        ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth().margin(bottom = 25.px),
            section = Section.Skill,
            alignment = Alignment.CenterHorizontally
        )
        TechSkillGrid()
    }
}