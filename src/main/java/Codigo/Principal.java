/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Codigo;

/**
 *
 * @author user01
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CListaLigada miLista = new CListaLigada();
        CListaLigada miListaOrdenada;
        Principal p = new Principal();
        
        
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
        miListaOrdenada = p.recursivo(miLista);
        
        miListaOrdenada.transversa();

    }
    
    public CListaLigada recursivo(CListaLigada coleccion)
    {
        CListaLigada ordenada = new CListaLigada();
        CListaLigada listaUno = new CListaLigada();
        CListaLigada listaDos = new CListaLigada();
        
        
        if(coleccion.cantidadDeElementos() > 1)
        {
            int puntoMedio = coleccion.cantidadDeElementos() / 2;
            listaUno = this.rellenarLista(coleccion, puntoMedio,0);
            listaDos = this.rellenarLista(coleccion, coleccion.cantidadDeElementos(), puntoMedio);
            listaUno = this.recursivo(listaUno);
            listaDos = this.recursivo(listaDos);
            //En esta parte ira el algoritmo que une ambas listas.
            int iUno = 0, iDos = 0;
            //Este algoritmo funciona solo si no hay elementos repetidos en la lista . 
            while(iUno < listaUno.cantidadDeElementos() & iDos < listaDos.cantidadDeElementos())
            {
                if(listaUno.getDato(iUno) < listaDos.getDato(iDos)) 
                {
                    ordenada.adicionar(listaUno.getDato(iUno));
                    iUno++;
                }
                else if(listaDos.getDato(iDos) < listaUno.getDato(iUno))
                {
                    ordenada.adicionar(listaDos.getDato(iDos));
                    iDos++;
                }
            }
            if(iUno < listaUno.cantidadDeElementos())
            {
                for(int i = iUno; i < listaUno.cantidadDeElementos(); i++)
                {
                    ordenada.adicionar(listaUno.getDato(i));
                }
            }
            else if(iDos < listaDos.cantidadDeElementos())
            {
                for(int i = iDos; i < listaDos.cantidadDeElementos(); i++)
                {
                    ordenada.adicionar(listaDos.getDato(i));
                }
            }
            
        }
        else
        {
            ordenada = coleccion;
        }
        return ordenada;
    }
    
    public CListaLigada rellenarLista(CListaLigada lista, int limite, int valorIterador)
    {
        CListaLigada mitadLista = new CListaLigada();
        for(int i = valorIterador; i < limite; i++ )
        {
            mitadLista.adicionar(lista.getDato(i));
        }
        return mitadLista;
    }
    
}
