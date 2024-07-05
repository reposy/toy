package devsy.toy.learn.assertions.assert_that

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import java.util.LinkedList
import java.util.Queue

class AssertThatQueue {
    @Test
    // Queue의 크기를 확인합니다.
    fun testQueueSize() {
        val queue: Queue<Int> = LinkedList()
        queue.add(1)
        queue.add(2)
        queue.add(3)
        assertThat(queue).hasSize(3)
    }

    @Test
    // Queue가 특정 요소를 포함하는지 확인합니다.
    fun testQueueContains() {
        val queue: Queue<Int> = LinkedList()
        queue.add(1)
        queue.add(2)
        queue.add(3)
        assertThat(queue).contains(2)
    }

    @Test
    // Queue가 특정 요소를 포함하지 않는지 확인합니다.
    fun testQueueDoesNotContain() {
        val queue: Queue<Int> = LinkedList()
        queue.add(1)
        queue.add(2)
        queue.add(3)
        assertThat(queue).doesNotContain(4)
    }

    @Test
    // Queue의 첫 번째 요소를 확인합니다.
    fun testQueuePeek() {
        val queue: Queue<Int> = LinkedList()
        queue.add(3)
        queue.add(1)
        queue.add(2)
        assertThat(queue.peek()).isEqualTo(3) // FIFO 순서로 첫 번째 요소가 나옵니다.
    }

    @Test
    // Queue에서 요소를 꺼내는지 확인합니다.
    fun testQueuePoll() {
        val queue: Queue<Int> = LinkedList()
        queue.add(1)
        queue.add(2)
        queue.add(3)
        val polled = queue.poll()
        assertThat(polled).isEqualTo(1) // FIFO 순서로 첫 번째 요소가 나옵니다.
        assertThat(queue).hasSize(2)
    }

    @Test
    // Queue에 요소를 추가하는지 확인합니다.
    fun testQueueAdd() {
        val queue: Queue<Int> = LinkedList()
        queue.add(1)
        assertThat(queue.peek()).isEqualTo(1)
        queue.add(2)
        assertThat(queue.peek()).isEqualTo(1) // 첫 번째 요소는 여전히 1입니다.
    }

    @Test
    // Queue가 비어 있는지 확인합니다.
    fun testQueueEmpty() {
        val queue: Queue<Int> = LinkedList()
        assertThat(queue).isEmpty()
    }

    @Test
    // Queue가 비어 있지 않은지 확인합니다.
    fun testQueueNotEmpty() {
        val queue: Queue<Int> = LinkedList()
        queue.add(1)
        assertThat(queue).isNotEmpty()
    }

    @Test
    // Queue에서 특정 요소를 제거하는지 확인합니다.
    fun testQueueRemove() {
        val queue: Queue<Int> = LinkedList()
        queue.add(1)
        queue.add(2)
        queue.add(3)
        queue.remove(2)
        assertThat(queue).doesNotContain(2)
        assertThat(queue).hasSize(2)
    }
}