class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        generate(list,"",n);
        return list;
    }
    public void generate(List<String> list,String s,int n){
        if(n*2==s.length()){
            if(valid(s))
                list.add(s);
            return;
        }
        generate(list,s+"(",n);
        generate(list,s+")",n);
    }
    public boolean valid(String str){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push('(');
            }
            else if(str.charAt(i)==')' && stack.isEmpty()){
                return false;
            }
            else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}