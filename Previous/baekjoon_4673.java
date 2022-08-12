import java.util.*;




class baekjoon_4673{

	public static void main(String args[]){

		Stack<Integer> stack=new Stack<>();
		int temp=0;
		while(true){
			if(gernerator(temp)<=20000)
				stack.push(gernerator(temp));
			else
				break;

			temp++;
		}

		temp=0;
		while(temp<=10000)
		{
			if(stack.search(temp)==-1)
			System.out.println(temp);
			temp++;
		}

	}

	public static int gernerator(int source){

		int result_num=source;
		String s=Integer.toString(source);
		for(char a:s.toCharArray()){
			result_num+=a-'0';
		}
		return result_num;
	}


}
