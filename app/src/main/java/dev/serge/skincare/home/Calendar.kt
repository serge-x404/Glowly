package dev.serge.skincare.home

data class Calendar(
    val date: String,
    val day: String,
    var isSelected: Boolean = false
)
