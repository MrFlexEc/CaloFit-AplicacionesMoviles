package com.example.calofitv2.calofit.data.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calofitv2.calofit.data.PacienteFit.PacienteDao
import com.example.calofitv2.calofit.data.PacienteFit.PacienteEntity

//@Database(entities = [PacienteEntity::class], version = 1, exportSchema = false)
@Database(entities = [PacienteEntity::class], version = 1)
abstract class PacienteDatabase:RoomDatabase() {
    abstract val dao:PacienteDao
}