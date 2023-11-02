package HexletExcersises.Arrays.ShipsGame;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

class Main {
    public static void main(String[] args) {

        int[][] battleField1 = {};
        System.out.println(calcShipsCount(battleField1));

        int[][] battleField2 = {{1}};
        System.out.println(calcShipsCount(battleField2));

        int[][] battleField3 = {{0}};
        System.out.println(calcShipsCount(battleField3));

        int[][] battleField4 = {
                {0, 0, 1},
                {0, 0, 0},
                {1, 1, 0},
        };
        System.out.println(calcShipsCount(battleField4));

        int[][] battleField5 = {
                {1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 0, 0},
        };
        System.out.println(calcShipsCount(battleField5));

        /*int[][] battleField11 = {}; System.out.println(isValidField(battleField11));
        int[][] battleField12 = {
                                    {0, 1, 0, 0},
                                    {1, 0, 0, 1},
                                    {0, 0, 0, 0},
                                    {0, 1, 1, 1},
        }; System.out.println(isValidField(battleField12));
        int[][] battleField13 = {
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 1},
        }; System.out.println(isValidField(battleField13));
        int[][] battleField14 = {
                {1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 0, 0},
        }; System.out.println(isValidField(battleField14));*/
        int[][] battleField15 = {
                {1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 1},
                {0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
        }; System.out.println(isValidField(battleField15));


    }

    public static int calcShipsCount(int[][] field) {
        int count = 0;
        for (int row = 0; row < field.length; row++) {
            if (ArrayUtils.contains(field[row], 1)) {
                for (int position = 0; position < field[row].length; position++) {
                    if (field[row][position] == 1 && row == 0 && position == 0) {
                        count = count + 1;
                    } else if (field[row][position] == 1 && row == 0 && position > 0) {
                        count = (field[row][position - 1] == 1) ? count : count + 1;
                    } else if (field[row][position] == 1 && row > 0 && position == 0) {
                        count = (field[row - 1][position] == 1) ? count : count + 1;
                    } else if (field[row][position] == 1 && row > 0 && position > 0) {
                        count = (field[row][position - 1] == 1 || field[row - 1][position] == 1) ? count : count + 1;
                    }
                }
            }
        }
        return count;
    }

    public static boolean isValidField(int[][] field) {
        int row = 0;
        boolean noNearShip = true;
        for (row = 1; row < field.length; row++) {
            if (ArrayUtils.contains(field[row], 1)) {
                for (int position = 0; position < field[row].length; position++) {
                    if (field[row][position] == 1 && position == 0) {
                        noNearShip = (field[row - 1][position + 1] != 1);
                    } else if (field[row][position] == 1 && position > 0 && position < field[row].length - 1) {
                        noNearShip = (field[row - 1][position + 1] != 1 || field[row - 1][position - 1] != 1);
                    } else if (field[row][position] == 1 && position == field[row].length - 1) {
                        noNearShip = (field[row - 1][position - 1] != 1);
                    }

                    if (!noNearShip) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}