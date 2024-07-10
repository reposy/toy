package devsy.toy.service

import devsy.toy.openfeign.EncarClient
import devsy.toy.service.dto.Vehicle
import devsy.toy.util.SeleniumUtil
import org.springframework.stereotype.Service

@Service
class EncarService(
    val encarClient: EncarClient,
    val seleniumUtil: SeleniumUtil
) {
    //fun getRealtimeVehicleList(): List<Vehicle> {
    fun getRealtimeVehicleList(): Any {

        return seleniumUtil.getHtmlByUrl("https://www.encar.com/dc/dc_carsearchlist.do")
    }

}