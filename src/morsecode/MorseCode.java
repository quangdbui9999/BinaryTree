/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package morsecode;

import binarytree.LinkedBinaryTree;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: 
 */
public class MorseCode{
    private LinkedBinaryTree<String> tree;
    private final static String DOT = ".";
    private final static String DASH = "-";
    private final static String SPACE = " ";
    private final static String VERTICAL_BAR = "|";
    private final static String NUMBER_SIGN = "#";
    
    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: LinkedBinaryTree<T> class must be defined
     * Post-condition: construct a binary tree following the standard
     * of Morse Code Messages rule.
     */
    public MorseCode() {
        String root = " ";
        String t = "T";
        String e = "E";
        String m = "M";
        String n = "N";
        String a = "A";
        String i = "I";
        String o = "O";
        String g = "G";
        String k = "K";
        String d = "D";
        String w = "W";
        String r = "R";
        String u = "U";
        String s = "S";
        String q = "Q";
        String z = "Z";
        String y = "Y";
        String c = "C";
        String x = "X";
        String b = "B";
        String j = "J";
        String p = "P";
        String l = "L";
        String f = "F";
        String v = "V";
        String h = "H";
        
        LinkedBinaryTree<String> aa, bb, cc, dd, ee, ff, gg, hh, ii, 
                jj, dashh, not, kk, ll, mm, nn, question, dotLink,
                oo, pp, qq, rr, ss, tt, uu, vv, ww, xx, yy, zz;
        
        oo = new LinkedBinaryTree<>(o);
        
        qq = new LinkedBinaryTree<>(q);
        zz = new LinkedBinaryTree<>(z);
        gg = new LinkedBinaryTree<>(g, qq, zz);

        yy = new LinkedBinaryTree<>(y);
        cc = new LinkedBinaryTree<>(c);
        kk = new LinkedBinaryTree<>(k, yy, cc);

        xx = new LinkedBinaryTree<>(x);
        bb = new LinkedBinaryTree<>(b);
        dd = new LinkedBinaryTree<>(d, xx, bb);

        jj = new LinkedBinaryTree<>(j);
        pp = new LinkedBinaryTree<>(p);
        ww = new LinkedBinaryTree<>(w, jj, pp);

        ll = new LinkedBinaryTree<>(l);
        rr = new LinkedBinaryTree<>(r, ll);

        ff = new LinkedBinaryTree<>(f);
        uu = new LinkedBinaryTree<>(u, ff);

        vv = new LinkedBinaryTree<>(v);
        hh = new LinkedBinaryTree<>(h);
        ss = new LinkedBinaryTree<>(s, vv, hh);

        mm = new LinkedBinaryTree<>(m, oo, gg);

        nn = new LinkedBinaryTree<>(n, kk, dd);
        aa = new LinkedBinaryTree<>(a, ww, rr);
        ii = new LinkedBinaryTree<>(i, uu, ss);
        tt = new LinkedBinaryTree<>(t, mm, nn);
        ee = new LinkedBinaryTree<>(e, aa, ii);

        tree = new LinkedBinaryTree<>(root, tt, ee);
    }
    
    /**
     * Accessor: size()
     * @return the number of objects in the tree
     * Pre-condition: none
     * Post-condition: return the number of objects in the tree
     */
    public int size(){
        return tree.size();
    }
    
    /**
     * Accessor: toString()
     * @return the number of objects in the tree
     * Pre-condition: size() method is defined
     * Post-condition: output the tree in form of iteratorinOrder
     */
    public String toString(){
        String showNodes = "";
        showNodes += " This tree has " + size() + " nodes\n";
        showNodes += tree;
        return showNodes;
    }
    
