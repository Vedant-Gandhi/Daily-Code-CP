import java.util.LinkedList;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N
 * A P L S I I G
 * Y I R
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * @author Vedant-Gandhi
 * 
 *         Issues
 *         Does not work for row Number = 1
 *         Happy to receive fixes
 */

class Problem2 {
    public String convert(String s, int numRows) {

        // The rows of the matrix as linkedlist
        LinkedList<Character>[] rows = new LinkedList[numRows];

        int strLen = s.length(), ctr = 0;

        // The queue to store the next row.
        LinkedList<LinkedList<Character>> queue = new LinkedList<>();

        // Add all the rows at start to queue
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new LinkedList<>();
            queue.addLast(rows[i]);
        }

        // Loop until all characters of string are not processed
        while (ctr != strLen) {

             // If  the queue is empty so once again add all the rows from start.
             if (queue.isEmpty()) {
                System.out.println("Inside queue empty");
                for (int i = 1; i < rows.length; i++)
                    queue.addLast(rows[i]);
            }

            // Get the front of queue
            LinkedList<Character> top = queue.pollFirst();
            // Add the current character at that row.
            top.addLast(s.charAt(ctr));
            ctr++;

            // Detect if the top row is the last row.If it is add the previous rows
            if (top == rows[rows.length - 1]) {
                for (int i = rows.length - 2; i >= 0; i--) {
                    queue.addLast(rows[i]);
                }
                continue;
            }

           

        }

        // Now collect the string

        StringBuilder sbr = new StringBuilder(s.length());

        for (int i = 0; i < numRows; i++) {
            for (Character ch : rows[i]) {
                sbr.append(ch);
            }
        }

        return sbr.toString();
    }

    public static void main(String[] args) {
        Problem2 pb = new Problem2();
        System.out.println("Result is :" + pb.convert("PAYPALISHIRING", 4));
    }
}