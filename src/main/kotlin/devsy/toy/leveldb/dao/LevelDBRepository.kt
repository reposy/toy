package devsy.toy.leveldb.dao

import devsy.toy.util.DataConvertUtil
import org.iq80.leveldb.DB
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository
class LevelDBRepository(
    private val db: DB,
    private val dataConvertUtil: DataConvertUtil
) {
    fun <T : Serializable> put(key: String, value: T) {
        db.put(dataConvertUtil.stringToBytes(key), dataConvertUtil.objectToBytes(value))
    }

    fun <T : Serializable> get(key: String): T? {
        val value = db.get(dataConvertUtil.stringToBytes(key)) ?: return null
        return dataConvertUtil.bytesToObject(value)
    }

    fun delete(key: String) {
        db.delete(dataConvertUtil.stringToBytes(key))
    }

    fun <T : Serializable> addToList(key: String, item: T) {
        val list = get<ArrayList<T>>(key) ?: ArrayList()
        list.add(item)
        put(key, list)
    }

    fun <K : Serializable, V : Serializable> putInMap(mapKey: String, key: K, value: V) {
        val map = get<HashMap<K, V>>(mapKey) ?: HashMap()
        map[key] = value
        put(mapKey, map)
    }
}