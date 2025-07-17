class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(stack.isEmpty() || asteroids[i]>0 || stack.peek()<0){
                stack.push(asteroids[i]);
            }
            else{
                if(Math.abs(stack.peek())==Math.abs(asteroids[i])){
                    stack.pop();
                }
                else if(Math.abs(stack.peek())>Math.abs(asteroids[i])){
                    continue;
                }
                else{
                    while(!stack.isEmpty() && stack.peek()>0 && Math.abs(stack.peek())<Math.abs(asteroids[i])){
                        stack.pop();
                    }
                    i--;
                }
            }
        }
        int arr[]=new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            arr[i]=stack.pop();
        }
        return arr;
    }
}