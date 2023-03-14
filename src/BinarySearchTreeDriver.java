import org.w3c.dom.ls.LSOutput;

public class BinarySearchTreeDriver {
    public static void main(String[] args) {
        BinarySearchTree<Integer,Integer> tree = new BinarySearchTree<Integer, Integer>();
        // testing the isEmpty method when the BST is empty
        System.out.println(tree.isEmpty()); // should print true
        // testing the put method
        tree.put(1,10);
        tree.put(2,20);
        tree.put(3,30);
        // testing the get method
        System.out.println(tree.get(1)); // should print 10
        System.out.println(tree.get(4)); // should print null
        // testing the size method
        System.out.println(tree.size()); // should print 3
        // testing the min and max methods
        System.out.println(tree.min()); // should print 1
        System.out.println(tree.max()); // should print 3
        // testing the remove method
        System.out.println(tree.remove(1)); // should return 10
        System.out.println(tree.remove(2)); // should return 20
        // seeing if the remove method works and the size method
        System.out.println(tree.size()); // should print 1
        // testing the contains method
        System.out.println(tree.contains(3)); // should print true
        System.out.println(tree.contains(1)); // should print false
    }
}
