package com.sandy.bingo.utils;

public class BingoAppUtils {

    private final static int POINTS_FIRST = 6;
    private final static int POINTS_SECOND = 4;
    private final static int POINTS_THIRD = 3;
    private final static int POINTS_ELSE = 1;
    private final static int POINTS_LINE = 2;

    public static Integer calculatePoints(Integer position, boolean isLine){
        int totalPoints;
        if(position > 3) {
            totalPoints = POINTS_ELSE;
        }
        else if (position == 1){
            totalPoints = POINTS_FIRST;
        }
        else if(position == 2){
            totalPoints = POINTS_SECOND;
        }
        else {
            totalPoints = POINTS_THIRD;
        }
        if(isLine){
            totalPoints += POINTS_LINE;
        }
        return totalPoints;
    }
}
