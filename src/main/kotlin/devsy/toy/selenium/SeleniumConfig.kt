package devsy.toy.selenium

import jakarta.annotation.PreDestroy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

@Configuration
class SeleniumConfig {

    @Bean
    fun chromeDriverService(): ChromeDriverService {
        val chromeDriverPath = System.getProperty("user.dir") + "/src/main/resources/chromedriver"
        System.setProperty("webdriver.chrome.driver", chromeDriverPath)

        return ChromeDriverService.Builder()
            .usingDriverExecutable(File(chromeDriverPath))
            .usingAnyFreePort()
            .build()
    }

    @Bean
    fun chromeDriver(chromeDriverService: ChromeDriverService): WebDriver {
        val chromeOptions = ChromeOptions()
        chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222")
        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.6478.127 Safari/537.36")
        chromeOptions.addArguments("--load-extension=/Users/hsykys0728/Library/Application Support/Google/Chrome/Default/Extensions/mpbjkejclgfgadiemmefgebjfooflfhl/3.1.0_0")
        // chromeOptions.addArguments("--headless")

        return ChromeDriver(chromeDriverService, chromeOptions)
    }
}
