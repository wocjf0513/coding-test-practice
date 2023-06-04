import java.util.Scanner;

public class 구간합구하기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        //m은 변경, k는 구간합 횟수

        
        long[] nList=new long[n+1];
        for(int i=1; i<=n; i++){
            nList[i]=sc.nextLong();
        }
        SegmentTree st=new SegmentTree(n);
        st.init(nList, 1, 1, n);
        

        for(int i=0; i<m+k; i++){
            int a=sc.nextInt();
            if(a==1){
                long b=sc.nextLong();
                long c=sc.nextLong();

                long diff=c-nList[Math.toIntExact(b)];
                nList[Math.toIntExact(b)]=c;

                st.update(1, 1, n, b, diff); 

            }
            if(a==2){
                long b=sc.nextLong();
                long c=sc.nextLong();
                System.out.println(st.sum(1,1,n,b,c));

            }
        }

    }

    static class SegmentTree{
        long[] tree;

        SegmentTree(int size){
            double treeHeight = Math.ceil(Math.log(size)/Math.log(2))+1;
            tree=new long[Math.toIntExact(Math.round(Math.pow(2, treeHeight)))];
        }
        public long init(long[] arr, int node, int start, int end){
            if(start==end){
            return tree[node]=arr[start];       
        }
            else{
                long leftnode=init(arr,node*2,start,(start+end)/2);
                long rightnode=init(arr,node*2+1,(start+end)/2+1,end);
                return tree[node]=leftnode+rightnode;
            }
        }
        public long sum(int node, int start, int end, long left, long right){
            if(right<start || end<left)
            return 0;
            else if(left<=start && end<=right)
            return tree[node];
            else{
                return sum(node*2, start, (start+end)/2, left, right)+sum(node*2+1, (start+end)/2+1, end, left, right);
            }
        }
        public void update(int node, int start, int end, long idx, long diff){
            if(idx<start || end<idx)
            {

            }
            else{
                tree[node]+=diff;
                if(start!=end){
                    update(node*2,start,(start+end)/2,idx,diff);
                    update(node*2+1,(start+end)/2+1,end,idx,diff);
                }
            }
            
        }
    }

    
    
}


