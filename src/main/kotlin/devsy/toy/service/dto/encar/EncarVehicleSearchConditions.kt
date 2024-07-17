package devsy.toy.service.dto.encar

import org.openqa.selenium.WebElement

data class Category(val path: String, val Name: String = "") // 차종
data class ModelStep(val path: String, val name: String = "") // 제조사/모델/등급
data class YearArea(
    val minYearId: String = "", val minYear: String = "2014", // minYear // 연식
    val minMonthId: String = "", val minMonth: String = "01", // minMonth
    val maxYearId: String = "", val maxYear: String = "2024", // maxYear
    val maxMonthId: String = "", val maxMonth: String = "12") // maxMonth
data class DistanceArea(
    val minDistanceId: String = "", val minDistance: String = "0",
    val maxDistanceId: String = "", val maxDistance: String = "300000") // 주행거리
data class PriceArea(
    val minPriceId: String = "", val minPrice: String = "0",
    val maxPriceId: String = "", val maxPrice: String = "100000000",) // 가격
data class Warranty(val id: String = "", val name: String = "") // 엔카 서비스
data class Location(val id: String = "", val name: String = "") // 지역
data class Performance(val id: String = "", val name: String = "") // 성능/보험공개
data class SellerType(val id: String = "", val name: String = "") // 판매자 유형
data class BuyType(val id: String = "", val name: String = "") // 판매 방식
data class Color(val id: String = "", val name: String = "") // 색상
data class FuelType(val id: String = "", val name: String = "") // 연료
data class Mission(val id: String = "", val name: String = "") // 변속기
data class Option(val id: String = "", val name: String = "") // 옵션

data class EncarVehicleSearchConditions (
    val carTypes: List<Category> = mutableListOf(), // 차종
    val modelSteps: List<ModelStep> = mutableListOf(), // 제조사/모델/등급
    val yearAreas: YearArea = YearArea(), // 연식(구간)
    val distanceAreas: DistanceArea = DistanceArea(), // 주행거리(구간)
    val priceAreas: PriceArea = PriceArea(), // 가격
    val warranties: List<Warranty> = mutableListOf(), // 엔카 서비스
    val locations: List<Location> = mutableListOf(), // 위치
    val performances: List<Performance> = mutableListOf(), // 성능/보험공개
    val sellerTypes: List<SellerType> = mutableListOf(), // 판매자구분
    val buyTypes: List<BuyType> = mutableListOf(), // 판매방식
    val colors: List<Color> = mutableListOf(), // 색상
    val fuelTypes: List<FuelType> = mutableListOf(), // 연료
    val missions: List<Mission> = mutableListOf(), // 변속기
    val options: List<Option> = mutableListOf(), // 차량 옵션
    val searchText: String = "" // 차량번호/판매자 이름
)