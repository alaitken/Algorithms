/**
 * @author Austin Aitken (201720943)
 */

import java.util.Scanner;
//import java.util.List;
import java.util.*;

public class BoardGameApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoardGame game = new BoardGame();
        System.out.println("What position would you like to start from? Please enter a non-negative whole number");
        int index = scanner.nextInt();
        /*
        This block of code tests the GetMoveCombo functionality with fixed values of 1, 2, or 5 as well as the
        MoveArraySize method.
        */
        System.out.println("The following is the set of possible move combinations:\n");
        ArrayList<ArrayList<Integer>> moveSet = new ArrayList<ArrayList<Integer>>();
        moveSet = game.GetMoveCombo(index);
        System.out.println(moveSet + "\n");
        System.out.println("The set size is: " + game.MoveArraySize(index) + "\n");

        /*
        This block of code tests the GetMoveCombo when the possible moves are given in a
        sequence.
        */
        ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> x0 = new ArrayList<Integer>();
        x.add(x0);
        ArrayList<Integer> x1 = new ArrayList<Integer>();
        x1.add(1);
        x.add(x1);
        ArrayList<Integer> x2 = new ArrayList<Integer>();
        x2.add(1);
        x2.add(2);
        x.add(x2);
        ArrayList<Integer> x3 = new ArrayList<Integer>();
        x3.add(1);
        x3.add(3);
        x.add(x3);
        ArrayList<Integer> x4 = new ArrayList<Integer>();
        x4.add(1);
        x.add(x4);
        ArrayList<Integer> x5 = new ArrayList<Integer>();
        x5.add(2);
        x5.add(4);
        x.add(x5);
        System.out.println("Now to test the MoveCombo method with specific possible moves from each position\n");
        System.out.println("The following is the set of moves from each position: " + x + "\n");
        System.out.println("The following are the possible set of moves from the chosen position: " + game.GetMoveCombo(index, x));

    }
}
