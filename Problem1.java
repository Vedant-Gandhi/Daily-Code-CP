import java.util.ArrayList;
import java.util.List;

/**
 * @author Vedant-Gandhi
 * @version 1.0
 */

/**
 * Problem Statement
 * This problem was asked by Twitter.
 * 
 * You are given an array of length 24, where each element represents the number
 * of new subscribers during the corresponding hour. Implement a data structure
 * that efficiently supports the following:
 * 
 * update(hour: int, value: int): Increment the element at index hour by value.
 * query(start: int, end: int): Retrieve the number of subscribers that have
 * signed up between start and end (inclusive).
 */

class AbstractDS {
    int[] data;

    AbstractDS(int[] array) {
        this.data = array.clone();
    }

    public void update(int hour, int value) {
        this.data[hour - 1] += value;
    }

    public List<Integer> query(int start, int end) {
        List<Integer> returnList = new ArrayList<>();
        for (int i = start - 1; i <= end - 1; i++) {
            returnList.add(this.data[i]);
        }
        return returnList;
    }

}