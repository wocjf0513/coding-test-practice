public class Programmers_makebigInteger {
    public static void main(String args[]){
        System.out.println(solution("999",2));

    }
    public static String solution(String number, int k) {
        String new_str=number;
        StringBuilder sb;
        sb=new StringBuilder(new_str);
        int del_idx;
        for(int i=0; i<k; i++){
            del_idx=sb.length()-1;
            for(int j=0; j<sb.length(); j++){
                if(j==sb.length()-1)
                break;
                if(sb.charAt(j)<sb.charAt(j+1)){
                    del_idx=j;
                    break;
                }
            }
            sb.deleteCharAt(del_idx);
        }
        return sb.toString();
    }
}
