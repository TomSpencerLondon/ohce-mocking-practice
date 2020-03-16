package com.codurance.ohce;

public class Ohce {

  private Console console;

  public Ohce(Console console) {
    this.console = console;
  }

  public void greet(String text) {
    StringBuilder result = new StringBuilder(text).reverse();

    if (isPalindrome(text)) {
      result.append("\n¡Bonita palabra!");
    }
    console.print(result.toString());
  }

  private boolean isPalindrome(String text) {
    return text.equals(new StringBuilder(text).reverse().toString());
  }
}
