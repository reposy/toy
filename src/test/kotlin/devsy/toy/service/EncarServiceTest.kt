package devsy.toy.service

import devsy.toy.util.SeleniumUtil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.Duration

@SpringBootTest
class EncarServiceTest(
    @Autowired val encarService: EncarService,
    @Autowired val driver: WebDriver,
    @Autowired val seleniumUtil: SeleniumUtil

) {

    @Test
    fun `1=1`() {
        // URL 로드
        driver.get("https://www.encar.com/dc/dc_carsearchlist.do")

        // 명시적 대기 추가: 특정 요소가 로드될 때까지 기다림
        val wait = WebDriverWait(driver, Duration.ofSeconds(30))
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("h_premium")))

        // 페이지 소스를 가져옴
        val pageSource = driver.pageSource

        // 확인
        assertThat(pageSource).isNotNull()
        println(pageSource)
    }
}