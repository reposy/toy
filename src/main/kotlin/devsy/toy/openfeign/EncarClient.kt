package devsy.toy.openfeign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "encarClient", url = "https://www.encar.com")
interface EncarClient {

    @GetMapping("/robots.txt")
    fun getRobotsTxt(
        @RequestHeader("Content-Type") contentType: String = "application/json; charset=utf-8"
    ): String

    /* 차량 목록 조회 */
    @GetMapping("/dc/dc_carsearchlist.do")
    fun getVehicleList(
        @RequestHeader("Content-Type") contentType: String = "application/json; charset=utf-8"
    ): String

    /* 차량 상세 조회 */
    @GetMapping("/dc/dc_cardetailview.do")
    fun getVehicleDetail(
        @RequestHeader("Content-Type") contentType: String = "application/json; charset=utf-8"
    ): String

}