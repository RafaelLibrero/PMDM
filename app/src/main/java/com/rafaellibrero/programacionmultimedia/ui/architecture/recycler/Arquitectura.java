package com.rafaellibrero.programacionmultimedia.ui.architecture.recycler;

public class Arquitectura {

    private final int NumColegiado;
    private final String Nombre;
    private final String Especialidad;
    private final boolean EstaActivo;
    private final int FechaNacimiento;

    public Arquitectura
            (int NumColegiado, String Nombre, String Especialidad,
             boolean EstaActivo, int FechaNacimiento) {
        this.NumColegiado = NumColegiado;
        this.Nombre = Nombre;
        this.Especialidad = Especialidad;
        this.EstaActivo = EstaActivo;
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getNumColegiado(){
        return String.valueOf(NumColegiado);
    }

    public String getNombre(){
        return Nombre;
    }

    public String getEspecialidad(){
        return Especialidad;
    }

    public String getEstaActivo(){
        return String.valueOf(EstaActivo);
    }

    public String getFechaNacimiento(){
        return String.valueOf(FechaNacimiento);
    }
}

