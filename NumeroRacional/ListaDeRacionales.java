import java.util.*;                                                                         //Añade API en general

// ================================================================
// ================== ARRAY LIST DE FRACCIONES ====================
// ================================================================
public class ListaDeRacionales {                                                            // ========== CLASE DE LISTA  ===============
    private ArrayList<Racional> listaNumeros = new ArrayList<Racional>();                   //Crea una lista de Numeros Racionales
    Scanner escanerDelTeclado = new Scanner(System.in);                                     //Aqui esta el scanner para la entrada

    public void inserta(Racional nuevoRacional){listaNumeros.add(nuevoRacional);}           // ========== INSERTAR EN ARRAY =============

    public void muestraElementos(){                                                         // ========== MUESTRA LOS ELEMENTOS  ========
        System.out.println("\n=========================");                                  //Muestro el menu
        for (int i = 0; i < listaNumeros.size(); i++)                                       //Recorre nuestro list
            System.out.println(listaNumeros.get(i));                                        //Muestra cada elemento
        System.out.println("=========================");                                    //Salida de todo
    }
    
    public void generaOperacion(){                                                          // ========== GENERA UNA OPERACION C=A*B ====
        System.out.println("\nDame tu Operacion en el estilo C=A+B");                       //Pide tu operacion
        String tempString = escanerDelTeclado.nextLine();                                   //Y da un scanner
        tempString = tempString.replaceAll("\\s","");                                       //Quitemos espacios por si los puso

        if(tempString.length()!=5 && tempString.charAt(1)!='='){generaOperacion();}         //Si algo salio mal, repite

        try {                                                                               //Intenta pasarlo a numeros
            Racional A = listaNumeros.get(Character.getNumericValue(tempString.charAt(2))); //Ponemos operadores 
            Racional B = listaNumeros.get(Character.getNumericValue(tempString.charAt(4))); //Ponemos operadores 
            Racional C = listaNumeros.get(Character.getNumericValue(tempString.charAt(0))); //Ponemos operadores

            if(tempString.charAt(3) == '+'){C.Suma(A,B); C.toString();}                     //Elige las operaciones
            if(tempString.charAt(3) == '-'){C.Resta(A,B); C.toString();}                    //Elige las operaciones
            if(tempString.charAt(3) == '*'){C.Multiplicacion(A,B); C.toString();}           //Elige las operaciones
            if(tempString.charAt(3) == '/'){C.Division(A,B); C.toString();}                 //Elige las operaciones
        }                       
        catch (NumberFormatException e) {generaOperacion();}                                //Sino, repite
    }

    public void comparaElementos(int A, int B){                                             // ========== COMPARA ELEMENTOS =============
        if(listaNumeros.get(A).equals(listaNumeros.get(B))){                                //Usa equals
            System.out.println("Son iguales");                                              //Si son diferentes
        }
        else{System.out.println("Son diferentes");}                                         //Si son diferentes dilo
    }

    public void muestraMenor(){                                                             // ========== MUESTRA ANTERIOR ==============
        int menorID = 0;                                                                    //Aqui guardamos su ID
        for (int i = 0; i < listaNumeros.size(); i++){                                      //Buscamos en todos lados
            if (listaNumeros.get(menorID).compara(listaNumeros.get(i)) == 1){               //Si lo encuentras
                menorID = listaNumeros.get(i).getID();                                      //Cambia si encontraste aun mas pequeño
            }
        }
        System.out.println("El menor es: "+listaNumeros.get(menorID));                      //Mostramos por pantalla
    }

    public void muestraMayor(){                                                             // ========== MUESTRA MAYOR =================
        int mayorID = 0;                                                                    //Aqui guardamos su ID
        for (int i = 0; i < listaNumeros.size(); i++){                                      //Buscamos en todos lados
            if (listaNumeros.get(mayorID).compara(listaNumeros.get(i)) == -1){              //Si lo encuentras
                mayorID = listaNumeros.get(i).getID();                                      //Cambia si encontraste aun mas grande
            }
        }
        System.out.println("El mayor es: "+listaNumeros.get(mayorID));                      //Mostramos por pantalla
    }

    public void ordenaElementos(){                                                          // ========== ORDENA ELEMENTOS ===============
        int mcmComun = Racional.MCM(1,listaNumeros.get(0).getDenominador());                //Encontramos un MCD

        for (int i = 1; i < listaNumeros.size(); i++){                                      //Recorramos la lista
            int a = listaNumeros.get(i).getDenominador();                                   //Sacamos un denomidor
            mcmComun = Racional.MCM(a,mcmComun);                                            //Y comparamos con lo que tenemos
        }

        for (int i = 0; i < listaNumeros.size(); i++){                                      //Creamos una lista que se encarga recorrer
            int num = listaNumeros.get(i).getNumerador();                                   //Y samos el numerador
            int den = listaNumeros.get(i).getDenominador();                                 //Y samos el denominador

            listaNumeros.get(i).setNumerador((num*mcmComun)/den);                           //Ponemos a todo con un mismo
            listaNumeros.get(i).setDenominador(mcmComun);                                   //denominador
        }
        Collections.sort(listaNumeros);                                                     //Ordena
        for (int i = 0; i < listaNumeros.size(); i++){                                      //Recorramos la nueva lista              
            listaNumeros.get(i).Reducir();                                                  //Vamos a reducir
            listaNumeros.get(i).setID(i);                                                   //Y cambiar su referencia
        }
        muestraElementos();                                                                 //Muestra los elementos
    }

    public void eliminar(){                                                                 // ==========  ELIMINAR ELEMENTOS ============
        muestraElementos();                                                                 //Muestra los elementos que tenemos
        int ID = PideDato();                                                                //Pedimos nuestro dato
        listaNumeros.get(ID).finalize();                                                    //Finaliza nuestro datos
        listaNumeros.remove(ID);                                                            //Remueve ahora el elemento
        for (int i = 0; i < listaNumeros.size(); i++){listaNumeros.get(i).setID(i);}        //Ahroa reacomoda nuestros indices
        muestraElementos();                                                                 //Muestra los elementos
    }

    public int PideDato(){                                                                  // ==========  PEDIMOS VALOR  ================
        System.out.print("\nDime valor: ");                                                 //Le pedimos un valor
        int resultado;                                                                      //Le pedimos que nos de un resultado
        Scanner escanerDelTeclado = new Scanner(System.in);                                 //Scaneamos lo que nos dijo 
        String temporalString = escanerDelTeclado.nextLine();                               //Generamos un String pequeño
        if (Racional.EsUnNumero(temporalString)) {                                          //Si lo que tenemos solo son enteros
            resultado = Integer.parseInt(temporalString);                                   //Vamos a guardarlo como entero
        }
        else{return -1;}                                                                    //-1 si nos dio error, pues solo acepto positivos
        return resultado;                                                                   //Regresa ese resultado
    }

    public boolean equals(ListaDeRacionales A){                                             // ========== SOBREESCRIR EQUAS  =============
        if(listaNumeros.size() != A.listaNumeros.size()){return false;}                     //Si ni son del mismo tamaño que le haces

        for (int i = 0; i < listaNumeros.size(); i++){                                      //Recorramos la lista
            if(A.listaNumeros.get(i).equals(listaNumeros.get(i)) == false){return false;}   //Si alguna no es igual regresa falso
        }
        return true;                                                                        //Si llegas aqui es que si que son iguales
    }
}

