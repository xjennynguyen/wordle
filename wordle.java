import java.io.File;
import java.util.Scanner;

import java.util.Scanner;
public class Full_Fledged_Version {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        //System.out.print("Do you want to see the secret?");
        //boolean Choice;
        //Choice = keyboard.nextLine().toLowerCase().startsWith("n"); //in order to declare a variable
        String secret, guess;
        System.out.print("Do you want to see the secret? ");
        String userChoice = keyboard.nextLine();
        secret = generateSecret();
        if(userChoice.charAt(0) == 'n') {
        } else {
           // System.out.print("Enter secret: ");
          //  secret = keyboard.next().toUpperCase();
            System.out.println(secret);
        }


        String [] history_guess_word = new String [6];
        int[] usage = new int[26];
        StringBuilder guess_word = new StringBuilder();


        for (int round = 1; round <= 6; round++) {
            System.out.println("Round "+ round + ". Enter guess: ");
            guess = keyboard.next().toUpperCase();


            while (guess.length() != 5 ){
                System.out.println("Invalid Guess");
                System.out.println("Round "+ round + ". Enter guess: ");
                guess = keyboard.next().toUpperCase();
            } // end of the while loop to check length of the guess word

            while (!checkValidity(guess) ){
                System.out.println("No such a word");
                System.out.println("Round "+ round + ". Enter guess: ");
                guess = keyboard.next().toUpperCase();
            } // end of the while loop to check length of the guess word


            String result = "";


            for (int i = 0; i < guess.length(); i++) {
                if (guess.charAt(i) == secret.charAt(i)){
                    result = result + "H";
                } else if ( secret.indexOf( guess.charAt(i)) != - 1)   {
                    result = result + "m";
                } else {
                    result = result + "_";
                }

            } //end of for loop

            history_guess_word [round-1] = result;

            if (result.equals("HHHHH")) {
                System.out.println( guess + ": " + result);
                System.out.println("You've got it right. ");
                break;
            }else{

                for (int i = 0; i < round;i++){
                    //System.out.println(guess + ": " + history_guess_word [i]);


                }
            }
            guess_word.append(guess + ": " + history_guess_word [round-1] + "\n");
            System.out.println(guess_word.toString());
            update( usage, guess, result );
        } // end of second for loop

        System.out.println("The secret was " + secret);
    } //end of main

    public static void update( int[] usage, String guess, String result) {
        int MUST_USE = 1;
        int MUST_NOT_USE = 2;
        int MAY_USE = 0;

//        String must_use[] = new String[5];
//        String not_use[] = new String[26];
        char theLetters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//these check all the letters in the alphabet


        // checking guess with secret to find which letters are MUST
        for (int i = 0; i < guess.length(); i++) {
            char character = guess.charAt(i);
            char character2 = result.charAt(i);
            int p = character - 'A';
            if ( character2 == 'H' ) { //needs to update the code
                usage[p] = MUST_USE; //this updates the variables
            }
            else if ( character2 == 'm') {
                usage[p] = MUST_USE; //this updates the variables

            }
            else if ( character2 == '_') {
                usage[p] = MUST_NOT_USE; //this updates the variables

            }
        }
        //NOT USE for loop
        // MUST_USE
        System.out.print( "MUST USE: ");
        for(int i = 0; i < usage.length; i++){ //checks the length of the guess to make sure that it matches
            if ( usage[i] == MUST_USE ) {
                System.out.print( theLetters[i] );

            }
        }
        System.out.println();

        System.out.print("MUST NOT USE: ");


        for (int i = 0; i <usage.length; i++) { //CREATE NOT USE
            if ( usage[i] == MUST_NOT_USE) {
                System.out.print(theLetters[i]);
            }
        }
        System.out.println();

        System.out.print("MAY USE: ");
        for (int i = 0; i < usage.length; i++) { //may use
            if ( usage[i] == MAY_USE) {
                System.out.print(theLetters[i]);
            }
        }
        System.out.println();
        //nneds another method to check for validity; random selection****************

        //NOW WE NEED TO CREATE FOR LOOP TO CHECK MAY USE


        // create another loop and check the elements inside of must_use with the elements in the guess
        // for each element in guess, if it's not contained within must_use -> if (guess.charAt(i) is not in must_use)


        // if an element is NOT in must_use, but IS in the guess, add it to must_not use

        // if an element is Not in must_use and NOT in the guess, add it to may_use

    }//end of partII method
    public static String generateSecret() {
        int position = (int)(Dictionary.SHORT_LIST.length * Math.random());
        String word = Dictionary.SHORT_LIST[position];
        return word;

    }//end of generateSecret
    public static boolean checkValidity(String guessWord) {
        for (int i = 0; i <Dictionary.LONG_LIST.length ; i++) { //checks to see if it makes an actual word
            if(Dictionary.LONG_LIST[i].equals(guessWord)) { //compares to the guess and if it matches then its a good word
                return true;
            }
        }//end of for loop
        return false;

    }//end CheckValidity

}// end of class

//we need the DIRECTIONALITY and VALIDITY OF THE WORD LIST
