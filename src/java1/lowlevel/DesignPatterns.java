package java1.lowlevel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DesignPatterns {
    /*
    Behavioural
    Strategy - collections.sort
    Observer -
    Chain of responsibility -
    Template -
    State Design Pattern

    Creational
    Singleton -
    Factory -
    Abstract Factory -
    Builder -

    Structural
    Facacde -
    Adapter -
    Decorator -

     */

    public static void main(String[] args) {
        List<String> str = Arrays.asList("qw");
        Collections.sort(str, (a,b) -> a.compareTo(b));
    }
}
