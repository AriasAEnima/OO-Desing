/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.oodesing;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 *
 * @author J. Eduardo Arias
 */
public class lambdaTests {

    public static void main(String[] args) {
        List<Double> numeros = new LinkedListG<>();
        numeros.add( 23.0);
        numeros.add(445.0);
        numeros.add(Double.parseDouble("17"));
        for (Double n : numeros) {
            System.out.println(n);
        }

        printNumbers(
                numeros,
                (Double p) -> p >=  18
                && p <= 29
        );

        printNumbersWithPredicate(numeros, p -> (p > 400));

        processNumbers(numeros, p -> p > 17, p -> System.out.println("Process :" + p));

        processNumbersWithFunction(
                numeros,
                p -> (p > 17),
                p -> "Con Funcion : Numero " + p + "+2 = " + (p + 2),
                d -> System.out.println(d)
        );
       
        processElements(numeros, p -> p>17,
          p -> "Process elements : Numero " + p + "+2 = " + (p + 2), d -> System.out.println(d) );
         
         numeros.stream()
                .filter(
                       p -> p>17)
                .map(p -> "Stream : Numero " + p + "+2 = " + (p + 2))
                .forEach(email -> System.out.println(email)
        );
        
    }

    public static void printNumbers(List<Double> numeros, CheckNumber tester) {
        for (Double p : numeros) {
            if (tester.test(p)) {
                System.out.println("Cumple: " + p);
            }
        }
    }

    public static void printNumbersWithPredicate(List<Double> lista, Predicate<Double> tester) {
        for (Double p : lista) {
            if (tester.test(p)) {
                System.out.println("Cumple Predicado: " + p);
            }
        }
    }

    public static void processNumbers(List<Double> lista, Predicate<Double> tester, Consumer<Double> block) {
        for (Double p : lista) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processNumbersWithFunction(List<Double> roster, Predicate<Double> tester,
            Function<Double, String> mapper,
            Consumer<String> block) {
        for (Double p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <X, Y>
            void processElements(Iterable<X> source, Predicate<X> tester,
                    Function<X, Y> mapper, Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
}