    /**
     * Mutator method: loadDataFromFile()
     * Pre-condition: checkEachCharacter(data) and 
     * checkLengthMorseCode(data) must be defined
     * Post-condition: load the data value from file with fileName is
     * entered by programmers
     */
    private void loadDataFromFile(){
        Scanner cin = new Scanner(System.in);
        Path myFile;
        String fName;
        do {
            System.out.print(" Please enter full Path File Name ---> ");
            fName = cin.nextLine();
            myFile = Paths.get(fName);
            
            if (!Files.exists(myFile)) {
                System.out.println("File NOT found ... ");
            }
        } while (!Files.exists(myFile));
        
        try {
            Scanner input = new Scanner(myFile);
            
            while (input.hasNext()) {
                String data = input.nextLine();
                
                if(!checkEachCharacter(data)){
                    System.out.println("Data is INVALID.");
                    System.exit(0);
                }else if(!checkLengthMorseCode(data)){
                    System.out.println("The Morse Code Message length must"
                        + "be in the range [1-240].");
                    System.exit(0);
                }else{
                    this.displayResult(data);
                }
            }
            input.close();
            System.out.println(" \nData Successfully Read "
                    + "Data from File " + fName);
        } catch (IOException | NoSuchElementException e) {
            System.out.println("Invalid data in File ... "
                    + "closing program.");
            System.exit(0);
        }
    }
    
