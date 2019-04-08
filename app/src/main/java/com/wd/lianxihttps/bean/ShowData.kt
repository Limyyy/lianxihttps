package com.wd.lianxihttps.bean

data class ShowData(
    val message: String,
    val result: List<ResultData>,
    val status: String
)

data class ResultData(
    val address: String,
    val commentTotal: Int,
    val distance: Int,
    val followCinema: Int,
    val id: Int,
    val logo: String,
    val name: String
)