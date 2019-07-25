/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package decision;

import java.io.FileNotFoundException;

/**
 * DRIVE FILR
 * Profesor: A. Wright
 * Programmer: Quang Bui
 */
public class BackPainAnalyzer {
    public static void main(String[] args) throws FileNotFoundException {
        //DecisionTree expert = new DecisionTree("question.txt");
        DecisionTree expert = new DecisionTree();
        System.out.println(" This tree has " + expert.size() + " nodes\n"
              + expert);
        expert.evaluate();
    }
}
