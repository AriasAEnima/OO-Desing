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
    
    public interface DoubleMath {
        double operation(List<Double> ld);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
    
    public double operateBinary(List<Double> a, DoubleMath op) {
        return op.operation(a);
    }
  

}
