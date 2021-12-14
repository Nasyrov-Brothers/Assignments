import java.util.Arrays;

public class Latest24HourTime {
    /**
     * Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
     * 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59.
     * The earliest 24-hour time is 00:00, and the latest is 23:59.
     * Return the latest 24-hour time in "HH:MM" format.  If no valid time can be made, return an empty string.
     * Example 1:
     * Input: arr = [1,2,3,4]
     * Output: "23:41"
     * Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14",
     * and "23:41". Of these times, "23:41" is the latest.
     * Example 2:
     * Input: arr = [5,5,5,5]
     * Output: ""
     * Explanation: There are no valid 24-hour times as "55:55" is not valid.
     * Example 3:
     * Input: arr = [0,0,0,0]
     * Output: "00:00"
     * Example 4:
     * Input: arr = [0,0,1,0]
     * Output: "10:00"
     * Constraints:
     * arr.length == 4
     * 0 <= arr[i] <= 9
     */

    public static void main(String[] args) {
        Latest24HourTime assignment = new Latest24HourTime();
        int[] numbers = {1, 2, 3, 4};
        System.out.println(Arrays.toString(numbers) + " => " + assignment.getLatestTime(numbers));
        numbers = new int[] {5, 5, 5, 5};
        System.out.println(Arrays.toString(numbers) + " => " + assignment.getLatestTime(numbers));
        numbers = new int[] {0, 0, 0, 0};
        System.out.println(Arrays.toString(numbers) + " => " + assignment.getLatestTime(numbers));
        numbers = new int[] {0, 0, 1, 0};
        System.out.println(Arrays.toString(numbers) + " => " + assignment.getLatestTime(numbers));
        numbers = new int[] {1, 2, 1, 2};
        System.out.println(Arrays.toString(numbers) + " => " + assignment.getLatestTime(numbers));
    }

    public String getLatestTime(int[] array) {
        int[] time = {-1, -1, -1, -1};
        for (int i = 0; i < array.length; i++) {
            if (time[0] < array[i] && array[i] <= 2 && array[i] != -1) {
                int temp = array[i];
                array[i] = time[0];
                time[0] = temp;
            }

            if (time[1] < array[i] && array[i] <= 3 && array[i] != -1) {
                int temp = array[i];
                array[i] = time[1];
                time[1] = temp;
            }

            if (time[2] < array[i] && array[i] <= 5 && array[i] != -1) {
                int temp = array[i];
                array[i] = time[2];
                time[2] = temp;
            }

            if (time[3] < array[i] && array[i] <= 9 && array[i] != -1) {
                int temp = array[i];
                array[i] = time[3];
                time[3] = temp;
            }
        }
        if (Arrays.toString(time).contains("-1")) {
            return "";
        }
        return "" + time[0] + time[1] + ":" + time[2] + time[3];
    }

}
