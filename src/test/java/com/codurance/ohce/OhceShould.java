package com.codurance.ohce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OhceShould {
  private TestableConsole testableConsole;
  private Ohce ohce;

  private TestableClock testableClock;
  private int HOUR;

  @BeforeEach
  void setUp() {
    testableConsole = new TestableConsole();
    testableClock = new TestableClock();
    ohce = new Ohce(testableConsole, testableClock);
  }

  @Test
  void reverses_a_string() {
    ohce.echo("hola");
    assertEquals("aloh", testableConsole.getText());
  }

  @Test
  void adds_bonita_palabra_for_palindome() {
    ohce.echo("oto");
    assertEquals("oto\n¡Bonita palabra!", testableConsole.getText());
  }

  @Test
  void returns_buenas_noches() {
    HOUR = 5;

    ohce.echo("ohce Pedro");
    assertEquals("¡Buenas noches Pedro!", testableConsole.getText());
  }

  @Test
  void returns_Buenos_días() {
    HOUR = 7;

    ohce.echo("ohce Pedro");
    assertEquals("¡Buenos días Pedro!", testableConsole.getText());
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
      Calendar time = Calendar.getInstance();
      time.set(Calendar.HOUR_OF_DAY, HOUR);
      return time;
    }
  }
}
