import java.util.*;



class Solution21 {
    public static int[] solution(String[] genres, int[] plays) {
        
    	TreeMap<Integer, Integer> play=new TreeMap<>();
    	for(int i=0; i<plays.length; i++) {
    	if(play.containsKey(plays[i]))
    		play.put(plays[i]-1,i);
        else
            play.put(plays[i],i);
    	}
    	Set set=play.descendingKeySet();
    	

        ArrayList<Integer> setlist=new ArrayList<>(set);
        setlist.sort((Object a,Object b)->{if(a==b)return (int)play.get(b)-(int)play.get(a); else return 1;});
        for(Object i:setlist.toArray()) {
        	System.out.println((int) i);
        }
    	
    	//play수 별로 고유 번호 정렬
        //play수는 같을 수 있으므로 수정 바람!
    	
    	HashMap<String,Integer> gen=new HashMap<>();
    	
    	for(int i=0; i<genres.length; i++) {
    	gen.put(genres[i],plays[i]+gen.getOrDefault(genres[i], 0));
    	}
    	//장르별 선호도 조사
    	ArrayList list=new ArrayList(gen.keySet());
    	list.sort((Object a,Object b)->{return gen.get(b)-gen.get(a);});
    	Iterator iter=list.iterator();
    	
    	String temp="";
    	
    	Iterator iter2;
    	ArrayList<Integer> answer=new ArrayList();
    	
    	int temp2=0;
    	int num=0;
    	
    	while(iter.hasNext()) {
            num=0;
    		temp=(String)iter.next();
    		iter2=set.iterator();
    		while(iter2.hasNext()) {
    			if(num==2)
    				break;
    			temp2=play.get(iter2.next());
                
    			if(genres[temp2].equals(temp)) {
    				num++;
    				answer.add(temp2);
    				}
    		}
    	}
    	
    	Integer[] array= answer.toArray(new Integer[answer.size()]);
    	int[] result=Arrays.stream(array).mapToInt(i->i).toArray();
    	
    	return result;

    	
    }
}