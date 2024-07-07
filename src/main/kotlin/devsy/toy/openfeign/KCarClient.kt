package devsy.toy.openfeign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "kcarClient", url = "https://www.kcar.com")
interface KCarClient {

    @GetMapping("/robots.txt")
    fun getRobotsTxt(
        @RequestHeader("Content-Type") contentType: String = "application/json; charset=utf-8"
    ): String

    @GetMapping("/bc/search")
    fun getVehicleList(
        @RequestHeader("Content-Type") contentType: String = "application/json; charset=utf-8"
    ): String

    @GetMapping("/bc/detail/carInfoDtl")
    fun getVehicleDetail(
        @RequestHeader("Content-Type") contentType: String = "application/json; charset=utf-8"
    ): String
}