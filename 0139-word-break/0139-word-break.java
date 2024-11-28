class Solution {
    TreeNode root;
    Map<Integer, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.root = new TreeNode();
        this.memo = new HashMap<>();
        this.memo.put(s.length(), true);

        for(String str : wordDict){
            addWord(str);
        }

        return checkIfContainsWord(0,s);


    }

    private boolean checkIfContainsWord(int index, String s){
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        
        TreeNode curr = root;
        for(int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!curr.nei.containsKey(c)) {
                this.memo.put(index, false);
                return false;
            }
            curr = curr.nei.get(c);
            if(curr.isWord) {
                if(checkIfContainsWord(i + 1, s)){
                    this.memo.put(index, true);
                    return true;
                }
            }
        }

        this.memo.put(index,false);
        return false;
    }

    

    private void addWord(String str) {
        TreeNode curr = root;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            curr.nei.putIfAbsent(c, new TreeNode());
            curr = curr.nei.get(c);
        }

        curr.isWord = true;
    }
}

class TreeNode{
    Map<Character, TreeNode> nei;
    boolean isWord;

    public TreeNode() {
        nei = new HashMap<>();
    }
}