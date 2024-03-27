import java.util.*;
import java.util.stream.Stream;

public class 뉴스클러스터링 {

    class Solution {

        HashMap<String, Integer> matrix1 = new HashMap<>();
        HashMap<String, Integer> matrix2 = new HashMap<>();

        int interSection = 0;
        int conjunctiveSet = 0;
        int answer = 0;
        int MULTIPLY_HELPER = 65536;

        public int solution(String str1, String str2) {

            str1 = str1.toUpperCase();
            str2 = str2.toUpperCase();

            transferStrToMatrix(matrix1, str1);
            transferStrToMatrix(matrix2, str2);

            Set<String> interSectionSet = new HashSet<>();

            matrix1.keySet().stream().forEach(key -> {
                interSection += Math.min(matrix1.get(key), matrix2.getOrDefault(key, 0));
                if(matrix2.containsKey(key)) {
                    conjunctiveSet += Math.max(matrix1.get(key), matrix2.getOrDefault(key, 0));
                    interSectionSet.add(key);
                } else {
                    conjunctiveSet += matrix1.get(key);
                }
            });

            matrix2.keySet().stream().forEach(key -> {
                if(!interSectionSet.contains(key)) {
                    conjunctiveSet += matrix2.get(key);
                }
            });

            if(interSection == 0 && conjunctiveSet == 0) {
                return MULTIPLY_HELPER;
            }

            answer = (int)(((double)interSection / conjunctiveSet) * MULTIPLY_HELPER);

            return answer;
        }
        public void transferStrToMatrix(HashMap<String, Integer> matrix, String str) {
            for(int i=0; i<str.length()-1; i++) {
                if(isAlphabat(str.charAt(i)) && isAlphabat(str.charAt(i+1))){
                    String splitStr = ""+ str.charAt(i) + str.charAt(i+1);
                    matrix.put(splitStr, matrix.getOrDefault(splitStr, 0) + 1);
                }
            }
        }
        public boolean isAlphabat(char c) {
            return 'A' <= c && c <= 'Z';
        }
    }
}
