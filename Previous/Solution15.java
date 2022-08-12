class Solution15 {
    public static int solution(String skill, String[] skill_trees) {
    	
        int answer = 0;
        int present=0;
        int temp=0;
        for(int i=0; i<skill_trees.length; i++) {
        	temp=0;
        	present=0;
        	for(int j=0; j<skill_trees[i].length(); j++) {
        		if(skill.indexOf(skill_trees[i].charAt(j))!=-1) {
    				present=skill.indexOf(skill_trees[i].charAt(j));
    				if(present==temp)
    					temp++;
    				else
    					break;
        		}
        		if(j==skill_trees[i].length()-1)
        			answer++;
        	}
        }
        return answer;
    }
    public static void main(String args[]) {
    	solution("CBD",	new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }
}