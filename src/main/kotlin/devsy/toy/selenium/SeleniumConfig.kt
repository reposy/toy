package devsy.toy.selenium

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File
import java.net.Socket
import java.time.Duration

@Configuration
class SeleniumConfig {

    private fun isPortInUse(port: Int): Boolean {
        return try {
            Socket("localhost", port).use { true }
        } catch (e: Exception) {
            false
        }
    }

    private fun startChromeDebug() {
        val command = arrayOf(
            "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome",
            "--remote-debugging-port=9222",
            "--user-data-dir=/tmp/chrome_debug"
        )

        try {
            val processBuilder = ProcessBuilder(*command)
            processBuilder.start()
            println("Chrome is started in debug mode.")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    @PostConstruct
    fun initChromeDebug() {
        if (isPortInUse(9222)) {
            println("Chrome debugger is already running.")
        } else {
            startChromeDebug()
        }
    }


    @Bean
    fun wait(driver: WebDriver): WebDriverWait {
        return WebDriverWait(driver, Duration.ofSeconds(10))
    }


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
    fun chromeOptions(): ChromeOptions {
        val chromeOptions = ChromeOptions()
        chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222")
        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.6478.127 Safari/537.36")
        chromeOptions.addArguments("--remote-debugging-port=9222")
        chromeOptions.addArguments("--user-data-dir=/tmp/chrome_debug")
        //chromeOptions.addArguments("--load-extension=/Users/hsykys0728/Library/Application Support/Google/Chrome/Default/Extensions/mpbjkejclgfgadiemmefgebjfooflfhl/3.1.0_0")
        //chromeOptions.addArguments("--load-extension=/src/main/3.1.0_0")
        // chromeOptions.addArguments("--headless")
        return chromeOptions
    }

    @Bean
    fun chromeDriver(chromeDriverService: ChromeDriverService, chromeOptions: ChromeOptions): WebDriver {
        return ChromeDriver(chromeDriverService, chromeOptions)
    }


}
