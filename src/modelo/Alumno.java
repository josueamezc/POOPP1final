/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Equipo1
 */
public class Alumno {
    public String nombre;
    public int edad;
    public int semestre;
    public String direccion;
    public ArrayList<Calificacion> materias = new ArrayList<>(); 
    public double promedio;
    public int numCreditos;
    public int numCuenta;
    public double numInsc;
    // lista ligada asignaturas //

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public Alumno() {
    }

    public Alumno(String nombre, int edad, int semestre, String direccion, double promedio, int numCreditos, int NumCuenta) {
        this.nombre = nombre;
        this.edad = edad;
        this.semestre = semestre;
        this.direccion = direccion;
        this.promedio = promedio;
        this.numCreditos = numCreditos;
        this.numCuenta = NumCuenta;
    }
       
    
    
}
