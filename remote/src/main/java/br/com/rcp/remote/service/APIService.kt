package br.com.rcp.remote.service

import br.com.rcp.domain.models.CheckIn
import br.com.rcp.domain.models.Event
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {
    @GET("events")
    suspend fun getEvents(): List<Event>

    @GET("events/{id}")
    suspend fun getEventDetail(@Path("id") identifier: Long): Event

    @POST("checkin")
    suspend fun doCheckIn(@Body checkIn: CheckIn) : Response<ResponseBody>
}