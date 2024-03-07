package com.example.kampusappdemo.data.local.database

import com.example.demomarketapp.R

enum class University(
    val id: Int,
    val universityName: String,
    val universityImage: Int,
    val universityLocation: String,
    val universityDescription: String,
    val universityStudyProgram: List<String>,
    val universityRating : Float,
    val universityType: String
) {
    KAMPUS_1(
        1,
        "Hijau University",
        R.drawable.kampus1,
        "Bekasi",
        loremIpsum,
        Prodi,
        2.4F,
        "private"
    ),
    KAMPUS_2(
        2,
        "Kuning University",
        R.drawable.kampus2,
        "Jakarta Timur",
        loremIpsum,
        Prodi,
        4.5F,
        "public"
    ),
    KAMPUS_3(
        3,
        "Merah University",
        R.drawable.kampus3,
        "Tangerang Selatan",
        loremIpsum,
        Prodi,
        4.8F,
        "private"
    ),
    KAMPUS_4(
        4,
        "Biru University",
        R.drawable.kampus4,
        "Ngawi",
        loremIpsum,
        Prodi,
        2.3F,
        "public"
    ),
    KAMPUS_5(
        5,
        "Cokelat University",
        R.drawable.kampus5,
        "Probolinggo",
        loremIpsum,
        Prodi,
        4.2F,
        "private"
    ),
    KAMPUS_6(
        6,
        "Hitam University",
        R.drawable.kampus6,
        "Jogja",
        loremIpsum,
        Prodi,
        3.4F,
        "private"
    ),
    KAMPUS_7(
        7,
        "Putih University",
        R.drawable.kampus7,
        "Solo",
        loremIpsum,
        Prodi,
        4.7F,
        "public"
    ),
    KAMPUS_8(
        8,
        "Ungu University",
        R.drawable.kampus8,
        "Cirebon",
        loremIpsum,
        Prodi,
        1.6F,
        "private"
    ),
    KAMPUS_9(
        9,
        "Abu University",
        R.drawable.kampus9,
        "Cilegon",
        loremIpsum,
        Prodi,
        3.3F,
        "private"
    ),
    KAMPUS_10(
        10,
        "Orange University",
        R.drawable.kampus10,
        "Jakarta Barat",
        loremIpsum,
        Prodi,
        5.0F,
        "public"
    ),
}

val Prodi = listOf(
    "Teknik",
    "Politeknik",
    "Terapan"
)

val loremIpsum =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Commodo ullamcorper a lacus vestibulum sed arcu. Est placerat in egestas erat. Nisl suscipit adipiscing bibendum est ultricies integer quis. Vitae sapien pellentesque habitant morbi tristique senectus et netus et. Nisi scelerisque eu ultrices vitae. Rhoncus est pellentesque elit ullamcorper dignissim. Eros in cursus turpis massa tincidunt dui. Commodo ullamcorper a lacus vestibulum. At varius vel pharetra vel. Sollicitudin aliquam ultrices sagittis orci a. Sed adipiscing diam donec adipiscing tristique risus nec feugiat in. Facilisi cras fermentum odio eu feugiat pretium nibh ipsum. Dignissim sodales ut eu sem integer vitae. A arcu cursus vitae congue mauris rhoncus aenean vel. Donec adipiscing tristique risus nec feugiat in. Ut ornare lectus sit amet est placerat in. Tortor aliquam nulla facilisi cras. Dui sapien eget mi proin sed libero. In mollis nunc sed id semper risus in hendrerit. Sit amet justo donec enim. Sit amet consectetur adipiscing elit ut aliquam. Rhoncus aenean vel elit scelerisque mauris. Est ante in nibh mauris cursus mattis molestie. Lorem ipsum dolor sit amet consectetur adipiscing. Congue nisi vitae suscipit tellus mauris a diam. Massa massa ultricies mi quis hendrerit dolor magna eget."
data class ImageKampus(val id : Int, val image : Int)

val ImageDummy :List<ImageKampus> = listOf(
    ImageKampus(0, R.drawable.kampus1),
    ImageKampus(1, R.drawable.kampus1),
    ImageKampus(2, R.drawable.kampus2),
    ImageKampus(3, R.drawable.kampus3),
    ImageKampus(4, R.drawable.kampus4),
    ImageKampus(5, R.drawable.kampus5),
    ImageKampus(6, R.drawable.kampus6),
    ImageKampus(7, R.drawable.kampus7),
    ImageKampus(8, R.drawable.kampus11),
    ImageKampus(9, R.drawable.kampus9),
    ImageKampus(10, R.drawable.kampus9),
    ImageKampus(11, R.drawable.kampus9),
    ImageKampus(12, R.drawable.kampus9),
    ImageKampus(13, R.drawable.kampus9),
    ImageKampus(14, R.drawable.kampus9),
    ImageKampus(15, R.drawable.kampus9),
    ImageKampus(16, R.drawable.kampus9),
    ImageKampus(17, R.drawable.kampus10),
    ImageKampus(18, R.drawable.kampus10),
    ImageKampus(19, R.drawable.kampus10),
    ImageKampus(20, R.drawable.kampus12),
    ImageKampus(21, R.drawable.kampus12),
    ImageKampus(22, R.drawable.kampus12),
    ImageKampus(23, R.drawable.kampus11),
)

