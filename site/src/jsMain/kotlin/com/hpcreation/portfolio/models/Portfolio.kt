package com.hpcreation.portfolio.models

import com.hpcreation.portfolio.util.Constants
import com.hpcreation.portfolio.util.Res

enum class Portfolio(
    val image: String, val title: String, val description: String, val url: String
) {
    GREEN_TILL(
        image = Res.Project.GREEN_TILL,
        title = "Green Till",
        description = "This helps retailer and wholesalers to generate digital receipts. The app also lets you store all your loyalty cards, coupons in one place.",
        url = Constants.GREEN_TILL
    ),
    HUSK(
        image = Res.Project.HUSK,
        title = "Husk",
        description = "This is a group of Application with different domains of Health care. 1) Husk Nutrition, 2) Husk Mental-Health, 3) Husk Wellness.",
        url = Constants.HUSK
    ),
    COLLT(
        image = Res.Project.COLT,
        title = "Nudge Up (Formerly Collt)",
        description = "This app is basically combination of all standard social media platforms like WhatsApp, Instagram, Snapchat.",
        url = Constants.COLLT
    ),
    DIGIT_RX(
        image = Res.Project.DIGIT_RX,
        title = "Digit RX",
        description = "It is a digital E Prescription Tool which helps to generate digital prescriptions.It helps doctors to prescribe medicines in digital format.",
        url = Constants.DIGIT_RX
    ),
}