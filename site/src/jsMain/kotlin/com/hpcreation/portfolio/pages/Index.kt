package com.hpcreation.portfolio.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hpcreation.portfolio.components.BackToTopButton
import com.hpcreation.portfolio.components.OverflowMenu
import com.hpcreation.portfolio.sections.AboutSection
import com.hpcreation.portfolio.sections.ContactSection
import com.hpcreation.portfolio.sections.ExperienceSection
import com.hpcreation.portfolio.sections.FooterSection
import com.hpcreation.portfolio.sections.MainSection
import com.hpcreation.portfolio.sections.PortfolioSection
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    var menuOpened by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            MainSection(onMenuClicked = { menuOpened = true })
            AboutSection()
            PortfolioSection()
            ExperienceSection()
            ContactSection()
            FooterSection()
        }
        BackToTopButton()

        if (menuOpened) {
            OverflowMenu(onMenuClosed = { menuOpened = false })
        }
    }
}
