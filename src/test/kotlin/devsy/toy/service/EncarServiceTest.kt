package devsy.toy.service

import devsy.toy.service.dto.Vehicle
import devsy.toy.util.SeleniumUtil
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.Duration

@SpringBootTest
class EncarServiceTest(

    @Autowired val encarService: EncarService,
    @Autowired val seleniumUtil: SeleniumUtil,

    @Autowired val driver: WebDriver,
    @Autowired val chromeDriverService: ChromeDriverService

) {

    @Test
    fun `test 차량 목록 조회`() {
        driver.get("http://www.encar.com/dc/dc_carsearchlist.do#!")

        val vehicles = mutableListOf<Vehicle>()
        var pageNumber = 1

        while (true) {
            WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.car_list li")))
            WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody#sr_normal tr")))

            val html = driver.pageSource
            val document: Document = Jsoup.parse(html)

            val carElements: Elements = document.select("ul.car_list li, tbody#sr_normal tr")

            for (element in carElements) {
                val make = element.select("span.cls strong").text()
                val model = element.select("span.cls em").text()
                val trim = element.select("span.dtl strong").text()
                val year = element.select("span.yer").text()
                val mileage = element.select("span.km").text()
                val fuel = element.select("span.ipt").text()
                val location = element.select("span.lo").text()
                val price = element.select("span.prc strong").text()

                val vehicle = Vehicle(make, model, trim, year, mileage, fuel, location, price)
                vehicles.add(vehicle)
            }

            WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.page")))

            val nextPageElement = if(pageNumber % 10 == 0)
                driver.findElement(By.cssSelector("span.next a[data-page='${pageNumber + 1}']"))
            else
                driver.findElement(By.cssSelector("span.page a[data-page='${pageNumber + 1}']"))
            nextPageElement.click()

            pageNumber++

            println("현재 페이지: $pageNumber, 차량 수: ${vehicles.size}")
            Thread.sleep(500)
        }
        vehicles.forEach { println(it) }
    }
}