
import java.util.LinkedList;
import java.util.Queue;

public class BST {

    class Node {

        private int number;
        private Node left, right;

        public Node(int number) {
            this.number = number;
            left = right = null;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BST() {
        root = null;
    }

    public void insert(int number) {
        root = insert(root, number);
    }

    public Node insert(Node root, int number) {
        if (root == null) {
            root = new Node(number);
            return root;
        } else if (number < root.number) {
            root.left = insert(root.left, number);
        } else if (number > root.number) {
            root.right = insert(root.right, number);
        } else {
            //do nothing if they are equals
        }
        return root;
    }

    public void inOrder() {
        if (root != null) {
            inOrder(root);
            System.out.println("");
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.number + " ");
            inOrder(root.right);
        }
    }

    public void preOrder() {
        if (root != null) {
            preOrder(root);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.number + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void height() {
        if (root != null) {
            System.out.print("Height:");
            System.out.println(height(root));
        }
    }

    public int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            int lDepth = height(root.left);
            int rDepth = height(root.right);

            /* use the larger one */
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    public void width() {
        if (root == null) {
            System.out.println("error");
            return;
        }
        System.out.print("Width:");
        System.out.println(width(root));
    }

    public int width(Node root) {
        if (root == null) {
            return 0;
        }
        int maxwidth = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            maxwidth = Math.max(maxwidth, count);

            while (count-- > 0) {
                Node temp = q.remove();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return maxwidth;
    }

    public void LeavesAsc() {
        if (root != null) {
            System.out.print("LeavesAsc:");
            LeavesAsc(root);
            System.out.println("");
        }
    }

    public void LeavesAsc(Node root) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.number + " ");
            return;
        }
        if (root.left != null) {
            LeavesAsc(root.left);
        }
        if (root.right != null) {
            LeavesAsc(root.right);
        }

    }

    public void insertH(int left, int right) {
        root = insertH(root, left, right);
        System.out.print("A full BST created with elements:");
        inOrder();
    }

    public Node insertH(Node root, int left, int right) {//left is 1 right is 15
        if (left > right) {//left start index right greateset integer
            return root;
        }
        int middle = (left + right) / 2;
        root = insert(root, middle);
        root.left = insertH(root.left, left, middle - 1);
        root.right = insertH(root.right, middle + 1, right);
        return root;
    }

    public int findMin(Node root) {
        while (root.left!=null)
            root=root.left;
        return root.number;
    }

    public void delete(int number) {
        root = delete(root, number);

    }

    public Node delete(Node root, int number) {
        if (root == null) {
            return root;
        }
        if (number < root.number) {
            root.left = delete(root.left, number);
        } else if (number > root.number) {
            root.right = delete(root.right, number);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.number = findMin(root.right);
            root.right = delete(root.right, root.number);
        }
        return root;
    }

}
