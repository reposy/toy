package devsy.toy.controller.rest

import devsy.toy.service.VoteService
import devsy.toy.sqlite.entity.Vote
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class VoteRestController(
    private val voteService: VoteService
) {

    @PostMapping("/vote")
    fun insertVote(@RequestParam option: String): Vote {
        return voteService.addVote(option)
    }
}