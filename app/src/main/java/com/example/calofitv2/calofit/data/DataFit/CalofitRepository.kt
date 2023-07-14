package com.example.calofitv2.calofit.data.DataFit

import com.example.calofitv2.calofit.ui.Pacientemenu
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class PacienteRepository @Inject constructor(
   private val pacientedao:PacienteDao
) {


    suspend fun InsertPaciente (paciente:PacienteEntity){
        val Entity = PacienteEntity(Nombre = paciente.Nombre
            , Cedula = paciente.Cedula
            , Edad = paciente.Edad.toInt()
            , Altura =  paciente.Altura.toInt()
        )
        return pacientedao.insertPacientedb(Entity)
    }

    suspend fun deletearPaciente(paciente: PacienteEntity) {
        return pacientedao.DeletePaciente(paciente)
    }

    suspend fun ModificarPaciente(paciente: PacienteEntity) {
        pacientedao.updatePacientedb(paciente)
    }

     fun getPacientes():Flow<List<PacienteEntity>>{
        return pacientedao.getAllPaciente()
    }


}

class PlatoRepository @Inject constructor (
    private val platodao: PlatoDao
) {

    suspend fun Insertplato (plato: PlatoEntity){
        val Entity = PlatoEntity(Nombre = plato.Nombre
            , Descripcion = plato.Descripcion
            , Calorias = plato.Calorias.toInt()

        )
        return platodao.insertPlatodb(Entity)
    }

    suspend fun deletearPlato(plato: PlatoEntity) {
        return platodao.DeletePlato(plato)
    }

    suspend fun ModificarPlato(plato: PlatoEntity) {
        platodao.updatePlatodb(plato)
    }

    fun getPlatos():Flow<List<PlatoEntity>>{
        return platodao.getAllPlato()
    }
}

class RegistroRepository @Inject constructor (
    private val registrodao: RegistroDao
) {

    suspend fun Insertregistro (registro: Registro){
        val Entity = RegistroEntity(PacienteId = registro.PacienteID.toLong()
            , PlatotId = registro.PlatoID.toLong()
            , Fecha = registro.Fecha
            , Porciones = registro.Porciones.toInt()

        )
        return registrodao.insertRegistrodb(Entity)
    }



}