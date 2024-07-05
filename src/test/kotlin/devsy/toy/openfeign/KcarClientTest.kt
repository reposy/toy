package devsy.toy.openfeign

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KcarClientTest {
    @Autowired
    private lateinit var kCarClient: KCarClient
    @Test
    fun getRobotsTxtTest() {
        val robotsTxt = kCarClient.getRobotsTxt()
        Assertions.assertThat(robotsTxt).isNotNull()
        println(robotsTxt)
    }
}