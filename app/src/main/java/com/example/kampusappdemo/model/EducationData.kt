package com.example.kampusappdemo.model

data class EducationData(
    val id: Int,
    val instance: String,
    val name: String,
    val rating: Double,
    val image: String,
    val emails: String,
    val teleConsultation: Double,
    val visit: Double,
    val register: Double,
    val location: Location,
    val studyProgram: String,
    val description: List<String>,
    val requirement: List<String>,
    val website: String,
    val termsCondition: List<String>,
)