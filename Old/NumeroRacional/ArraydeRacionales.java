import java.util.*;                                                                         //Añade API en general

public class ArraydeRacionales {
    private Racional[] listaNumeros = new Racional[0];
    Scanner escanerDelTeclado = new Scanner(System.in);                                     //Aqui esta el scanner para la entrada

    // ========== INSERTAR EN ARRAY =============
    public void inserta(Racional nuevoRacional){listaNumeros = add(listaNumeros, nuevoRacional);}

    // ========== MUESTRA LOS ELEMENTOS  =============
    public void muestraElementos(){
        System.out.println("\n=========================");                                  //Muestro el menu
        for (int i = 0; i < listaNumeros.length; i++)                                       //Recorre nuestro list
            System.out.println(listaNumeros[i]);
        System.out.println("=========================");                                    //Salida de todo
    }

    // ========== GENERA UNA OPERACION ===============
    public void generaOperacion(){                                                          //Genera String tipo C=A*B ==
        System.out.println("\nDame tu Operacion en el estilo C=A+B");                       //Pide tu operacion
        String tempString = escanerDelTeclado.nextLine();                                   //Y da un scanner
        tempString = tempString.replaceAll("\\s","");                                       //Quitemos espacios por si los puso

        if(tempString.length() !=5 && tempString.charAt(1)!='='){generaOperacion();}        //Si algo salio mal, repite

        try {                                                                               //Intenta pasarlo a numeros
            System.out.println("Entre");
            Racional A = listaNumeros[Character.getNumericValue(tempString.charAt(2))];    //Ponemos operadores 
            Racional B = listaNumeros[Character.getNumericValue(tempString.charAt(4))];    //Ponemos operadores 
            Racional C = listaNumeros[Character.getNumericValue(tempString.charAt(0))];    //Ponemos operadores

            if(tempString.charAt(3) == '+'){C.Suma(A,B); C.toString();}
            if(tempString.charAt(3) == '-'){C.Resta(A,B); C.toString();}
            if(tempString.charAt(3) == '*'){C.Multiplicacion(A,B); C.toString();}
            if(tempString.charAt(3) == '/'){C.Division(A,B); C.toString();}
        }                       
        catch (NumberFormatException e) {generaOperacion();}                                //Sino, repite
    }

    // ========== COMPARA ELEMENTOS ===============
    public void comparaElementos(int A, int B){                                             //Compara si dos elementos son iguales
        if(listaNumeros[A].equals(listaNumeros[B])){                                        //Usa equals
            System.out.println("Son iguales");                                              //Si son diferentes
        }
        else{System.out.println("Son diferentes");}                                         //Si son diferentes dilo
    }

    // ========== MUESTRA ANTERIOR ===============
    public void muestraMenor(){                                                             //Muestra el elemento Menor
        int menorID = 0;                                                                    //Aqui guardamos su ID
        for (int i = 0; i < listaNumeros.length ; i++){                                     //Buscamos en todos lados
            if (listaNumeros[menorID].compara(listaNumeros[i]) == 1){                       //Si lo encuentras
                menorID = listaNumeros[i].getID();                                          //Cambia si encontraste aun mas pequeño
            }
        }
        System.out.println("El menor es: "+listaNumeros[menorID]);                          //Mostramos por pantalla
    }

    // ========== MUESTRA MAYOR ===============
    public void muestraMayor(){                                                             //Muestra el mayor
        int mayorID = 0;                                                                    //Aqui guardamos su ID
        for (int i = 0; i < listaNumeros.length ; i++){                                     //Buscamos en todos lados
            if (listaNumeros[mayorID].compara(listaNumeros[i]) == -1){                      //Si lo encuentras
                mayorID = listaNumeros[i].getID();                                          //Cambia si encontraste aun mas grande
            }
        }
        System.out.println("El mayor es: "+listaNumeros[mayorID]);                          //Mostramos por pantalla
    }


    // ========== ORDENA ELEMENTOS ===============
    public void ordenaElementos(){
        int mcmComun = Racional.MCM(1,listaNumeros[0].getDenominador());

        for (int i = 1; i < listaNumeros.length ; i++){
            int a = listaNumeros[i].getDenominador();
            mcmComun = Racional.MCM(a,mcmComun);
        }

        for (int i = 0; i < listaNumeros.length; i++){
            int num = listaNumeros[i].getNumerador();
            int den = listaNumeros[i].getDenominador();

            listaNumeros[i].setNumerador((num*mcmComun)/den);
            listaNumeros[i].setDenominador(mcmComun);
        }
        Arrays.sort(listaNumeros);
        for (int i = 0; i < listaNumeros.length; i++){listaNumeros[i].Reducir();listaNumeros[i].setID(i);}
        muestraElementos();
    }



    //======  ELIMINAR ELEMENTOS ==============

    public void eliminar(){ 

        muestraElementos();
        int ID = PideDato();

        Racional eliminar = listaNumeros[ID];

        System.out.println("El dato a eliminar es:" + eliminar);


        Racional[] nuevaLista = new Racional[(listaNumeros.length)-1];
        boolean flag = false;

        for (int i = 0; i < listaNumeros.length; i++){
            int k=i;
            if (flag) {k--;}
            if(listaNumeros[i].equals(eliminar) == true){
                flag = true;
                continue;
            }
            else{
                nuevaLista[k] = listaNumeros[i];
            }
        }

        listaNumeros = nuevaLista;

        for (int i = 0; i < listaNumeros.length; i++){listaNumeros[i].setID(i);}
        muestraElementos();
    }


    public int PideDato(){
        System.out.print("\nDime valor: ");
        int resultado;
        Scanner escanerDelTeclado = new Scanner(System.in);
        String temporalString = escanerDelTeclado.nextLine();                           //Generamos un String pequeño
        if (Racional.EsUnNumero(temporalString)) {                                      //Si lo que tenemos solo son enteros
            resultado = Integer.parseInt(temporalString);                               //Vamos a guardarlo como entero
        }
        else{return -1;}
        return resultado;
    }

    public boolean equals(ArraydeRacionales A){
        if(listaNumeros.length != A.listaNumeros.length){return false;}

        for (int i = 0; i < listaNumeros.length; i++){
            if(A.listaNumeros[i].equals(listaNumeros[i]) == false){return false;}
        }
        return true;
    }


    //========== AÑADIR ELEMENTOS ==============
    static Racional[] add(Racional[] a, Racional e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }
}