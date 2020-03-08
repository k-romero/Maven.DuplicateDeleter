package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    Logger logger = Logger.getLogger(IntegerDuplicateDeleter.class.getName());

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }
    public Integer countOccurrences(Integer valueToEvaluate){
        Integer counter = 0;
        for (Integer i : testArray) {
            if (i == valueToEvaluate) {
                counter++;
            }
        }
        return counter;
    }

    Integer[] testArray = Arrays.copyOf(array,array.length);


    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] tempArray = new Integer[array.length];
        int newArrayLength = 0;
        for (Integer i : testArray) {
                                 //if less than amount
            if(countOccurrences(i) < maxNumberOfDuplications){
                tempArray[newArrayLength] = i;
                newArrayLength++;
            }
        }
        Integer[] result = new Integer[newArrayLength];
        for (int i = 0; i < newArrayLength; i++) {
            result[i] = tempArray[i];
        }

        logger.log(Level.INFO, String.valueOf(newArrayLength));
        return result;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] tempArray = new Integer[array.length];
        int newArrayLength = 0;
        for (Integer i : testArray) {
            if(countOccurrences(i) != exactNumberOfDuplications){
                tempArray[newArrayLength] = i;
                newArrayLength++;
            }
        }
        Integer[] result = new Integer[newArrayLength];
        for (int i = 0; i < newArrayLength; i++) {
            result[i] = tempArray[i];
        }

        logger.log(Level.INFO, String.valueOf(newArrayLength));
        return result;
    }
}
