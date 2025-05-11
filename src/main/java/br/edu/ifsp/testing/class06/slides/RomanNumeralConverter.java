package br.edu.ifsp.testing.class06.slides;

import java.util.Map;

public class RomanNumeralConverter {
    private static final Map<Character, Integer> table = Map.of(
            'I', 1,'V', 5, 'X', 10,'L', 50,
            'C', 100,'D', 500, 'M', 1000
    );

    public int convert(String numberInRoman) {
        int finalNumber = 0;
        int lastNeighbor = 0;  //A
        //          a                            b       g
        for(int i = numberInRoman.length() - 1; i >= 0; i--) {
            int current = table.get(numberInRoman.charAt(i)); //c

            int multiplier = 1;  //c
                    //d                     e
            if(current < lastNeighbor) multiplier = -1;

            finalNumber += current * multiplier; // f
            lastNeighbor = current;
        }
        // h
        return finalNumber;
    }
}
