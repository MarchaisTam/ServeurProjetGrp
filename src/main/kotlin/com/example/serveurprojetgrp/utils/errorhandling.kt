package com.example.serveurprojetgrp.utils

import javax.servlet.http.HttpServletResponse

const val DBREQUEST_ERROR = 666

inline fun <T, R> T.tryNCatch(response: HttpServletResponse, block: T.() -> R): Any {
    return runCatching { block()!! }.getOrElse {
        it.printStackTrace()
        response.status = DBREQUEST_ERROR
        object {
            val error_code = DBREQUEST_ERROR
            val error_message = it.message ?: "Unknown Error"
        }
    }
}

inline fun <T, R> T.tryNCatch(block: T.() -> R): Any {
    return runCatching { block()!! }.getOrElse {
        it.printStackTrace()
    }
}