package lab4p1_josuerivera;

import java.util.Scanner;

public class Lab4P1_JosueRivera {
    
    public static int deCharAInt(char caracterDigito) {
        switch (caracterDigito) {
                case '1':
                    return 1;
                case '2':
                    return 2;
                case '3':
                    return 3;
                case '4':
                    return 4;
                case '5':
                    return 5;
                case '6':
                    return 6;
                case '7':
                    return 7;
                case '8':
                    return 8;
                case '9':
                    return 9;
                default:
                    return 0;
            }
    }
    
    public static void DigitoS() {
        int numAuxiliar = 0;
        int indice = 0;
        int posicionS = 0;
        String caracteresLetras = "qwertyuiopasdfghjklñzxc.vbnmQWERTYUIOPASDFGHJKLÑZXCVBNM";
        String numero;
        Scanner read2 = new Scanner(System.in);
        boolean mayor0;
        int cantidad0 = 0;
        do { //VERIFICACION DE QUE EL STRING INGRESADO EN EL USUARIO SEA VALIDO, QUE SEA MAYOR A 0 Y QUE NO TENGA CARACTERES INVÁLIDOS
            mayor0 = true;
            System.out.println("Ingrese un entero: ");
            numero = read2.next();
            for (int i = 0; i < numero.length(); i++) {
                for (int j = 0; j < caracteresLetras.length(); j++) {
                    if(caracteresLetras.charAt(j) == numero.charAt(i)) {
                        mayor0 = false;
                    }
                }
                if(numero.charAt(i) == '0') {
                    cantidad0++;
                }
            }
            if(!mayor0 || cantidad0 == numero.length()) {
                System.out.println("Ese número no es aceptable.");
            }
        } while(!mayor0 || cantidad0 == numero.length());
        int longitud = numero.length();
        for (int j = 0; j < longitud; j++) { 
            int sumaAuxiliar = 0;
            char caracterDigito = numero.charAt(j);
            int n = deCharAInt(caracterDigito);
            for (int i = 1; i <= n; i++) { //N ES LA CANTIDAD DE DIGITOS QUE TIENE QUE SUMARSE A LA sumaAuxiliar DE LOS DIGITOS DE LA IZQUIERDA Y LOS DIGITOS DE LA DERECHA, VALIDA QUE SEA UNA POSICION VÁLIDA
                if (j - i >= 0) {
                    char caracterNum = numero.charAt(j - i);
                    numAuxiliar = deCharAInt(caracterNum);
                    sumaAuxiliar += numAuxiliar;
                }
                if (j + i < longitud) {
                    char caracterNum = numero.charAt(j + i);
                    numAuxiliar = deCharAInt(caracterNum);
                    sumaAuxiliar += numAuxiliar;
                }
            }
            if(sumaAuxiliar < indice || j == 0) {
                posicionS = j;
                indice = sumaAuxiliar;
            }
        }
        int posicionFinal = posicionS+1;
        System.out.println("El digito mas solitario es "+numero.charAt(posicionS)+" en la posicion #"+posicionFinal+" en el indice de soledad de "+indice);
    }

    public static void Cubo() {
        int tamano;
        Scanner read3 = new Scanner(System.in);
        do {
            System.out.println("Ingrese tamaño n * n: ");
            tamano = read3.nextInt();
            if(tamano < 7) {
                System.out.println("El tamaño debe ser mayor a 7.");
            }
        } while(tamano < 7);
        for (int i = 0; i < tamano + (tamano/2); i++) {
            for (int j = 0; j < tamano + (tamano/2); j++) { //EL IF DE ABAJO SON TODAS LAS VALIDACIONES PARA LAS LINEAS EN LAS CUALES SE TIENEN QUE IMPRIMIR EL *
                if((i == j+tamano-1 && j < tamano/2) || (j >= tamano && j-tamano+1 == i && i != 0) || (i == 0 && j < tamano) || (j == 0 && i < tamano) || (i < tamano && j == tamano-1) || (i == tamano-1 && j < tamano) || (j >= tamano/2 && i == tamano/2) || (j >= tamano/2 && (i+1) == (tamano*3/2)) || (j == tamano/2 && i > tamano/2) || (j+1 == tamano*3/2 && i > tamano/2) || (i < tamano/2 && i == j) || (i >= tamano && i == j)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        
    }

    public static void Menu() {
        Scanner read = new Scanner(System.in);
        int opcion = 1;
        while (opcion != 0) {
            System.out.println("---Laboratorio #3 de Programacion 1---");
            System.out.println("0. Salir");
            System.out.println("1. Digito solitario");
            System.out.println("2. Cubo 3D");
            System.out.println("Ingrese una opcion: ");
            opcion = read.nextInt();
            switch (opcion) {
                case 0 -> {
                    System.out.println("Saliendo del programa");
                }
                case 1 -> {
                    DigitoS();
                }
                case 2 -> {
                    Cubo();
                }
            }
        }
    }

    public static void main(String[] args) {
        Menu();
    }

}
