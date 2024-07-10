package devsy.toy.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

class SeleniumUtilTest {
    private lateinit var seleniumUtil: SeleniumUtil
    private lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
        driver = mock(WebDriver::class.java)
        seleniumUtil = SeleniumUtil(driver)
    }

    @Test
    fun `test getHtmlByUrl`() {
        val url = "http://example.com"
        val expectedHtml = "<html>example</html>"

        `when`(driver.pageSource).thenReturn(expectedHtml)

        val result = seleniumUtil.getHtmlByUrl(url)
        assertThat(result).isEqualTo(expectedHtml)

        verify(driver).get(url)
        verify(driver).quit()
    }

    @Test
    fun `test getAllLinks`() {
        val url = "http://example.com"
        val link1 = "http://example.com/link1"
        val link2 = "http://example.com/link2"
        val webElement1 = mock(WebElement::class.java)
        val webElement2 = mock(WebElement::class.java)

        `when`(webElement1.getAttribute("href")).thenReturn(link1)
        `when`(webElement2.getAttribute("href")).thenReturn(link2)
        `when`(driver.findElements(By.tagName("a"))).thenReturn(listOf(webElement1, webElement2))

        val result = seleniumUtil.getAllLinks(url)
        assertThat(result).hasSize(2)
        assertThat(result).containsExactlyInAnyOrder(link1, link2)

        verify(driver).get(url)
        verify(driver).quit()
    }

}