    /**
     * Mutator: removeRedundantSpace(String s)
     * @param s the string need to be remove the redundant space
     * @return the String with removed the space that beginning
     * and ending and redundant space between two words of String
     * Pre-condition: none
     * Post-condition: return the String with removed the space that 
     * beginning and ending and redundant space between two 
     * words of String
     */
    private String removeRedundantSpace(String s){
        try{
            // delete all space character at beginning and ending string
            s = s.trim();
            
            // delete two space characters consecutive
            while(s.lastIndexOf("  ") != -1){
                s = s.replaceAll("  ", " ");
            }
            
            return s;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    /**
     * mutator menuInterface() 
     * Provide the user/client with options menu to select from 
     * preconditions: inputManager(option) method must be defined 
     * postconditions: displays menu options,
     * exits on command
     */
    public void menuInterface() {
        int option = 0;
        Scanner cin = new Scanner(System.in);
        
        boolean isValidData = false;

        while (isValidData == false) {
            try {
                do {
                    System.out.println(" Menu Options "
                            + "\n\t0.  EXIT SYSTEM "
                            + "\n\t1.  Input Data from Keyboard. "
                            + "\n\t2.  Load Data from File  ");
                    System.out.print("\t\t Select 0 - 2 --> ");

                    option = Integer.parseInt(cin.nextLine());
                    
                    /**
                     * we need to be sure the input is between 0 .. 2
                     */
                    inputManager(option);
                } while (option != 0);
                isValidData = true;
            } catch (NumberFormatException e) {
                System.err.println("Input is not a valid integer "
                        + "data type.");
                System.err.println("The exception message is:"
                        + " " + e.getMessage());
            }
        }
    }

    /**
     * Mutator Method: inputManager(int input)
     * @param input select from the menu to implement the case
     * Pre-condition: none
     * Post-condition: Programmers will select the function of application 
     * from Menu and implement each case that Programmers selected
     */
    private void inputManager(int input) {
        switch (input) {
            case 0:
                break;
            case 1:
                this.inputKeyboard();
                break;
            case 2:
                this.loadDataFromFile();
                break;
            default:
                System.out.println(" Invalid input, try again!");
                break;
        }
    }
    
    /**
     * Accessor: checkEachCharacter(String str)
     * Pre-condition: none
     * Post-condition: return true if the Morse Code Message is only
     * contain the NUMBER_SIGN, SPACE, VERTICAL_BAR, DASH, DOT character;
     * otherwise return false
     * @param str The encoded Morse Code Message
     * @return true if the Morse Code Message is only
     * contain the NUMBER_SIGN, SPACE, VERTICAL_BAR, DASH, DOT character;
     * otherwise return false
     */
    private boolean checkEachCharacter(String str){
        boolean isValidCharacter = false;
        int count = 0;
        
        for(int i = 0; i < str.length(); i++){
            String c = Character.toString(str.charAt(i));
            if(!(c.equalsIgnoreCase(NUMBER_SIGN) 
                    || c.equalsIgnoreCase(DASH)
                    || c.equalsIgnoreCase(DOT)
                    || c.equalsIgnoreCase(SPACE)
                    || c.equalsIgnoreCase(VERTICAL_BAR))){
                count++;
            }
        }
        
        if(count <= 0){
            isValidCharacter = true;
        }else{
            isValidCharacter = false;
        }
        
        return isValidCharacter;
    }
    
    /**
     * Accessor: checkLengthMorseCode(String str)
     * Pre-condition: none
     * Post-condition: return true if the length of str is [1-240];
     * otherwise return false
     * @param str The encoded Morse Code Message
     * @return true if the length of str is [1-240]
     * otherwise return false
     */
    private boolean checkLengthMorseCode(String str){
        boolean isValidLength = false;
        
        if(0 < str.length() && str.length() <= 240){
            isValidLength = true;
        }else{
            isValidLength = false;
        }
        
        return isValidLength;
    }
    
    /**
     * Mutator method: inputKeyboard()
     * Pre-condition: evaluate(whatString, height) and
     * removeRedundantSpace(whatString) methods
     * must be defined. Method checkEachCharacter(data) and 
     * checkLengthMorseCode(data) must be defined
     * Post-condition: enter the String Morse Code Message from the
     * keyboard. You must enter the Morse Code Message (encoded),
     * if you enter invalid Morse code, you enter again until
     * you enter right Morse Code
     */
    private void inputKeyboard(){
        Scanner cin = new Scanner(System.in);
        String str = "";
        do{
            System.out.print("Enter the Morse Code (only accep the "
                + "character ' ', '#', '.', '-' and '#'): ");
            str = cin.nextLine();
            if(!this.checkEachCharacter(str)){
                System.out.println("Your Morse Code Message is not valid."
                        + "Can you check and enter again, please: ");
            }
            if(!this.checkLengthMorseCode(str)){
                System.out.println("The Morse Code Message length must"
                        + "be in the range [1-240].");
            }
        }while(!(this.checkEachCharacter(str) && this.checkLengthMorseCode(str)));
        this.displayResult(str);
    }
    
    /**
     * Mutator method: decodeMorse(String str, int count, LinkedBinaryTree current)
     * Pre-condition: none
     * Post-condition: return The Morse Code Message has been decoded
     * by using recursion with base case is str.length() <= (count)
     * @param str the encoded Morse code 
     * @param count the index in of each character of encoded Morse code 
     * @param current using to move the tree to left or right depend on
     * the encoded Morse code 
     * @return The Morse Code Message has been decoded
     */
    private String decodeMorse(String str, int count, LinkedBinaryTree current){
        String out = "";
        if(str.length() <= (count) || str.length() == 0){
            out += current.getRootElement();
        }else{
            String c = Character.toString(str.charAt(count));
            if(c.equalsIgnoreCase(VERTICAL_BAR)){
                current = tree;
                out += " " + decodeMorse(str, ++count, current);
            }else if(c.equalsIgnoreCase(DASH)){
                out += decodeMorse(str, ++count, current.getLeft());
            }else if(c.equalsIgnoreCase(DOT)){
                out += decodeMorse(str, ++count, current.getRight());
            }else if(c.equalsIgnoreCase(SPACE)){
                current = tree;
                out += decodeMorse(str, ++count, current);
            }
        }
        return out;
    }
    
    /**
     * Mutator method: displayResult(String whatString)()
     * Pre-condition: evaluate(whatString, height) and
     * removeRedundantSpace(whatString) methods
     * must be defined
     * Post-condition: remove the redundant space by using the 
     * removeRedundantSpace(whatString) method, and decoded Morse 
     * Code Message to the screen by using evaluate(whatString, height)
     * method, and then display the decode message to screen
     * @param whatString the String need to be decoded
     */
    private void displayResult(String whatString){
        whatString = removeRedundantSpace(whatString);
        String[] str = whatString.split(" ");
        String result = "";
        
        System.out.print("\nAnswer: ");
        
        // Decoding morse code Message
        int countGetLine = 0;
        boolean checkGetLine = false;
        for(String element : str){
            //System.out.println("element:" + element);
            for(int i = 0; i < element.length(); i++){
                if(Character.toString(element.charAt(i)).
                        equalsIgnoreCase(VERTICAL_BAR)){
                    checkGetLine = true;
                    countGetLine++;
                }
                if(Character.toString(element.charAt(i)).
                        equalsIgnoreCase(NUMBER_SIGN)){
                    System.out.println("");
                    System.exit(0);
                }
            }
            result = decodeMorse(element, 0, tree);
            System.out.print(result);
            if(countGetLine % 9 == 0 && countGetLine != 0 && checkGetLine){
                System.out.println("");
            }
            checkGetLine = false;
        }
        System.out.println("\n\n");
    }
}