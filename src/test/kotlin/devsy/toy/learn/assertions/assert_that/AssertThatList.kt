package devsy.toy.learn.assertions.assert_that

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssertThatList {
    @Test
    // 리스트의 크기를 확인합니다.
    fun testListSize() {
        val list = listOf(1, 2, 3)
        assertThat(list).hasSize(3)
    }

    @Test
    // 리스트가 특정 요소를 포함하는지 확인합니다.
    fun testListContains() {
        val list = listOf(1, 2, 3)
        assertThat(list).contains(2)
    }

    @Test
    // 리스트가 특정 요소를 포함하지 않는지 확인합니다.
    fun testListDoesNotContain() {
        val list = listOf(1, 2, 3)
        assertThat(list).doesNotContain(4)
    }

    @Test
    // 리스트가 정확히 특정 요소들을 포함하는지 순서대로 확인합니다.
    fun testListContainsExactly() {
        val list = listOf(1, 2, 3)
        assertThat(list).containsExactly(1, 2, 3)
    }

    @Test
    // 리스트가 정확히 특정 요소들을 포함하는지 순서에 상관없이 확인합니다.
    fun testListContainsExactlyInAnyOrder() {
        val list = listOf(1, 2, 3)
        assertThat(list).containsExactlyInAnyOrder(3, 2, 1)
    }

    @Test
    // 리스트의 특정 인덱스에 있는 값을 확인합니다.
    fun testListElementAtIndex() {
        val list = listOf(1, 2, 3)
        assertThat(list[1]).isEqualTo(2)
    }

    @Test
    // 리스트가 비어 있는지 확인합니다.
    fun testEmptyList() {
        val list = listOf<Int>()
        assertThat(list).isEmpty()
    }

    @Test
    // 리스트가 비어 있지 않은지 확인합니다.
    fun testNotEmptyList() {
        val list = listOf(1, 2, 3)
        assertThat(list).isNotEmpty()
    }

    @Test
    // 리스트가 특정 순서로 시작하는지 확인합니다.
    fun testListStartsWith() {
        val list = listOf(1, 2, 3)
        assertThat(list).startsWith(1, 2)
    }

    @Test
    // 리스트가 특정 순서로 끝나는지 확인합니다.
    fun testListEndsWith() {
        val list = listOf(1, 2, 3)
        assertThat(list).endsWith(2, 3)
    }

    @Test
    // 리스트의 모든 요소가 특정 조건을 만족하는지 확인합니다.
    fun testListAllMatch() {
        val list = listOf(1, 2, 3)
        assertThat(list).allMatch { it > 0 }
    }

    @Test
    // 리스트의 일부 요소가 특정 조건을 만족하는지 확인합니다.
    fun testListAnyMatch() {
        val list = listOf(1, 2, 3)
        assertThat(list).anyMatch { it > 2 }
    }

    @Test
    // 리스트의 어떤 요소도 특정 조건을 만족하지 않는지 확인합니다.
    fun testListNoneMatch() {
        val list = listOf(1, 2, 3)
        assertThat(list).noneMatch { it < 0 }
    }

    @Test
    // 리스트가 특정 요소들을 순서에 상관없이 포함하는지 확인합니다.
    fun testListContainsAll() {
        val list = listOf(1, 2, 3, 4, 5)
        assertThat(list).containsAll(listOf(3, 1, 4))
    }
}