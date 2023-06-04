class Programmers_carpet{
    public static void main(String args[]){
        for(int i:solution(10,2))
        System.out.println(i);

    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer=new int[2];
        int i=1;
        
        while(true){
            if(((float)(yellow+brown)/i)==((float)(brown+4-2*i)/2)){
            if(i>(yellow+brown)/i){
            answer[0]=i;
            answer[1]=(yellow+brown)/i;
            }
            else{
                answer[0]=(yellow+brown)/i;
                answer[1]=i;
            }
            break;
            }
            i++;
        }

        return answer;
    }
  
}