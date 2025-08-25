 # Overview:
This is a Java console-based word-guessing game inspired by Wordle. The program generates a random
5-letter secret word from a predefined dictionary and challenges the user to guess it within 6 rounds.
After each round, the program provides feedback on which letters are correct and which are misplaced/absent.
Finally, the program will provide a summary of which letters must, must not, or may be used in future guesses.

 # Features:
1) Randomly selects a secret 5-letter word.
2) Validates user guesses (must be 5 letters and in the dictionary)
3) Provides feedback
   H = correct letter in correct position
   m = correct letter in wrong position
   _ = letter not found in the secret word
4) Tracks letter usage across rounds
5) Optional secret reveal for the user
6) Lastly, displays the history

# How to Run the Game?
1) Java must be installed
2) The Dictionary class must have the SHORT_LIST and LONG_LIST in the same folder
3) Compile andrun the script
   
