package devsy.toy.leveldb.dao

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.Serializable

@SpringBootTest
class LevelDBRepositoryTest(
    @Autowired private val repo: LevelDBRepository
) {

    @BeforeEach
    fun setUp() {
        repo.delete("testKey")
        repo.delete("testList")
        repo.delete("testMap")
    }

    @Test
    fun `test put and get`() {
        val key = "testKey"
        val value = "testValue" as Serializable

        repo.put(key, value)
        val result = repo.get<Serializable>(key)

        assertThat(result).isEqualTo(value)
    }

    @Test
    fun `test add to list`() {
        val key = "testList"
        val item = "newItem" as Serializable

        repo.addToList(key, item)
        repo.addToList(key, "anotherItem" as Serializable)
        val result = repo.get<Serializable>(key) as? ArrayList<Serializable>

        assertThat(result).isNotNull
        assertThat(result).containsExactly(item, "anotherItem" as Serializable)
    }

    @Test
    fun `hi`() {
        repo.put("test-value", "123")
        assertThat(repo.get<String>("test-value")).isEqualTo("123")

        repo.delete("test-value")
        assertThat(repo.get<String>("test-value")).isNull()
    }

    @Test
    fun `test put in map`() {
        val mapKey = "testMap"
        val key = "subKey" as Serializable
        val value = "subValue" as Serializable

        repo.putInMap(mapKey, key, value)
        val result = repo.get<HashMap<Serializable, Serializable>>(mapKey)

        assertThat(result).isNotNull
        assertThat(result).containsEntry(key, value)
    }

    @Test
    fun `test delete`() {
        val key = "testKey"
        val value = "testValue" as Serializable

        repo.put(key, value)
        repo.delete(key)
        val result = repo.get<Serializable>(key)

        assertThat(result).isNull()
    }
}