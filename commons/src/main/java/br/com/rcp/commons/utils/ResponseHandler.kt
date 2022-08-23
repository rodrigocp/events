package br.com.rcp.commons.utils

sealed class ResponseHandler<out data : Any> {
    data class Success<out T : Any>(val data: T) : ResponseHandler<T>()
    data class Failure(val exception: String)    : ResponseHandler<Nothing>()
}