package devsy.toy.service

import devsy.toy.sqlite.entity.Vote
import devsy.toy.sqlite.repository.VoteRepository
import org.springframework.stereotype.Service

@Service
class VoteService(private val voteRepository: VoteRepository) {
    fun getAllVotes(): List<Vote> = voteRepository.findAll()

    fun addVote(option: String): Vote {
        val vote = Vote(option = option)
        return voteRepository.save(vote)
    }
}