package com.example.calofitv2.calofit.data.DataFit

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import kotlinx.coroutines.flow.Flow

@Dao
interface PacienteDao {

   @Insert(onConflict = IGNORE)
    suspend fun insertPacientedb(paciente: PacienteEntity)

    @Query("SELECT * FROM PacienteEntity")
     fun getAllPaciente(): Flow<List<PacienteEntity>>

     @Delete
     suspend fun DeletePaciente(paciente: PacienteEntity)
    @Update
    suspend fun updatePacientedb(paciente: PacienteEntity)
    @Query("SELECT * FROM PacienteEntity WHERE Id = :pacienteId")
    suspend fun getPacienteById(pacienteId: Long): PacienteEntity?

   // @Query("SELECT * FROM TvEntity Where Nombre = :idnombre")
    //suspend fun getOneTv(idnombre:String): PacienteEntity
}

@Dao
interface PlatoDao {

    @Insert(onConflict = IGNORE)
   suspend fun insertPlatodb(plato: PlatoEntity)

     @Query("SELECT * FROM PlatoEntity")
     fun getAllPlato():Flow<List<PlatoEntity>>

    @Delete
    suspend fun DeletePlato(plato: PlatoEntity)
    @Update
    suspend fun updatePlatodb(plato: PlatoEntity)
    @Query("SELECT * FROM PlatoEntity WHERE Id = :platoId")
    suspend fun getPlatoById(platoId: Long): PlatoEntity?

}

@Dao
interface RegistroDao {

    @Insert(onConflict = IGNORE)
   suspend fun insertRegistrodb(registro: RegistroEntity)

    @Query("SELECT * FROM RegistroEntity")
    fun getAllRegistro():Flow<List<RegistroEntity>>

    @Delete
    suspend fun DeleteRegistro(registro: RegistroEntity)
    @Update
    suspend fun updateRegistrodb(registro: RegistroEntity)



}