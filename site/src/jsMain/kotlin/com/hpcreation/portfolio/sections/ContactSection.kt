package com.hpcreation.portfolio.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.hpcreation.portfolio.components.ContactForm
import com.hpcreation.portfolio.components.SectionTitle
import com.hpcreation.portfolio.models.Section
import com.hpcreation.portfolio.util.Constants.SECTION_WIDTH
import com.hpcreation.portfolio.util.ObserveViewPortEntered
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ContactSection() {
    Box(
        modifier = Modifier.id(Section.Contact.id).fillMaxWidth().maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px), contentAlignment = Alignment.Center
    ) {
        ContactContent()
    }
}

@Composable
fun ContactContent() {
    val breakpoint = rememberBreakpoint()
    val scope = rememberCoroutineScope()
    var animationRotation by remember { mutableStateOf(0.deg) }

    ObserveViewPortEntered(
        sectionId = Section.Contact.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
            animationRotation = 10.deg
            scope.launch {
                delay(500)
                animationRotation = 0.deg
            }
        })

    Column(
        modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(modifier = Modifier.fillMaxWidth().margin(bottom = 25.px)
            .transform { rotate(animationRotation) }
            .transition(Transition.of(property = "transform", duration = 500.ms)),
            section = Section.Contact,
            alignment = Alignment.CenterHorizontally)
        ContactForm(breakpoint = breakpoint)
    }
}
