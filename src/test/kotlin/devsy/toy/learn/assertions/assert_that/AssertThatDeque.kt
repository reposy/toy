package devsy.toy.learn.assertions.assert_that
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.ArrayDeque
import java.util.Deque

class AssertThatDeque {
    @Test
    // Deque의 크기를 확인합니다.
    fun testDequeSize() {
        val deque: Deque<Int> = ArrayDeque()
        deque.add(1)
        deque.add(2)
        deque.add(3)
        assertThat(deque).hasSize(3)
    }

    @Test
    // Deque가 특정 요소를 포함하는지 확인합니다.
    fun testDequeContains() {
        val deque: Deque<Int> = ArrayDeque()
        deque.add(1)
        deque.add(2)
        deque.add(3)
        assertThat(deque).contains(2)
    }

    @Test
    // Deque가 특정 요소를 포함하지 않는지 확인합니다.
    fun testDequeDoesNotContain() {
        val deque: Deque<Int> = ArrayDeque()
        deque.add(1)
        deque.add(2)
        deque.add(3)
        assertThat(deque).doesNotContain(4)
    }

    @Test
    // Deque의 첫 번째 요소를 확인합니다.
    fun testDequePeekFirst() {
        val deque: Deque<Int> = ArrayDeque()
        deque.add(3)
        deque.add(1)
        deque.add(2)
        assertThat(deque.peekFirst()).isEqualTo(3)
    }

    @Test
    // Deque의 마지막 요소를 확인합니다.
    fun testDequePeekLast() {
        val deque: Deque<Int> = ArrayDeque()
        deque.add(3)
        deque.add(1)
        deque.add(2)
        assertThat(deque.peekLast()).isEqualTo(2)
    }
}