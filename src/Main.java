import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Instancias
        Heap<Patient<String>> heap;
        Scanner readInput = new Scanner(System.in);

        String[] line;
        String read = "", input = "";

        // Pidiendole la implementación al usuario
        System.out.println("|\t\tSpringfield General Hospital");
        System.out.println("| Se puede utilizar una de las siguientes implementaciones: ");
        System.out.println("| 1. Implementación de JCF Queue ");
        System.out.println("| 2. Implementación de VectorHeap (default)");
        System.out.print("| Ingrese la que desea utilizar: ");
        heap = Factory.factory(readInput.nextLine()); // Consiguiendo la instancia deseada

        // Leyendo el archivo de texto y agregando los elementos al arbol
        try{
            FileReader file = new FileReader("pacientes.txt");
            BufferedReader buffer = new BufferedReader(file);
            System.out.println("|\n|\n|\t Info del documento\n| Ingresando a la base de datos: ");
            while ((read = buffer.readLine()) != null){
                line = read.split(",");

                line[1] = line[1].replace(" ", "");
                line[2] = line[2].replace(" ", "");

                line[2] = line[2].toUpperCase();

                // Mostrando los datos ingresados a la base de datos
                System.out.println("| Nombre: " + line[0]);
                System.out.println("| Sintomas: " + line[1]);
                System.out.println("| Categoría: " + line[2] + "\n|");

                heap.add(new Patient<>(line[0], line[1], line[2]));
            }

        } catch (Exception e){
            System.out.print("HOLA BB");
        }

        // Preguntandole al usuario que desea realizar
        do{
            System.out.println("|\t Lista de pacienter");
            System.out.println("| 1. Ver al proximo paciente");
            System.out.println("| 2. Salir");
            System.out.print("| Ingrese la opcion que desee: ");
            input = readInput.nextLine();

            // Realizando la opcion que desea el usuario
            switch (input){

                // Eliminar a alguien del heap
                case "1":
                    System.out.println("|\n" + heap.remove().getPatientInfo() + "\n|");
                    if(heap.isEmpty()) {
                        System.out.println("| Ya no hay mas pacientes a los cuales atender\n");
                    }
                    break;

                // Salir del programa
                case "2":
                    System.out.println("| Usted ha cerrado sesion");
                    break;

                // Si la opcion no es 1 o 2
                default:
                    System.out.println("| Opcion invalida");
                    break;
            }


        }while (!heap.isEmpty() && !input.equalsIgnoreCase("2"));

    }

}
