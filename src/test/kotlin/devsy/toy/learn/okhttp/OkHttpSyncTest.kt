package devsy.toy.learn.okhttp

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OkHttpSyncTest {
    private val client = OkHttpClient()

    @Test
    fun testSyncGetRequest() {
        val request = Request.Builder()
            .url("https://httpbin.org/get")
            .build()

        val response = client.newCall(request).execute()
        response.use {
            assertThat(response.code).isEqualTo(200)
            assertThat(response.body?.string()).isNotNull()
        }
    }

    @Test
    fun testSyncPostRequest() {
        val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()
        val requestBody = """{"key":"value"}""".toRequestBody(JSON)

        val request = Request.Builder()
            .url("https://httpbin.org/post")
            .post(requestBody)
            .build()

        val response = client.newCall(request).execute()
        response.use {
            assertThat(response.code).isEqualTo(200)
            assertThat(response.body?.string()).isNotNull()
        }
    }

    @Test
    fun testSyncPutRequest() {
        val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()
        val requestBody = """{"key":"updatedValue"}""".toRequestBody(JSON)

        val request = Request.Builder()
            .url("https://httpbin.org/put")
            .put(requestBody)
            .build()

        val response = client.newCall(request).execute()
        response.use {
            assertThat(response.code).isEqualTo(200)
            assertThat(response.body?.string()).isNotNull()
        }
    }

    @Test
    fun testSyncDeleteRequest() {
        val request = Request.Builder()
            .url("https://httpbin.org/delete")
            .delete()
            .build()

        val response = client.newCall(request).execute()
        response.use {
            assertThat(response.code).isEqualTo(200)
            assertThat(response.body?.string()).isNotNull()
        }
    }
}