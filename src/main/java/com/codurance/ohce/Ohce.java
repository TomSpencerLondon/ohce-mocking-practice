package com.codurance.ohce;

public class Ohce {

  private Console console;

  public Ohce(Console console, Clock clock) {
    this.console = console;
  }

  public void greet(String text) {
    StringBuilder result = new StringBuilder(text).reverse();

    String[] string = text.split(" ");

    if (string[0].equals("ohce")){
      String name = string[1];
      result = new StringBuilder("¡Buenas noches " + name + "!");
    }

    if (isPalindrome(text)) {
      result.append("\n¡Bonita palabra!");
    }
    console.print(result.toString());
  }

  private boolean isPalindrome(String text) {
    return text.equals(new StringBuilder(text).reverse().toString());
  }
}
