import java.util.logging.Handler;

public class 우선순위큐2 {

    static int max=1000;
    static int que[]=new int[max];
    static int heapSize=0;


    static void add(int item){
        if(heapSize==1000){
            System.out.println("Full");
            return;
        }

        int current=heapSize;
        que[heapSize]=item;
        heapSize++;

        while(0<=current && current<=heapSize && 0<=(current-1)/2 && (current-1)/2 <=heapSize){
            if(que[current]<que[(current-1)/2]){
            int tempN=que[current];
            que[current]=que[(current-1)/2];
            que[(current-1)/2]=tempN;
            current=(current-1)/2;
            }
            else{
                return;
            }
        }

    }
    static int poll(){
        if(heapSize==0){
            System.out.println("Empty");
            return -1;
        }

        int top=que[0];
        que[0]=que[heapSize-1];
        int current=0;
        heapSize--;

        while(0<=current && current<=heapSize && 0<=current*2+1 && current*2+1 <=heapSize){
            int child=0;
            if(0<=current*2+2 && current*2+2<=heapSize){
                if(que[current]>que[current*2+1])
                child=current*2+1;
                if(que[child]>que[current*2+2])
                child=current*2+2;
            }
            else{
                if(que[current]>que[current*2+1])
                child=current*2+1;
            }
            if(child==0){
            return top;
            }
            else{
                int tempN=que[current];
                que[current]=que[child];
                que[child]=tempN;
                current=child;
            }
        }
        return top;


    }
    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(-4);
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
    }
    
}
