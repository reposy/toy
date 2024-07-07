package devsy.toy.openfeign

import devsy.toy.util.CrawlerUtil
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KcarClientTest(
    @Autowired val kCarClient: KCarClient,
    @Autowired val crawlerUtil: CrawlerUtil
) {

    @Test
    fun getRobotsTxtTest() {
        val robotsTxt = kCarClient.getRobotsTxt()
        Assertions.assertThat(robotsTxt).isNotNull()

        val rules = crawlerUtil.parseRobotsTxtToRules(robotsTxt)

        /* 차량 목록 조회 */
        assertThat(crawlerUtil.isPathAllowed(userAgent = "*", path = "/bc/search", rules)).isTrue
        /* 차량 상세 조회 */
        assertThat(crawlerUtil.isPathAllowed(userAgent = "*", path = "/bc/detail/carInfoDtl?i_sCarCd=EC61030844", rules)).isTrue

    }
}