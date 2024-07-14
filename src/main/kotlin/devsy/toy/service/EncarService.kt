package devsy.toy.service

import devsy.toy.service.dto.VehicleInfo
import devsy.toy.service.dto.encar.Category
import devsy.toy.service.dto.encar.EncarVehicleSearchConditions
import devsy.toy.util.SeleniumUtil
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class EncarService(
    val seleniumUtil: SeleniumUtil,
    val driver: WebDriver

) {
    //fun getRealtimeVehicleList(): List<Vehicle> {
    fun getRealtimeSearchCondition(): EncarVehicleSearchConditions {
        val doc = seleniumUtil.getDocumentByUrl("https://www.encar.com/dc/dc_carsearchlist.do")

        val categoryOpenTag = driver.findElement(By.cssSelector(".schset.category a"))
        categoryOpenTag.click()

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(#schCategory)))

        //println(">>>>>>>>>>> ${doc.text()}")
        println(">>>>>>>>>" + doc.select(".deparea"))
        doc.select(".deparea.category .deplist li").map { element ->
            val id = element.selectFirst("input")?.id()
            val name = element.selectFirst("label")?.text()
            println("id = $id")
            println("name = $name")
        }

        return EncarVehicleSearchConditions()
    }

    // 엔카 차량 조회 화면 첫 페이지부터 마지막 페이지까지 순회하며, 전체 차량 정보 목록 리턴
    fun getRealtimeTotalVehicleList(): List<VehicleInfo> {
        var document: Document

        val vehicleInfos = mutableListOf<VehicleInfo>()
        var pageNumber = 1

        while (true) {
            WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.car_list li")))
            WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody#sr_normal tr")))

            val html = driver.pageSource
            document = Jsoup.parse(html)

            val carElements: Elements = document.select("ul.car_list li, tbody#sr_normal tr")

            for (element in carElements) {
                val platform = "ENCAR"
                val detailUrl = element.select("a").map { it.attr("href") }.firstOrNull()?:""
                val imageUrl = element.select("span.img img").map { it.attr("src") }.firstOrNull()?:""
                val make = element.select("span.cls strong").text()
                val model = element.select("span.cls em").text()
                val trim = element.select("span.dtl strong").text()
                val year = element.select("span.yer").text()
                val mileage = element.select("span.km").text()
                val fuel = element.select("span.ipt").text()
                val location = element.select("span.lo").text()
                val price = element.select("span.prc strong").text()

                val vehicleInfo = VehicleInfo(platform, detailUrl, imageUrl, make, model, trim, year, mileage, fuel, location, price)
                vehicleInfos.add(vehicleInfo)
                println(vehicleInfo)
            }

            WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.page")))

            try {
                val nextPageElement = if(pageNumber % 10 == 0)
                    driver.findElement(By.cssSelector("span.next a[data-page='${pageNumber + 1}']"))
                else
                    driver.findElement(By.cssSelector("span.page a[data-page='${pageNumber + 1}']"))
                nextPageElement.click()
            } catch (e: org.openqa.selenium.NoSuchElementException) {
                println("Next Page not found: nextPageNumber: ${pageNumber + 1}")
                break
            }
            println("현재 페이지: $pageNumber, 차량 수: ${vehicleInfos.size}")
            pageNumber++

            Thread.sleep(1000)
        }
        vehicleInfos.forEach { println(it) }
        return vehicleInfos
    }


}