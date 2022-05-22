/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Equipo1
 */
public class ServiciosEscolares {
    public ArrayList<Alumno> Lista = new ArrayList<>();
    public ArrayList<Materia> ListaMaterias = new ArrayList<>();
    
    public void ModGenNumInsc(){
        ArrayList<Double> TIndicEsc = new ArrayList<>();
        
        for (int i = 0; i < Lista.size(); i++) {
            int AsigAOrdinario = Lista.get(i).materias.size();
            int AsigInsc = Lista.get(i).materias.size();
            int Escolaridad = (AsigAOrdinario / AsigInsc)*1;
            int CredAlum = Lista.get(i).numCreditos;
            int CredDIngr = Lista.get(i).numCreditos;
            int Velocidad = (CredAlum/CredDIngr)*1; 
            
            double IndicEsc = (Lista.get(i).promedio)*(Escolaridad)*(Velocidad); 
            
            TIndicEsc.add(IndicEsc);
            
        }
        
        double arr[][] = new double[TIndicEsc.size()][TIndicEsc.size()];
        for (int i = 0; i < TIndicEsc.size(); i++) {
            arr[i][0] = TIndicEsc.get(i);
            arr[i][i] = i;
        }
        
        //Selection-sort
        for (int i = 0; i < (TIndicEsc.size())-1; i++) {
            
            int min_idx = i;
            for (int j = i+1; j < TIndicEsc.size(); j++) {
                if(arr[j][0] < arr[min_idx][0])
                    min_idx = j;
                
                double temp = arr[min_idx][0];
                double temp2 = arr[min_idx][min_idx];
                arr[min_idx][0] = arr[i][0];
                arr[min_idx][min_idx] = arr[i][i];
                arr[i][0] = temp;
                arr[i][i] = temp2;
                
            }           
        }
        int lugar = arr.length-1;
        
        //Asignar el lugar segun su posicion en el arreglo de promedios ordenados
        for (int i = 0; i < arr.length; i++) {
            
            int posicion = (int)arr[lugar][lugar];  
            Lista.get(posicion).numInsc = i;           
            lugar--;
        }
        
        
    }
    //CRUD
    public void create(){
        Scanner scanS = new Scanner(System.in);
        Scanner scanI = new Scanner(System.in);
        
        try{
            Alumno alumno = new Alumno();
            System.out.println("Ingrese el primer nombre");
            String primerNombre = scanS.nextLine();
            System.out.println("Ingrese le segundo nombre o un guion en caso de no tener");
            String segundoNombre = scanS.nextLine();
            System.out.println("Ingrese el primer apellido");
            String primerApellido = scanS.nextLine();
            System.out.println("Ingrese el segundo apellido");
            String segundoApellido = scanS.nextLine();
            String nombreCompleto = primerNombre+","+segundoNombre+","+primerApellido+","+segundoApellido;
            alumno.nombre = nombreCompleto;
            System.out.println("Ingrese la edad");
            int edad = scanI.nextInt();
            alumno.edad = edad;
            System.out.println("Ingrese direccion");
            String direccion = scanS.nextLine();
            alumno.direccion = direccion;
            System.out.println("Ingrese el semestre");
            int semestre = scanI.nextInt();
            alumno.semestre = semestre;
            
            Random random = new Random();
            //Agrgar materias, creditos y calificaciones aleatorias depenediendo de sus semestre
            switch(alumno.semestre){
                case 1:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        alumno.materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        System.out.println("Materias: "+alumno.materias.get(j).materia+" Calif: "+alumno.materias.get(j).calif);
                    }
                    alumno.numCreditos = 46;
                    break;
                case 2:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        alumno.materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        System.out.println("Materias: "+alumno.materias.get(j).materia+" Calif: "+alumno.materias.get(j).calif);
                    }
                    alumno.numCreditos = 90;
                    break;
                case 3:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        alumno.materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        System.out.println("Materias: "+alumno.materias.get(j).materia+" Calif: "+alumno.materias.get(j).calif);
                    }
                    alumno.numCreditos = 126;
                    break;
                case 4:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        alumno.materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        System.out.println("Materias: "+alumno.materias.get(j).materia+" Calif: "+alumno.materias.get(j).calif);
                    }
                    alumno.numCreditos = 170;
                    break;
                case 5:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        alumno.materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        System.out.println("Materias: "+alumno.materias.get(j).materia+" Calif: "+alumno.materias.get(j).calif);
                    }
                    alumno.numCreditos = 212;
                    break;
                case 6:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        alumno.materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        System.out.println("Materias: "+alumno.materias.get(j).materia+" Calif: "+alumno.materias.get(j).calif);
                    }
                    alumno.numCreditos = 260;
                    break;
                case 7:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        alumno.materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        System.out.println("Materias: "+alumno.materias.get(j).materia+" Calif: "+alumno.materias.get(j).calif);
                    }
                    alumno.numCreditos = 298;                   
                    break;
                case 8:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        alumno.materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        System.out.println("Materias: "+alumno.materias.get(j).materia+" Calif: "+alumno.materias.get(j).calif);
                    }
                    alumno.numCreditos = 338;
                    break;    
                case 9:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        alumno.materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        System.out.println("Materias: "+alumno.materias.get(j).materia+" Calif: "+alumno.materias.get(j).calif);
                    }
                    alumno.numCreditos = 382;
                    break;
                case 10:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        alumno.materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        System.out.println("Materias: "+alumno.materias.get(j).materia+" Calif: "+alumno.materias.get(j).calif);
                    }
                    alumno.numCreditos = 422;                    
                    break;
                    
            }
            
            double sumaCalif = 0;
            //Promedio de los alumnos
            for (int i = 0; i < alumno.materias.size(); i++) { 
                sumaCalif= sumaCalif + alumno.materias.get(i).calif;
            }
            double promedio = sumaCalif/alumno.materias.size();
            alumno.promedio = promedio;
            
            System.out.println("Ingrese el numero de cuenta");
            int numCuenta = scanI.nextInt();
            alumno.numCuenta = numCuenta;
            Lista.add(alumno); 
            
            //Reasignar numeros de inscripcion
            ArrayList<Double> TIndicEsc = new ArrayList<>();
        
            for (int i = 0; i < Lista.size(); i++) {
                int AsigAOrdinario = Lista.get(i).materias.size();
                int AsigInsc = Lista.get(i).materias.size();
                int Escolaridad = (AsigAOrdinario / AsigInsc)*1;
                int CredAlum = Lista.get(i).numCreditos;
                int CredDIngr = Lista.get(i).numCreditos;
                int Velocidad = (CredAlum/CredDIngr)*1; 

                double IndicEsc = (Lista.get(i).promedio)*(Escolaridad)*(Velocidad); 

                TIndicEsc.add(IndicEsc);

            }
        
            double arr[][] = new double[TIndicEsc.size()][TIndicEsc.size()];
            for (int i = 0; i < TIndicEsc.size(); i++) {
                arr[i][0] = TIndicEsc.get(i);
                arr[i][i] = i;
            }

            //Selection-sort
            for (int i = 0; i < (TIndicEsc.size())-1; i++) {

                int min_idx = i;
                for (int j = i+1; j < TIndicEsc.size(); j++) {
                    if(arr[j][0] < arr[min_idx][0])
                        min_idx = j;

                    double temp = arr[min_idx][0];
                    double temp2 = arr[min_idx][min_idx];
                    arr[min_idx][0] = arr[i][0];
                    arr[min_idx][min_idx] = arr[i][i];
                    arr[i][0] = temp;
                    arr[i][i] = temp2;

                }           
            }
            int lugar = arr.length-1;

            //Asignar el lugar segun su posicion en el arreglo de promedios ordenados
            for (int i = 0; i < arr.length; i++) {

                int posicion = (int)arr[lugar][lugar];  
                Lista.get(posicion).numInsc = i;           
                lugar--;
            }
        }
        catch(Exception e){
            System.out.println("Ocurrio un error");
        }
        
    }
    
    public void read(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Lista de alumnos");
        for (int i = 0; i < Lista.size(); i++) {
            System.out.println("["+i+"] :"+Lista.get(i).nombre);
        }
        System.out.println("Ingrese el numero del alumno del que desea obtener su informacion");
        int tag = scan.nextInt();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("###################################################################################");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Nombre completo: "+Lista.get(tag).nombre);
        System.out.println("Edad: "+Lista.get(tag).edad);
        System.out.println("Direccion: "+Lista.get(tag).direccion);
        System.out.println("Numero de cuenta: "+Lista.get(tag).numCuenta);
        System.out.println("Semestre: "+Lista.get(tag).semestre);
        System.out.println("Promedio: "+Lista.get(tag).promedio);
        System.out.println("Numero de creditos: "+Lista.get(tag).numCreditos);
        System.out.println("Materias cursadas y su calificacion");       
        for (int i = 0; i < Lista.get(tag).materias.size(); i++) {
            System.out.println("Materia: "+Lista.get(tag).materias.get(i).materia+" Calificacion: "+Lista.get(tag).materias.get(i).calif);
        }
 
    }
    
    public void update(){
        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        System.out.println("Lista de alumnos");
        for (int i = 0; i < Lista.size(); i++) {
            System.out.println("["+i+"] :"+Lista.get(i).nombre);
        }
        System.out.println("########################################################");
        System.out.println("Ingrese el numero del alumno del que desea actualizar");
        int tag = scanI.nextInt();
        System.out.println("Que desea actualizar del alumno: "+Lista.get(tag).nombre);
        System.out.println("1) Nombre");
        System.out.println("2) Edad");
        System.out.println("3) Direccion");
        System.out.println("4) Numero de cuenta");
        System.out.println("5) Semestre");
        System.out.println("6) Numero de creditos");
        System.out.println("7) Materias cursadas");
        int opc = scanI.nextInt(); 
        scanI.nextLine();       
        switch(opc){
            case 1:
                System.out.println("Ingrese el primer nombre");
                String primerNombre = scanS.nextLine();
                System.out.println("Ingrese le segundo nombre o un guion en caso de no tener");
                String segundoNombre = scanS.nextLine();
                System.out.println("Ingrese el primer apellido");
                String primerApellido = scanS.nextLine();
                System.out.println("Ingrese el segundo apellido");
                String segundoApellido = scanS.nextLine();
                String nombreCompleto = primerNombre+","+segundoNombre+","+primerApellido+","+segundoApellido;                              
                Lista.get(tag).nombre = nombreCompleto;
                break;
            case 2:
                System.out.println("Nueva edad");
                int edad = scanI.nextInt();
                scanI.nextLine();
                Lista.get(tag).edad = edad;
                break;
            case 3:
                System.out.println("Nueva direccion");
                String direccion = scanS.nextLine();               
                Lista.get(tag).direccion = direccion;
                break;
            case 4:
                System.out.println("Nuevo numero de cuenta");
                int numCuenta = scanI.nextInt();
                scanI.nextLine();
                Lista.get(tag).numCuenta = numCuenta;
                break;
            case 5:
                System.out.println("Nuevo semestre");
                int semestre = scanI.nextInt();
                scanI.nextLine();
                Lista.get(tag).semestre = semestre;
                break;
            case 6:
                System.out.println("Nuevo numero de creditos");
                int creditos = scanI.nextInt();
                scanI.nextLine();
                Lista.get(tag).numCreditos = creditos;
                break;   
            case 7:
                System.out.println("Materias cursadas");
                System.out.println("Lista de materias");
                for (int i = 0; i < Lista.get(tag).materias.size(); i++) {
                    System.out.println("["+i+"] :"+Lista.get(tag).materias.get(i).materia);
                }
                System.out.println("Seleccionar materia a modificar");
                int update = scanI.nextInt();
                scanI.nextLine();
                System.out.println("1) Modificar nombre");
                System.out.println("2) Modificar calificacion");
                int opc2 = scanI.nextInt();
                scanI.nextLine();
                if(opc2 == 1){
                    System.out.println("Nuevo nombre");
                    String materia = scanS.nextLine(); 
                    Lista.get(tag).materias.get(update).materia = materia;
                    for (int i = 0; i < Lista.get(tag).materias.size(); i++) {
                        System.out.println("["+i+"] :"+Lista.get(tag).materias.get(i).materia);
                    }
                }
                if(opc2 == 2){                   
                    int calif = scanI.nextInt(); 
                    scanI.nextLine();
                    Lista.get(tag).materias.get(update).calif = calif;                    
                    //Promedio actualizado                 
                    double sumaCalif = 0;
                    for (int j = 0; j < Lista.get(tag).materias.size(); j++) {               
                        sumaCalif= sumaCalif + Lista.get(tag).materias.get(j).calif;
                    }
                    double promedio = sumaCalif/Lista.get(tag).materias.size();
                    Lista.get(tag).promedio = promedio;     
            
                    
                }
                
                break;
      
        }
        
    }
    
    public void delete(){
        Scanner scanI = new Scanner(System.in);
        for (int i = 0; i < Lista.size(); i++) {
                System.out.println("["+i+"] :"+Lista.get(i).nombre);
        }
        System.out.println("Seleccione el numero del alumno que desea eliminar");
        int tag = scanI.nextInt();
        Lista.remove(tag);
        System.out.println("Lista Actualizada");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("###################################################################################");
        System.out.println("-----------------------------------------------------------------------------------");
        for (int i = 0; i < Lista.size(); i++) {
                System.out.println("["+i+"] :"+Lista.get(i).nombre);
        }
    }
    
    public void exportar(){
        
        try {

            //Escribir texto en archivo
            FileWriter fw = new FileWriter("RegistrosAcademicos.csv");
            //Buffer por el que pasa la informaciòn, està conectado a fw
            BufferedWriter bw = new BufferedWriter(fw);
            //Impresora
            PrintWriter salida = new PrintWriter(bw);
            //Encabezado
            salida.println("PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,Edad,Semestre,Direccion,Promedio,NumeroCreditos,NumCuenta,NumInscripcion");

            //Escribir hacia abajo 
            for(int i = 0; i<Lista.size();i++){
                salida.println(Lista.get(i).nombre+","+String.valueOf(Lista.get(i).edad)+","+String.valueOf(Lista.get(i).semestre)+","+Lista.get(i).direccion+","+String.valueOf(Lista.get(i).promedio)+","+String.valueOf(Lista.get(i).numCreditos)+","+String.valueOf(Lista.get(i).numCuenta)+","+String.valueOf(Lista.get(i).numInsc));
            }
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void ModGenNombre(){
        //Se geenran los nombres de los alumnos de manera aleatoria
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> ListaNombres = new ArrayList<>();
        ArrayList<Integer> ListaRepetidos = new ArrayList<>();
        
        try{
            FileReader fr = new FileReader("Nombres.csv");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            
            while(linea != null){
                ListaNombres.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        int tamaño = ListaNombres.size();
        Random random = new Random();
        while (ListaRepetidos.size() < 50){
            
            int posicion = random.nextInt(tamaño);
            
            if(!ListaRepetidos.contains(posicion)){             
                Alumno alumno = new Alumno();
                alumno.nombre = ListaNombres.get(posicion);
                Lista.add(alumno);
                ListaRepetidos.add(posicion);
            }
        }      
        
    }
    public void ModGenDatosP(){
        //Aqui se generan los semestre basandonos en la edad del alumno
        for (int i = 0; i < Lista.size(); i++) {
            Random random = new Random();
            int edad = random.nextInt(9)+18;
            Lista.get(i).edad = edad;
            if(Lista.get(i).edad >= 18 && Lista.get(i).edad <= 20 ){               
                int semestre = random.nextInt(3)+1;
                Lista.get(i).semestre = semestre;
            }
            if(Lista.get(i).edad > 20 && Lista.get(i).edad <= 22 ){               
                int semestre = random.nextInt(5)+3;
                Lista.get(i).semestre = semestre;
            }
            if(Lista.get(i).edad > 22 && Lista.get(i).edad <= 24 ){               
                int semestre = random.nextInt(3)+7;
                Lista.get(i).semestre = semestre;
            }
            if(Lista.get(i).edad > 24 && Lista.get(i).edad <= 27 ){               
                int semestre = random.nextInt(1)+9;
                Lista.get(i).semestre = semestre;
            }  
        }
        
        //Se generan las direcciones aleatoriamente
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> ListaDirecciones = new ArrayList<>();
        ArrayList<Integer> ListaRepetidos = new ArrayList<>();
        
        try{
            FileReader fr = new FileReader("Direcciones.csv");
            br = new BufferedReader(fr);          
            String linea = br.readLine();
            
            while(linea != null){
                ListaDirecciones.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        int tamaño = ListaDirecciones.size();
        int lugar = 0;
        Random random = new Random();
        
        while (ListaRepetidos.size() < 50){
            
            int posicion = random.nextInt(tamaño);
            
            if(!ListaRepetidos.contains(posicion)){             
                Lista.get(lugar).direccion = ListaDirecciones.get(posicion);
                lugar ++;
                ListaRepetidos.add(posicion);
            }
        }
        //Generador de numeros de cuenta
        for (int i = 0; i < Lista.size(); i++) {
            
            switch(Lista.get(i).semestre){
                case 1: 
                        if(i>=10){
                            String numCuentaS = "3206065"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                        else{
                            String numCuentaS = "32060652"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }

                    break;
                case 2:
                    if(i>=10){
                            String numCuentaS = "3196065"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                        else{
                            String numCuentaS = "31960652"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                    break;
                case 3:
                    if(i>=10){
                            String numCuentaS = "3186065"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                        else{
                            String numCuentaS = "31860652"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                case 4:
                    if(i>=10){
                            String numCuentaS = "3176065"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                        else{
                            String numCuentaS = "31760652"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                    break;
                case 5:
                    if(i>=10){
                            String numCuentaS = "3166065"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                        else{
                            String numCuentaS = "31660652"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                case 6:
                    if(i>=10){
                            String numCuentaS = "3156065"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                        else{
                            String numCuentaS = "31560652"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                    break;
                case 7:
                    if(i>=10){
                            String numCuentaS = "3146065"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                        else{
                            String numCuentaS = "31460652"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                case 8:
                    if(i>=10){
                            String numCuentaS = "3136065"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                        else{
                            String numCuentaS = "31360652"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }    
                case 9:
                    if(i>=10){
                            String numCuentaS = "3126065"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                        else{
                            String numCuentaS = "31260652"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                case 10:
                    if(i>=10){
                            String numCuentaS = "3116065"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                        else{
                            String numCuentaS = "31160652"+i;
                            Lista.get(i).numCuenta = Integer.parseInt(numCuentaS);
                        }
                    
            } 
        }
        
    }
        
    public void ModGenRAcademico(){
        
        //Recupera los datos de las materias y los guarda en un arreglo
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Integer> ListaRepetidos = new ArrayList<>();
                
        try{
            FileReader fr = new FileReader("Materias.csv");
            br = new BufferedReader(fr);;
            String linea = br.readLine();
            int control = 0;
            int posicion=0;
            while(linea != null){               
                StringTokenizer tokenizador = new StringTokenizer(linea,",");
                while(tokenizador.hasMoreTokens()){
                    if(control == 0){
                        String token = tokenizador.nextToken();
                        ListaMaterias.add(new Materia(token));
                        ListaMaterias.get(posicion).nombre = token;
                    }
                    if(control == 1){
                        String token = tokenizador.nextToken();                       
                        ListaMaterias.get(posicion).creditos = Integer.parseInt(token);    
                    }
                    if(control == 2){
                        String token = tokenizador.nextToken();
                        ListaMaterias.get(posicion).clave = Integer.parseInt(token);
                    }
                    if(control == 3){
                        String token = tokenizador.nextToken();
                        ListaMaterias.get(posicion).semestre = Integer.parseInt(token);
                    }
                                      
                    control++;
                }
                control = 0;
                posicion++;
                linea = br.readLine();
            }
            br.close();
        } catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Asignar asignaturas, calificacion por materia y numero de creditos a los alumnos
        //Son las calificaciones del final de semestre.
        
        for (int i = 0; i < Lista.size(); i++) {
            Random random = new Random();
            switch(Lista.get(i).semestre){
                case 1:
                    for (int j = 0; j < 5; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        Lista.get(i).materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        
                    }
                    Lista.get(i).numCreditos = 46;
                    break;
                case 2:
                    for (int j = 0; j < 10; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        Lista.get(i).materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        
                    }
                    Lista.get(i).numCreditos = 90;
                    break;
                case 3:
                    for (int j = 0; j < 15; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        Lista.get(i).materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        
                    }
                    Lista.get(i).numCreditos = 126;
                    break;
                case 4:
                    for (int j = 0; j < 20; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        Lista.get(i).materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        
                    }
                    Lista.get(i).numCreditos = 170;
                    break;
                case 5:
                    for (int j = 0; j < 25; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        Lista.get(i).materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        
                    }
                    Lista.get(i).numCreditos = 212;
                    break;
                case 6:
                    for (int j = 0; j < 30; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        Lista.get(i).materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        
                    }
                    Lista.get(i).numCreditos = 260;
                    break;
                case 7:
                    for (int j = 0; j < 35; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        Lista.get(i).materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                          
                    }
                    Lista.get(i).numCreditos = 298;                   
                    break;
                case 8:
                    for (int j = 0; j < 40; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        Lista.get(i).materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        
                    }
                    Lista.get(i).numCreditos = 338;
                    break;    
                case 9:
                    for (int j = 0; j < 45; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        Lista.get(i).materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        
                    }
                    Lista.get(i).numCreditos = 382;
                    break;
                case 10:
                    for (int j = 0; j < 50; j++) {
                        int aleatorio = random.nextInt(4)+6;
                        Lista.get(i).materias.add(new Calificacion(ListaMaterias.get(j).nombre,aleatorio));
                        
                    }
                    Lista.get(i).numCreditos = 422;
                    break;
                    
            }
            
        }
        //Promedio de los alumnos
        for (int i = 0; i < Lista.size(); i++) {
            double sumaCalif = 0;
            for (int j = 0; j < Lista.get(i).materias.size(); j++) {               
                sumaCalif= sumaCalif + Lista.get(i).materias.get(j).calif;
            }
            double promedio = sumaCalif/Lista.get(i).materias.size();
            Lista.get(i).promedio = promedio;
            
        }
        
    }
    
    
}
