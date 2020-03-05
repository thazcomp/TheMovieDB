package br.com.themoviedb.di

import br.com.themoviedb.repositories.main.MainRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepositoryImpl() }
}