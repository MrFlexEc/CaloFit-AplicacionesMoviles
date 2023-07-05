package com.example.calofitv2.calofit.data.PacienteFit


class PacienteRepository(
   private val pacientedao:PacienteDao
) {

    /*
    suspend fun InsertPaciente (paciente:Paciente){
        val Entity = PacienteEntity(Nombre = paciente.NombrePaciente
            , Cedula = paciente.CedulaPaciente
            , Edad = paciente.EdadPaciente.toInt()
            , Altura =  paciente.AlturaPaciente.toInt()
        )
        return pacientedao.insertPacientedb(Entity)
    }
    */





    suspend fun InsertPaciente (paciente:Paciente){
        val Entity = PacienteEntity(Nombre = paciente.NombrePaciente
            , Cedula = paciente.CedulaPaciente
            , Edad = paciente.EdadPaciente.toInt()
            , Altura =  paciente.AlturaPaciente.toInt()
        )
        return pacientedao.insertPacientedb(Entity)
    }





/*
suspend fun ObtenerPacientes():List<Paciente>{
    val entities = tvpaciente.getAllPaciente()
    return entities.map {
        Paciente(
            NombrePaciente = it.Nom,
            CedulaPaciente = it.Informacion,
            EdadPaciente = it.Precio,
            AlturaPaciente = = it.Precio
    }
}*/




//interface PacienteRepository {
  //  fun InsertPacientetoRoom (paciente:Paciente)
}