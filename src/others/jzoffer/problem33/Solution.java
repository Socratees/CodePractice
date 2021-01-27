package others.jzoffer.problem33;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verify(postorder, 0, postorder.length - 1);
    }

    public boolean verify(int[] seq, int start, int end) {
        if (end <= start) {
            return true;
        }
        int i = start, j = end - 1;
        while (i < end && seq[i] < seq[end]) {
            i++;
        }
        while (j >= start && seq[j] > seq[end]) {
            j--;
        }
        if (i < j) {
            return false;
        }
        return verify(seq, start, i - 1) && verify(seq, j + 1, end - 1);

    }
}
