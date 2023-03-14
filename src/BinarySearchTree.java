public class BinarySearchTree <Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {
        root = null;
    }

    public int size() {
        return size(root);
    }

    //use Node's recursive size
    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            int print = 1 + size(x.getLeft()) + size(x.getRight());
            return print;
        }
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val) {
        if (n == null){ // creating an if statement to see if n is null
            return new Node<>(key,val,1); // making a new node with the size of 1
        }
        if (n.getKey().compareTo(key) > 0){ // if the key is positive
            n.setLeft(put(n.getLeft(),key,val)); // setting to left
        } else if (n.getKey().compareTo(key) < 0){ // of the key is negative
            n.setRight(put(n.getRight(),key,val));{ // setting to right
            }
        } else {
            return n; // otherwise returning n
        }
        return n; // returning n
    }

    //recursive get wrapper
    public Value get(Key key) {
        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        if (n == null){ // creating an if statement if null
            return null; // returning null
        } else if (n.getKey().compareTo(key) == 0){ // if the key is 0
            return n.getValue(); // getting the value
        } else if (n.getKey().compareTo(key) > 0){ // if the key is positive
            return get(n.getRight(),key); // setting right
        } else if (n.getKey().compareTo(key) < 0){ // if the key is negative
            return get(n.getLeft(),key); // setting left
        }
        return null; // returning null otherwise
    }

    public boolean contains(Key key) { // creating a contains method
        return this.get(key) != null; // returning the key if not null
    }

    public Value remove(Key key) { // remove method
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) { // creating a remove method with keys and values
        if (n == null) return null; // if n is null, returning null
        int i = key.compareTo(n.getKey()); // setting i
        if (i < 0) { // is negative
            n.setLeft(remove(n.getLeft(), key)); // removing left
        } else if (i > 0) { // if positive
            n.setRight(remove(n.getRight(), key)); // removing right
        } else { // otherwise
            if (n.getRight() == null) return n.getLeft(); // returning null
            if (n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        if (n.getLeft() == null){ // if the left is null
            return n; // returning null
        } else { // otherwise
            return this.min(n.getLeft()); // returning the left side
        }
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
        if (n.getRight() == null){ // if the right is null
            return n; // return n
        } else { // otherwise
            return this.max(n.getRight()); // return the right
        }
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());

    }
}