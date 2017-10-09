/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * @author Paolo
 */
public class HtmlDoc {
    private ArrayList<String> contenidos;
	/*public static void main(String []args){
		try {
			new HtmlDoc("s");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	public HtmlDoc(String dir,String tipo) throws IOException{
            Expresion_Regular analizador=new Expresion_Regular();
		try {
			java.net.URL url = new java.net.URL(dir);
			java.net.URLConnection con = url.openConnection();
			InputStream s = con.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s));
			String line;
			while((line = bufferedReader.readLine())!=null){
                            if(line.length()>0)
                            {
                                if(analizador.Evaluar(line,tipo))
                                {
                                    analizador.getTipo_reservada();
                                }
                            }
			}
                        contenidos=analizador.getTipo_reservada();
		} catch (java.net.MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Asegurese de que la direccion sea valida:\n Ejm: https://www.instagram.com/instagram/");
		}
	}

    /**
     * @return the contenidos
     */
    public ArrayList<String> getContenidos() {
        return contenidos;
    }
}
