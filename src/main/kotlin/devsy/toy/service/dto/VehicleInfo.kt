package devsy.toy.service.dto

import org.jsoup.nodes.Element
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import java.io.Serializable


data class VehicleInfo(
    val platform: String,
    val detailUrl: String,
    val imageUrl: String,
    val make: String,
    val model: String,
    val trim: String,
    val year: String,
    val mileage: String,
    val fuel: String,
    val location: String,
    val price: String
): Serializable {
    constructor(platform: String, element: Element) : this(
        platform = platform,
        detailUrl = element.select("a").map { it.attr("href") }.firstOrNull()?:"",
        imageUrl = element.select("span.img span.ass").map { it.attr("src") }.firstOrNull()?:"",
        make = element.select("span.cls strong").text(),
        model = element.select("span.cls em").text(),
        trim = element.select("span.dtl strong").text(),
        year = element.select("span.yer").text(),
        mileage = element.select("span.km").text(),
        fuel = element.select("span.ipt").text(),
        location = element.select("span.lo").text(),
        price = element.select("span.prc strong").text(),
    )
}
/*
import devsy.toy.service.constant.VehiclePlatform
data class Vehicle(
    val platform: VehiclePlatform, // 차량이 제공되는 플랫폼 (ENCAR, KCAR 등)
    val manufacturer: String,      // 차량 제조사 (예: 현대, 기아)
    val price: String,             // 차량 가격
    val name: String,              // 차량 이름 (예: 아반떼)
    val type: String,              // 차량 타입 (예: 승용차, SUV)
    val vehicleType: String,       // 차종 (예: 경형, 소형, 중형)
    val year: String,              // 차량 년식
    val mileage: String,           // 주행거리 (km)
    val engineCapacity: String,    // 배기량 (cc)
    val fuelType: String,          // 연료 종류 (예: 가솔린, 디젤)
    val options: List<String>,     // 차량 옵션 (예: 썬루프, 네비게이션)

    val isUsedCar: Boolean,        // 중고차 여부
    val location: String,          // 거래 장소 (예: 서울, 경기, 부산)

    val vehicleUrl: String,        // 차량 상세 페이지 URL
    val imageUrl: String,          // 차량 이미지 URL

    val comments: String?           // 비고
)
*/