package devsy.toy.openfeign

import devsy.toy.util.CrawlerUtil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EncarClientTest(
    @Autowired val encarClient: EncarClient,
    @Autowired val crawlerUtil: CrawlerUtil
) {

    @Test
    fun `test getRobotsTxt()`() {
        val robotsTxt = encarClient.getRobotsTxt()
        assertThat(robotsTxt).isNotNull()

        val rules = crawlerUtil.parseRobotsTxtToRules(robotsTxt)

        /* 차량 목록 조회 부분 */
        assertThat(crawlerUtil.isPathAllowed(userAgent = "*", path = "/dc/dc_carsearchlist.do?carType=", rules)).isTrue
        /* 차량 상세 조회 부분 */
        assertThat(crawlerUtil.isPathAllowed(userAgent = "*", path = "/dc/dc_cardetailview.do?page_id=", rules)).isTrue
    }
}