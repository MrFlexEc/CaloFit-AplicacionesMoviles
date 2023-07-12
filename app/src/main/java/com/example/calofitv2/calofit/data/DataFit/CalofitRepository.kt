package com.example.calofitv2.calofit.data.DataFit

import com.example.calofitv2.calofit.ui.Pacientemenu
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class PacienteRepository @Inject constructor(
   private val pacientedao:PacienteDao
) {

    suspend fun InsertPaciente (paciente:Paciente){
        val Entity = PacienteEntity(Nombre = paciente.NombrePaciente
            , Cedula = paciente.CedulaPaciente
            , Edad = paciente.EdadPaciente.toInt()
            , Altura =  paciente.AlturaPaciente.toInt()
        )
        return pacientedao.insertPacientedb(Entity)
    }

    /*
    suspend fun getPacientes():List<Paciente>{
        val entities=userDao.getallUsers()
        return entities.map {
            User(
                name=it.name
            )
        }
    }*/

    /*

  suspend fun ObtenerPacientes(): Flow<List<Paciente>> {
    val entities = pacientedao.getAllPaciente()
    return entities.map {
        PacienteEntity(
            Nombre = it.Nombre,


        )

}*/




//interface PacienteRepository {
  //  fun InsertPacientetoRoom (paciente:Paciente)
}

class PlatoRepository @Inject constructor (
    private val platodao: PlatoDao
) {

    suspend fun Insertplato (plato: Plato){
        val Entity = PlatoEntity(Nombre = plato.NombrePlato
            , Descripcion = plato.DescripcionPlato
            , Calorias = plato.CaloriasPlato.toInt()

        )
        return platodao.insertPlatodb(Entity)
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