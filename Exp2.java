
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author AtakanAYYILDIZ
 */
public class Exp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(args[0])));
            FileOutputStream f = new FileOutputStream(args[1]);
            System.setOut(new PrintStream(f));
        } catch (FileNotFoundException ex) {
            System.out.println("error");
            return;
        }

        BST bst = null;
        while (sc.hasNext()) {
            String array[] = sc.nextLine().split(" ");
            switch (array[0]) {
                case "CreateBST":
                    if (array.length < 2) {//if no numbers entered
                        System.out.println("error");
                        break;
                    }
                    String Stringnumbers[] = array[1].split(",");//parse the string 
                    if (Stringnumbers.length >= 1) {
                        int i = 0;

                        i = 0;
                        bst = new BST();
                        while (i < Stringnumbers.length) {
                            bst.insert(Integer.parseInt(Stringnumbers[i]));
                            i++;
                        }
                        System.out.print("BST created with elements:");
                        bst.inOrder();

                    }
                    break;
                case "CreateBSTH":
                    try {
                        int H = Integer.parseInt(array[1]);
                        if (H < 0) {
                            System.out.println("error");
                            break;
                        }
                        bst = new BST();

                        bst.insertH(1, (int) Math.pow(2, H + 1) - 1);
                    } catch (Exception e) {
                        System.out.println("error");
                    }

                    break;
                case "FindHeight":
                    if (bst != null && bst.getRoot() != null) {
                        bst.height();
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "FindWidth":
                    if (bst != null && bst.getRoot() != null) {
                        bst.width();
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Preorder":
                    if (bst != null && bst.getRoot() != null) {
                        System.out.print("Preorder:");
                        bst.preOrder();
                        System.out.println("");
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "LeavesAsc":
                    if (bst != null && bst.getRoot() != null) {
                        bst.LeavesAsc();
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "DelRoot":
                    if (bst == null || bst.getRoot() == null) {
                        System.out.println("error");
                    } else {
                        try {
                            int number = bst.getRoot().getNumber();
                            bst.delete(number);
                            System.out.println("Root Deleted:" + number);
                        } catch (Exception e) {
                            System.out.println("error");
                            break;
                        }
                    }
                    break;
                case "DelRootLc":
                    if (bst == null || bst.getRoot() == null) {
                        System.out.println("error");
                    } else {
                        try {
                            int number = bst.getRoot().getLeft().getNumber();
                            bst.delete(number);
                            System.out.println("Left Child of Root Deleted:" + number);
                        } catch (Exception e) {
                            System.out.println("error");
                            break;
                        }
                    }
                    break;
                case "DelRootRc":
                    if (bst == null || bst.getRoot() == null) {
                        System.out.println("error");
                    } else {
                        try {
                            int number = bst.getRoot().getRight().getNumber();
                            bst.delete(number);
                            System.out.println("Right Child of Root Deleted:" + number);
                        } catch (Exception e) {
                            System.out.println("error");
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
