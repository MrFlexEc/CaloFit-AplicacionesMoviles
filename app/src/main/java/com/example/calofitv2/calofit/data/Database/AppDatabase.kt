package com.example.calofitv2.calofit.data.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calofitv2.calofit.data.DataFit.PacienteDao
import com.example.calofitv2.calofit.data.DataFit.PacienteEntity
import com.example.calofitv2.calofit.data.DataFit.PlatoDao
import com.example.calofitv2.calofit.data.DataFit.PlatoEntity


//@Database(entities = [PacienteEntity::class], version = 1, exportSchema = false)
@Database(entities = [PacienteEntity::class, PlatoEntity::class], version = 2)
abstract class AppDatabase:RoomDatabase() {
    abstract fun Pacidao():PacienteDao;
    abstract fun Pladao(): PlatoDao;

}