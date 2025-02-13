package com.example.section4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class BRepeatedTest {

    @Test
    void test1() {

        System.out.println("Prueba concepto test1");
    }

    @RepeatedTest(value = 3)
    @DisplayName("Caso de test 2")
    void test2() {
        System.out.println("Prueba concepto test2");
    }

    @RepeatedTest(value = 3, name = RepeatedTest.SHORT_DISPLAY_NAME)
    @DisplayName("Caso de test 3")
    void test3() {

        System.out.println("Prueba concepto test3");
    }

    @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Caso de test 4")
    void test4() {

        System.out.println("Prueba concepto test4");
    }

    @DisplayName("Caso de test 5")
    @RepeatedTest(value = 3, name = "{displayName} - {currentRepetition} / {totalRepetitions}")
    void test5() {
        System.out.println("Prueba concepto test5");
    }
}
