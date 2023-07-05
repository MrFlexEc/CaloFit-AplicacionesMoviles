package com.example.calofitv2

import android.app.Application
import androidx.room.Room
import com.example.calofitv2.calofit.data.Database.PacienteDatabase
import com.example.calofitv2.calofit.data.PacienteFit.PacienteDao
import com.example.calofitv2.calofit.data.PacienteFit.PacienteRepository
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
    fun providePacienteDao(application: Application): PacienteDao{
        val db = Room.databaseBuilder(
            application,
            PacienteDatabase::class.java,
            "Calofitv2")
            .allowMainThreadQueries().build()
        return db.dao
    }

    @Provides
    @Singleton
    fun providePacienteRepository(dao:PacienteDao): PacienteRepository{
        return PacienteRepository(dao)
    }

}