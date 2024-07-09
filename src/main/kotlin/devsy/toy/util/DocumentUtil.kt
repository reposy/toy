package devsy.toy.util

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Component

@Component
class DocumentUtil {
    // HTML 문자열을 Document 객체로 변환
    fun htmlToDocument(html: String): Document {
        return Jsoup.parse(html)
    }
}