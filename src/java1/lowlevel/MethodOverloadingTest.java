package java1.lowlevel;

import com.sun.source.tree.SynchronizedTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class MethodOverloadingTest {

   /* public void print(int a){
        System.out.println("1");
    }*/

    public void print(Integer a){
        System.out.println("2");
    }

 /*   public void print(float a){
        System.out.println("3");
    }*/


    public static void main(String[] args) {

        MethodOverloadingTest t = new MethodOverloadingTest();
        t.print(10);
        t.print(new Integer(23));
        List<Integer> lst = new ArrayList<>();
        Supplier<String> s = () -> "Ranjeet Mishra";
        System.out.println(s.get());


    }
}
