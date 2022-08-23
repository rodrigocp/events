package br.com.rcp.details.di

import br.com.rcp.details.viewmodels.DetailViewModel
import br.com.rcp.details.viewmodels.DialogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val details = module {
    viewModel { DetailViewModel(get()) }
    viewModel { DialogViewModel(get()) }
}