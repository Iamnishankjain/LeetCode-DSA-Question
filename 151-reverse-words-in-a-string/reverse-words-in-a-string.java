class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<String> stack=new Stack<>();
        String str="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==' ' && !str.equals("")){
                stack.push(str);
                str="";
            }
            else if(c!=' '){
                str+=c;
            }
        }
        if(!str.equals(""))
            stack.push(str);
        while(stack.size()!=1){
            sb.append(stack.pop()+" ");
        }
        sb.append(stack.pop());
        return sb.toString();
    }
}