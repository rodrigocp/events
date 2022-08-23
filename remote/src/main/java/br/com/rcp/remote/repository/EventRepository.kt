package br.com.rcp.remote.repository

import br.com.rcp.domain.models.CheckIn
import br.com.rcp.domain.models.Event
import okhttp3.ResponseBody
import retrofit2.Response

interface EventRepository {
    suspend fun getEvents() : List<Event>
    suspend fun getEventDetail(identifier: Long) : Event
    suspend fun doCheckIn(checkIn: CheckIn) : Response<ResponseBody>
}