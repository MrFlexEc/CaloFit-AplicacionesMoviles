package com.example.calofitv2

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.calofitv2.calofit.ViewModels.PacienteViewModel
import com.example.calofitv2.calofit.ViewModels.PlatoViewModel
import com.example.calofitv2.calofit.ViewModels.RegistroViewModel
import com.example.calofitv2.calofit.data.DataFit.*
import com.example.calofitv2.calofit.data.Database.AppDatabase


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase{
        val db = Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "Calofitv2").fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()
        return db
    }

    @Provides
    fun providePacienteDao(database: AppDatabase): PacienteDao {
        return database.Pacidao()
    }

    @Provides
    fun providePlatoDao(database: AppDatabase): PlatoDao {
        return database.Pladao()
    }
    @Provides
    fun provideRegistroDao(database: AppDatabase): RegistroDao {
        return database.Regidao()
    }



    @Provides
    @Singleton
    fun providePacienteRepository(pacientedao:PacienteDao): PacienteRepository{
        return PacienteRepository(pacientedao)
    }

    @Provides
    @Singleton
    fun providePlatoRepository(platodao:PlatoDao): PlatoRepository{
        return PlatoRepository(platodao)
    }

    @Provides
    @Singleton
    fun provideRegistroRepository(registrodao:RegistroDao): RegistroRepository{
        return RegistroRepository(registrodao)
    }




    @Provides
    @Singleton
    fun providePacienteViewModel(repository: PacienteRepository): PacienteViewModel {
        return PacienteViewModel(repository)
    }

    @Provides
    @Singleton
    fun providePlatoViewModel(repository: PlatoRepository): PlatoViewModel {
        return PlatoViewModel(repository)
    }
    @Provides
    @Singleton
    fun provideRegistroViewModel(repository: RegistroRepository): RegistroViewModel {
        return RegistroViewModel(repository)
    }



}