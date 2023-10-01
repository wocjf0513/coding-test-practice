//양, 음수 상관없이 절대값으로 결과 출력
//우선순위는 두 개 이상의 연산자가 같은 우선순위를 가질 수는 없다.
//expresion의 길이는 100이하 문자열, 최대 49개의 연산자
//결과값은 최대 2^63-1 -> long으로

//연산자는 총 3개, 우선순위는 최대 3!=6가지 조합이 가능
//문제는 저장구조를 어떻게 설계할 것인가.
//StringBuilder replace를 사용한다.


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {

    char[] exp={'*','+','-'};
    long max=0;
    public long solution(String expression) {

        ArrayList<String> exp=new ArrayList<>();

        Deque<Character> que=new LinkedList<>();

        int curIdx=0;

        for(int i=0; i<expression.length(); i++){
            if(Character.isDigit(expression.charAt(i))){
                que.add(expression.charAt(i));
            }
            else{
                StringBuilder sb=new StringBuilder();
                while(!que.isEmpty()){
                    sb.append(que.poll());
                }
                exp.add(sb.toString());
                exp.add(Character.toString(expression.charAt(i)));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!que.isEmpty()){
            sb.append(que.poll());
        }
        exp.add(sb.toString());

        dfs(exp,new boolean[3]);


        return max;
    }
    public void dfs(ArrayList<String> exp,boolean[] check){
        if(exp.size()<=1){
            max=Math.max(Math.abs(Long.parseLong(exp.get(0))),max);
            return;
        }
        for(int i=0; i<3; i++){
            if(!check[i]){
                check[i]=true;
                dfs(cal(exp,i),check);
                check[i]=false;
            }
        }
    }
    public ArrayList<String> cal(ArrayList<String> expression, int idx){
        ArrayList<String> newExp=new ArrayList<>(expression);
        for(int i=0; i<newExp.size(); i++){
            if(newExp.get(i).equals(Character.toString(exp[idx]))){
                long result;
                switch (exp[idx]){
                    case '*':
                        result=Long.parseLong(newExp.get(i-1))*Long.parseLong(newExp.get(i+1));

                        for(int c=0; c<3; c++)
                            newExp.remove(i-1);

                        newExp.add(i-1,Long.toString(result));
                        i-=1;
                        break;
                    case '+':
                        result=Long.parseLong(newExp.get(i-1))+Long.parseLong(newExp.get(i+1));

                        for(int c=0; c<3; c++)
                            newExp.remove(i-1);

                        newExp.add(i-1,Long.toString(result));
                        i-=1;
                        break;
                    case '-':
                        result=Long.parseLong(newExp.get(i-1))-Long.parseLong(newExp.get(i+1));

                        for(int c=0; c<3; c++)
                            newExp.remove(i-1);

                        newExp.add(i-1,Long.toString(result));
                        i-=1;
                        break;
                }
            }
        }
        return newExp;
    }


    public static void main(String[] args) {
        Solution sol=new Solution();
        System.out.println(sol.solution("50*6-3*2"));
    }
}