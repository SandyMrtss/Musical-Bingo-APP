package com.sandy.bingo.unittests.utils;

import com.sandy.bingo.utils.BingoAppUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BingoAppUtilsTest {

    private final static int POINTS_FIRST = 6;
    private final static int POINTS_SECOND = 4;
    private final static int POINTS_THIRD = 3;
    private final static int POINTS_ELSE = 1;
    private final static int POINTS_LINE = 2;

    @ParameterizedTest
    @MethodSource("buildCalculatePoints")
    void testCalculatePoints(Integer position, boolean isLine, Integer expectedPoints){
        assertEquals(expectedPoints, BingoAppUtils.calculatePoints(position, isLine));
    }

    static Stream<Arguments> buildCalculatePoints(){
        return Stream.of(
                Arguments.of(1, true, POINTS_FIRST + POINTS_LINE),
                Arguments.of(1, false, POINTS_FIRST),
                Arguments.of(2, false, POINTS_SECOND),
                Arguments.of(2, true, POINTS_SECOND + POINTS_LINE),
                Arguments.of(3, true, POINTS_THIRD + POINTS_LINE),
                Arguments.of(3, false, POINTS_THIRD),
                Arguments.of(4, false, POINTS_ELSE),
                Arguments.of(6, true, POINTS_ELSE + POINTS_LINE)
        );
    }
}
