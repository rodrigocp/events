package br.com.rcp.remote.repository

import br.com.rcp.domain.models.CheckIn
import br.com.rcp.domain.models.Event
import br.com.rcp.remote.service.APIService
import okhttp3.ResponseBody
import retrofit2.Response

class EventRepositoryImpl(private val service : APIService): EventRepository {
    override suspend fun getEvents(): List<Event> {
        return service.getEvents()
    }

    override suspend fun getEventDetail(identifier: Long): Event {
        return service.getEventDetail(identifier)
    }

    override suspend fun doCheckIn(checkIn: CheckIn): Response<ResponseBody> {
        return service.doCheckIn(checkIn)
    }
}