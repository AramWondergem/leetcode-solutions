class Solution {
    private int[] barPrefix; 
    public int maximizeSweetness(int[] sweetness, int k) {
        barPrefix = new int[sweetness.length];
        int left = Integer.MAX_VALUE;
        int right = 1;
        int lastSum = 0;

        for(int i = 0; i < sweetness.length; i++) {
            int chunk = sweetness[i];
            right += chunk;
            left = Math.min(left,chunk);
            barPrefix[i] = lastSum + chunk;
            lastSum += chunk;
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(check(k + 1, mid)){
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }

        return right;
        
    }

    private boolean check(int numOfPieces, int min) {

        int valuePreviousChunks = 0;

        for(int i = 0; i < barPrefix.length; i++) {
            int chunk = barPrefix[i] - valuePreviousChunks;

            if(chunk >= min) {
                numOfPieces--;
                valuePreviousChunks += chunk;
            }

            if(numOfPieces > barPrefix.length - i - 1) {
                return false;
            }

        }

        return true;

    }
}