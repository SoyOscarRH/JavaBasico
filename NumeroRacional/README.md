
#RACIONAL

##Propiedades de este Programa:

Genera una clase racional diseñada para usarse como parte de un arreglo de racionales
    **Constructores:**
        * Uno vacio que obliga al usuario a ingresar datos
        * Uno que recibe un string que dedice si lo escribiste como "1/3" o "0.23"
        * Uno que recibe dos enteros para guardarlos
        * Un constructor de copia

        * Interprete: La clase se crea con un string que puede ser desde: "-1/ 3" "-1/-6" "-0.23" 

    
    **Reducir:**
    Al final de cada operacion, es decir en cualquier momento el racional esta en su forma mas corta posible, ademas
    usa MCD de forma recursiva para conseguirlo, adems quita signos negativos incesario o los manda al numerador por estatica

    **Metodos Estaticos:**
    Usa metodos estaticos que nos permiten acceder a ellos en cualquier momento, como para analizar un string o para MCD
    Usa una variable estatica que nos permite saber en cualquier momento la cantidad de racionales que hemos creado. 

    **Object**
    Se sobre eescriben los metodos de finalice y sobretodo se usan metodos como tostring y equals, que son comunes en el codigo

    **Interprete:**
    Es genial porque nos permite entender que operacion queremos hacer.

    **Operaciones:** 
    Nos permite generar operaciones, todas:
        - Guardan el resultado en el objeto que las llamo
        - Regresan ese objeto por si las dudas necesitas almacenar en otro lado el resultado.

    **Orden**
    Nos permite encontrar el menor o el mayor en cada arreglo o array

    **Ordena**
    Nos permite ordenar todo nuestro conjunto de racionales



    Se crea cada clase y un archivo que sirve solo como interfaz al usuario de estas practicas

    === ARRAY === 
    Se crea una clase nueva que usa racional para crear una array de racionales, usamos algoritmos propios para ponera añadir 
    y eliminar elementos del array

    === ARRAY LIST ===
    Usamos mucho mas esta pues nos permite un codigo mas limpio, ademas obre escribimos la clase compareto para poder comparar 
    elementos




    PARA CORRER COMO ARRAY:
    javac Usuario.java && javac Racional.java && javac ListaDeRacionales.java &&clear &&  javac ArraydeRacionales.java && javac UsuarioArray.java && java UsuarioArray

    PARA CORRER COMO LISTA:
    javac Usuario.java && javac Racional.java && javac ListaDeRacionales.java &&clear &&  javac ArraydeRacionales.java && javac UsuarioArray.java && java Usuario

