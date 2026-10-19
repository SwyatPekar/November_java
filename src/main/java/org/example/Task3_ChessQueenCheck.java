package org.example;

public class Task3_ChessQueenCheck {

    public static void main(String[] args) {
        String queenPos = "d4";
        String targetPos = "d8";

        int qCol = getFileIndex(queenPos.charAt(0));
        int qRow = getRankIndex(queenPos.charAt(1));

        boolean isWhiteSquare = ((qCol + qRow) % 2 == 0);
        String colorString = isWhiteSquare ? "белая" : "черная";

        int moveCount = 0;

        for (int c = 0; c < 8; c++) {
            for (int r = 0; r < 8; r++) {

                if (c == qCol && r == qRow) {
                    continue;
                }

                if (canQueenReach(qCol, qRow, c, r)) {
                    moveCount++;
                }
            }
        }

        int tCol = getFileIndex(targetPos.charAt(0));
        int tRow = getRankIndex(targetPos.charAt(1));

        boolean hasThreat = canQueenReach(qCol, qRow, tCol, tRow);
        String threatString = hasThreat ? "угроза есть" : "угрозы нет";

        System.out.printf("Ферзь %s, цель %s: %d ходов, цвет %s, %s%n",
                queenPos, targetPos, moveCount, colorString, threatString);
    }

    private static int getFileIndex(char letter) {
        return letter - 'a';
    }

    private static int getRankIndex(char digit) {
        return digit - '1';
    }

    private static boolean canQueenReach(int startC, int startR, int endC, int endR) {
        int diffC = Math.abs(startC - endC); // Разница по горизонтали
        int diffR = Math.abs(startR - endR); // Разница по вертикали


        if (diffC == 0 || diffR == 0 || diffC == diffR) {
            return true;
        } else {
            return false;
        }
    }
}
