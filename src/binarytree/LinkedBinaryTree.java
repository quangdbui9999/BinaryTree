/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package binarytree;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DRIVE FILR
 * Profesor: A. Wright
 * Programmer: Quang Bui
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T>{
    public BinaryTreeNode<T> root;
    protected int modCount;

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree(){
        root = null; // empty tree
        modCount = 0; // set count to 0
    }
    
    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the binary tree
     */
    public LinkedBinaryTree(T element){
        root = new BinaryTreeNode<T>(element);
        modCount = 1;
    }
    
    /**
     * Creates a binary tree with the specified element as its root and the 
     * given trees as its right child
     *
     * @param element the element that will become the root of the binary tree
     * @param right the right subtree of this tree
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> right){
        root = new BinaryTreeNode<T>(element);
        root.setRight(right.root);
        modCount = 3;
    }
    
    /**
     * Creates a binary tree with the specified element as its root and the 
     * given trees as its left child and right child
     *
     * @param element the element that will become the root of the binary tree
     * @param left the left subtree of this tree
     * @param right the right subtree of this tree
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, 
            LinkedBinaryTree<T> right){
        root = new BinaryTreeNode<T>(element);
        root.setLeft(left.root);
        root.setRight(right.root);
        modCount = 3;
    }
    
    /**
     * Returns a reference to the node at the root
     *
     * @return a reference to the specified node
     * @throws EmptyCollectionException if the tree is empty
     */
    protected BinaryTreeNode<T> getRootNode() throws EmptyCollectionException{
        if(root == null){
            throw new EmptyCollectionException("Empty Tree");
        }
        return root;
    }
    
    /**
     * Returns a reference to the element at the root
     *
     * @return a reference to the specified target
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T getRootElement() throws EmptyCollectionException{
        if(root == null){
            throw new EmptyCollectionException("Empty Tree");
        }
        return root.getElement();
    }
    
    /**
     * Returns the left subtree of the root of this tree.
     *
     * @return a link to the left subtree fo the tree
     */
    public LinkedBinaryTree<T> getLeft(){
        if(root == null){
            throw new EmptyCollectionException("Empty Tree. No Left Child");
        }
        
        LinkedBinaryTree<T> result = new LinkedBinaryTree();
        result.root = root.getLeft();
        return result;
    }
    
    /**
     * Returns the right subtree of the root of this tree.
     *
     * @return a link to the right subtree of the tree
     */
    public LinkedBinaryTree<T> getRight(){
        if(root == null){
            throw new EmptyCollectionException("Empty Tree. No Left Child");
        }
        
        LinkedBinaryTree<T> result = new LinkedBinaryTree();
        result.root = root.getRight();
        return result;
    }

    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Returns the integer size of this tree.
     *
     * @return the integer size of the tree
     */
    @Override
    public int size() {
        return (root.numChildren());
    }
    
    /**
     * Returns the height of this tree.
     *
     * @return the height of the tree
     */
    public int getHeight(){
        return height(root);
    }
    
    /**
     * Returns the height of the specified node.
     *
     * @param node the node from which to calculate the height
     * @return the height of the tree
     */
    private int height(BinaryTreeNode<T> node){
        if(node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight > rightHeight){
            return (leftHeight + 1);
        }else{
            return (rightHeight + 1);
        }
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     */
    public BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next){
        if(next == null){
            return null;
        }
        
        if(next.getElement().equals(targetElement)){
            return next;
        }
        
        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());
        
        if(temp == null){
            temp = findNode(targetElement, next.getRight());
        }
        return temp;
    }
    
    /**
     * Returns true if this tree contains an element that matches the
     * specified target element and false otherwise.
     *
     * @param targetElement the element being sought in this tree
     * @return true if the element in is this tree, false otherwise
     */
    @Override
    public boolean contains(T targetElement) {
        boolean itsHere = true;
        BinaryTreeNode<T> current = findNode(targetElement, root);
        
        if(current == null){
            itsHere = false;
        }
        return itsHere;
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.  Throws a ElementNotFoundException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if the element is not in the tree
     */
    @Override
    public T find(T targetElement) {
        BinaryTreeNode<T> current = findNode(targetElement, root);
        
        if(current == null){
            throw new ElementNotFoundException("LinkedBinaryTree");
        }
        return (current.getElement());
    }

    /**
     * Returns a string representation of this binary tree showing
     * the nodes in an inorder fashion.
     *
     * @return a string representation of this binary tree
     */
    public String toString(){
        String treeList = "";
        int countGetLine = 0;
        Iterator<T> iter = iterator();
        while(iter.hasNext()){
            countGetLine++;
            treeList += iter.next() + "\t";
            if(countGetLine % 9 == 0 && countGetLine != 0){
                treeList += "\n";
            }
        }
        return treeList;
    }
    
    @Override
    public Iterator<T> iterator() {
        return iteratorinOrder();
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList){
        if(node != null){
            inOrder(node.getLeft(), tempList);
            tempList.addToRear(node.getElement());
            inOrder(node.getRight(), tempList);
        }
    }
    
    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with
     * the root.
     *
     * @return an in order iterator over this binary tree
     */
    @Override
    public Iterator<T> iteratorinOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList){
        if(node != null){
            tempList.addToRear(node.getElement());
            preOrder(node.getLeft(), tempList);
            preOrder(node.getRight(), tempList);
        }
    }
    
    /**
     * Performs an preorder traversal on this binary tree by calling 
     * an overloaded, recursive preorder method that starts with
     * the root.
     *
     * @return a pre order iterator over this tree
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void postOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList){
        if(node != null){
            postOrder(node.getLeft(), tempList);
            postOrder(node.getRight(), tempList);
            tempList.addToRear(node.getElement());
        }
    }
    
    /**
     * Performs an postorder traversal on this binary tree by calling
     * an overloaded, recursive postorder method that starts
     * with the root.
     *
     * @return a post order iterator over this tree
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        postOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a levelorder traversal on this binary tree, using a
     * templist.
     *
     * @return a levelorder iterator over this binary tree
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<BinaryTreeNode<T>> nodes = 
                new ArrayUnorderedList<BinaryTreeNode<T>>();
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        BinaryTreeNode<T> current;
        
        nodes.addToRear(root);
        
        while(!nodes.isEmpty()){
            current = nodes.removeFirst();
            
            if(current != null){
                tempList.addToRear(current.getElement());
                if(current.getLeft() != null){
                    nodes.addToRear(current.getLeft());
                }
                if(current.getRight() != null){
                    nodes.addToRear(current.getRight());
                }
            }else{
                tempList.addToRear(null);
            }
        }
        return new TreeIterator(tempList.iterator());
    }
    
    /**
     * Inner class to represent an iterator over the elements of this tree
     */
    private class TreeIterator implements Iterator<T>{
        private int expectedModCount;
        private Iterator<T> iter;
        
        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a tree traversal
         */
        public TreeIterator(Iterator<T> iter){
            this.iter = iter;
            expectedModCount = modCount;
        }
        
        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException{
            if(!(modCount == expectedModCount)){
                throw new ConcurrentModificationException();
            }
            return (iter.hasNext());
        }
        
        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws NoSuchElementException{
            if(hasNext()){
                return (iter.next());
            }else{
                throw new NoSuchElementException();
            }
        }
        
        /**
         * The remove operation is not supported.
         * 
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
