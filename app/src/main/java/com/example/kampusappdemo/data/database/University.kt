package com.example.kampusappdemo.data.database

import com.example.demomarketapp.R

enum class University(
    val id: Int,
    val universityName: String,
    val universityImage: Int,
    val universityLocation: String,
    val universityDescription: String,
    val universityStudyProgram: List<String>
) {
    KAMPUS_1(
        1,
        "Hijau University",
        R.drawable.kampus1,
        "Bekasi",
        loremIpsum,
        Prodi
    ),
    KAMPUS_2(
        2,
        "Kuning University",
        R.drawable.kampus2,
        "Jakarta Timur",
        loremIpsum,
        Prodi
    ),
    KAMPUS_3(
        3,
        "Merah University",
        R.drawable.kampus3,
        "Tangerang Selatan",
        loremIpsum,
        Prodi
    ),
    KAMPUS_4(
        4,
        "Biru University",
        R.drawable.kampus4,
        "Ngawi",
        loremIpsum,
        Prodi
    ),
    KAMPUS_5(
        5,
        "Cokelat University",
        R.drawable.kampus5,
        "Probolinggo",
        loremIpsum,
        Prodi
    ),
    KAMPUS_6(
        6,
        "Hitam University",
        R.drawable.kampus6,
        "Jogja",
        loremIpsum,
        Prodi
    ),
    KAMPUS_7(
        7,
        "Putih University",
        R.drawable.kampus7,
        "Solo",
        loremIpsum,
        Prodi
    ),
    KAMPUS_8(
        8,
        "Ungu University",
        R.drawable.kampus8,
        "Cirebon",
        loremIpsum,
        Prodi
    ),
    KAMPUS_9(
        9,
        "Abu University",
        R.drawable.kampus9,
        "Cilegon",
        loremIpsum,
        Prodi
    ),
    KAMPUS_10(
        10,
        "Orange University",
        R.drawable.kampus10,
        "Jakarta Barat",
        loremIpsum,
        Prodi
    ),
}

val Prodi = listOf(
    "Teknik",
    "Politeknik",
    "Terapan"
)

val loremIpsum =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Commodo ullamcorper a lacus vestibulum sed arcu. Est placerat in egestas erat. Nisl suscipit adipiscing bibendum est ultricies integer quis. Vitae sapien pellentesque habitant morbi tristique senectus et netus et. Nisi scelerisque eu ultrices vitae. Rhoncus est pellentesque elit ullamcorper dignissim. Eros in cursus turpis massa tincidunt dui. Commodo ullamcorper a lacus vestibulum. At varius vel pharetra vel. Sollicitudin aliquam ultrices sagittis orci a. Sed adipiscing diam donec adipiscing tristique risus nec feugiat in. Facilisi cras fermentum odio eu feugiat pretium nibh ipsum. Dignissim sodales ut eu sem integer vitae. A arcu cursus vitae congue mauris rhoncus aenean vel. Donec adipiscing tristique risus nec feugiat in. Ut ornare lectus sit amet est placerat in. Tortor aliquam nulla facilisi cras. Dui sapien eget mi proin sed libero. In mollis nunc sed id semper risus in hendrerit. Sit amet justo donec enim. Sit amet consectetur adipiscing elit ut aliquam. Rhoncus aenean vel elit scelerisque mauris. Est ante in nibh mauris cursus mattis molestie. Lorem ipsum dolor sit amet consectetur adipiscing. Congue nisi vitae suscipit tellus mauris a diam. Massa massa ultricies mi quis hendrerit dolor magna eget."