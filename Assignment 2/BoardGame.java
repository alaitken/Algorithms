/**
 * @author Austin Aitken (201720943)
 */

//import java.lang.Math;
//import java.util.List;
import java.util.*;

public class BoardGame {

    public BoardGame() {

    }

    /*
    Returns the amount of various move combinations from the starting point of "index"
     */
    public int MoveArraySize(int index) {
        return (GetMoveCombo(index).size());
    }

    /*
    Returns a set of the possible move combinations from the starting position of "x".
    This method assumes the player can only move 1, 2, or 5 spaces per turn.
     */
    public ArrayList<ArrayList<Integer>> GetMoveCombo(int x) {
        ArrayList<ArrayList<Integer>> tempFinalArray = new ArrayList<ArrayList<Integer>>();
        if (x == 0) {
            return tempFinalArray;
        } else if (x == 1) {
            ArrayList<Integer> arrayOfOne = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> arrayOfArrayOfOne = new ArrayList<ArrayList<Integer>>();
            arrayOfOne.add(1);
            arrayOfArrayOfOne.add(arrayOfOne);
            return arrayOfArrayOfOne;
        } else if (x > 1) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            temp = GetMoveCombo(x - 1);
            for (int i = 0; i < temp.size(); i++) {
                boolean inArrayAlready = false;
                ArrayList<Integer> check = new ArrayList<Integer>();
                check.add(1);
                check.addAll(temp.get(i));
                temp = GetMoveCombo(x - 1);
                if (!tempFinalArray.contains(check)) {
                    tempFinalArray.add(check);
                }
                ArrayList<Integer> check2 = new ArrayList<Integer>();
                check2.addAll(temp.get(i));
                check2.add(1);
                if (!tempFinalArray.contains(check2)) {
                    tempFinalArray.add(check2);
                }
            }
            int y = x;
            ArrayList<Integer> twos = new ArrayList<>();
            while ((y % 2 == 0) && (y > 0)) {
                y = y - 2;
                twos.add(2);
            }
            if (twos.size() > 0) {
                tempFinalArray.add(twos);
            }
        }
        if (x > 4) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            temp = GetMoveCombo(x - 1);
            ArrayList<Integer> lastElementOfTemp = new ArrayList<Integer>();
            lastElementOfTemp = temp.get(temp.size() - 1);
            ArrayList<Integer> parsing = new ArrayList<>();
            double q = Math.floor(lastElementOfTemp.size() / 2);
            int r = (int) q;
            for (int i = 0; i < r; i++) {
                parsing.add(lastElementOfTemp.get(i));
            }
            parsing.add(1);
            for (int i = r + 1; i <= lastElementOfTemp.size(); i++) {
                parsing.add(lastElementOfTemp.get(i - 1));
            }
            if (!tempFinalArray.contains(parsing)) {
                tempFinalArray.add(parsing);
            }
            int z = x;
            ArrayList<Integer> fives = new ArrayList<>();
            while ((z % 5 == 0) && (z > 0)) {
                z = z - 5;
                fives.add(5);
            }
            if (fives.size() > 0) {
                tempFinalArray.add(fives);
            }
        }
        return tempFinalArray;
    }

    /*
    Returns the possible move combinations starting from a position of "x". This method takes in
    the possible moves per position on the board instead of fixed values of 1, 2 or 5 like the
    other GetMoveCombo method.
     */
    public ArrayList<ArrayList<Integer>> GetMoveCombo(int x, ArrayList<ArrayList<Integer>> l) {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> tempFinalArray = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < l.get(x).size(); i++) {
            if (l.get(x).get(i) < x) {
                temp = GetMoveCombo((x-(l.get(x).get(i))), l);
                for (int j = 0; j < temp.size(); j++) {
                    ArrayList<Integer> addToFinal = new ArrayList<Integer>();
                    addToFinal.add(l.get(x).get(i));
                    addToFinal.addAll(temp.get(j));
                    tempFinalArray.add(addToFinal);
                }
            }
            else if (l.get(x).get(i) == x) {
                ArrayList<Integer> addToFinal2 = new ArrayList<Integer>();
                addToFinal2.add(l.get(x).get(i));
                tempFinalArray.add(addToFinal2);
            }
        }
        return tempFinalArray;
    }
}
