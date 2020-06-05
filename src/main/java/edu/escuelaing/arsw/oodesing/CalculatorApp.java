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
        Calculator.DoubleMath mean=(a)->{
            Double ans=0.0;
            for(Double n:a){
                ans+=n;
            }
            return ans/a.size();
        };
        
        Calculator.DoubleMath sDeviation=(a)->{
            Double m=myApp.operateBinary(a, mean);
            Double ans=0.0;
            for(Double n:a){
                ans+=Math.pow((n-m),2);
            }
            return Math.sqrt(ans/(a.size()-1));
        };
                                    
        Path file = Paths.get(args[0]);  
        List<Double> lista=getNumbers(file);                         
        Double m=myApp.operateBinary(lista, mean);
        Double d=myApp.operateBinary(lista, sDeviation);
        System.out.println("Mean : "+m+", Standard Deviation: "+d);     
               
    }

    private static List<Double> getNumbers(Path file) throws Exception {
        List<Double> ans=new LinkedListG<>();
        Charset charset = Charset.forName("UTF-8");                                 
        try {
            BufferedReader BR = Files.newBufferedReader(file, charset);
            String linea= BR.readLine();
            while (linea != null) {  
                String[] tmp = linea.split(" "); 
                for (String s:tmp){
                    ans.add(Double.parseDouble(s));
                }
                linea= BR.readLine();
            }                     
        } catch (IOException ex) {
            throw new Exception("Error leyendo el archivo, revise la ruta"); 
        }
        return ans;
    }
}
