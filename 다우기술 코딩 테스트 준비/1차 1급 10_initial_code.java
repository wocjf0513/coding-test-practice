class Solution10 {
    class Pair{
        public int firstNum;
        public int secondNum;
    }
    
    public int func_a(int numA, int numB, char exp){
        if (exp == '+')
            return numA + numB;
        else if (exp == '-')
            return numA - numB;
        else
            return numA * numB;
    }
    
    public int func_b(String exp){
        for(int i = 0; i < exp.length(); i++){
            char e = exp.charAt(i);
            if(e == '+' || e == '-' || e == '*')
                return i;
        }
        return -1;
    }
    public Pair func_c(String exp, int idx){
        Pair ret = new Pair();
        ret.firstNum = Integer.parseInt(exp.substring(0, idx));
        ret.secondNum = Integer.parseInt(exp.substring(idx + 1));
        return ret;
    }
    
    public int solution(String expression) {
        int expIndex = func_b(expression);
        Pair numbers = func_c(expression,expIndex);
        int result = func_a(numbers.firstNum,numbers.secondNum,expression.charAt(expIndex));
        return result;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution10 sol = new Solution10();
        String expression = "123+12";
        int ret = sol.solution(expression);

        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}