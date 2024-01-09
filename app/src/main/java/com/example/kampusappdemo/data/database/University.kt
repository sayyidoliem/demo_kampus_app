package com.example.kampusappdemo.data.database

import com.example.demomarketapp.R

enum class University(
    val id: Int,
    val universityName: String,
    val universityImage : Int,
    val universityDescription: String,
    val universityStudyProgram: List<String>
) {
    SUARA_DUNIA(
        1,
        "Suara Dunia University",
        R.drawable.ui,
        "Lorem ipsum dolor sit amet",
        Prodi
    )
}

val Prodi = listOf(
    "Teknik",
    "Politeknik",
    "Terapan"
)