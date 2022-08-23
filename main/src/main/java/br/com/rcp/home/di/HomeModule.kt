package br.com.rcp.home.di

import br.com.rcp.home.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val home = module {
    viewModel { HomeViewModel(get()) }
}