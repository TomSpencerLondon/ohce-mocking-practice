package com.codurance.ohce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OhceShould {
  private TestableConsole testableConsole;
  private Ohce ohce;

  private TestableClock testableClock;

  @BeforeEach
  void setUp() {
    testableConsole = new TestableConsole();
    testableClock = new TestableClock();
    ohce = new Ohce(testableConsole, testableClock);
  }

  @Test
  void reverses_a_string() {
    ohce.greet("hola");
    assertEquals("aloh", testableConsole.getText());
  }

  @Test
  void adds_bonita_palabra_for_palindome() {
    ohce.greet("oto");
    assertEquals("oto\n¡Bonita palabra!", testableConsole.getText());
  }

  @Test
  void returns_buenas_noches() {
    ohce.greet("ohce Pedro");
    assertEquals("¡Buenas noches Pedro!", testableConsole.getText());
  }

  private class TestableConsole implements Console {

    private String text;

    @Override
    public void print(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }
  }

  private class TestableClock implements Clock {
    @Override
    public Calendar currentTime() {
      return null;
    }
  }
}
