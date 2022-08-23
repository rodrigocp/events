package br.com.rcp.domain.di

import android.content.SharedPreferences
import android.preference.PreferenceManager
import br.com.rcp.domain.repository.UserRepository
import br.com.rcp.domain.repository.UserRepositoryImpl
import org.koin.dsl.module

val domain = module {
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<SharedPreferences> { PreferenceManager.getDefaultSharedPreferences(get()) }
}