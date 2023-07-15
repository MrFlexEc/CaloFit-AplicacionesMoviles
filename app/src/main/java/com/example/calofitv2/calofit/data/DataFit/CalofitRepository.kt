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

    suspend fun getPacienteById(pacienteId: Long): PacienteEntity? {
        return pacientedao.getPacienteById(pacienteId)
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
    suspend fun getPlatoById(platoId: Long): PlatoEntity? {
        return platodao.getPlatoById(platoId)
    }
}

class RegistroRepository @Inject constructor (
    private val registrodao: RegistroDao
) {

    suspend fun Insertregistro (registro: RegistroEntity){
        val Entity = RegistroEntity(PacienteId = registro.PacienteId.toLong()
            , PlatotId = registro.PlatotId.toLong()
            , Fecha = registro.Fecha
            , Porciones = registro.Porciones.toInt()

        )
        return registrodao.insertRegistrodb(Entity)
    }

    suspend fun deletearRegistro(registro: RegistroEntity) {
        return registrodao.DeleteRegistro(registro)
    }

    suspend fun ModificarRegistro(registro: RegistroEntity) {
        registrodao.updateRegistrodb(registro)
    }

    fun getRegistros():Flow<List<RegistroEntity>>{
        return registrodao.getAllRegistro()
    }





}