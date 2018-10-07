package stringorarray;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MissingNumbersFromArray {

    public void findMissingNumbers(int n, int[] input){
        ReferenceNumber[] referenceNumbers = new ReferenceNumber[n+1];
        for (int i = 0; i <= n; i++) {
            referenceNumbers[i] = new ReferenceNumber(i,false);
        }

        for (int i = 0; i < input.length; i++) {
            if(input[i] == referenceNumbers[input[i]].value) {
                referenceNumbers[input[i]].visited = true;
            }
        }

        System.out.println(Arrays.stream(referenceNumbers).filter(referenceNumber -> !referenceNumber.visited).map(referenceNumber -> referenceNumber.value).collect(Collectors.toList()));
    }

    class ReferenceNumber {
        int value;
        boolean visited;

        public ReferenceNumber(int value, boolean visited) {
            this.value = value;
            this.visited = visited;
        }
    }

    public static void main(String[] args) {
        MissingNumbersFromArray missingNumbersFromArray = new MissingNumbersFromArray();
        int[] input = {2,3,4};
        missingNumbersFromArray.findMissingNumbers(10,input);
    }

}
