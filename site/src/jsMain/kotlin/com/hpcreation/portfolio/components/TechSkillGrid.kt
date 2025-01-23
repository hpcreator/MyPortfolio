package com.hpcreation.portfolio.components

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.models.TechSkill
import com.hpcreation.portfolio.models.Theme
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun TechSkillGrid(
    modifier: Modifier = Modifier,
) {
    val breakpoint = rememberBreakpoint()

    val itemsPerRow = when (breakpoint) {
        Breakpoint.MD -> 5
        Breakpoint.SM, Breakpoint.ZERO -> 4
        else -> 10
    }

    val chunkedSkills = TechSkill.entries.chunked(itemsPerRow)

    GlassBox(
        modifier = modifier.fillMaxWidth(90.percent),
        borderWidth = 1.px,
    ) {
        Column(
            modifier = modifier.fillMaxWidth().padding(bottom = 10.px),
            verticalArrangement = Arrangement.spacedBy(10.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            chunkedSkills.forEach { rowSkills ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(leftRight = 5.px).margin(10.px),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    rowSkills.forEachIndexed { index, techSkill ->
                        TechSkillItem(
                            techSkill = techSkill, modifier = Modifier.weight(
                                if (rowSkills.size == 2 && index == 1) 2f else 1f
                            ), breakpoint
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TechSkillItem(
    techSkill: TechSkill, modifier: Modifier = Modifier, breakpoint: Breakpoint
) {
    val itemSize = when (breakpoint) {
        Breakpoint.MD -> 80.px
        Breakpoint.SM -> 64.px
        Breakpoint.ZERO -> 48.px
        else -> 100.px
    }

    Box(
        modifier = modifier.padding(10.px).margin(top = 10.px, leftRight = 10.px)
            .borderRadius(10.px).boxShadow(
                BoxShadow.of(
                    blurRadius = 5.px, spreadRadius = 2.px, color = Theme.Primary.rgb
                )
            ), contentAlignment = Alignment.Center
    ) {
        Image(
            src = techSkill.image,
            description = "Skill Image",
            modifier = modifier.id("skillImage").size(itemSize)
        )
    }
}