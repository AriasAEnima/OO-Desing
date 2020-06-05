/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.oodesing;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.lang.Math; 
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 *
 * @author J. Eduardo Arias
 */
public class Calculator {
    
    public interface IntegerMath {
        int operation(int a, int b);        
    }
    
    /**
     * Permite hacer operaciones sobre una lista de double's.
     */
    public interface DoubleMath {
        double operation(List<Double> ld);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
    
    /**
     * Ejecuta una operacion sobre una lista de doubles.
     * @param a la lista
     * @param op la opracion
     * @return resultado de la operacion
     */
    public double operateList(List<Double> a, DoubleMath op) {
        return op.operation(a);
    }
  

}
