class Solution {
    private String digits;
    private Map<Integer, List<Character>> digitsMap;
    List<String> ans;
    
    public List<String> letterCombinations(String digits) {
        this.ans = new ArrayList<>();
        if(digits.length() == 0){
            return this.ans;
        }
        this.digits = digits;
        this.digitsMap = new HashMap<>();
        
        int num = 2;
        int c = (int) 'a';
        
        while(num <= 9) {
            if(num == 7 || num == 9) {
                for(int i = 0; i < 4; i++) {
                    
                    this.digitsMap.putIfAbsent(num, new ArrayList<Character>());
                    this.digitsMap.get(num).add((char) c);
                    c++;
                    
                }
            } else {
               for(int i = 0; i < 3; i++) {
                    this.digitsMap.putIfAbsent(num, new ArrayList<Character>());
                    this.digitsMap.get(num).add((char) c);
                    c++;
                }   
            }
            num++;
        }
                
        backtrack(new StringBuilder(), 0);
        
        return this.ans;
    }
    
    private void backtrack(StringBuilder curr, int i) {
        if(i == digits.length()) {
           this.ans.add(curr.toString()); 
            return;
        }
        
        int telNumber = this.digits.charAt(i) - 48;
        System.out.println(telNumber);
        
        for(char c: digitsMap.get(telNumber)) {
            curr.append(c);
            backtrack(curr, i + 1);
            curr.deleteCharAt(curr.length() - 1);   
        }
        
    }
}