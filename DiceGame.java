/*
* This is DiceGame program.
*
* @author  Abdul Basit Butt
* @version 1.0
* @since   2022-02-15
* Class DiceGame.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
* This class generates a random number and asks the user to guess it.
*/
final class DiceGame {

    /**
    * This constant represents the lowest number the randomizer can generate.
    */
    public static final int LOWER_BOUND = 1;
    /**
    * This constant represents the highest number the randomizer can generate.
    */
    public static final int HIGHER_BOUND = 6;

    /**
    * Prevents instantiation.
    * Throw an exception IllegalStateException when called.
    *
    * @throws IllegalStateException
    *
    */
    private DiceGame() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Generates a random number.
    *
    * @param lowerBound It is the lowest value that the randomizer can produce.
    *     By default it is 0, but because 1 is added to it, it is 1.
    *
    * @param higherBound is the highest value that the randomizer can produce.
    *     It usually excludes the number given but because of lowerBound being
    *     added to the random number, it can reach the number 6.
    *
    * @return This function returns the random number.
    *
    */
    private static int randomNumber(
            final int lowerBound, final int higherBound) {
        return new Random().nextInt(higherBound) + lowerBound;
    }

    /**
    * Checks if the user's guess is higher or lower than the random number.
    *
    * @param guess It is the user's latest guess.
    *
    * @param randomNumber It is the random number generated at the start of the
    *     game.
    *
    * @return This function returns whether the user's guess is too high or too
    *     low.
    *
    */
    private static String higherOrLower(
            final int guess, final int randomNumber) {

        final String highOrLow;

        if (guess > randomNumber) {
            highOrLow = "Too high!\n";
        } else {
            highOrLow = "Too low!\n";
        }

        return highOrLow;
    }

    /**
     * Calculates and outputs the energy generated from a certain amount of
     * mass.
     *
     * @param args No args will be used.
     * @throws IOException if there is anything wrong with the user input.
     * @throws NumberFormatException if the user input cannot be turned into
     *     an integer.
     * */
    public static void main(final String[] args)
            throws NumberFormatException, IOException {

        final int randomNumber = randomNumber(LOWER_BOUND, HIGHER_BOUND);
        int numOfTries = 0;

        String guessString;
        int guess;

        while (true) {
            try {
                // User prompt
                System.out.print("Guess a number between 1 and 6: ");

                // Gathers and parses input to a String
                guessString = new BufferedReader(
                        new InputStreamReader(System.in)
                ).readLine();

                guess = Integer.parseInt(guessString);

                if (guess == randomNumber) {
                    numOfTries++;
                    System.out.println("Congratulations! you won! It took you "
                            + numOfTries + " tries.");
                    break;
                } else {
                    numOfTries++;
                    System.out.println(higherOrLower(guess, randomNumber));
                }

            } catch (IOException | NumberFormatException exception) {
                // Outputs error message
                System.out.println("Please enter a correct input.\n");
            }

        }

        System.out.println("\nDone.");
    }

}

