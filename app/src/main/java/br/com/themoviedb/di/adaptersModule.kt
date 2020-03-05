package br.com.themoviedb.di

import br.com.themoviedb.ui.main.adapters.MoviesAdapter
import org.koin.dsl.module

val adaptersModule = module {
    factory { MoviesAdapter(get(), get()) }
}