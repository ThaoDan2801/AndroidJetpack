package com.glucozo.android_jetpack.model

data class Student(
    val id: Int,
    val name: String = "",
    val age: String = "",
    val avatar: String = ""
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id
    }
}
