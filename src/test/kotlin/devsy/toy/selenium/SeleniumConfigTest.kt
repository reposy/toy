package devsy.toy.selenium

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SeleniumConfigTest {

    @Autowired
    private lateinit var driver: WebDriver
    @Test
    fun `chromeDriver bean should be created`() {
        // Get the chromeDriver bean from the application context
        val chromeDriver = driver

        // Check if the bean is not null
        assertNotNull(chromeDriver, "The chromeDriver bean should be created and not null")

        // Optionally, you can perform additional checks or interactions with the chromeDriver instance
        chromeDriver.get("https://www.google.com")
        assertNotNull(chromeDriver.title, "The chromeDriver should be able to open a page and get the title")

        // Close the driver
        chromeDriver.quit()
    }
}