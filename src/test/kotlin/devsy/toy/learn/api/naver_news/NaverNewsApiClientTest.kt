package devsy.toy.learn.api.naver_news

import devsy.toy.openfeign.NaverNewsApiClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NaverNewsApiClientTest {

    @Autowired
    lateinit var naverApiClient: NaverNewsApiClient

    @Test
    fun testSearchNews() {
        val clientId = "R6UWUpQ_HgPdAyqLR0dE"
        val clientSecret = "cOTmo9X_dD"
        val response = naverApiClient.searchNews(
            query = "주식", // (required) 검색어. UTF-8로 인코딩되어야 합니다.
            display = 10, // 한 번에 표시할 검색 결과 개수(기본값: 10, 최댓값: 100)
            start = 1,
            sort = "sim", // sim: 정확도순으로 내림차선, date: 날짜순으로 내림차순
            clientId = clientId,
            clientSecret = clientSecret
        )
        println(response)
        assertThat(response.toString()).isNotNull()
    }
}