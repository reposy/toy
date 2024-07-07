package devsy.toy.util.dto

data class RobotsRule(
    val userAgent: String,
    val allows: MutableSet<String> = mutableSetOf(),
    val disallows: MutableSet<String> = mutableSetOf()
)