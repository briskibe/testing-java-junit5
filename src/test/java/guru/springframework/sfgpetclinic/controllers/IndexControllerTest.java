package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Test Proper View name is returned for index page")
    void index() {
        assertEquals("index", controller.index(), "Wrong view returned");

        // AssertJ test
        assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oupsHandler();
        });
    }

    // assertTimeout vs assertTimeoutPreemptively: assertTimeout waits for the code to finish, then checks the result. assertTimeoutPreemptively interrupts the code after the timeout is reached.
    @Test
    @Disabled("Demo of timeout")
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here");
        });
    }

    @Test
    @Disabled("Demo of timeout")
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here 342423423432");
        });
    }

    // assumptions are used when there is some case when something is missing in some environment, and the test should be skipped in that case
    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.MAC)
    void testMeOnMacOS() {

    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    void testMeOnWindows() {
    }

    @Test
    @EnabledOnJre(org.junit.jupiter.api.condition.JRE.JAVA_8)
    void testMeOnJava8() {
    }

    @Test
    @EnabledOnJre(org.junit.jupiter.api.condition.JRE.JAVA_11)
    void testMeOnJava11() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "jt")
    void testIfUserJT() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "bernardbriski")
    void testIfUserBernardBriski() {

    }
}


