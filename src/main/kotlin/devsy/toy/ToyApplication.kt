package devsy.toy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ToyApplication

fun main(args: Array<String>) {
    runApplication<ToyApplication>(*args)
}
