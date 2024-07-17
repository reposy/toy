package devsy.toy.util

import org.jsoup.Jsoup
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.springframework.stereotype.Component
import java.time.Duration

@Component
class SeleniumUtil(
    private val driver: WebDriver
) {
    private fun <T> processTemplate(url: String, process:(WebDriver) -> T): T {
        driver.get(url)
        return process(driver)
        /*
        try {
            driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)))
            driver.get(url)
            return process(driver)
        } finally {
            driver.quit()
        }
         */

    }

    // String HTML 가져오기
    fun getDriverByUrl(url: String) = processTemplate(url) { driver }

    // String HTML 가져오기
    fun getHtmlByUrl(url: String) = processTemplate(url) { driver.pageSource }

    // Document 얻기
    fun getDocumentByUrl(url: String) = processTemplate(url) { Jsoup.parse(driver.pageSource) }

    // 특정 요소의 텍스트 추출
    fun getTextBySelector(url: String, cssSelector: String) = processTemplate(url) {
        it.findElement(By.cssSelector(cssSelector)).text
    }

    // 모든 링크 추출
    fun getAllLinks(url: String) = processTemplate(url) {
        it.findElements(By.tagName("a")).mapNotNull { element -> element.getAttribute("href") }.distinct()
    }
}