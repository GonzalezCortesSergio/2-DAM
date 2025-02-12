package com.example.section2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CClassTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void setUp() {

        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {

        System.out.println("tearDown");
    }

    @Order(2)
    @Test
    void test1() {

        System.out.println("test1");

        assertTrue(true);
    }

    @Order(1)
    @Test
    void test2() {

        System.out.println("test2");
        assertTrue(true);
    }
}
