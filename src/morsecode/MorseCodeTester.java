/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package morsecode;

import java.io.FileNotFoundException;

/**
 * DRIVE FILR
 * Profesor: A. Wright
 * Programmer: Quang Bui
 */
public class MorseCodeTester {
    public static void main(String[] args) throws FileNotFoundException {
        MorseCode decodeMorse = new MorseCode();
        System.out.println(decodeMorse);
        decodeMorse.menuInterface();
    }
}

/*
run:Menu Options 
	0.  EXIT SYSTEM 
	1.  Input Data from Keyboard. 
	2.  Load Data from File  
		 Select 0 - 2 --> 2
Please enter full Path File Name ---> valid.txt

Answer: IS THAT YOUR FINAL AN

Please enter full Path File Name ---> validdata.txt

Answer: I LOVE PROGRAMMING

 Please enter full Path File Name ---> longString.txt
The Morse Code Message length mustbe in the range [1-240].

 Please enter full Path File Name ---> invaliddata.txt
Data is INVALID.

run:
 This tree has 26 nodes
O	M	Q	G	Z	T	Y	K	C	
N	X	D	B	 	J	W	P	A	
R	L	E	U	F	I	V	S	H	

 Menu Options 
	0.  EXIT SYSTEM 
	1.  Input Data from Keyboard. 
	2.  Load Data from File  
		 Select 0 - 2 --> 1
Enter the Morse Code (only accep the character ' ', '#', '.', '-' and '#'): 
The Morse Code Message length mustbe in the range [1-240].
Enter the Morse Code (only accep the character ' ', '#', '.', '-' and '#'): 
-... ..- - | -... . - - . .-. | - --- | --. . - | .... ..- .-. - |
-... -.-- | - .... . | - .-. ..- - .... | - .... .- -. | -.-. --- 
-- ..-. --- .-. - . -.. | .-- .. - .... | .- | .-.. .. .-... ..- - |
-... . - - . .-. | - --- | --. . - | .... ..- .-. - | -... -.-- | - 
.... . | - .-. ..- - .... | - .... .- -. | -.-. --- -- ..-. --- .-. - 
. -.. | .-- .. - .... | .- | .-.. .. .
The Morse Code Message length mustbe in the range [1-240].
Enter the Morse Code (only accep the character ' ', '#', '.', '-' and '#'):
.Quang.Dave.
Your Morse Code Message is not valid.Can you check and enter again, please: 
Enter the Morse Code (only accep the character ' ', '#', '.', '-' and '#'): 
.. ... |- .... .- - |-.-- --- ..- .-. |..-. .. -. .- .-.. |.- -.
... .-- . .-. #

Answer: IS THAT YOUR FINAL ANSWER
BUILD SUCCESSFUL (total time: 37 seconds)

 Menu Options 
	0.  EXIT SYSTEM 
	1.  Input Data from Keyboard. 
	2.  Load Data from File  
		 Select 0 - 2 --> 1
Enter the Morse Code (only accep the character ' ', '#', '.', '-' and '#'):
.. |.-.. --- ...- . |.--. .-. --- --. #.-. .- -- -- .. -. --. 

Answer: I LOVE PROG
*/