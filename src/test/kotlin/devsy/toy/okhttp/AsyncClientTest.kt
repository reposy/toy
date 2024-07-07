package devsy.toy.okhttp

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

class AsyncClientTest {

    private val client = AsyncClient() // AsyncClient 인스턴스 생성

    @Test
    fun `test GET request`() {
        val url = "https://jsonplaceholder.typicode.com/posts/1" // 테스트할 URL

        // CompletableFuture가 완료되었을 때 응답 본문을 처리하는 람다식
        val responseBody =
            client.get(url) // AsyncClient의 GET 메서드를 호출하여 CompletableFuture를 반환받음
            .thenApply { response ->
            /*
            println(response::class.qualifiedName) // okhttp3.Response
            println(response) // Response{protocol=h2, code=200, message=, url=https://jsonplaceholder.typicode.com/posts/1}
            println(response.body!!::class.qualifiedName) // okhttp3.internal.http.RealResponseBody
            println(response.body) // khttp3.internal.http.RealResponseBody@2f3a8ea2
            println(response.body?.string()) // body는 stream 형식이기 때문에, 한 번 읽으면 다시 읽을 수 없음
            /* 결과
                {
                  "userId": 1,
                  "id": 1,
                  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                  "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
                }
             */
=*/
            response.body?.string() // 응답 본문을 문자열로 변환
        }.orTimeout(5, TimeUnit.SECONDS).join() // 5초 안에 완료되지 않으면 Timeout 예외 발생, 결과를 기다림

        assertThat(responseBody).isNotNull() // 응답 본문이 null이 아닌지 확인
        assertThat(responseBody).contains("userId", "id", "title", "body") // 응답 본문에 특정 문자열이 포함되어 있는지 확인
    }

    @Test
    fun `test POST request`() {
        val url = "https://jsonplaceholder.typicode.com/posts" // 테스트할 URL
        val json = """
            {
                "title": "foo",
                "body": "bar",
                "userId": 1
            }
        """.trimIndent() // POST 요청에 사용할 JSON 데이터
        val future = client.post(url, json) // AsyncClient의 POST 메서드를 호출하여 CompletableFuture를 반환받음

        // CompletableFuture가 완료되었을 때 응답 본문을 처리하는 람다식
        val responseBody = future.thenApply { response ->
            response.body?.string() // 응답 본문을 문자열로 변환
        }.orTimeout(5, TimeUnit.SECONDS).join() // 5초 안에 완료되지 않으면 Timeout 예외 발생, 결과를 기다림

        assertThat(responseBody).isNotNull() // 응답 본문이 null이 아닌지 확인
        assertThat(responseBody).contains("title", "body", "userId", "id") // 응답 본문에 특정 문자열이 포함되어 있는지 확인
    }

    @Test
    fun `test PUT request`() {
        val url = "https://jsonplaceholder.typicode.com/posts/1" // 테스트할 URL
        val json = """
            {
                "id": 1,
                "title": "foo",
                "body": "bar",
                "userId": 1
            }
        """.trimIndent() // PUT 요청에 사용할 JSON 데이터
        val future = client.put(url, json) // AsyncClient의 PUT 메서드를 호출하여 CompletableFuture를 반환받음

        // CompletableFuture가 완료되었을 때 응답 본문을 처리하는 람다식
        val responseBody = future.thenApply { response ->
            response.body?.string() // 응답 본문을 문자열로 변환
        }.orTimeout(5, TimeUnit.SECONDS).join() // 5초 안에 완료되지 않으면 Timeout 예외 발생, 결과를 기다림

        assertThat(responseBody).isNotNull() // 응답 본문이 null이 아닌지 확인
        assertThat(responseBody).contains("id", "title", "body", "userId") // 응답 본문에 특정 문자열이 포함되어 있는지 확인
    }

    @Test
    fun `test PATCH request`() {
        val url = "https://jsonplaceholder.typicode.com/posts/1" // 테스트할 URL
        val json = """
            {
                "title": "foo updated"
            }
        """.trimIndent() // PATCH 요청에 사용할 JSON 데이터
        val future = client.patch(url, json) // AsyncClient의 PATCH 메서드를 호출하여 CompletableFuture를 반환받음

        // CompletableFuture가 완료되었을 때 응답 본문을 처리하는 람다식
        val responseBody = future.thenApply { response ->
            response.body?.string() // 응답 본문을 문자열로 변환
        }.orTimeout(5, TimeUnit.SECONDS).join() // 5초 안에 완료되지 않으면 Timeout 예외 발생, 결과를 기다림

        assertThat(responseBody).isNotNull() // 응답 본문이 null이 아닌지 확인
        assertThat(responseBody).contains("title") // 응답 본문에 특정 문자열이 포함되어 있는지 확인
    }
}