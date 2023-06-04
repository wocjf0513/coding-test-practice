import java.util.*;



public class baekjoon_1002{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int loop=in.nextInt();
		int x1,y1,d1;
		int x2,y2,d2;
		int distance;

		int[] list=new int[loop];

		for(int i=0; i<loop; i++){

			x1=in.nextInt();
			y1=in.nextInt();
			d1=in.nextInt();
			x2=in.nextInt();
			y2=in.nextInt();
			d2=in.nextInt();

			distance=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
			
			if(distance>(d1+d2)*(d1+d2))
			list[i]=0;//원이 만나지 않는 경우
			else if(distance==(d1+d2)*(d1+d2))
			list[i]=1;//원이 외접하는 경우
			else if((d1-d2)*(d1-d2)<distance&&distance<(d1+d2)*(d1+d2))
			list[i]=2;//원이 내부 두점에서 만나는 경우
			else if((d1-d2)*(d1-d2)==distance)
			list[i]=1;//원이 내접하는 경우
			else if((d1-d2)*(d1-d2)>distance)
			list[i]=0;//원이 외부에서 만나지 않는 경우
			else
			list[i]=-1;

			if(x1==x2 && y1==y2 && d1==d2)
				list[i]=-1;
				//같은 원인 경우 
		}
		for(int i:list){
			System.out.println(i);
		}
		in.close();
	}







}
