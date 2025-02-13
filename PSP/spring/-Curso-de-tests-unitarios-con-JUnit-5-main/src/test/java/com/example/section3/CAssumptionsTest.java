package com.example.section3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class CAssumptionsTest {

    @BeforeAll
    static void beforeAll() {

        System.getenv()
                .forEach(
                        (key, value) -> System.out.println("%s - %s".formatted(key, value))
                );

    }

    @Test
    void getEnvVar() {

        String jdk = System.getenv("JAVA_HOME");
        assumeTrue(jdk.contains("jdk-17"));

        System.out.println("El test continua");
    }

    @Test
    void test2() {
        String jdk = System.getenv("JAVA_HOME");
        assumingThat(jdk.contains("jdk-17"),
                () -> System.out.println(jdk));
    }
}
