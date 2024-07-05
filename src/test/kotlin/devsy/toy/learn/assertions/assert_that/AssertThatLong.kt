package devsy.toy.learn.assertions.assert_that

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssertThatLong {
    @Test
    // 두 Long 값이 동일한지 확인합니다.
    fun testLongEquality() {
        val actual: Long = 42L
        val expected: Long = 42L
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    // 두 Long 값이 동일하지 않은지 확인합니다.
    fun testLongInequality() {
        val actual: Long = 42L
        val expected: Long = 43L
        assertThat(actual).isNotEqualTo(expected)
    }

    @Test
    // Long 값이 특정 값보다 큰지 확인합니다.
    fun testLongGreaterThan() {
        val actual: Long = 42L
        assertThat(actual).isGreaterThan(41L)
    }

    @Test
    // Long 값이 특정 값보다 크거나 같은지 확인합니다.
    fun testLongGreaterThanOrEqualTo() {
        val actual: Long = 42L
        assertThat(actual).isGreaterThanOrEqualTo(42L)
    }

    @Test
    // Long 값이 특정 값보다 작은지 확인합니다.
    fun testLongLessThan() {
        val actual: Long = 42L
        assertThat(actual).isLessThan(43L)
    }

    @Test
    // Long 값이 특정 값보다 작거나 같은지 확인합니다.
    fun testLongLessThanOrEqualTo() {
        val actual: Long = 42L
        assertThat(actual).isLessThanOrEqualTo(42L)
    }

    @Test
    // Long 값이 양수인지 확인합니다.
    fun testLongPositive() {
        val actual: Long = 42L
        assertThat(actual).isPositive()
    }

    @Test
    // Long 값이 음수인지 확인합니다.
    fun testLongNegative() {
        val actual: Long = -42L
        assertThat(actual).isNegative()
    }

    @Test
    // Long 값이 0인지 확인합니다.
    fun testLongZero() {
        val actual: Long = 0L
        assertThat(actual).isZero()
    }

    @Test
    // Long 값이 특정 범위 내에 있는지 확인합니다.
    fun testLongBetween() {
        val actual: Long = 42L
        assertThat(actual).isBetween(40L, 45L)
    }

    @Test
    // Long 값이 특정 값 중 하나인지 확인합니다.
    fun testLongIn() {
        val actual: Long = 42L
        assertThat(actual).isIn(41L, 42L, 43L)
    }

    @Test
    // Long 값이 특정 값 중 하나가 아닌지 확인합니다.
    fun testLongNotIn() {
        val actual: Long = 42L
        assertThat(actual).isNotIn(43L, 44L, 45L)
    }
}