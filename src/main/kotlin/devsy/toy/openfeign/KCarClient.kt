package devsy.toy.openfeign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "kcarClient", url = "https://www.kcar.com")
interface KCarClient {

    @GetMapping("/robots.txt")
    fun getRobotsTxt(): String
    @GetMapping("/api/vehicles")
    //fun getVehicles(@RequestParam("query") query: String): List<Vehicle>
    fun getVehicles(@RequestParam("query") query: String): String
}