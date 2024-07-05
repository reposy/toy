package devsy.toy.openfeign

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EncarClientTest {
    @Autowired
    private lateinit var encarClient: EncarClient

    @Test
    fun getRobotsTxtTest() {
        val robotsTxt = encarClient.getRobotsTxt()
        assertThat(robotsTxt).isNotNull()
        println(robotsTxt)
    }
}