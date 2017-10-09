    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import ER.Expresion_Regular;
import ER.HtmlDoc;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Paolo
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        HtmlDoc cod_fuente=new HtmlDoc("https://www.instagram.com/instagram/","meta");
        
        ArrayList<String> contenidos = new ArrayList<String>();
        contenidos = cod_fuente.getContenidos();
        
        for ( int i = 0; i < contenidos.size(); i++)
        {
            System.out.println(contenidos.get(i));
        }
        
    }
    
}
