package test.my;

class Main {

    static int[] findUnsortedSubarray(int[] array) {
        if (array.length < 2) {
            return (new int[]{-1, -1});
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                min = Math.min(min, array[i]);
        }
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1])
                max = Math.max(max, array[i]);
        }
        if (min == Integer.MAX_VALUE) {
            return (new int[]{-1, -1});
        }

        int left, right;
        for (left = 0; left < array.length; left++) {
            if (min < array[left])
                break;
        }
        for (right = array.length - 1; right >= 0; right--) {
            if (max > array[right])
                break;
        }
        return (new int[]{left, right});
    }

    public static void main(String[] args) {
    }
}