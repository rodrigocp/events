package br.com.rcp.remote.di

import br.com.rcp.remote.BASE_URL
import br.com.rcp.remote.repository.EventRepository
import br.com.rcp.remote.repository.EventRepositoryImpl
import br.com.rcp.remote.service.APIService
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val remote = module {
    val builder             = OkHttpClient.Builder()
//    val pinner              = CertificatePinner.Builder().add("api.github.com", "sha256/WoiWRyIOVNa9ihaBciRSC7XHjliYS9VwUGOIud4PB18=").build()
//    val client              = builder.certificatePinner(pinner).build()
    single<Retrofit>        { Retrofit.Builder().client(builder.build()).baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build() }
    single<EventRepository> { EventRepositoryImpl(get()) }
    single<APIService>      { get<Retrofit>().create() }
}