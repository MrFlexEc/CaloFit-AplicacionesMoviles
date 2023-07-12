package com.example.calofitv2.calofit.data.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calofitv2.calofit.data.DataFit.*


//@Database(entities = [PacienteEntity::class], version = 1, exportSchema = false)
@Database(entities = [PacienteEntity::class, PlatoEntity::class, RegistroEntity::class], version = 3)
abstract class AppDatabase:RoomDatabase() {
    abstract fun Pacidao():PacienteDao;
    abstract fun Pladao(): PlatoDao;

    abstract fun Regidao(): RegistroDao;

}