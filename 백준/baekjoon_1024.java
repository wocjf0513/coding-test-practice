
import java.util.*;


public class baekjoon_1024{

	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		String str=in.nextLine();
		int count;
		if(str=="")
		count=0;
		else count=1;

		for(char c:str.toCharArray())
		{
			if(c==' ')
				count++;
		}
		if(str.charAt(0)==' ')
			count--;
		if(str.charAt(str.length()-1)==' ')
			count--;
		System.out.print(count);
	}

}
