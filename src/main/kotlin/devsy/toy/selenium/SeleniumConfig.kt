package devsy.toy.selenium

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SeleniumConfig {

    val chromeDriverPath: String = "/src/main/resources/chromedriver"

    @Bean
    fun chromeDriver(): WebDriver {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath)
        val chromeOptions = ChromeOptions()
        chromeOptions.addArguments("--headless")
        return ChromeDriver(chromeOptions)
    }
}