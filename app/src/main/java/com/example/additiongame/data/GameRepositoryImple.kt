package com.example.additiongame.data

import com.example.additiongame.domain.entity.GameSettings
import com.example.additiongame.domain.entity.Level
import com.example.additiongame.domain.entity.Question
import com.example.additiongame.domain.repository.GameRepository
import java.lang.Integer.max
import java.lang.Math.min
import kotlin.random.Random

object GameRepositoryImpl: GameRepository  {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while(options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when(level){
            Level.TEST -> {
                GameSettings(
                    10,
                    3,
                    50,
                    8
                )
            }Level.EASY -> {
                GameSettings(
                    15,
                    10,
                    60,
                    20
                )
            }Level.NORMAL -> {
                GameSettings(
                    20,
                    15,
                    70,
                    45
                )
            }Level.HARD -> {
                GameSettings(
                    30,
                    21,
                    85,
                    40
                )
            }
        }
    }
}