package com.hpcreation.portfolio.models

enum class Experience(
    val number: String,
    val jobPosition: String,
    val description: String,
    val companyName: String,
    val startDate: String,
    val endDate: String
) {
    OPENXCELL(
        number = "01",
        jobPosition = "Software Developer - Android",
        description = "Led and mentored a team of Android developers, ensuring timely delivery and adherence to quality standards. Designed, developed, and maintained complex Android applications using Java and Kotlin. Optimized app performance and user experience across various screen sizes and Android OS versions. Collaborated with design teams, translating wireframes and mockups into functional app features. Implemented robust RESTful APIs and JSON data integration to enhance app functionality. Utilized Git for efficient code versioning and collaboration. Conducted thorough testing and debugging to resolve app issues. Contributed to the entire software development lifecycle, from requirements gathering to deployment. Successfully published and maintained apps on the Google Play Store.",
        companyName = "Openxcell Technolabs Pvt. Ltd.",
        startDate = "February-2022",
        endDate = "March-2024"
    ),
    SPACE_STEM(
        number = "02",
        jobPosition = "Jr. Android Developer",
        description = "Developed Android applications using Java and Kotlin, following MVC and MVVM architectural patterns. Integrated third-party SDKs and libraries to expand app features and capabilities. Collaborated with cross-functional teams to deliver high-quality Android applications. Participated in code reviews and provided constructive feedback to improve code quality. Adhered to Agile development methodologies to ensure efficient project delivery.",
        companyName = "Spacestem Pvt. Ltd.",
        startDate = "April-2021",
        endDate = "January-2022"
    ),
    FREELANCER(
        number = "03",
        jobPosition = "Freelancer",
        description = "Independently developed and launched Android applications. Managed all aspects of the development process, including requirements gathering, design, development, testing, and deployment. Successfully delivered projects on time and within budget. Built a strong portfolio of Android applications showcasing diverse skill set.",
        companyName = "Freelance",
        startDate = "June 2020",
        endDate = "March 2021"
    ),
    ADRI_IT_SOLUTION(
        number = "04",
        jobPosition = "Jr. Android Developer",
        description = "Developed Android applications under the guidance of senior developers. Gained hands-on experience in the Android development lifecycle. Contributed to team projects by writing clean and efficient code. Learned to collaborate effectively with team members and stakeholders.",
        companyName = "Adri It Solutions Pvt. Ltd.",
        startDate = "May 2019",
        endDate = "May 2020"
    ),
    SILVER_WINGS(
        number = "05",
        jobPosition = "Intern",
        description = "Gained foundational knowledge of Android app development. Assisted senior developers in various development tasks. Learned about the software development process and industry best practices.",
        companyName = "SilverWings Pvt Ltd",
        startDate = "April 2018",
        endDate = "April 2019"
    )
}