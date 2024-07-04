package devsy.toy.learn.assertions.assert_that
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
class AssertThatString {
    @Test
    // 두 문자열이 동일한지 확인합니다.
    fun testStringEquality() {
        val actual = "Hello, World!"
        val expected = "Hello, World!"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    // 문자열이 특정 서브스트링을 포함하는지 확인합니다.
    fun testStringContains() {
        val actual = "Hello, World!"
        assertThat(actual).contains("World")
    }

    @Test
    // 문자열이 특정 서브스트링을 포함하지 않는지 확인합니다.
    fun testStringDoesNotContain() {
        val actual = "Hello, World!"
        assertThat(actual).doesNotContain("Universe")
    }

    @Test
    // 문자열이 특정 문자열로 시작하는지 확인합니다.
    fun testStringStartsWith() {
        val actual = "Hello, World!"
        assertThat(actual).startsWith("Hello")
    }

    @Test
    // 문자열이 특정 문자열로 끝나는지 확인합니다.
    fun testStringEndsWith() {
        val actual = "Hello, World!"
        assertThat(actual).endsWith("World!")
    }

    @Test
    // 문자열의 길이를 확인합니다.
    fun testStringLength() {
        val actual = "Hello, World!"
        assertThat(actual).hasSize(13)
    }

    @Test
    // 문자열이 비어 있는지 확인합니다.
    fun testStringIsEmpty() {
        val actual = ""
        assertThat(actual).isEmpty()
    }

    @Test
    // 문자열이 비어 있지 않은지 확인합니다.
    fun testStringIsNotEmpty() {
        val actual = "Hello, World!"
        assertThat(actual).isNotEmpty()
    }

    @Test
    // 문자열이 특정 정규 표현식에 맞는지 확인합니다.
    fun testStringMatchesRegex() {
        val actual = "hello@example.com"
        assertThat(actual).matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")
    }

    @Test
    // 문자열이 특정 정규 표현식에 맞지 않는지 확인합니다.
    fun testStringDoesNotMatchRegex() {
        val actual = "hello@.com"
        assertThat(actual).doesNotMatch("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")
    }

    @Test
    // 문자열이 대소문자를 무시하고 특정 서브스트링을 포함하는지 확인합니다.
    fun testStringContainsIgnoringCase() {
        val actual = "Hello, World!"
        assertThat(actual).containsIgnoringCase("hello")
    }

    @Test
    // 문자열이 공백만으로 이루어져 있는지 확인합니다.
    fun testStringIsBlank() {
        val actual = "   "
        assertThat(actual).isBlank()
    }

    @Test
    // 문자열이 공백만으로 이루어져 있지 않은지 확인합니다.
    fun testStringIsNotBlank() {
        val actual = "Hello, World!"
        assertThat(actual).isNotBlank()
    }

    @Test
    // 문자열이 특정 줄 수를 가지고 있는지 확인합니다.
    fun testStringHasLineCount() {
        val actual = """
            Hello,
            World!
        """.trimIndent()
        assertThat(actual).hasLineCount(2)
    }
}