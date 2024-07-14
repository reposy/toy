package devsy.toy.service.dto.encar

data class Category(var id: String = "", var Name: String = "") // 차종
data class ModelStep(var id: String = "", var name: String = "") // 제조사/모델/등급
data class YearArea(
    var minYearId: String = "", var minYear: String = "2014", // minYear // 연식
    var minMonthId: String = "", var minMonth: String = "01", // minMonth
    var maxYearId: String = "", var maxYear: String = "2024", // maxYear
    var maxMonthId: String = "", var maxMonth: String = "12") // maxMonth
data class DistanceArea(
    var minDistanceId: String = "", var minDistance: String = "0",
    var maxDistanceId: String = "", var maxDistance: String = "300000") // 주행거리
data class PriceArea(
    var minPriceId: String = "", var minPrice: String = "0",
    var maxPriceId: String = "", var maxPrice: String = "100000000",) // 가격
data class Warranty(var id: String = "", var name: String = "") // 엔카 서비스
data class Location(var id: String = "", var name: String = "") // 지역
data class Performance(var id: String = "", var name: String = "") // 성능/보험공개
data class SellerType(var id: String = "", var name: String = "") // 판매자 유형
data class BuyType(var id: String = "", var name: String = "") // 판매 방식
data class Color(var id: String = "", var name: String = "") // 색상
data class FuelType(var id: String = "", var name: String = "") // 연료
data class Mission(var id: String = "", var name: String = "") // 변속기
data class Option(var id: String = "", var name: String = "") // 옵션

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