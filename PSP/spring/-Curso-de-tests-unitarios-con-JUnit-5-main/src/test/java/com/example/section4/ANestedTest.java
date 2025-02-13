package com.example.section4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Tests para servicio SmartPhone")
public class ANestedTest {

    @Test
    @DisplayName("Test 1")
    void test1() {
        System.out.println("test1");
        assertTrue(true);
    }

    @Nested
    @DisplayName("Operaciones recuperar datos")
    class Grupo1{

        @Test
        @DisplayName("Find all()")
        void test2() {
            System.out.println("Test2");
        }
        @Test
        @DisplayName("Find one()")
        void test3() {
            System.out.println("Test3");
        }
        @Test
        @DisplayName("Find by CPU cores()")
        void test4() {
            System.out.println("Test4");
        }
    }

    @Nested
    @DisplayName("Operaciones insercion datos")
    class Grupo2{

        @Test
        @DisplayName("Insert one")
        void test5() {

            System.out.println("Test5");
            assertTrue(true);
        }

        @Test
        @DisplayName("Insert in batch")
        void test6() {

            System.out.println("Test6");
            assertTrue(true);
        }
    }
}
