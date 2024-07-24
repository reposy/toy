package devsy.toy.sqlite.repository

import devsy.toy.sqlite.entity.Vote
import org.springframework.data.jpa.repository.JpaRepository

interface VoteRepository: JpaRepository<Vote, Long>