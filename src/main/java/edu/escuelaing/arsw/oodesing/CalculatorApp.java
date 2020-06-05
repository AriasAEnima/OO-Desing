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
            Double m=myApp.operateList(a, mean);
            Double ans=0.0;
            for(Double n:a){
                ans+=Math.pow((n-m),2);
            }
            return Math.sqrt(ans/(a.size()-1));
        };
                                    
        Path file = Paths.get(args[0]);  
        FileReaderColumns frc=new FileReaderColumns(2);
        frc.read(file);
        List<List<Double>> data=frc.getData();
        int n=0;
        for (List<Double> col: data){
            Double m=myApp.operateList(col, mean);
            Double d=myApp.operateList(col, sDeviation);
            System.out.println("Column "+n+" -> Mean : "+m+", Standard Deviation: "+d);   
            n++;
        }                      
    }
}
