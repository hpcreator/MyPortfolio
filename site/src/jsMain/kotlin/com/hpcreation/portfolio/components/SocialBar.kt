package com.hpcreation.portfolio.components

import androidx.compose.runtime.Composable
import com.hpcreation.portfolio.models.Theme
import com.hpcreation.portfolio.styles.SocialLinkStyle
import com.hpcreation.portfolio.util.Constants
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaInstagram
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.FaMedium
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar(row: Boolean = false) {
    if (row) {
        Row(
            modifier = Modifier.margin(top = 30.px).padding(leftRight = 25.px).minHeight(40.px)
                .borderRadius(r = 15.px).backgroundColor(Theme.White.rgb).boxShadow(
                    BoxShadow.of(
                        color = Theme.Secondary.rgb, spreadRadius = 2.px, blurRadius = 10.px
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SocialLinks(row = true)
        }
    } else {
        Column(
            modifier = Modifier.margin(right = 30.px).padding(topBottom = 25.px).minWidth(40.px)
                .borderRadius(r = 15.px).backgroundColor(Theme.White.rgb).boxShadow(
                    BoxShadow.of(
                        color = Theme.Secondary.rgb, spreadRadius = 2.px, blurRadius = 10.px
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SocialLinks()
        }
    }
}

@Composable
private fun SocialLinks(row: Boolean = false) {
    Link(
        path = Constants.LINKEDIN_URL, openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaLinkedin(
            modifier = SocialLinkStyle.toModifier().margin(
                bottom = if (row) 0.px else 40.px, right = if (row) 40.px else 0.px
            ), size = IconSize.LG
        )
    }
    Link(
        path = Constants.GITHUB_URL, openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaGithub(
            modifier = SocialLinkStyle.toModifier().margin(
                bottom = if (row) 0.px else 40.px, right = if (row) 40.px else 0.px
            ), size = IconSize.LG
        )
    }
    Link(
        path = Constants.MEDIUM_URL, openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaMedium(
            modifier = SocialLinkStyle.toModifier().margin(
                bottom = if (row) 0.px else 40.px, right = if (row) 40.px else 0.px
            ), size = IconSize.LG
        )
    }
    Link(
        path = Constants.INSTAGRAM_URL, openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaInstagram(
            modifier = SocialLinkStyle.toModifier(), size = IconSize.LG
        )
    }
}
