package devsy.toy.okhttp

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.stereotype.Component
import java.io.IOException
import java.util.concurrent.CompletableFuture


@Component
class AsyncClient {
    private val client = OkHttpClient()

    private fun executeRequest(request: Request): CompletableFuture<Response> {
        val future = CompletableFuture<Response>()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                future.completeExceptionally(e)
            }

            override fun onResponse(call: Call, response: Response) {
                future.complete(response)
            }
        })
        return future
    }

    fun get(url: String): CompletableFuture<Response> {
        val request = Request.Builder()
            .url(url)
            .build()

        return executeRequest(request)
    }

    fun post(url: String, json: String): CompletableFuture<Response> {
        val body = json.toRequestBody("application/json; charset=utf-8".toMediaType())
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        return executeRequest(request)
    }

    fun put(url: String, json: String): CompletableFuture<Response> {
        val body = json.toRequestBody("application/json; charset=utf-8".toMediaType())
        val request = Request.Builder()
            .url(url)
            .put(body)
            .build()
        return executeRequest(request)
    }

    fun patch(url: String, json: String): CompletableFuture<Response> {
        val body = json.toRequestBody("application/json; charset=utf-8".toMediaType())
        val request = Request.Builder()
            .url(url)
            .patch(body)
            .build()
        return executeRequest(request)
    }
}