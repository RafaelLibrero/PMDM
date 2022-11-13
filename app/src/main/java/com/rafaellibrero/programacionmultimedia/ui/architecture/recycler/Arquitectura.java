package com.rafaellibrero.programacionmultimedia.ui.architecture.recycler;

public class Arquitectura {

    private final int numColegiado;
    private final String nombre;
    private final String especialidad;
    private final boolean estaActivo;
    private final int fechaNacimiento;

    public Arquitectura
            (int NumColegiado, String Nombre, String Especialidad,
             boolean EstaActivo, int FechaNacimiento) {
        this.numColegiado = NumColegiado;
        this.nombre = Nombre;
        this.especialidad = Especialidad;
        this.estaActivo = EstaActivo;
        this.fechaNacimiento = FechaNacimiento;
    }

    public String getNumColegiado(){
        return String.valueOf(numColegiado);
    }

    public String getNombre(){
        return nombre;
    }

    public String getEspecialidad(){
        return especialidad;
    }

    public String getEstaActivo(){
        return String.valueOf(estaActivo);
    }

    public String getFechaNacimiento(){
        return String.valueOf(fechaNacimiento);
    }
}

