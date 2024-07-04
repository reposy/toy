package devsy.toy.learn.assertions.assert_that
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat

class AssertThatInt {
    @Test
    // 두 정수가 동일한지 확인합니다.
    fun testIntEquality() {
        val actual = 42
        val expected = 42
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    // 두 정수가 동일하지 않은지 확인합니다.
    fun testIntInequality() {
        val actual = 42
        val expected = 43
        assertThat(actual).isNotEqualTo(expected)
    }

    @Test
    // 정수가 특정 값보다 큰지 확인합니다.
    fun testIntGreaterThan() {
        val actual = 42
        assertThat(actual).isGreaterThan(41)
    }

    @Test
    // 정수가 특정 값보다 크거나 같은지 확인합니다.
    fun testIntGreaterThanOrEqualTo() {
        val actual = 42
        assertThat(actual).isGreaterThanOrEqualTo(42)
    }

    @Test
    // 정수가 특정 값보다 작은지 확인합니다.
    fun testIntLessThan() {
        val actual = 42
        assertThat(actual).isLessThan(43)
    }

    @Test
    // 정수가 특정 값보다 작거나 같은지 확인합니다.
    fun testIntLessThanOrEqualTo() {
        val actual = 42
        assertThat(actual).isLessThanOrEqualTo(42)
    }

    @Test
    // 정수가 양수인지 확인합니다.
    fun testIntPositive() {
        val actual = 42
        assertThat(actual).isPositive()
    }

    @Test
    // 정수가 음수인지 확인합니다.
    fun testIntNegative() {
        val actual = -42
        assertThat(actual).isNegative()
    }

    @Test
    // 정수가 0인지 확인합니다.
    fun testIntZero() {
        val actual = 0
        assertThat(actual).isZero()
    }

    @Test
    // 정수가 특정 범위 내에 있는지 확인합니다.
    fun testIntBetween() {
        val actual = 42
        assertThat(actual).isBetween(40, 45)
    }

    @Test
    // 정수가 특정 값 중 하나인지 확인합니다.
    fun testIntIn() {
        val actual = 42
        assertThat(actual).isIn(41, 42, 43)
    }

    @Test
    // 정수가 특정 값 중 하나가 아닌지 확인합니다.
    fun testIntNotIn() {
        val actual = 42
        assertThat(actual).isNotIn(43, 44, 45)
    }
}