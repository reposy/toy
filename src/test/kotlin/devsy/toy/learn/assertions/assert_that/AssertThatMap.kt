package devsy.toy.learn.assertions.assert_that
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat

class AssertThatSet {
    @Test
    // Set의 크기를 확인합니다.
    fun testSetSize() {
        val set = setOf(1, 2, 3)
        assertThat(set).hasSize(3)
    }

    @Test
    // Set이 특정 요소를 포함하는지 확인합니다.
    fun testSetContains() {
        val set = setOf(1, 2, 3)
        assertThat(set).contains(2)
    }

    @Test
    // Set이 특정 요소를 포함하지 않는지 확인합니다.
    fun testSetDoesNotContain() {
        val set = setOf(1, 2, 3)
        assertThat(set).doesNotContain(4)
    }

    @Test
    // Set이 비어 있는지 확인합니다.
    fun testEmptySet() {
        val set = setOf<Int>()
        assertThat(set).isEmpty()
    }

    @Test
    // Set이 비어 있지 않은지 확인합니다.
    fun testNotEmptySet() {
        val set = setOf(1, 2, 3)
        assertThat(set).isNotEmpty()
    }

    @Test
    // Set이 특정 요소들을 포함하는지 확인합니다.
    fun testSetContainsAll() {
        val set = setOf(1, 2, 3, 4, 5)
        assertThat(set).containsAll(listOf(1, 3, 5))
    }

    @Test
    // Set의 모든 요소가 특정 조건을 만족하는지 확인합니다.
    fun testSetAllMatch() {
        val set = setOf(2, 4, 6)
        assertThat(set).allMatch { it % 2 == 0 }
    }

    @Test
    // Set의 일부 요소가 특정 조건을 만족하는지 확인합니다.
    fun testSetAnyMatch() {
        val set = setOf(1, 2, 3)
        assertThat(set).anyMatch { it > 2 }
    }

    @Test
    // Set의 어떤 요소도 특정 조건을 만족하지 않는지 확인합니다.
    fun testSetNoneMatch() {
        val set = setOf(1, 2, 3)
        assertThat(set).noneMatch { it < 0 }
    }

    @Test
    // 두 Set이 동일한지 확인합니다.
    fun testSetEquality() {
        val set1 = setOf(1, 2, 3)
        val set2 = setOf(1, 2, 3)
        assertThat(set1).isEqualTo(set2)
    }

    @Test
    // 두 Set이 동일하지 않은지 확인합니다.
    fun testSetInequality() {
        val set1 = setOf(1, 2, 3)
        val set2 = setOf(4, 5, 6)
        assertThat(set1).isNotEqualTo(set2)
    }

    @Test
    // Set이 특정 요소들을 포함하는지 순서에 상관없이 확인합니다.
    fun testSetContainsExactlyInAnyOrder() {
        val set = setOf(1, 2, 3)
        assertThat(set).containsExactlyInAnyOrder(3, 2, 1)
    }
}