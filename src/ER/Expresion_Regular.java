/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ER;

import java.util.ArrayList;

/**
 *
 * @author Paolo
 */
public class Expresion_Regular{
    private String cadena;
    private String Qo;
    private String Qa;
    private String Qe;
    private String Qf;
    private int i;
    
    /*private String head="";
    private String body="";
    private String reservadas[]={"head","body"};*/
    private ArrayList<String> tipo_reservada;
    
    public Expresion_Regular()
    {
        this.Qo="0";
        this.Qa="0";
        this.Qe="-1";
        this.Qf="100";
        this.cadena="";
        this.i=0;
        ArrayList<String> contenidos=new ArrayList<>();
        this.tipo_reservada=contenidos;
    }

    //METODOS
    private char sgteCar()
    {
        if(FinCad())
        {
            return '$';
        }
        else
        {
        i++;
        return cadena.charAt(this.i);
        }
    }
    
    private void GenerarAutomata(String clave)
    {
        char token=cadena.charAt(0);
        String acumulada="";
        String contenido="";
        while(!Qa.equals(Qf) && !Qa.equals(Qe))
        {
            switch(Qa)
            {
                case "0":
                    if(token=='<'){Qa="1";token=sgteCar();}
                        else{
                            if(FinCad()){Qa=Qe;} else{/*ignorar*/ token=sgteCar();}     
                            }
                    break;
                
                case "1":
                    if(token=='>'){Qa="3";;token=sgteCar();}
                    else{
                        if(token=='/'){Qa="5";token=sgteCar();}
                        else{
                            if(FinCad()){Qa=Qe;} else{/*acumular 1 token*/acumulada+=token;Qa="2";token=sgteCar();}     
                            }
                        }
                    break;
                
                case "2":
                    if(token==' '){Qa="4";if(!acumulada.equals(clave))acumulada="";token=sgteCar();}
                        else{
                            if(token=='>'){Qa="3";if(!acumulada.equals(clave))acumulada="";token=sgteCar();}
                                else{
                                     /*acumular tokens*/acumulada+=token;token=sgteCar();
                                    }
                            }
                    break;
                
                case "3":
                    
                    if(token=='<'){Qa="1";token=sgteCar();}
                    else{
                        if(!FinCad()){token=sgteCar();}
                        else{if(token=='$'){Qa=Qf;}else{Qa=Qe;}}}
                    break;
                
                case "4":
                    
                    if(token=='>'){Qa="3";if(acumulada.equals(clave)){getTipo_reservada().add(contenido);};acumulada="";contenido="";token=sgteCar();}
                        else{if(FinCad()){Qa=Qe;} else{/*acumular s2*/contenido+=token;token=sgteCar();}}
                    break;
                
                case "5":
                    //acumular
                    Qa="7";
                    break;
                
                case "6":
                    //Si pila vacia aceptar
                    //sino error
                    break;
                
                case "7":
                    if(token=='>'){Qa="3";acumulada="";token=sgteCar();}
                        else{if(FinCad()){Qa=Qe;} else{/*acumular*/acumulada+=token;token=sgteCar();}     }
                    break;
            }
            
        }
    }
    
    public boolean Evaluar(String cadena,String clave)
    {
        this.Qa=this.Qo;
        this.i=0;
        setCadena(cadena);
        GenerarAutomata(clave);
        return Qa.equals(Qf);
    }
    
    
    private boolean FinCad()
    {
        return i==cadena.length()-1;
    }
    
    /**
     * @return the cadena
     */
    public String getCadena() {
        return cadena;
    }

    /**
     * @param cadena the cadena to set
     */
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    /**
     * @return the Qa
     */
    private String getQa() {
        return Qa;
    }

    /**
     * @param Qa the Qa to set
     */
    private void setQa(String Qa) {
        this.Qa = Qa;
    }
    
    
   /* private boolean BusquedaR(String palabra)
    {
        int i=0;
        boolean enc=false;
        while(enc!=true && i<this.reservadas.length)
        {
            if(palabra.equals(reservadas[i]))
                enc=true;
        }
        
        return enc;
    }*/

    /**
     * @return the tipo_reservada
     */
    public ArrayList<String> getTipo_reservada() {
        return tipo_reservada;
    }
    
}
