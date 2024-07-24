package devsy.toy.service

import devsy.toy.leveldb.dao.LevelDBRepository
import devsy.toy.service.dto.VehicleInfo
import devsy.toy.util.SeleniumUtil
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EncarServiceTest(

    @Autowired val encarService: EncarService,
    @Autowired private val lvRepo: LevelDBRepository,
) {

    @BeforeEach
    fun setUp() {
        lvRepo.put("vehicleInfoList", ArrayList<VehicleInfo>())
    }
    @Test
    fun `test getEncarVehicleList`() {
//        val vehicleInfoList: MutableList<VehicleInfo> = lvRepo.get("vehicleInfoList") ?: mutableListOf()
//        println(">>>>>>>" + vehicleInfoList.size)
//        if(vehicleInfoList.size > 1000) {
//            vehicleInfoList.forEach {
//                println("${it.platform}) make= ${it.make}, model= ${it.model}, year=${it.year}, mileage=${it.mileage}, fuel=${it.fuel}, location=${it.location}, price=${it.price}만원")
//            }
//            return
//        }
        encarService.getEncarVehicleList()
    }
    @Test
    fun `test 차량 옵션 목록 조회`() {
        encarService.getRealtimeSearchConditions()
    }
    @Test
    fun `test 차량 목록 조회`() {
        encarService.getRealtimeTotalVehicleList()
    }

}