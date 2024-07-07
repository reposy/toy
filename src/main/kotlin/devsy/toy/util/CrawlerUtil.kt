package devsy.toy.util

import devsy.toy.util.dto.RobotsRule
import org.springframework.stereotype.Component

@Component
class CrawlerUtil {

    fun isPathAllowed(userAgent: String, path: String, rules: List<RobotsRule>): Boolean {
        return !isPathDisallowed(userAgent, path, rules)
    }

    private fun generateParentPathsToCheck(path: String): List<String> {
        val withoutParameterPath = path.split("?").first()
        val segments = withoutParameterPath.trim('/').split('/')
        return segments.indices.map { index ->
            "/" + segments.subList(0, index + 1).joinToString("/") + "/"
        } + path
    }
    fun isPathDisallowed(userAgent: String, path: String, rules: List<RobotsRule>): Boolean {
        val specificRule = rules.find { it.userAgent.equals(userAgent, ignoreCase = true) }
        val globalRule = rules.find { it.userAgent == "*" }

        val ruleToApply = specificRule ?: globalRule

        // 현재 경로와 상위 경로들을 리스트로 만듦
        val pathsToCheck = generateParentPathsToCheck(path)

        // Allow 목록 확인
        val isAllowed = ruleToApply?.allows?.any { allowPath ->
            pathsToCheck.any { pathToCheck ->
                pathToCheck.startsWith(allowPath) || pathToCheck == allowPath
            }
        } ?: false

        if (isAllowed) { // Allow가 Disallow보다 우선. 만약 허용이라면, Disallow를 볼 필요 없음
            return false
        }

        // Disallow 목록 확인
        return ruleToApply?.disallows?.any { disallowPath ->
            pathsToCheck.any { pathToCheck ->
                pathToCheck.startsWith(disallowPath) || pathToCheck == disallowPath
            }
        } ?: false
    }

    fun parseRobotsTxtToRules(robotsTxt: String): List<RobotsRule> {
        val rules: MutableList<RobotsRule> = mutableListOf()

        var tempRule: RobotsRule? = null
        robotsTxt.lines().forEach { line ->
            val trimmedLine = line.trim()
            when {
                trimmedLine.startsWith("User-agent:", ignoreCase = true) -> {
                    val userAgent = trimmedLine.removePrefix("User-agent:").trim()
                    tempRule = RobotsRule(userAgent)
                    rules.add(tempRule!!)
                }
                trimmedLine.startsWith("Allow:", ignoreCase = true) -> {
                    tempRule?.allows?.add(trimmedLine.removePrefix("Allow:").trim())
                }
                trimmedLine.startsWith("Disallow:", ignoreCase = true) -> {
                    tempRule?.disallows?.add(trimmedLine.removePrefix("Disallow:").trim())
                }
            }
        }
        return rules
    }

}