package tr.edu.iztech.teamstech.io;

import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Scanner(System.In) wrapper class with validation support
 * <p>
 * NOTE: It's my (Gökberk) code written for CENG-211 in 2019.
 */
public class KeyboardReader {
    private final Scanner scanner;
    private final String prefix;
    private final String suffix;

    public KeyboardReader() {
        this("$ ", ": ");
    }

    /**
     * @param prefix prefix to be added for each prompt message
     * @param suffix suffix to be added for each prompt message
     */
    public KeyboardReader(String prefix, String suffix) {
        this.scanner = new Scanner(System.in);
        this.prefix = prefix;
        this.suffix = suffix;
    }

    /**
     * Reads input until it is integer
     * Any exception different than NumberFormatException will cause null return value.
     *
     * @param promptMessage a message to show user
     * @return input value
     */
    public Integer promptInteger(String promptMessage) {
        return prompt(promptMessage, Integer::parseInt, v -> true);
    }

    /**
     * promptInteger with validation
     *
     * @param promptMessage a message to show user
     * @param predicate     checks if input is valid or not
     * @return input value
     */
    public Integer promptInteger(String promptMessage, Predicate<Integer> predicate) {
        return prompt(promptMessage, Integer::parseInt, predicate);
    }

    /**
     * Reads input until it is double
     * Any exception different than NumberFormatException will cause null return value.
     *
     * @param promptMessage a message to show user
     * @return input value
     */
    public Double promptDouble(String promptMessage) {
        return prompt(promptMessage, Double::parseDouble, v -> true);
    }

    /**
     * promptDouble with validation
     *
     * @param promptMessage a message to show user
     * @param predicate     checks if input is valid or not
     * @return input value
     */
    public Double promptDouble(String promptMessage, Predicate<Double> predicate) {
        return prompt(promptMessage, Double::parseDouble, predicate);
    }

    /**
     * Reads input
     *
     * @param promptMessage a message to show user
     * @return input value
     */
    public String promptString(String promptMessage) {
        return prompt(promptMessage, v -> v, v -> true);
    }

    /**
     * promptString with validation
     *
     * @param promptMessage a message to show user
     * @param predicate     checks if input is valid or not
     * @return input value
     */
    public String promptString(String promptMessage, Predicate<String> predicate) {
        return prompt(promptMessage, v -> v, predicate);
    }

    /**
     * Closes reader
     */
    public void close() {
        scanner.close();
    }

    private <T> T prompt(String promptMessage, Parsable<T> parsable, Predicate<T> predicate) {
        String line = null;
        T parsed = null;
        boolean isValid = false;

        printPrompt(promptMessage);
        while (!isValid && scanner.hasNextLine()) {
            try {
                line = scanner.nextLine();
                parsed = parsable.parse(line);

                if (predicate.test(parsed)) isValid = true;
            } catch (NumberFormatException ignored) {
            } catch (Exception e) {
                isValid = true;
            }

            if (!isValid) printPrompt(promptMessage);
        }

        return parsed;
    }

    private void printPrompt(String promptMessage) {
        System.out.print(prefix + promptMessage + suffix);
    }

    private interface Parsable<T> {
        T parse(String line);
    }

    /**
     * Helper class for printing options
     */
    public static class Options {
        private final String[] options;
        private final String header;
        private final boolean noBack;

        /**
         * @param header  option title
         * @param options options
         */
        public Options(String header, String[] options) {
            this(header, options, false);
        }

        /**
         * @param header  option title
         * @param options options
         * @param noBack  add zero numbered options to go back or no
         */
        public Options(String header, String[] options, boolean noBack) {
            this.options = options;
            this.header = header;
            this.noBack = noBack;
        }

        /**
         * prints options
         */
        public void printOptions() {
            System.out.println("[#] " + header + ":");
            for (int i = 0; i < options.length; i++) {
                System.out.printf("[%d] %s\n", i + 1, options[i]);
            }
            if (!noBack) System.out.println("[0] Go back");
        }

        /**
         * generates predicate for prompt methods
         *
         * @return predicate
         */
        public Predicate<Integer> getPredicate() {
            return noBack ? (v -> v > 0 && v <= options.length) : (v -> v >= 0 && v <= options.length);
        }
    }
}