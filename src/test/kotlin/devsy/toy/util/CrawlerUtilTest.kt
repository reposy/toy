package devsy.toy.util

import devsy.toy.util.dto.RobotsRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CrawlerUtilTest {

    private val crawlerUtil = CrawlerUtil()

    @Test
    fun `test parseRobotsTxtToRules with valid robots txt`() {
        val robotsTxt = """
            User-agent: *
            Disallow: /private/
            Allow: /public/
            
            User-agent: Googlebot
            Disallow: /no-google/
            Allow: /google-only/
        """.trimIndent()

        val expected = listOf(
            RobotsRule(
                userAgent = "*",
                allows = mutableSetOf("/public/"),
                disallows = mutableSetOf("/private/")
            ),
            RobotsRule(
                userAgent = "Googlebot",
                allows = mutableSetOf("/google-only/"),
                disallows = mutableSetOf("/no-google/")
            )
        )

        val result = crawlerUtil.parseRobotsTxtToRules(robotsTxt)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `test parseRobotsTxtToRules with empty robots txt`() {
        val robotsTxt = ""

        val expected = emptyList<RobotsRule>()

        val result = crawlerUtil.parseRobotsTxtToRules(robotsTxt)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `test isPathAllowed`() {
        val robotsTxt = """
            User-agent: *
            Disallow: /private/
            Allow: /public/
            Allow: /private/section/
            Disallow: /es/record.do
            
            User-agent: Googlebot
            Disallow: /no-google/
            Allow: /google-only/
        """.trimIndent()

        val rules = crawlerUtil.parseRobotsTxtToRules(robotsTxt)

        // Test for User-agent: *
        assertThat(crawlerUtil.isPathAllowed("*", "/private/", rules)).isFalse()
        assertThat(crawlerUtil.isPathAllowed("*", "/public/", rules)).isTrue()
        assertThat(crawlerUtil.isPathAllowed("*", "/private/section/", rules)).isTrue()
        assertThat(crawlerUtil.isPathAllowed("*", "/private/section/subsection", rules)).isTrue()
        assertThat(crawlerUtil.isPathAllowed("*", "/private/anothersection", rules)).isFalse()
        assertThat(crawlerUtil.isPathAllowed("*", "/es/record.do", rules)).isFalse()
        assertThat(crawlerUtil.isPathAllowed("*", "/es/record.do/something", rules)).isFalse()

        // Test for User-agent: Googlebot
        assertThat(crawlerUtil.isPathAllowed("Googlebot", "/no-google/", rules)).isFalse()
        assertThat(crawlerUtil.isPathAllowed("Googlebot", "/google-only/", rules)).isTrue()
        assertThat(crawlerUtil.isPathAllowed("Googlebot", "/no-google/section", rules)).isFalse()
        assertThat(crawlerUtil.isPathAllowed("Googlebot", "/google-only/section", rules)).isTrue()

        // Test for User-agent: Bingbot (which falls back to the global rule)
        assertThat(crawlerUtil.isPathAllowed("Bingbot", "/private/", rules)).isFalse()
        assertThat(crawlerUtil.isPathAllowed("Bingbot", "/public/", rules)).isTrue()
        assertThat(crawlerUtil.isPathAllowed("Bingbot", "/private/section/", rules)).isTrue()
        assertThat(crawlerUtil.isPathAllowed("Bingbot", "/private/section/subsection", rules)).isTrue()
        assertThat(crawlerUtil.isPathAllowed("Bingbot", "/private/anothersection", rules)).isFalse()
        assertThat(crawlerUtil.isPathAllowed("Bingbot", "/es/record.do", rules)).isFalse()
        assertThat(crawlerUtil.isPathAllowed("Bingbot", "/es/record.do/something", rules)).isFalse()
    }

    @Test
    fun `test isPathDisallowed`() {
        val robotsTxt = """
            User-agent: *
            Disallow: /private/
            Allow: /public/
            Allow: /private/section/
            
            User-agent: Googlebot
            Disallow: /no-google/
            Allow: /google-only/
        """.trimIndent()

        val rules = crawlerUtil.parseRobotsTxtToRules(robotsTxt)

        assertThat(crawlerUtil.isPathDisallowed("*", "/private/", rules)).isTrue()
        assertThat(crawlerUtil.isPathDisallowed("*", "/public/", rules)).isFalse()
        assertThat(crawlerUtil.isPathDisallowed("*", "/private/section/", rules)).isFalse()
        assertThat(crawlerUtil.isPathDisallowed("*", "/private/section/subsection", rules)).isFalse()
        assertThat(crawlerUtil.isPathDisallowed("*", "/private/anothersection", rules)).isTrue()

        assertThat(crawlerUtil.isPathDisallowed("Googlebot", "/no-google/", rules)).isTrue()
        assertThat(crawlerUtil.isPathDisallowed("Googlebot", "/google-only/", rules)).isFalse()
        assertThat(crawlerUtil.isPathDisallowed("Googlebot", "/no-google/section", rules)).isTrue()
        assertThat(crawlerUtil.isPathDisallowed("Googlebot", "/google-only/section", rules)).isFalse()

        assertThat(crawlerUtil.isPathDisallowed("Bingbot", "/private/", rules)).isTrue()
        assertThat(crawlerUtil.isPathDisallowed("Bingbot", "/public/", rules)).isFalse()
        assertThat(crawlerUtil.isPathDisallowed("Bingbot", "/private/section/", rules)).isFalse()
        assertThat(crawlerUtil.isPathDisallowed("Bingbot", "/private/section/subsection", rules)).isFalse()
        assertThat(crawlerUtil.isPathDisallowed("Bingbot", "/private/anothersection", rules)).isTrue()
    }
}