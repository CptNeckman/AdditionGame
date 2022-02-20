package com.example.additiongame.domain.repository

import com.example.additiongame.domain.entity.GameSettings
import com.example.additiongame.domain.entity.Level
import com.example.additiongame.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}