package devsy.toy.learn.assertions.assert_that

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class AssertThatPriorityQueue {
    @Test
    // PriorityQueue의 크기를 확인합니다.
    fun testPriorityQueueSize() {
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(1)
        priorityQueue.add(2)
        priorityQueue.add(3)
        assertThat(priorityQueue).hasSize(3)
    }

    @Test
    // PriorityQueue의 첫 번째 요소를 확인합니다.
    fun testPriorityQueuePeek() {
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(3)
        priorityQueue.add(1)
        priorityQueue.add(2)
        assertThat(priorityQueue.peek()).isEqualTo(1) // 가장 작은 요소가 먼저 나옵니다.
    }

    @Test
    // PriorityQueue에서 요소를 꺼내는지 확인합니다.
    fun testPriorityQueuePoll() {
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(3)
        priorityQueue.add(1)
        priorityQueue.add(2)
        val polled = priorityQueue.poll()
        assertThat(polled).isEqualTo(1) // 가장 작은 요소가 먼저 나옵니다.
        assertThat(priorityQueue).hasSize(2)
    }

    @Test
    // PriorityQueue에 요소를 추가하는지 확인합니다.
    fun testPriorityQueueAdd() {
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(1)
        assertThat(priorityQueue.peek()).isEqualTo(1)
        priorityQueue.add(2)
        assertThat(priorityQueue.peek()).isEqualTo(1) // 가장 작은 요소는 1입니다.
    }

    @Test
    // PriorityQueue가 비어 있는지 확인합니다.
    fun testPriorityQueueEmpty() {
        val priorityQueue = PriorityQueue<Int>()
        assertThat(priorityQueue).isEmpty()
    }

    @Test
    // PriorityQueue가 비어 있지 않은지 확인합니다.
    fun testPriorityQueueNotEmpty() {
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(1)
        assertThat(priorityQueue).isNotEmpty()
    }

    @Test
    // PriorityQueue가 특정 요소를 포함하는지 확인합니다.
    fun testPriorityQueueContains() {
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(1)
        priorityQueue.add(2)
        priorityQueue.add(3)
        assertThat(priorityQueue).contains(2)
    }

    @Test
    // PriorityQueue가 특정 요소를 포함하지 않는지 확인합니다.
    fun testPriorityQueueDoesNotContain() {
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(1)
        priorityQueue.add(2)
        priorityQueue.add(3)
        assertThat(priorityQueue).doesNotContain(4)
    }
}