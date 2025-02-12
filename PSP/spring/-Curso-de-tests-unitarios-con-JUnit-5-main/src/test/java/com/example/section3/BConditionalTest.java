package com.example.section3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class BConditionalTest {

    //JRE

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void test1() {

        System.out.println("Ejecutando desde Java 8");
    }

    @EnabledOnJre(JRE.JAVA_17)
    @Test
    void test2() {
        System.out.println("Ejecutando desde Java 17");

    }
}
