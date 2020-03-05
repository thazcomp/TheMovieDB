package br.com.themoviedb

import androidx.multidex.MultiDexApplication
import br.com.themoviedb.di.adaptersModule
import br.com.themoviedb.di.repositoryModule
import br.com.themoviedb.di.viewModelModule
import io.reactivex.internal.functions.Functions
import io.reactivex.plugins.RxJavaPlugins
import org.koin.core.context.startKoin

class App: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        RxJavaPlugins.setErrorHandler(Functions.emptyConsumer())
        startKoin {
            modules(listOf(viewModelModule, repositoryModule, adaptersModule))
        }

    }
}