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
    private Calculator.FloatMath mean;
    private Calculator.FloatMath sDeviation;
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
            Float ans=0f;
            for(Float n:a){
                ans+=n;
            }
            return ans/a.size();
        };
        
        sDeviation=(a)->{
            Float m=myApp.operateBinary(a, mean);
            Float ans=0f;
            for(Float n:a){
                ans+=(n-m)*(n-m);
            }
            return (float) Math.sqrt(ans/(a.size()-1));
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
        List<Float> lista=new LinkedListG<Float>();
        lista.add(160f);
        lista.add(591f);
        lista.add(114f);
        lista.add(229f);
        lista.add(230f);
        lista.add(270f);
        lista.add(128f);
        lista.add(1657f);
        lista.add(624f);
        lista.add(1503f);
        Float ans1m=myApp.operateBinary(lista, mean);
        Float ans2m=myApp.operateBinary(lista, sDeviation);
        assertEquals(550.6f, ans1m,0.0001);
        assertEquals(572.03f, ans2m,0.005);
    }
    
     @Test
    public void Datos2() {
        List<Float> lista=new LinkedListG<Float>();
        lista.add(15.0f);
        lista.add(69.9f);
        lista.add(6.5f);
        lista.add(22.4f);
        lista.add(28.4f);
        lista.add(65.9f);
        lista.add(19.4f);
        lista.add(198.7f);
        lista.add(38.8f);
        lista.add(138.2f);
        Float ans1m=myApp.operateBinary(lista, mean);
        Float ans2m=myApp.operateBinary(lista, sDeviation);
        assertEquals(60.32f, ans1m,0.0001);
        assertEquals(62.26f, ans2m,0.005);
    }
    
    @Test
    public void datos3(){
        List<Float> lista=new LinkedListG<Float>();
        lista.add(186f);
        lista.add(699f);
        lista.add(132f);
        lista.add(272f);
        lista.add(291f);
        lista.add(331f);
        lista.add(199f);
        lista.add(1890f);
        lista.add(788f);
        lista.add(1601f);
        Float ans1m=myApp.operateBinary(lista, mean);
        Float ans2m=myApp.operateBinary(lista, sDeviation);
        assertEquals(638.9f, ans1m,0.0001);
        assertEquals(625.633981f, ans2m,0.005);
    }

 
}
