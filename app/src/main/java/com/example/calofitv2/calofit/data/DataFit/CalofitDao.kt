package com.example.calofitv2.calofit.data.DataFit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query

@Dao
interface PacienteDao {

    @Insert(onConflict = IGNORE)
     fun insertPacientedb(paciente: PacienteEntity)

    @Query("SELECT * FROM PacienteEntity")
    suspend fun getAllPaciente():List<PacienteEntity>


   // @Query("SELECT * FROM TvEntity Where Nombre = :idnombre")
    //suspend fun getOneTv(idnombre:String): PacienteEntity
}

@Dao
interface PlatoDao {

    @Insert(onConflict = IGNORE)
    fun insertPlatodb(plato: PlatoEntity)

     @Query("SELECT * FROM PlatoEntity")
    suspend fun getAllPlato():List<PlatoEntity>


    // @Query("SELECT * FROM TvEntity Where Nombre = :idnombre")
    //suspend fun getOneTv(idnombre:String): PacienteEntity



}

@Dao
interface RegistroDao {

    @Insert(onConflict = IGNORE)
    fun insertRegistrodb(registro: RegistroEntity)

    // @Query("SELECT * FROM PacienteEntity")
    //suspend fun getAllPaciente():List<PacienteEntity>


    // @Query("SELECT * FROM TvEntity Where Nombre = :idnombre")
    //suspend fun getOneTv(idnombre:String): PacienteEntity



}