package devsy.toy.openfeign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "kcarClient", url = "https://www.kcar.com")
interface KCarClient {

    @GetMapping("/robots.txt")
    fun getRobotsTxt(): String
}