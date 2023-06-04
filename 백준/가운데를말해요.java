import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class 가운데를말해요 {

    public static void main(String[] args) {
        //좌측과 우측을 나눠 숫자를 부를 때마다 좌로 갈지 우로갈지 나눈다.
        //좌측과 우측의 개수를 같게 유지

        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();

        PriorityQueue<Integer> minPQ=new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ=new PriorityQueue<>();
        

        for(int i=0; i<n; i++){
            int temp=sc.nextInt();

            //min의 개수 > max 의 개수 : max에 넣어야 된다.
            //min의 개수 == max 의 개수 : min에 넣어야 된다.
          
        }
    }
    
}
