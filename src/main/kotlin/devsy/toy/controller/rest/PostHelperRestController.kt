package devsy.toy.controller.rest

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post")
class PostHelperRestController {
    @GetMapping("")
    fun PostHelper(): String {
        return "aaa"
    }
}