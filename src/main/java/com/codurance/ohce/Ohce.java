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
    private final Calendar firstBoundary = Calendar.getInstance();
    private final Calendar secondBoundary = Calendar.getInstance();

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
        StringBuilder stringBuilder = new StringBuilder();
        String name = text.split(" ")[1];

        if (isMorning()) {
            stringBuilder.append(MORNING_GREETING);
        } else {
            stringBuilder.append(EVENING_GREETING);
        }

        return stringBuilder.append(name)
                            .append("!");
    }

    private boolean isMorning() {
        Calendar now = clock.currentTime();
        firstBoundary.set(Calendar.HOUR_OF_DAY, 6);
        secondBoundary.set(Calendar.HOUR_OF_DAY, 12);
        return now.after(firstBoundary) && now.before(secondBoundary);
    }

    private boolean isGreet(String text) {
        return text.split(GREET_SEPERATOR)[0].equals(GREET_MESSAGE);
    }

    private boolean isPalindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }
}
