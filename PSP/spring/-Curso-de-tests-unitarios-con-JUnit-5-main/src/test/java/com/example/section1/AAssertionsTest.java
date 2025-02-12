package com.example.section1;

import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AAssertionsTest {

    @Test
    void count() {

        SmartPhoneService service = new SmartPhoneServiceImpl();

        Integer count = service.count();

        assertNotNull(count);
        assertTrue(count > 0);
        assertEquals(3, count);
        assertEquals(3, count + 1, "El número de elementos esperado es 3");
    }
}
