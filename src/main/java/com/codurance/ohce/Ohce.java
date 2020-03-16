package com.codurance.ohce;

import java.util.Calendar;

public class Ohce {

    public static final String GREET_MESSAGE = "ohce";
    public static final String GREET_SEPERATOR = " ";
    public static final String EVENING_GREETING = "¡Buenas noches ";
    public static final String MORNING_GREETING = "¡Buenos días ";
    public static final String PALINDROME_MSG = "¡Bonita palabra!";
    public static final String NEW_LINE = "\n";
    private Console console;
    private Clock clock;

    public Ohce(Console console, Clock clock) {
        this.console = console;
        this.clock = clock;
    }

    public void echo(String text) {
        StringBuilder result = new StringBuilder(text).reverse();

        if (isGreet(text)) {
            result = greet(text);
        }

        if (isPalindrome(text)) {
            result.append(NEW_LINE + PALINDROME_MSG);
        }

        console.print(result.toString());
    }

    private StringBuilder greet(String text) {
        Calendar a1 = Calendar.getInstance();
        a1.set(Calendar.HOUR_OF_DAY, 6);

        Calendar a2 = Calendar.getInstance();
        a2.set(Calendar.HOUR_OF_DAY, 12);

        Calendar now = clock.currentTime();
        boolean isBetween = now.after(a1) && now.before(a2);
        if (isBetween) {
            return new StringBuilder(MORNING_GREETING + text.split(" ")[1] + "!");
        }

        return new StringBuilder(EVENING_GREETING + text.split(" ")[1] + "!");
    }

    private boolean isGreet(String text) {
        return text.split(GREET_SEPERATOR)[0].equals(GREET_MESSAGE);
    }

    private boolean isPalindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }
}
