/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.oodesing;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author J. Eduardo Arias
 */
public class CalculatorApp {
    public static void main(String[] args) throws Exception {
        Calculator myApp = new Calculator();
        Calculator.FloatMath mean=(a)->{
            Float ans=0f;
            for(Float n:a){
                ans+=n;
            }
            return ans/a.size();
        };
        
        Calculator.FloatMath sDeviation=(a)->{
            Float m=myApp.operateBinary(a, mean);
            Float ans=0f;
            for(Float n:a){
                ans+=(float) Math.pow((n-m),2);
            }
            return (float) Math.sqrt(ans/(a.size()-1));
        };
                                    
        Path file = Paths.get(args[0]);  
        List<Float> lista=getNumbers(file);                         
        Float m=myApp.operateBinary(lista, mean);
        Float d=myApp.operateBinary(lista, sDeviation);
        System.out.println("Mean : "+m+", Standard Deviation: "+d);     
               
    }

    private static List<Float> getNumbers(Path file) throws Exception {
        List<Float> ans=new LinkedListG<>();
        Charset charset = Charset.forName("UTF-8");                                 
        try {
            BufferedReader BR = Files.newBufferedReader(file, charset);
            String linea= BR.readLine();
            while (linea != null) {  
                String[] tmp = linea.split(" "); 
                for (String s:tmp){
                    ans.add(Float.parseFloat(s));
                }
                linea= BR.readLine();
            }                     
        } catch (IOException ex) {
            throw new Exception("Error leyendo el archivo, revise la ruta"); 
        }
        return ans;
    }
}
