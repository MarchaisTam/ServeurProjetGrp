package com.example.serveurprojetgrp.utils

import com.example.serveurprojetgrp.beans.BikeContractBean
import com.example.serveurprojetgrp.beans.BikeStationBean
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.InputStreamReader
import javax.servlet.http.HttpServletRequest

object RequestUtils {

    private const val EXT_BIKESTATIONAPI_URL =
        "https://api.jcdecaux.com/vls/v1/stations?apiKey=2a1b07b2a523f81188fe34e348206a57ffa6f2a7&contract="
    private const val EXT_BIKECONTRACTAPI_URL =
        "https://api.jcdecaux.com/vls/v1/contracts?apiKey=2a1b07b2a523f81188fe34e348206a57ffa6f2a7&country_code="
    private val client = OkHttpClient()
    private val gson = Gson()

    private fun sendGet(url: String): Response {
        println("request url=$url")
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        if (!response.isSuccessful) {
            throw Exception("Réponse du serveur incorrecte : ${response.code} - ${response.message}")
        }
        return response
    }

    private fun <T> loadFromJson(url: String, t: Class<T>): T =
        InputStreamReader(sendGet(url).body!!.byteStream()).use {
            gson.fromJson(it, t)
        }

    fun loadBikeStations(cityName: String = "Toulouse") =
        loadFromJson("$EXT_BIKESTATIONAPI_URL$cityName", Array<BikeStationBean>::class.java).toList()

    fun loadBikeContracts(countryCode: String = "FR") =
        loadFromJson("$EXT_BIKECONTRACTAPI_URL$countryCode", Array<BikeContractBean>::class.java).toList()

    /* ------------------------------ */
    private val HEADERS_TO_TRY = arrayOf(
        "X-Forwarded-For",
        "Proxy-Client-IP",
        "WL-Proxy-Client-IP",
        "HTTP_X_FORWARDED_FOR",
        "HTTP_X_FORWARDED",
        "HTTP_X_CLUSTER_CLIENT_IP",
        "HTTP_CLIENT_IP",
        "HTTP_FORWARDED_FOR",
        "HTTP_FORWARDED",
        "HTTP_VIA",
        "REMOTE_ADDR"
    )

    fun getClientIpAddress(request: HttpServletRequest): String? {
        for (header in HEADERS_TO_TRY) {
            val ip = request.getHeader(header)
            if (ip != null && ip.isNotEmpty() && !"unknown".equals(ip, ignoreCase = true)) {
                return ip
            }
        }
        return request.remoteAddr
    }
}