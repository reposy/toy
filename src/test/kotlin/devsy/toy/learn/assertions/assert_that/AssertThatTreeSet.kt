package devsy.toy.learn.assertions.assert_that
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import java.util.TreeSet

class AssertThatTreeSet {
    @Test
    // TreeSet의 크기를 확인합니다.
    fun testTreeSetSize() {
        val treeSet = TreeSet<Int>()
        treeSet.add(1)
        treeSet.add(2)
        treeSet.add(3)
        assertThat(treeSet).hasSize(3)
    }

    @Test
    // TreeSet이 특정 요소를 포함하는지 확인합니다.
    fun testTreeSetContains() {
        val treeSet = TreeSet<Int>()
        treeSet.add(1)
        treeSet.add(2)
        treeSet.add(3)
        assertThat(treeSet).contains(2)
    }

    @Test
    // TreeSet이 특정 요소를 포함하지 않는지 확인합니다.
    fun testTreeSetDoesNotContain() {
        val treeSet = TreeSet<Int>()
        treeSet.add(1)
        treeSet.add(2)
        treeSet.add(3)
        assertThat(treeSet).doesNotContain(4)
    }

    @Test
    // TreeSet이 정렬된 순서로 요소를 포함하는지 확인합니다.
    fun testTreeSetOrder() {
        val treeSet = TreeSet<Int>()
        treeSet.add(3)
        treeSet.add(1)
        treeSet.add(2)
        assertThat(treeSet).containsExactly(1, 2, 3)
    }

    @Test
    // TreeSet에서 첫 번째 요소를 확인합니다.
    fun testTreeSetFirst() {
        val treeSet = TreeSet<Int>()
        treeSet.add(3)
        treeSet.add(1)
        treeSet.add(2)
        assertThat(treeSet.first()).isEqualTo(1)
    }

    @Test
    // TreeSet에서 마지막 요소를 확인합니다.
    fun testTreeSetLast() {
        val treeSet = TreeSet<Int>()
        treeSet.add(3)
        treeSet.add(1)
        treeSet.add(2)
        assertThat(treeSet.last()).isEqualTo(3)
    }

    @Test
    // TreeSet이 비어 있는지 확인합니다.
    fun testTreeSetEmpty() {
        val treeSet = TreeSet<Int>()
        assertThat(treeSet).isEmpty()
    }

    @Test
    // TreeSet이 비어 있지 않은지 확인합니다.
    fun testTreeSetNotEmpty() {
        val treeSet = TreeSet<Int>()
        treeSet.add(1)
        assertThat(treeSet).isNotEmpty()
    }

    @Test
    // TreeSet에서 특정 요소를 제거하는지 확인합니다.
    fun testTreeSetRemove() {
        val treeSet = TreeSet<Int>()
        treeSet.add(1)
        treeSet.add(2)
        treeSet.add(3)
        treeSet.remove(2)
        assertThat(treeSet).doesNotContain(2)
        assertThat(treeSet).hasSize(2)
    }

    @Test
    // TreeSet의 하위 집합을 확인합니다.
    fun testTreeSetSubSet() {
        val treeSet = TreeSet<Int>()
        treeSet.add(1)
        treeSet.add(2)
        treeSet.add(3)
        val subSet = treeSet.subSet(1, 3) // 3은 포함되지 않습니다.
        assertThat(subSet).containsExactly(1, 2)
    }
}