package devsy.toy.service

import devsy.toy.util.SeleniumUtil
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EncarServiceTest(

    @Autowired val encarService: EncarService,
    @Autowired val seleniumUtil: SeleniumUtil,

    @Autowired val driver: WebDriver,

) {
    @Test
    fun `test 차량 옵션 목록 조회`() {
        encarService.getRealtimeSearchConditions()
    }
    @Test
    fun `test 차량 목록 조회`() {
        encarService.getRealtimeTotalVehicleList()
    }

}