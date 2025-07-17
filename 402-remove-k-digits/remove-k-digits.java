class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        StringBuilder ans=new StringBuilder();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<num.length();i++){
            int val=num.charAt(i)-'0';

            while(!stack.isEmpty() && stack.peek()>val && k!=0){
                stack.pop();
                k--;
            }
            stack.push(val);
        }

        while(k!=0){
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }
        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        return ans.length()==0 ? "0" : ans.toString();
    }
}