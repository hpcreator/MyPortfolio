package com.hpcreation.portfolio.models

import com.hpcreation.portfolio.util.Res
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

enum class Skills(
    val title: String, val percentage: CSSSizeValue<CSSUnit.percent>
) {
    Creative(
        title = "Creative", percentage = 90.percent
    ),
    Accountable(
        title = "Accountable", percentage = 90.percent
    ),
    HardWorking(
        title = "Hard Working", percentage = 80.percent
    ),
    Value(
        title = "Value for Money", percentage = 85.percent
    ),
    Delivery(
        title = "On-Time Delivery", percentage = 75.percent
    )
}

enum class TechSkill(val image: String, val title: String) {
    Android(image = Res.Image.ANDROID, title = "Android"), JAVA(
        image = Res.Image.JAVA, title = "Java"
    ),
    KOTLIN(image = Res.Image.KOTLIN, title = "Kotlin"), JETPACK_COMPOSE(
        image = Res.Image.COMPOSE, title = "Compose"
    ),
    FLUTTER(
        image = Res.Image.FLUTTER, title = "Flutter"
    ),
    DART(image = Res.Image.DART, title = "Dart"), FIREBASE(
        image = Res.Image.FIREBASE, title = "Firebase"
    ),
    MYSQL(
        image = Res.Image.MYSQL, title = "MySql"
    ),
    MATERIAL_UI(
        image = Res.Image.MATERIAL_UI, title = "Material UI"
    ),
    AUTH0(image = Res.Image.AUTH0, "Auth0"), FIGMA(
        image = Res.Image.FIGMA, title = "Figma"
    ),
    XD(image = Res.Image.XD, title = "Adobe XD"), POSTMAN(
        image = Res.Image.POSTMAN, title = "Postman"
    ),
    SWAGGER(
        image = Res.Image.SWAGGER, title = "Swagger"
    ),
    JIRA(
        image = Res.Image.JIRA, title = "Jira"
    ),
    GIT(
        image = Res.Image.GIT, title = "Git"
    ),
    TRELLO(
        image = Res.Image.TRELLO, title = "Trello"
    ),
    GOOGLE_PLAY_SERVICES(
        image = Res.Image.GOOGLE_SERVICES, title = "Play Services"
    ),
    ANDROID_STUDIO(
        image = Res.Image.ANDROID_STUDIO, title = "Android Studio"
    ),
    VS_CODE(image = Res.Image.VS_CODE, title = "VS Code"),
}