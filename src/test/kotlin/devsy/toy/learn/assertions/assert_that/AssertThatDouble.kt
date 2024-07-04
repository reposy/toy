package devsy.toy.learn.assertions.assert_that
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat

class AssertThatFloat {
    @Test
    // 두 Float 값이 동일한지 확인합니다.
    fun testFloatEquality() {
        val actual: Float = 42.0f
        val expected: Float = 42.0f
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    // 두 Float 값이 동일하지 않은지 확인합니다.
    fun testFloatInequality() {
        val actual: Float = 42.0f
        val expected: Float = 43.0f
        assertThat(actual).isNotEqualTo(expected)
    }

    @Test
    // Float 값이 특정 값보다 큰지 확인합니다.
    fun testFloatGreaterThan() {
        val actual: Float = 42.0f
        assertThat(actual).isGreaterThan(41.0f)
    }

    @Test
    // Float 값이 특정 값보다 크거나 같은지 확인합니다.
    fun testFloatGreaterThanOrEqualTo() {
        val actual: Float = 42.0f
        assertThat(actual).isGreaterThanOrEqualTo(42.0f)
    }

    @Test
    // Float 값이 특정 값보다 작은지 확인합니다.
    fun testFloatLessThan() {
        val actual: Float = 42.0f
        assertThat(actual).isLessThan(43.0f)
    }

    @Test
    // Float 값이 특정 값보다 작거나 같은지 확인합니다.
    fun testFloatLessThanOrEqualTo() {
        val actual: Float = 42.0f
        assertThat(actual).isLessThanOrEqualTo(42.0f)
    }

    @Test
    // Float 값이 양수인지 확인합니다.
    fun testFloatPositive() {
        val actual: Float = 42.0f
        assertThat(actual).isPositive()
    }

    @Test
    // Float 값이 음수인지 확인합니다.
    fun testFloatNegative() {
        val actual: Float = -42.0f
        assertThat(actual).isNegative()
    }

    @Test
    // Float 값이 0인지 확인합니다.
    fun testFloatZero() {
        val actual: Float = 0.0f
        assertThat(actual).isZero()
    }

    @Test
    // Float 값이 특정 범위 내에 있는지 확인합니다.
    fun testFloatBetween() {
        val actual: Float = 42.0f
        assertThat(actual).isBetween(40.0f, 45.0f)
    }

    @Test
    // Float 값이 특정 값 중 하나인지 확인합니다.
    fun testFloatIn() {
        val actual: Float = 42.0f
        assertThat(actual).isIn(41.0f, 42.0f, 43.0f)
    }

    @Test
    // Float 값이 특정 값 중 하나가 아닌지 확인합니다.
    fun testFloatNotIn() {
        val actual: Float = 42.0f
        assertThat(actual).isNotIn(43.0f, 44.0f, 45.0f)
    }

    @Test
    // Float 값이 NaN인지 확인합니다.
    fun testFloatNaN() {
        val actual: Float = Float.NaN
        assertThat(actual).isNaN()
    }

    @Test
    // Float 값이 유한한지 확인합니다.
    fun testFloatFinite() {
        val actual: Float = 42.0f
        assertThat(actual).isFinite()
    }

    @Test
    // Float 값이 무한한지 확인합니다.
    fun testFloatInfinite() {
        val actual: Float = Float.POSITIVE_INFINITY
        assertThat(actual).isInfinite()
    }
}