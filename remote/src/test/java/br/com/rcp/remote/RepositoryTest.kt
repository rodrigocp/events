package br.com.rcp.remote

import br.com.rcp.domain.models.Event
import br.com.rcp.remote.repository.EventRepository
import br.com.rcp.remote.repository.EventRepositoryImpl
import br.com.rcp.remote.service.APIService
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.math.BigDecimal

@ExperimentalCoroutinesApi
class RepositoryTest {
    private          val service    : APIService        = mockk(relaxed = true)
    private lateinit var repository : EventRepository

    @Before
    fun before() {
        repository = EventRepositoryImpl(service)
    }

    @After
    fun after() {
        unmockkAll()
    }

    @Test
    fun shouldReturnEventList() {
        runBlockingTest {
            val mocked = createEventList()
            coEvery { service.getEvents() } returns createEventList()
            assertEquals(mocked, repository.getEvents())
        }
    }

    @Test
    fun shouldReturnEventDetail() {
        runBlockingTest {
            val mocked = createEvent()
            coEvery { service.getEventDetail(1) } returns mocked
            assertEquals(mocked, repository.getEventDetail(1))
            assertEquals(mocked.id, repository.getEventDetail(1).id)
            assertNotEquals(mocked.title, "Another Test LOL")
        }
    }

    private fun createEventList() : List<Event> {
        return listOf(createEvent(), createEvent())
    }


    private fun createEvent() : Event {
        return Event(1, "https://www.recompra.com.br", "Teste", "Teste Loko", 27344610, BigDecimal(89.99), BigDecimal(60), BigDecimal(90))
    }
}