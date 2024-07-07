package devsy.toy.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

@Component
class JsonUtil {
    private val objectMapper = ObjectMapper()

    fun <T> jsonStrToObject(jsonStr: String, vo: Class<T>): T {
        return objectMapper.readValue(jsonStr, vo)
    }

    fun jsonStrToMap(jsonStr: String): Map<String, Any> {
        val objectMapper = ObjectMapper()
        return objectMapper.readValue(jsonStr, object : TypeReference<Map<String, Any>>() {})
    }
}