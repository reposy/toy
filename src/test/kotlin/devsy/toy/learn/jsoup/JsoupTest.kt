package devsy.toy.learn.jsoup

import org.assertj.core.api.Assertions.assertThat
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.jupiter.api.Test

class JsoupTest {
    val sampleHtml = """
        <html>
            <head>
                <title>Test Page</title>
            </head>
            <body>
                <div class="content">
                    <h1>Header</h1>
                    <p class="description">This is a sample description.</p>
                    <a href="http://example.com">Example Link</a>
                    <ul>
                        <li>Item 1</li>
                        <li>Item 2</li>
                        <li>Item 3</li>
                    </ul>
                </div>
            </body>
        </html>
    """.trimIndent()

    @Test
    fun `test parsing HTML`() {
        val document: Document = Jsoup.parse(sampleHtml)
        val title = document.title()

        assertThat(title).isEqualTo("Test Page")
    }

    @Test
    fun `test selecting elements`() {
        val document: Document = Jsoup.parse(sampleHtml)
        val header = document.select("h1").text()
        val description = document.select(".description").text()

        assertThat(header).isEqualTo("Header")
        assertThat(description).isEqualTo("This is a sample description.")
    }

    @Test
    fun `test extracting attributes`() {
        val document: Document = Jsoup.parse(sampleHtml)
        val link = document.select("a").attr("href")

        assertThat(link).isEqualTo("http://example.com")
    }

    @Test
    fun `test iterating over elements`() {
        val document: Document = Jsoup.parse(sampleHtml)
        val items = document.select("ul li")
        val itemTexts = items.map { it.text() }

        assertThat(itemTexts).containsExactly("Item 1", "Item 2", "Item 3")
    }

    @Test
    fun `test modifying elements`() {
        val document: Document = Jsoup.parse(sampleHtml)
        val header = document.select("h1").first()
        header?.text("Updated Header")

        val updatedHeader = document.select("h1").text()
        assertThat(updatedHeader).isEqualTo("Updated Header")
    }
}