package devsy.toy.controller

import devsy.toy.service.VoteService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class VoteController(
    private val voteService: VoteService
) {

    @GetMapping("/")
    fun index(model: Model): String {
        val votes = voteService.getAllVotes()
        val voteCounts = votes.groupBy { it.option }
            .mapValues { it.value.size }
        model.addAttribute("votes", voteCounts)
        return "/vote"
    }

}