public class TreeIsPostorder {
    public static void main(String[] args) {

    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 1) {
            return true;
        }
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int start, int end) {
        if (start <= end) {
            return true;
        }
        int root = postorder[end];
        int mid = 0;
        for (int i = 0; i < end - 1; i++) {
            if (postorder[i] > root) {
                mid = i;
                break;
            }
        }
        for (int i = mid; i < end; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        return recur(postorder, start, mid - 1) && recur(postorder, mid, end - 1);

    }

}