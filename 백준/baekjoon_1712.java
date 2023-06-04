
import java.util.Scanner;

public class baekjoon_1712{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		Long[] input=new Long[3];
		
		for(int i=0; i<3; i++)
			input[i]=in.nextLong();

		if((input[1]>=input[2]) || input[2]==0)
		System.out.print(-1);
		else{
		Long count;
		count=input[0]/(input[2]-input[1]);
		count+=1;

		System.out.print(count);
		}
	}
}




