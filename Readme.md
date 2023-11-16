Angel Rodriguez 15-11669
Kevin Briceño 15-11661

Proyecto II: Mundo Chiquito

Descripción general: Mundo chiquito es una carta de popular juego de estrategia yi gi oh. El efecto de la carta consiste en: Muestrale a tu oponente una carta mostro de tu mano, elige un mostro de tu mazo que comparta exactamente una característica (nivel, poder o atributo) con el mostro revelado de tu mano y muestraselo a tu oponente. Luego agrega desde tu mazo a tu mano un mostro que comparta exactamente una caracteristica (nivel, poder o atributo) con el mostro revelado de tu mazo.


Objetivo: Se desea crear una implementación que permita calcular las ternas (a,b,c) posibles de un deck de 40 a 60 cartas con la ayuda de la carta mundo chiquito, tomando en cuenta que cada par de mostro solo puede compatir una única caracteristica posible (nivel, atrubuto, poder); 



Implementación: Se creó la clase DGrafo.java, en ella utilizaremos una tabla de hash que almacenará cada nodo del grafo; además, tendremos un arreglo de la clase edge que almacenará las conexiones entre los nodos.

Contenido:

1. DGrafo.java: como se explica anteriormente, esta clase tendrá la tarea de tener todas la funciones necesaria para manejar la interfaz de un grafo. No solo contiene la tabla de hash y el arreglo que almacenan vertices y sus arcos respectivamente, sino que, además, contiene los métodos de añadir un nodo, eliminar un nodo, buscar si un nodo está contenido, conectar y desconectar dos nodos, qué tienen en común 2 nodos, nodos adyacentes a un nodo dado, tamaño del grafo, predecesores y sucesores, cargarGrafo, mundoChiquito, y las conecciones de las ternas con la caracteristica común.

	1.1 CargarGrafo() es una funcion leera el archivo .csv tomará el nombre y los atrubutos de cada mostro y los almacenara en el CartaMonstro.java y posteriormente en las hashTable.
	luego llamara a la funcion connect y hará las coneccion de un mostro A con un mountruo B si estos comparte alguna caracteristica en común. (nivel, atributo,poder).

	1.2 mundoChiquito() es una funcion que relaciona y conecta las relaciones de un vertice A con un vertice B y luego un vertice B con un vertice C, si existe una caracteristica en común. 		Retorna la lista de las ternas.
	
	1.3 containsconnectComun(): es una funcion que indica cómo se relacion 2 Montros, Ya sea por (Nivel, Atrubuto, Poder).

	
2. connect.java: esta clase está implementada con un metodo abstracto, contiene tambien el constructor que almacena los id de las conexiones así como los metodos de para busqueda y un toString

3. edge.java: esta es un clase hija de connect, esta clase por medio de un extend, conecta el extremo de inicio con el extremo final de un par de vertice, creado así un arco entre ellos.

4. Graph.Java en la interfaz principal, a patir de alli se harán todas las llamadas correspondientes y se podrá hacer uso de los método mencionados en adjacencyListGraph

5. CartaMostro.java: Es la clase que almacena los nodos con un respectivo nombre, características como nivel, atributo y poder de cada mostro; en ella tenemos métodos get() y set() para buscar y escribir un nodo.

6. MundoChiquito.Java: esta clase contiene el main, desde aqui se hará la llamada al archivo .csv y se haran las llamadas a los métodos que estan en la intefaz Graph para la ejecución del programa.



complejidad aproximada segun el método:

Ya que se está usando tablas de hash, los metodo de añadir O(1), contener tiene una complejidad O(1) constante. Mientras que los métodos relacionados a las conexiones (conect) tiene complejidad O(k), cargarGrafo esta función tiene una complejidad de O(k^2)  y  mundoChiquito su complejidad sería O(i.j.k). para i = |getOutwardEdges(a)|, j = |getOutwardEdges(b)|, k = |hashTable|

Complejidad aproximada total en el peor caso es: i.j.k = O(n^3), 
