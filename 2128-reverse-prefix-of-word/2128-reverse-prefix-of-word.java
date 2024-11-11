// lower levelcase English letters, string, 1 <= word.lenght <= 250
// char also lowercase

// the part inclusive until char turned around

//turn string into charArray
//find the char
// two pointer change if char is there
// otherwise return string



class Solution {
    public String reversePrefix(String word, char ch) {
        if(word.length() == 1) {
            return word;
        }

        char[] w = word.toCharArray();
        int left = 0;
        int right = -1;
        
        for(int i = 0; i < w.length; i++) {
            if(w[i] == ch) {
                right = i;
                break;
            }
        }

        if(right == -1) {
            return word;
        }

        while(left < right) {
            char c = w[right];
            w[right] = w[left];
            w[left] = c;
            left++;
            right--;
        }

        return new String(w);
    }
}