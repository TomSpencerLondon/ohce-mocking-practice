package com.codurance.ohce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OhceShould {
  @Test
  void reverses_a_string() {
    TestableConsole testableConsole = new TestableConsole();
    Ohce ohce = new Ohce(testableConsole);
    ohce.greet("hola");
    assertEquals("aloh", testableConsole.getText());
  }

  @Test
  void adds_bonita_palabra_for_palindome() {
    TestableConsole testableConsole = new TestableConsole();
    Ohce ohce = new Ohce(testableConsole);
    ohce.greet("oto");
    assertEquals("oto\n¡Bonita palabra!", testableConsole.getText());
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
}
