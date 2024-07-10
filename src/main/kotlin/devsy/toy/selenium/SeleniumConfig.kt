package devsy.toy.selenium

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SeleniumConfig {

    @Bean
    fun chromeDriver(): WebDriver {
        val chromeDriverPath = System.getProperty("user.dir") + "/src/main/resources/chromedriver"
        System.setProperty("webdriver.chrome.driver", chromeDriverPath)
        val chromeOptions = ChromeOptions()

        //chromeOptions.addExtensions(File("/Users/hsykys0728/Library/Application Support/Google/Chrome/Default/Extensions/mpbjkejclgfgadiemmefgebjfooflfhl/3.1.0_0"))

        return ChromeDriver(chromeOptions)
    }
}
