package com.example.additiongame.domain.entity

data class GameSettings (

    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeInSecond: Int
        )