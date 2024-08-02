package devsy.toy.openfeign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "naverApiClient", url = "https://openapi.naver.com")
interface NaverNewsApiClient {

    data class NaverNewsApiResponse(
        val lastBuildDate: String,
        val total: Int,
        val start: Int,
        val display: Int,
        val items: List<NaverNewsItem>
    )

    data class NaverNewsItem(
        val title: String,
        val originallink: String, // 뉴스 기사 원문의 URL
        val link: String, // 뉴스 기사의 네이버 뉴스 URL. 네이버 제공되지 않은 기사라면 기사 원문의 URL(originallink
        val description: String, // 뉴스 기사의 내용을 요약한 패시지 정보. 검색어와 일치하는 부분은 <b/>로 감싸져있음
        val pubDate: String // 뉴스 기사가 네이버에 제공된 시간
    )
    @GetMapping("/v1/search/news.json")
    fun searchNews(
        @RequestParam("query") query: String,
        @RequestParam("display") display: Int,
        @RequestParam("start") start: Int,
        @RequestParam("sort") sort: String,
        @RequestHeader("X-Naver-Client-Id") clientId: String,
        @RequestHeader("X-Naver-Client-Secret") clientSecret: String
    ): NaverNewsApiResponse
}