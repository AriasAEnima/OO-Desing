/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.escuelaing.arsw.oodesing.Calculator;
import edu.escuelaing.arsw.oodesing.LinkedListG;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author J. Eduardo Arias
 */
public class CalculadoraTest {
    private Calculator myApp;
    private Calculator.DoubleMath mean;
    private Calculator.DoubleMath sDeviation;
    private  Calculator.IntegerMath addition = (a, b) -> a + b;
    private  Calculator.IntegerMath subtraction = (a, b) -> a - b;

    /**
     * Sets up the test fixture. 
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
        myApp = new Calculator();
        mean=(a)->{
            Double ans=0.0;
            for(Double n:a){
                ans+=n;
            }
            return ans/a.size();
        };
        
        sDeviation=(a)->{
            Double m=myApp.operateBinary(a, mean);
            Double ans=0.0;
            for(Double n:a){
                ans+=(n-m)*(n-m);
            }
            return Math.sqrt(ans/(a.size()-1));
        };
    }

    @Test
    public void enteros(){     
        try{
            System.out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
            System.out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));  
            assertTrue(true);
        }catch(Exception e){
            fail("Error");
        }
    }
    
    @Test
    public void Datos1() {
        List<Double> lista=new LinkedListG<Double>();
        lista.add(160.0);
        lista.add(591.0);
        lista.add(114.0);
        lista.add(229.0);
        lista.add(230.0);
        lista.add(270.0);
        lista.add(128.0);
        lista.add(1657.0);
        lista.add(624.0);
        lista.add(1503.0);
        Double ans1m=myApp.operateBinary(lista, mean);
        Double ans2m=myApp.operateBinary(lista, sDeviation);
        assertEquals(550.6, ans1m,0.0001);
        assertEquals(572.03, ans2m,0.005);
    }
    
     @Test
    public void Datos2() {
        List<Double> lista=new LinkedListG<Double>();
        lista.add(15.0);
        lista.add(69.9);
        lista.add(6.5);
        lista.add(22.4);
        lista.add(28.4);
        lista.add(65.9);
        lista.add(19.4);
        lista.add(198.7);
        lista.add(38.8);
        lista.add(138.2);
        Double ans1m=myApp.operateBinary(lista, mean);
        Double ans2m=myApp.operateBinary(lista, sDeviation);
        assertEquals(60.32, ans1m,0.0001);
        assertEquals(62.26, ans2m,0.005);
    }
    
    @Test
    public void datos3(){
        List<Double> lista=new LinkedListG<Double>();
        lista.add(186.0);
        lista.add(699.0);
        lista.add(132.0);
        lista.add(272.0);
        lista.add(291.0);
        lista.add(331.0);
        lista.add(199.0);
        lista.add(1890.0);
        lista.add(788.0);
        lista.add(1601.0);
        Double ans1m=myApp.operateBinary(lista, mean);
        Double ans2m=myApp.operateBinary(lista, sDeviation);
        assertEquals(638.9, ans1m,0.0001);
        assertEquals(625.633981, ans2m,0.00001);
    }

 
}
