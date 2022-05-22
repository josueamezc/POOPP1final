/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Scanner;
import static vista.Impresiones.encabezadoMenu;

/**
 *
 * @author Piky
 */
public class MenuOPC{
    public static void MenuOpciones(){
        int selection;
        Scanner opc = new Scanner(System.in);
        selection=0;
        ServiciosEscolares generador = new ServiciosEscolares();
        generador.ModGenNombre();
        generador.ModGenDatosP();
        generador.ModGenRAcademico();
        generador.ModGenNumInsc();
        while(selection!=12){
            encabezadoMenu();
            selection=opc.nextInt();
            switch(selection){
                case 1:
                    generador.create();
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("###################################################################################");
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;
                case 2:
                    generador.read();
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("###################################################################################");
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;
                case 3:
                    generador.update();
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("###################################################################################");
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;           
                case 4:
                    generador.delete();
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("###################################################################################");
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;
                case 5:
                    System.err.println("\t\tSESION ACTUAL CERRADA EXITOSAMENTE\n");
                    selection=12;
                    generador.exportar();
                break;
                   
            }
        }
    }
}
