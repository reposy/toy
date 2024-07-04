package devsy.toy.learn.assertions.assert_that
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat

class AssertThatDouble {
    @Test
    // 두 Double 값이 동일한지 확인합니다.
    fun testDoubleEquality() {
        val actual: Double = 42.0
        val expected: Double = 42.0
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    // 두 Double 값이 동일하지 않은지 확인합니다.
    fun testDoubleInequality() {
        val actual: Double = 42.0
        val expected: Double = 43.0
        assertThat(actual).isNotEqualTo(expected)
    }

    @Test
    // Double 값이 특정 값보다 큰지 확인합니다.
    fun testDoubleGreaterThan() {
        val actual: Double = 42.0
        assertThat(actual).isGreaterThan(41.0)
    }

    @Test
    // Double 값이 특정 값보다 크거나 같은지 확인합니다.
    fun testDoubleGreaterThanOrEqualTo() {
        val actual: Double = 42.0
        assertThat(actual).isGreaterThanOrEqualTo(42.0)
    }

    @Test
    // Double 값이 특정 값보다 작은지 확인합니다.
    fun testDoubleLessThan() {
        val actual: Double = 42.0
        assertThat(actual).isLessThan(43.0)
    }

    @Test
    // Double 값이 특정 값보다 작거나 같은지 확인합니다.
    fun testDoubleLessThanOrEqualTo() {
        val actual: Double = 42.0
        assertThat(actual).isLessThanOrEqualTo(42.0)
    }

    @Test
    // Double 값이 양수인지 확인합니다.
    fun testDoublePositive() {
        val actual: Double = 42.0
        assertThat(actual).isPositive()
    }

    @Test
    // Double 값이 음수인지 확인합니다.
    fun testDoubleNegative() {
        val actual: Double = -42.0
        assertThat(actual).isNegative()
    }

    @Test
    // Double 값이 0인지 확인합니다.
    fun testDoubleZero() {
        val actual: Double = 0.0
        assertThat(actual).isZero()
    }

    @Test
    // Double 값이 특정 범위 내에 있는지 확인합니다.
    fun testDoubleBetween() {
        val actual: Double = 42.0
        assertThat(actual).isBetween(40.0, 45.0)
    }

    @Test
    // Double 값이 특정 값 중 하나인지 확인합니다.
    fun testDoubleIn() {
        val actual: Double = 42.0
        assertThat(actual).isIn(41.0, 42.0, 43.0)
    }

    @Test
    // Double 값이 특정 값 중 하나가 아닌지 확인합니다.
    fun testDoubleNotIn() {
        val actual: Double = 42.0
        assertThat(actual).isNotIn(43.0, 44.0, 45.0)
    }

    @Test
    // Double 값이 NaN인지 확인합니다.
    fun testDoubleNaN() {
        val actual: Double = Double.NaN
        assertThat(actual).isNaN()
    }

    @Test
    // Double 값이 유한한지 확인합니다.
    fun testDoubleFinite() {
        val actual: Double = 42.0
        assertThat(actual).isFinite()
    }

    @Test
    // Double 값이 무한한지 확인합니다.
    fun testDoubleInfinite() {
        val actual: Double = Double.POSITIVE_INFINITY
        assertThat(actual).isInfinite()
    }
}