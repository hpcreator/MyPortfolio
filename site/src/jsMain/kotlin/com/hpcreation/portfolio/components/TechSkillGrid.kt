package com.hpcreation.portfolio.components

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.models.TechSkill
import com.hpcreation.portfolio.models.Theme
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.overlay.AdvancedTooltip
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.PopupPlacementStrategy
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Composable
fun TechSkillGrid(
    modifier: Modifier = Modifier,
) {
    val breakpoint = rememberBreakpoint()

    val itemsPerRow = when (breakpoint) {
        Breakpoint.MD -> 5
        Breakpoint.SM -> 4
        Breakpoint.ZERO -> 4
        else -> 10
    }

    val chunkedSkills = TechSkill.entries.chunked(itemsPerRow)

    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
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
    val width = when (breakpoint) {
        Breakpoint.MD -> 80.px
        Breakpoint.SM -> 64.px
        Breakpoint.ZERO -> 48.px
        else -> 100.px
    }
    val height = when (breakpoint) {
        Breakpoint.MD -> 80.px
        Breakpoint.SM -> 64.px
        Breakpoint.ZERO -> 48.px
        else -> 100.px
    }


    Box(
        modifier = modifier.width(width).height(height).padding(10.px)
            .margin(top = 10.px, leftRight = 10.px).borderRadius(10.px).boxShadow(
                BoxShadow.of(
                    blurRadius = 10.px, spreadRadius = 2.px, color = Theme.Primary.rgb
                )
            ), contentAlignment = Alignment.Center
    ) {
        Image(
            src = techSkill.image,
            description = "Skill Image",
            modifier = Modifier.id("skillImage").fillMaxSize().margin(5.px).border(
                width = 2.px, color = Theme.Secondary.rgb
            )
        )
        AdvancedTooltip(
            target = ElementTarget.Parent,
            modifier = Modifier.padding(leftRight = 10.px, topBottom = 5.px),
            hasArrow = true,
            placementStrategy = PopupPlacementStrategy.of(PopupPlacement.Top)
        ) {
            Text(value = techSkill.title)
        }
    }
}