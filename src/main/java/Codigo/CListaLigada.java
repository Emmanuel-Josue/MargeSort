/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

public class CListaLigada {
    
    //Ancla o encabezado de la lista. La acla indica el incio de la lista ligada.
    //Algunas personas guardad datos en el ancla, pero segun la experiencia del 
    //profesor a él le guata comenzar a guardar datos desde la segunda posición que 
    //vendria siendo la primera.
    private CNodo ancla;
    
    // Esta variable de referencia nos ayuda a trabajar con la lista 
    //Nos indicara cual es el nodo con el que estamos trabajando en ese momento.
    private CNodo trabajo;
    
    //Esta variable de referencia nos apoyara en ciertas operaciones de la lista.
    //Nos apuyara en busquedas, cual ha sido el nodo anterior. 
    private CNodo trabajo2;
    
    //Creamos el cosntructor de esta clase 
    public CListaLigada()
    {
        //Instanceamos el ancla 
        ancla = new CNodo();
        //Lo que acabo de entender es que se instancea para poder ulilizar los métodos 
        //que el objeot posee, como el que utilizamos a continuación. 
        
        //Como es una lista vacia su - siguiete - es null
        ancla.setSiguiente(null);//Se utiliza null para indicar que no hay conexion a otro nodo 
    }
    
    //Recorre toda la lista
    public void transversa()
    {
        //trabajo al inicio 
        trabajo = ancla;
        
        //recorre hasta encontrar el final 
        while( trabajo.getSiguiente() != null)
        {
            //avanzamos travajo
            trabajo = trabajo.getSiguiente();
            
            //objtenemos el dato y lo mostramos
            int d = trabajo.getDato();
            
            System.out.println("El dato objetenido es " + d);
        }
        //Bajamos la linea 
        System.out.println("");
    }
    
    // Adicionar siempre se realiza al final 
    public void adicionar(int pDato)
    {
        // Trabajo al inicio
        trabajo = ancla;
        
        // recorremos hasta encontrar el final 
        while( trabajo.getSiguiente() != null )
        {
            //avanzamos trabajo
            trabajo = trabajo.getSiguiente();
            
        }
        
        //creamos el nuevo nodo
        CNodo tem = new CNodo();
            
        //Insertamos el dato 
        tem.setDato(pDato);
        
        //Finalizamos correctamente
        tem.setSiguiente(null);
        
        //Ligamos el ultimo nodo encontrado con el recien creado 
        trabajo.setSiguiente(tem);
        
        
        
    }
    
    //Vaciar la lista 
    public void vaciar()
    {
        ancla.setSiguiente(null);
        /*
        En lenguajes no administrados hay que liberar la memoria adecuadamente, en 
        este lenguaje aprovechamos el recolector de basura.
        Lo que se hace es simplemente desconectar el comienzo de la lista que es +
        ancla a el resto de la lista.
        */
    }
    
    public boolean estaVacio()
    {
        boolean ciertoFalso;
        if( ancla.getSiguiente() == null )
        {
            ciertoFalso = true;
            
        }
        else
        {
            ciertoFalso = false;
        }
        return ciertoFalso;
    }
    
    //regresa el nodo de la primera ocurrencia del dato.
    public CNodo buscar(int bDato)
    {
        CNodo referencia = null; // variable que se retornara
        CNodo referenciaBucle; //La utilizare para poder terminar el bucle 
        //Si entra el if es porque la lista no esta vacia 
        if( this.estaVacio() == false)
        {
            trabajo2 = ancla;
            // Se recorre para ver si se encuentra el dato 
            //Este algoritmo es practicamente la transversa solo que con la variable
            //trabajo2, no entiendo porque no se puede utilizar la variable trabajo.
            referenciaBucle = trabajo2.getSiguiente();
            while( referenciaBucle != null)
            {
                trabajo2 = trabajo2.getSiguiente();
                referencia = trabajo2;
                //Al encontrar el dato, se tiene que salir del bucle, esto se logra dandole
                //una referencia nula a la variable.
                if (trabajo2.getDato() == bDato)
                {
                    referenciaBucle = null;
                }
                else
                {
                    referenciaBucle = trabajo2.getSiguiente();
                    referencia = null;
                }
            }
            
        }
        return referencia;
       
    }
    
    public int buscarIndice(int bDato)
    {
        int indice = -1; // variable que se retornara
        int contador = -1;
        CNodo referenciaBucle; //La utilizare para poder terminar el bucle 
        //Si entra el if es porque la lista no esta vacia 
        if( this.estaVacio() == false)
        {
            trabajo2 = ancla;
            
            referenciaBucle = trabajo2.getSiguiente();
            while( referenciaBucle != null)
            {
                ++contador;
                trabajo2 = trabajo2.getSiguiente();
                if (trabajo2.getDato() == bDato)
                {
                    referenciaBucle = null;
                    indice = contador;
                }
                else
                {
                    referenciaBucle = trabajo2.getSiguiente();
                }
            }
            
        }
        return indice;
       
    }
    
    public CNodo buscarNodoAnterior(int bDato)
    {
        trabajo2 = ancla;
        
        //Sí hay una diferencia entre los operadores & y &&
        while( trabajo2.getSiguiente() != null && trabajo2.getSiguiente().getDato() != bDato)
        {
            trabajo2 =  trabajo2.getSiguiente();
        }
        return trabajo2;
    }
    
    //Borra la primera ocurrencia del dato 
    public void borrar(int datoABuscar)
    {
        if( this.estaVacio() == false )
        {
            //Buscamos los nodos con los que trabajaremos
            CNodo anterior = this.buscarNodoAnterior(datoABuscar);
            CNodo encontrado = this.buscar(datoABuscar);
            
            if( encontrado != null)
            {
                //Se brinca el nodo, se liga al sigiente(variable) del objeoto encontrado
                anterior.setSiguiente(encontrado.getSiguiente());
                
                //Quitamos el actual de la lista
                encontrado.setSiguiente(null);
                
            }
        }
    }
    
    public void insertar( int posicion, int valorAInsetar)
    {
        //Encontramos la posición donde vamos a insertar
        trabajo = buscar(posicion);
   //     System.out.println("Se imprime la variable trabajo " + trabajo.getDato());
        //verificamos que exista el nodo en donde vamos a insetar 
        if( trabajo != null)
        {
            //Creamos el nodo temporal que vamos a insetar 
            CNodo temporal = new CNodo();
            temporal.setDato(valorAInsetar);
            
            //Conectamos el temporal a la lista 
            temporal.setSiguiente(trabajo.getSiguiente());
            
            //Conectamos trabajo a temporal
            trabajo.setSiguiente(temporal);
        }
        
    }
    
    public void insertarInicio(int datoAInsertar)
    {
        if( this.estaVacio() == true)
        {
            this.adicionar(datoAInsertar);
        }
        else
        {
            trabajo = ancla;
            
            //Se crea el dono que se va a insertar al incio y que llavara el dato
            CNodo temporal = new CNodo();
            temporal.setDato(datoAInsertar);
            
            //Apuntamos la variable -siguiente- de temporal al primer nodo que tiene el primer dato 
            temporal.setSiguiente(trabajo.getSiguiente());
            
            //Apuntamos la variable -siguiente- de trabajo que en este moemento tambien es ancla 
            trabajo.setSiguiente(temporal);
            
            
            
            
        }
    }
    
    public CNodo obtenerPorIndice(int indiceABuscar)
    {
        CNodo trabajo2 = null;
        int indice = -1;
        
        trabajo = ancla;
        while( trabajo.getSiguiente() != null )
        {
            trabajo = trabajo.getSiguiente();
            indice++;
            if( indice == indiceABuscar )
            {
                trabajo2 = trabajo;
            }
        }
        return trabajo2;
    }
    
    // En java no se pueden crear indexer, lo más marecido a esto es haacer 
    // metodos ger y set que modifiquen el valor que hay en los arreglos 
    
    /*
        En el tipo de dato que hay que regresar, no estoy muy seguro de que tipo 
        seria el adecuado para regresar ya que en el video regresarn un dato de tipo 
        int, pero mi primera intención fue regresar un CNodo, y en otro video regresaban 
        uno de tipo String entonces creo que hay que regresar el que se nos sirva más, en este 
        ejemplo la clase solo maneja un tipo de dato que es int y por lo tanto regresare este tipo. 
    
    */
    public int getDato(int posicion)
    {
        int valorEnElemento;
        valorEnElemento = this.obtenerPorIndice(posicion).getDato();
        return valorEnElemento;
    }
    
    public void setDato(int posicion, int valorAEstablecer)
    {
        CNodo referencia;
        referencia = this.obtenerPorIndice(posicion);
        if( referencia != null )
        {
            referencia.setDato(valorAEstablecer);
        }
    }
    
    public int cantidadDeElementos()
    {
        trabajo = ancla;
        int n = 0;
        
        while( trabajo.getSiguiente() != null )
        {
            trabajo = trabajo.getSiguiente();
            //Esta variable llera el conteo de elementos
            n++;
        }
        return n;
    }
    
}
