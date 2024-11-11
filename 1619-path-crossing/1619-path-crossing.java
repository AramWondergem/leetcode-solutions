class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int[] coo = new int[2];

        set.add(toHString(coo));

        for(char c : path.toCharArray()){
            move(c, coo);
            String cooS = toHString(coo);
            if(set.contains(cooS)) {
                return true;
            }
            set.add(cooS);
        }
        return false;     
    }

    private void move(char d, int[] coo) {
        switch(d) {
            case 'N' -> coo[0] = coo[0] + 1;
            case 'S' -> coo[0] = coo[0] - 1;
            case 'E' -> coo[1] = coo[1] + 1; 
            case 'W' -> coo[1] = coo[1] - 1;
            default -> throw new IllegalStateException("invalid direction: " + d) ;
        };
    }

    private String toHString(int[] coo) {
        return coo[0] + "," + coo[1];
    }
}