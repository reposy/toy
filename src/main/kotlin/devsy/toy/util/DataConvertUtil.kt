package devsy.toy.util

import org.springframework.stereotype.Component
import java.io.*
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

@Component
class DataConvertUtil {
    fun stringToBytes(value: String): ByteArray {
        return value.toByteArray(StandardCharsets.UTF_8)
    }

    fun bytesToString(value: ByteArray): String {
        return String(value, StandardCharsets.UTF_8)
    }

    fun <T : Serializable> objectToBytes(value: T): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        ObjectOutputStream(byteArrayOutputStream).use { it.writeObject(value) }
        return byteArrayOutputStream.toByteArray()
    }

    fun <T : Serializable> bytesToObject(bytes: ByteArray): T {
        val byteArrayInputStream = ByteArrayInputStream(bytes)
        return ObjectInputStream(byteArrayInputStream).use { it.readObject() as T }
    }
}