// Binary Tree Node class
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// Binary Tree class
class BinaryTree {
    Node root;

    // Constructor
    BinaryTree() {
        root = null;
    }

    // Function to insert a new node in the binary search tree
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in the BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        // return the (unchanged) node pointer
        return root;
    }

    // Function to find the minimum value in a binary tree
    int findMin(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int res = node.data;
        int lres = findMin(node.left);
        int rres = findMin(node.right);

        if (lres < res) {
            res = lres;
        }
        if (rres < res) {
            res = rres;
        }

        return res;
    }

    // Function to find the maximum value in a binary tree
    int findMax(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);

        if (lres > res) {
            res = lres;
        }
        if (rres > res) {
            res = rres;
        }

        return res;
    }

    // Function to find the difference between max and min values
    int findMaxMinDifference() {
        int min = findMin(root);
        int max = findMax(root);
        return max - min;
    }

    // Main method
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Let us create following BST
              20
             /  \
            8   22
           / \
          4   12
             /  \
            10  14
        */
        tree.insert(20);
        tree.insert(8);
        tree.insert(22);
        tree.insert(4);
        tree.insert(12);
        tree.insert(10);
        tree.insert(14);

        System.out.println("Difference between maximum and minimum value is: " + tree.findMaxMinDifference());
    }
}
