package devsy.toy.learn.document

import org.assertj.core.api.Assertions.assertThat
import org.jsoup.Jsoup
import org.junit.jupiter.api.Test

class DocumentTest {
    private val sampleHtml = """
        <html>
            <head>
                <title>Test Page</title>
            </head>
            <body>
                <div class="content">
                    <p id="first">First paragraph</p>
                    <p id="second">Second paragraph</p>
                    <a href="http://example.com">Example Link</a>
                    <a href="http://example.com/second">Second Link</a>
                </div>
                <div class="footer">
                    Footer content
                </div>
            </body>
        </html>
    """.trimIndent()

    @Test
    fun `test parseHtml`() {
        val document = Jsoup.parse(sampleHtml)
        assertThat(document).isNotNull
    }

    @Test
    fun `test getTextBySelector`() {
        val document = Jsoup.parse(sampleHtml)
        val text = document.selectFirst("p#first")?.text()
        assertThat(text).isEqualTo("First paragraph")
    }

    @Test
    fun `test getTextsBySelector`() {
        val document = Jsoup.parse(sampleHtml)
        val texts = document.select("p").map { it.text() }
        assertThat(texts).containsExactly("First paragraph", "Second paragraph")
    }

    @Test
    fun `test getAttributeBySelector`() {
        val document = Jsoup.parse(sampleHtml)
        val href = document.selectFirst("a")?.attr("href")
        assertThat(href).isEqualTo("http://example.com")
    }

    @Test
    fun `test getAttributesBySelector`() {
        val document = Jsoup.parse(sampleHtml)
        val hrefs = document.select("a").map { it.attr("href") }
        assertThat(hrefs).containsExactly("http://example.com", "http://example.com/second")
    }

    @Test
    fun `test getElementsContainingText`() {
        val document = Jsoup.parse(sampleHtml)
        val elements = document.getElementsContainingOwnText("paragraph")
        val texts = elements.map { it.text() }
        assertThat(texts).containsExactly("First paragraph", "Second paragraph")
    }

    @Test
    fun `test getElementsByClass`() {
        val document = Jsoup.parse(sampleHtml)
        val elements = document.getElementsByClass("content")
        assertThat(elements).hasSize(1)
        assertThat(elements.first().tagName()).isEqualTo("div")
    }

    @Test
    fun `test getElementsByTag`() {
        val document = Jsoup.parse(sampleHtml)
        val elements = document.getElementsByTag("a")
        assertThat(elements).hasSize(2)
    }

    @Test
    fun `test getElementById`() {
        val document = Jsoup.parse(sampleHtml)
        val element = document.getElementById("second")
        assertThat(element).isNotNull
        assertThat(element?.text()).isEqualTo("Second paragraph")
    }

    @Test
    fun `test getElementsByAttribute`() {
        val document = Jsoup.parse(sampleHtml)
        val elements = document.getElementsByAttribute("href")
        assertThat(elements).hasSize(2)
    }

    @Test
    fun `test selectElements`() {
        val document = Jsoup.parse(sampleHtml)
        val elements = document.select("div.footer")
        assertThat(elements).hasSize(1)
        assertThat(elements.first().text()).isEqualTo("Footer content")
    }
}