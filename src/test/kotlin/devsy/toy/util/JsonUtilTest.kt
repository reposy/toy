package devsy.toy.util

import com.fasterxml.jackson.annotation.JsonProperty
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.stereotype.Component

@Component
class JsonUtilTest {
    private val jsonUtil = JsonUtil()

    data class SimpleData(
        @JsonProperty("name") val name: String,
        @JsonProperty("age") val age: Int
    )

    data class PhoneNumber(
        @JsonProperty("type") val type: String,
        @JsonProperty("number") val number: String
    )

    data class Address(
        @JsonProperty("city") val city: String,
        @JsonProperty("zipcode") val zipcode: String
    )

    data class SampleData(
        @JsonProperty("name") val name: String,
        @JsonProperty("age") val age: Int,
        @JsonProperty("address") val address: Address,
        @JsonProperty("phoneNumbers") val phoneNumbers: List<PhoneNumber>
    )

    @Test
    fun `test jsonStrToObject - simple json`() {
        // 단순 JSON 문자열 테스트
        val simpleJsonStr = """{"name":"John","age":30}"""
        val simpleResult = jsonUtil.jsonStrToObject(simpleJsonStr, SimpleData::class.java)

        // 단순 JSON 검증
        assertThat(simpleResult).isNotNull
        assertThat(simpleResult.name).isEqualTo("John")
        assertThat(simpleResult.age).isEqualTo(30)
    }
    fun `test jsonStrToObject - nested json`() {
        // 중첩된 JSON 문자열 테스트
        val nestedJsonStr = """
            {
                "name": "John",
                "age": 30,
                "address": {
                    "city": "New York",
                    "zipcode": "10001"
                },
                "phoneNumbers": [
                    {
                        "type": "home",
                        "number": "212 555-1234"
                    },
                    {
                        "type": "fax",
                        "number": "646 555-4567"
                    }
                ]
            }
        """.trimIndent()

        val nestedResult = jsonUtil.jsonStrToObject(nestedJsonStr, SampleData::class.java)

        // 중첩된 JSON 검증
        assertThat(nestedResult).isNotNull
        assertThat(nestedResult.name).isEqualTo("John")
        assertThat(nestedResult.age).isEqualTo(30)

        val address = nestedResult.address
        assertThat(address.city).isEqualTo("New York")
        assertThat(address.zipcode).isEqualTo("10001")

        val phoneNumbers = nestedResult.phoneNumbers
        assertThat(phoneNumbers).hasSize(2)

        val phoneNumber1 = phoneNumbers[0]
        assertThat(phoneNumber1.type).isEqualTo("home")
        assertThat(phoneNumber1.number).isEqualTo("212 555-1234")

        val phoneNumber2 = phoneNumbers[1]
        assertThat(phoneNumber2.type).isEqualTo("fax")
        assertThat(phoneNumber2.number).isEqualTo("646 555-4567")
    }

    @Test
    fun `test jsonStrToMap with simple JSON`() {
        val jsonStr = """{"name":"John","age":30}"""
        val result = jsonUtil.jsonStrToMap(jsonStr)

        // 단순 JSON 검증
        assertThat(result).isNotNull
        assertThat(result["name"]).isEqualTo("John")
        assertThat(result["age"]).isEqualTo(30)
    }
    @Test
    fun `test jsonStrToMap with nested JSON`() {
        val jsonStr = """
            {
                "name": "John",
                "age": 30,
                "address": {
                    "city": "New York",
                    "zipcode": "10001"
                },
                "phoneNumbers": [
                    {
                        "type": "home",
                        "number": "212 555-1234"
                    },
                    {
                        "type": "fax",
                        "number": "646 555-4567"
                    }
                ]
            }
        """.trimIndent()
        val result = jsonUtil.jsonStrToMap(jsonStr)

        // 중첩된 JSON 검증
        assertThat(result).isNotNull
        assertThat(result["name"]).isEqualTo("John")
        assertThat(result["age"]).isEqualTo(30)

        val address = result["address"] as Map<*, *>
        assertThat(address["city"]).isEqualTo("New York")
        assertThat(address["zipcode"]).isEqualTo("10001")

        val phoneNumbers = result["phoneNumbers"] as List<*>
        assertThat(phoneNumbers).hasSize(2)

        val phoneNumber1 = phoneNumbers[0] as Map<*, *>
        assertThat(phoneNumber1["type"]).isEqualTo("home")
        assertThat(phoneNumber1["number"]).isEqualTo("212 555-1234")

        val phoneNumber2 = phoneNumbers[1] as Map<*, *>
        assertThat(phoneNumber2["type"]).isEqualTo("fax")
        assertThat(phoneNumber2["number"]).isEqualTo("646 555-4567")
    }

    @Test
    fun `test jsonStrToMap with empty JSON`() {
        val jsonStr = """{}"""
        val result = jsonUtil.jsonStrToMap(jsonStr)

        // 빈 JSON 검증
        assertThat(result).isNotNull
        assertThat(result).isEmpty()
    }

    @Test
    fun `test jsonStrToMap with array JSON`() {
        val jsonStr = """
            {
                "name": "John",
                "age": 30,
                "hobbies": ["reading", "travelling", "swimming"]
            }
        """.trimIndent()
        val result = jsonUtil.jsonStrToMap(jsonStr)

        // 배열을 포함한 JSON 검증
        assertThat(result).isNotNull
        assertThat(result["name"]).isEqualTo("John")
        assertThat(result["age"]).isEqualTo(30)

        val hobbies = result["hobbies"] as List<*>
        assertThat(hobbies).hasSize(3)
        assertThat(hobbies[0]).isEqualTo("reading")
        assertThat(hobbies[1]).isEqualTo("travelling")
        assertThat(hobbies[2]).isEqualTo("swimming")
    }
}