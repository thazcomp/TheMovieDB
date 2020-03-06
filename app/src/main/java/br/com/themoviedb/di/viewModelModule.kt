package br.com.themoviedb.di

import br.com.themoviedb.ui.details.DetailViewModel
import br.com.themoviedb.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { DetailViewModel() }
}