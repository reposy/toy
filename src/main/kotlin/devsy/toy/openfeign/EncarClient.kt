package devsy.toy.openfeign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "encarClient", url = "https://www.encar.com")
interface EncarClient {

    @GetMapping("/robots.txt")
    fun getRobotsTxt(): String
}