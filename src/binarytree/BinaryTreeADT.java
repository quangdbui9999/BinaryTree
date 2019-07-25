/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package binarytree;

import java.util.Iterator;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: 
 */
public interface BinaryTreeADT<T> {
    
    /**
     * Return a reference to the root element
     * @return a reference to the root element
     */
    public T getRootElement();
    
    /**
     * Return true if this binary tree is empty and false otherwise
     * @retrun true if this binary tree is empty and false otherwise
     */
    public boolean isEmpty();
    
    /**
     * Return the number of elements in this binary tree
     * @return the number of elements in the tree
     */
    public int size();
    
    /**
     * Return true if the binary tree contains an element that matches
     * the specified element and false otherwise
     * @param targetElement the element being sought in the tree
     * @return true if the tree contains the target element
     */
    public boolean contains(T targetElement);
    
    /**
     * Return a reference to the specified element if it is found in
     * this binary tree. Throws an exception if the specified element
     * is not found
     * @param targetElement the element being sought in the tree
     * @return a reference to a the the specified element
     */
    public T find(T targetElement);
    
    /**
     * Return the string representation of this binary tree
     * @return a string representation of the binary tree
     */
    public String toString();
    
    /**
     * Return an iterator over the element of this binary tree
     * @return an iterator over the element of this binary tree
     */
    public Iterator<T> iterator();
    
    /**
     * Return an iterator that represents an inorder traversal on the binary
     * tree
     * @return an iterator over the element of this binary tree
     */
    public Iterator<T> iteratorinOrder();
    
    /**
     * Return an iterator that represents a preorder traversal on the binary
     * tree
     * @return an iterator over the element of this binary tree
     */
    public Iterator<T> iteratorPreOrder();
    
    /**
     * Return an iterator that represents a postorder traversal on the binary
     * tree
     * @return an iterator over the element of this binary tree
     */
    public Iterator<T> iteratorPostOrder();
    
    /**
     * Return an iterator that represents a levelorder traversal on the binary
     * tree
     * @return an iterator over the element of this binary tree
     */
    public Iterator<T> iteratorLevelOrder();
}