class Solution {
    public int getVal(char ch){

        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    public int romanToInt(String s) {
        int num=0;
        for(int i=0;i<s.length()-1;i++){
            int prev=getVal(s.charAt(i));
            int next=getVal(s.charAt(i+1));
            if(prev>=next){
                num+=prev;
            }
            else{
                num-=prev;
            }
        }
        num+=getVal(s.charAt(s.length()-1));
        return num;
    }
}