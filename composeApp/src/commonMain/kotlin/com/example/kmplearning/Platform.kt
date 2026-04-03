package com.example.kmplearning

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform