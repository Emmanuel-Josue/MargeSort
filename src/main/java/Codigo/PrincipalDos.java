/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Codigo;

/**
 *
 * @author user01
 */
public class PrincipalDos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CListaLigada miLista = new CListaLigada();
        CListaLigada miListaOrdenada;
        PrincipalDos p = new PrincipalDos();
        
        
        //agregamos datos desordenados 
        miLista.adicionar(2);
        miLista.adicionar(6);
        miLista.adicionar(8);
        miLista.adicionar(10);
        miLista.adicionar(1);
        miLista.adicionar(4);
        miLista.adicionar(5);
        miLista.adicionar(7);
        
        miLista.transversa();
        miListaOrdenada = p.mergeSort(miLista);
        
        miListaOrdenada.transversa();

    }
    
    public CListaLigada mergeSort(CListaLigada listaDesordenada)
    {
        CListaLigada listaOrdenada = null;
        //Cantidad de elementos en la lista
        int cantidad = listaDesordenada.cantidadDeElementos();
        int n = 0;
        
        //Caso base, una lista de un solo elemento ya esta ordenada 
        if( cantidad < 2 & cantidad > 0 )
        {
            listaOrdenada = listaDesordenada;
        }
        else
        {
            int mitad = cantidad/2;
            
            CListaLigada izquierda = new CListaLigada();
            CListaLigada derecha = new CListaLigada();
            
            //Adicionamos a la izquierda desde el inicio hasta antes de la mitad
            for(int i = 0; i < mitad; i++)
            {
                izquierda.adicionar(listaDesordenada.getDato(i));
            }
            
            // Adicionamos a la derecha desde la mitad hasta el final de la lista.
            for(int i = mitad; i < cantidad; i++)
            {
                derecha.adicionar(listaDesordenada.getDato(i));
            }
            
            //Casos inductivos 
            //Hacemos el MergeSort de las listas Izquierda y Derecha.
            CListaLigada temporalUno = this.mergeSort(izquierda);
            CListaLigada temporalDos = this.mergeSort(derecha);
            
            //Hacemos el merge de lo que nos regresa el caso inductivo
            listaOrdenada = merge(temporalUno, temporalDos);
        }
        return listaOrdenada;
        
    }
    
    public CListaLigada merge(CListaLigada listaIzq, CListaLigada listaDer)
    {
        //Para que este método entregue una lista ordenada debe de obtener como
        //parametros dos listas previamente ordenadas 
        
        CListaLigada union = new CListaLigada(); 
        
        //Indece en cada lista.
        int indiceI = 0;
        int indiceD = 0;
        
        //Cantidad de elementos en cada lista
        int cantidadI = listaIzq.cantidadDeElementos();
        int cantidadD = listaDer.cantidadDeElementos();
        
        //Recorermos mientras las dos listas tengan elementos sin procesar.
        while( indiceI < cantidadI && indiceD < cantidadD )
        {
            //Si el de la izquierda es menor o igual adicionamos el de la izquierda.
            if( listaIzq.getDato(indiceI) <= listaDer.getDato(indiceD))
            {
                union.adicionar(listaIzq.getDato(indiceI));
            
                //Avanzamos el indice izquierdo
                indiceI++;
            }
            else //Si el de la derecha es menor adicionamos el de la derecha.
            {
                union.adicionar(listaDer.getDato(indiceD));
                //Avanzamos el indice derecho.
                indiceD++;
            }
        }
        
        //Si sobraron elementos en la lista izquierda los ponemos todos
        while( indiceI < cantidadI )
        {
            union.adicionar(listaIzq.getDato(indiceI));
            //Avanzamos el indice izquierdo
                indiceI++;
        }
        
        //Si sobraron elementos en la lista derecha los ponemos todos
        while (indiceD < cantidadD) 
        {
            union.adicionar(listaDer.getDato(indiceD));
            //Avanzamos el indice izquierdo
            indiceD++;
        }
        //Regresamos nuestra lista ordenada y unida. 
        return union;
    }
    
}
