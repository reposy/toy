package devsy.toy.learn.assertions.assert_that
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import java.util.Stack
class AssertThatStack {
    @Test
    // Stack의 크기를 확인합니다.
    fun testStackSize() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertThat(stack).hasSize(3)
    }

    @Test
    // Stack의 맨 위 요소를 확인합니다.
    fun testStackPeek() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertThat(stack.peek()).isEqualTo(3)
    }

    @Test
    // Stack에서 요소를 꺼내는지 확인합니다.
    fun testStackPop() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        val popped = stack.pop()
        assertThat(popped).isEqualTo(3)
        assertThat(stack).hasSize(2)
    }

    @Test
    // Stack에 요소를 추가하는지 확인합니다.
    fun testStackPush() {
        val stack = Stack<Int>()
        stack.push(1)
        assertThat(stack.peek()).isEqualTo(1)
        stack.push(2)
        assertThat(stack.peek()).isEqualTo(2)
    }

    @Test
    // Stack이 비어 있는지 확인합니다.
    fun testStackEmpty() {
        val stack = Stack<Int>()
        assertThat(stack).isEmpty()
    }

    @Test
    // Stack이 비어 있지 않은지 확인합니다.
    fun testStackNotEmpty() {
        val stack = Stack<Int>()
        stack.push(1)
        assertThat(stack).isNotEmpty()
    }

    @Test
    // Stack에서 특정 요소를 검색하는지 확인합니다.
    fun testStackSearch() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertThat(stack.search(2)).isEqualTo(2) // Stack의 search는 1-based index를 반환합니다.
    }

    @Test
    // Stack에서 존재하지 않는 요소를 검색하는지 확인합니다.
    fun testStackSearchNonExistingElement() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertThat(stack.search(4)).isEqualTo(-1) // 요소가 존재하지 않으면 -1을 반환합니다.
    }
}