package structures.trees._234;

import java.io.IOException;
import java.util.Scanner;

public class Tree234Runner {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        long value;
        Tree234<Integer> theTree = new Tree234();
        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);
        while(true)
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, or find: ");
            switch(getChoice())
            {
                case "show":
                    theTree.displayTree();
                    break;
                case "insert":
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert((int) value);
                    break;
                case "find":
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find((int) value);
                    if(found != -1)
                        System.out.println("Found "+value);
                    else
                        System.out.println("Could not find "+value);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    public static String getChoice() throws IOException
    {
        return in.next();
    }

    public static int getInt() throws IOException
    {
        return in.nextInt();
    }
}
