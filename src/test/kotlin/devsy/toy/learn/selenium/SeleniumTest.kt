package devsy.toy.learn.selenium

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootTest
class SeleniumUtilConfigTest {

    @Autowired
    private lateinit var webDriver: WebDriver

    @Test
    fun `test chromeDriver bean is configured correctly`() {
        assertThat(webDriver).isNotNull
        assertThat(webDriver).isInstanceOf(ChromeDriver::class.java)

        webDriver.get("http://example.com")
        assertThat(webDriver.title).isEqualTo("Example Domain")
    }

    @Configuration
    class TestConfig {

        private val chromeDriverPath: String = "/src/main/resources/chromedriver"

        @Bean
        fun chromeDriver(): WebDriver {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath)
            val chromeOptions = ChromeOptions()
            chromeOptions.addArguments("--headless")
            return ChromeDriver(chromeOptions)
        }
    }
}