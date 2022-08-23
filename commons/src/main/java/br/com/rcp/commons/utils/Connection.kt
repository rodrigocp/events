package br.com.rcp.commons.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object Connection {
    fun hasInternetConnection(context: Context?): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network     = connectivityManager?.activeNetwork
            val connection  = connectivityManager?.getNetworkCapabilities(network)
            return connection != null && (connection.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || connection.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
        } else {
            val network     = connectivityManager?.activeNetworkInfo
            return (network != null) && (network.type == ConnectivityManager.TYPE_WIFI || network.type == ConnectivityManager.TYPE_MOBILE)
        }
    }
}