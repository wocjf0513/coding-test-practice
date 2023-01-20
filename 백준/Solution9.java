import java.util.*;

class Solution9 {
    public static int solution(String name) {
        int answer = 0;
        char[] name_arr=name.toCharArray();

        
        for(int i=0; i<name.length(); i++)
        	answer+=minimal(name.charAt(i));
        
        
        
        int position=0;
        boolean exit=true;
        
        while(exit)
        {
        int round_check=0;
        int loop1=0;
        int loop2=0;
        int loop1_i=0;
        int loop2_i=0;

        exit=false;
        
    	for(char n:name_arr)
    		if(n!='A')
    			exit=true;
    		
    	
    	if(exit==false)
    		break;
    	
    	//Aüũ 
    	
    	
        for(int i=position; i<name.length(); i++)
        {
        	if(name_arr[i]!='A')
        	{
        		loop1_i=i;
        		break;
        	}
        	if(round_check==1&&i==position)
        		break;
      

        	if(i==name.length()-1)
        	{
        		i=-1;	
        		round_check=1;
        	}
        	
        	loop1++;
        	
        }
        
        round_check=0;
     
        
        for(int i=position; i>=0; i--)
        {

    		
        	if(name_arr[i]!='A')
        	{
        		loop2_i=i;
        		break;
        		
        	}
        	
        	if(round_check==1&&i==position)
        		break;
        	

        	if(i==0)
        	{
        		i=name.length(); 
        		round_check=1;
        	}
        	

        	if(i==0)
        	{
        		i=name.length(); 
        		round_check=1;
        	}
        	
        	loop2++;
        }  
        if(loop1<=loop2)
        {
        	answer+=loop1;
        	position=loop1_i;
        }
        else {
        	answer+=loop2;
        	position=loop2_i;
        }
        
        name_arr[position]='A';
        for(char n:name_arr)
        	System.out.print(n);
        System.out.println(" :"+position);
      
        }
         
        

        
        
        
        
        return answer;
        
    } //JAAZAE JAZAAE
    public static int minimal(char c) {
    	int temp1=0;
    	int temp2=1;
    	char[] alpha=new char[] {'A','B','C','D','E','F','G','H','I','J','K','L',
    			'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    	for(int i=0; i<alpha.length; i++) {
    		if(alpha[i]==c)
    			break;
    		else
    			temp1++;
    	}
    	for(int i=alpha.length-1; i>=0; i--) {
    		if(alpha[i]==c)
    			break;
    		else
    			temp2++;
    	}
    	
    	if(temp1<temp2)
    		return temp1;
    	else
    		return temp2;
    	}

    
    public static void main(String[] args) {
    	System.out.print(
    	    	solution("BBAABAAAAB"));
    }
}