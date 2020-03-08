package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    Logger logger = Logger.getLogger(StringDuplicateDeleter.class.getName());


    String[] testArray = Arrays.copyOf(array,array.length);

    public Integer countOccurrences(String valueToEvaluate){
        Integer counter = 0;
        for (String i : testArray) {
            if (i.equals(valueToEvaluate)) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] tempArray = new String[array.length];
        int newArrayLength = 0;
        for (int i = 0; i < array.length; i++) {
            int occurrences = countOccurrences(array[i]);
            if(occurrences < maxNumberOfDuplications){
                tempArray[newArrayLength] = array[i];
                newArrayLength++;
            }
        }
        String[] result = new String[newArrayLength];
        for (int i = 0; i < newArrayLength; i++) {
            result[i] = tempArray[i];
        }
        return result;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] tempArray = new String[array.length];
        int newArrayLength = 0;
        for (int i = 0; i < array.length; i++) {
            int occurrences = countOccurrences(array[i]);
            if(occurrences != exactNumberOfDuplications){
                tempArray[newArrayLength] = array[i];
                newArrayLength++;
            }
        }
        String[] result = new String[newArrayLength];
        for (int i = 0; i < newArrayLength; i++) {
            result[i] = tempArray[i];
        }
        return result;
    }
}
