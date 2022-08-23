package br.com.rcp.domain

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import br.com.rcp.domain.models.Event
import br.com.rcp.domain.repository.UserRepository
import br.com.rcp.domain.repository.UserRepositoryImpl
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
    private          val context            : Context           = mockk(relaxed = true)
    private lateinit var sharedPreferences  : SharedPreferences
    private lateinit var repository         : UserRepository

    @Before
    fun before() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        repository        = UserRepositoryImpl(sharedPreferences)
    }

    @After
    fun after() {
        unmockkAll()
    }

    @Test
    fun shouldReturnUserDetails() {
        runBlockingTest {
            val name  = "Rodrigo Pereira"
            val email = "rodrigo.pereira@hotmail.com"
            coEvery { repository.getName() } returns name
            coEvery { repository.getEmail() } returns email
            assertEquals(name, repository.getName())
            assertEquals(email, repository.getEmail())
            assertNotEquals(name, repository.getEmail())
        }
    }
}