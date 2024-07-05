package devsy.toy.learn.assertions.assert_that

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssertThatMap {
    @Test
    // Map의 크기를 확인합니다.
    fun testMapSize() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map).hasSize(3)
    }

    @Test
    // Map이 특정 키를 포함하는지 확인합니다.
    fun testMapContainsKey() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map).containsKey("key2")
    }

    @Test
    // Map이 특정 값을 포함하는지 확인합니다.
    fun testMapContainsValue() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map).containsValue(2)
    }

    @Test
    // Map이 특정 키-값 쌍을 포함하는지 확인합니다.
    fun testMapContainsEntry() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map).containsEntry("key2", 2)
    }

    @Test
    // Map이 특정 키를 포함하지 않는지 확인합니다.
    fun testMapDoesNotContainKey() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map).doesNotContainKey("key4")
    }

    @Test
    // Map이 특정 값을 포함하지 않는지 확인합니다.
    fun testMapDoesNotContainValue() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map).doesNotContainValue(4)
    }

    @Test
    // Map이 특정 키-값 쌍을 포함하지 않는지 확인합니다.
    fun testMapDoesNotContainEntry() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map).doesNotContainEntry("key4", 4)
    }

    @Test
    // Map이 비어 있는지 확인합니다.
    fun testEmptyMap() {
        val map = emptyMap<String, Int>()
        assertThat(map).isEmpty()
    }

    @Test
    // Map이 비어 있지 않은지 확인합니다.
    fun testNotEmptyMap() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map).isNotEmpty()
    }

    @Test
    // Map이 특정 키-값 쌍을 모두 포함하는지 확인합니다.
    fun testMapContainsAllEntries() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map).containsAllEntriesOf(mapOf("key1" to 1, "key3" to 3))
    }

    @Test
    // Map의 특정 키가 주어진 조건을 만족하는지 확인합니다.
    fun testMapKeyMatches() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map.keys).allMatch { it.startsWith("key") }
    }
    @Test
    // Map의 특정 값이 주어진 조건을 만족하는지 확인합니다.
    fun testMapValueMatches() {
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map.values).allMatch { it > 0 }
    }

    @Test
    // 두 Map이 동일한지 확인합니다.
    fun testMapEquality() {
        val map1 = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        val map2 = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        assertThat(map1).isEqualTo(map2)
    }

    @Test
    // 두 Map이 동일하지 않은지 확인합니다.
    fun testMapInequality() {
        val map1 = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        val map2 = mapOf("key4" to 4, "key5" to 5, "key6" to 6)
        assertThat(map1).isNotEqualTo(map2)
    }
}