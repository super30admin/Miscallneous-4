class Pair{
    char ch;
    int count;
    Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}

/*
TC: O(n), where n is length of string
SC :O(n), used to save chars in stack
    */
class Solution {
    public String removeDuplicates(String s, int k) {
        
        if(s.length() == 0 || s == null){
            return null;
        }
        
        // System.out.println("here");
        Stack<Pair> stack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(new Pair(ch, 1));
            }
            else{
                //check top char, if same increment its count and if >= k delete it
                if(ch == stack.peek().ch){
                    // System.out.println("here");
                    int curr = stack.peek().count;
                    if(curr+1 >= k){
                        stack.pop();
                    }
                    else{
                        curr += 1;
                        stack.peek().count = curr;
                    }
                    
                }else{
                    stack.push(new Pair(ch, 1));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair p  = stack.pop();
            int count = p.count;
            char ch = p.ch;
            while(count >0 ){
                sb.append(ch);
                count--;
            }
        }
        String res = sb.reverse().toString();
        return res;
    }
}