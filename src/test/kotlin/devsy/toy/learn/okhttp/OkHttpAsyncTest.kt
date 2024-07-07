package devsy.toy.learn.okhttp

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.IOException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

class OkHttpAsyncTest {

    private val client = OkHttpClient()

    @Test
    fun testAsyncGetRequest() {
        val future = CompletableFuture<Response>()
        val request = Request.Builder()
            .url("https://httpbin.org/get")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                future.completeExceptionally(e)
            }

            override fun onResponse(call: Call, response: Response) {
                future.complete(response)
            }
        })

        val response = future.get(10, TimeUnit.SECONDS)
        response.use {
            assertThat(response.code).isEqualTo(200)
            assertThat(response.body?.string()).isNotNull()
        }
    }

    @Test
    fun testAsyncPostRequest() {
        val future = CompletableFuture<Response>()
        val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()
        val requestBody = """{"key":"value"}""".toRequestBody(JSON)

        val request = Request.Builder()
            .url("https://httpbin.org/post")
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                future.completeExceptionally(e)
            }

            override fun onResponse(call: Call, response: Response) {
                future.complete(response)
            }
        })

        val response = future.get(10, TimeUnit.SECONDS)
        response.use {
            assertThat(response.code).isEqualTo(200)
            assertThat(response.body?.string()).isNotNull()
        }
    }

    @Test
    fun testAsyncPutRequest() {
        val future = CompletableFuture<Response>()
        val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()
        val requestBody = """{"key":"updatedValue"}""".toRequestBody(JSON)

        val request = Request.Builder()
            .url("https://httpbin.org/put")
            .put(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                future.completeExceptionally(e)
            }

            override fun onResponse(call: Call, response: Response) {
                future.complete(response)
            }
        })

        val response = future.get(10, TimeUnit.SECONDS)
        response.use {
            assertThat(response.code).isEqualTo(200)
            assertThat(response.body?.string()).isNotNull()
        }
    }

    @Test
    fun testAsyncDeleteRequest() {
        val future = CompletableFuture<Response>()
        val request = Request.Builder()
            .url("https://httpbin.org/delete")
            .delete()
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                future.completeExceptionally(e)
            }

            override fun onResponse(call: Call, response: Response) {
                future.complete(response)
            }
        })

        val response = future.get(10, TimeUnit.SECONDS)
        response.use {
            assertThat(response.code).isEqualTo(200)
            assertThat(response.body?.string()).isNotNull()
        }
    }
}
