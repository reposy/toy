package devsy.toy.learn.assertions.assert_that
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssertThatChar {
    @Test
    // Char 값이 특정 값과 동일한지 확인합니다.
    fun testCharEquality() {
        val actual: Char = 'A'
        val expected: Char = 'A'
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    // Char 값이 특정 값과 동일하지 않은지 확인합니다.
    fun testCharInequality() {
        val actual: Char = 'A'
        val expected: Char = 'B'
        assertThat(actual).isNotEqualTo(expected)
    }

    @Test
    // Char 값이 특정 값보다 큰지 확인합니다.
    fun testCharGreaterThan() {
        val actual: Char = 'B'
        assertThat(actual).isGreaterThan('A')
    }

    @Test
    // Char 값이 특정 값보다 작은지 확인합니다.
    fun testCharLessThan() {
        val actual: Char = 'A'
        assertThat(actual).isLessThan('B')
    }

    @Test
    // Char 값이 특정 값보다 크거나 같은지 확인합니다.
    fun testCharGreaterThanOrEqualTo() {
        val actual: Char = 'A'
        assertThat(actual).isGreaterThanOrEqualTo('A')
    }

    @Test
    // Char 값이 특정 값보다 작거나 같은지 확인합니다.
    fun testCharLessThanOrEqualTo() {
        val actual: Char = 'A'
        assertThat(actual).isLessThanOrEqualTo('A')
    }

    @Test
    // Char 값이 대문자인지 확인합니다.
    fun testCharUpperCase() {
        val actual: Char = 'A'
        assertThat(actual).isUpperCase()
    }

    @Test
    // Char 값이 소문자인지 확인합니다.
    fun testCharLowerCase() {
        val actual: Char = 'a'
        assertThat(actual).isLowerCase()
    }

    @Test
    // Char 값이 숫자인지 확인합니다.
    fun testCharDigit() {
        val actual: Char = '1'
        assertThat(Character.isDigit(actual)).isTrue()
    }

    @Test
    // Char 값이 알파벳인지 확인합니다.
    fun testCharAlphabetic() {
        val actual: Char = 'A'
        assertThat(Character.isAlphabetic(actual.code)).isTrue()
    }
    @Test
    // Char 값이 공백인지 확인합니다.
    fun testCharWhitespace() {
        val actual: Char = ' '
        assertThat(Character.isWhitespace(actual)).isTrue()
    }
}