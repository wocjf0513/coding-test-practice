public class 우선순위큐{
    static final int maxLen=100;
    static int heapSize=0;
    static int[] heap=new int[maxLen];

    public static void push(int item){
        if(heapSize==100){
            System.out.println("full....");
            return;
        }
        
        int current=heapSize;
        heap[heapSize]=item;
        while(0<=current && current<=heapSize && 0<=(current-1)/2 && (current-1)/2<=heapSize){
            if(heap[(current-1)/2]<heap[current]){
                int temp=heap[current];
                heap[current]=heap[(current-1)/2];
                heap[(current-1)/2]=temp;
                current=(current-1)/2;
            }
            else
            break;
        }
        heapSize+=1;
    }
    public static void poll(){
        if(heapSize==0){
            System.out.println("empty....");
            return ;
        }

        int top=heap[0];
        heap[0]=heap[heapSize];
        heapSize-=1;

        int current=0;

        while(0<=current && current<heapSize && 0<=(current*2)+1 && (current*2)+1<heapSize){
            int child=0;
            if(current*2+2>maxLen){
                child=current*2+1;
            }
            else{
                child=heap[(current*2)+1]>heap[(current*2)+2]?current*2+1:current*2+2;
            }
            if(heap[current]>=heap[child]){
                break;
            }
            int temp=heap[current];
            heap[current]=heap[child];
            heap[child]=temp;
            current=child;
        }
       System.out.println(top);
    }

    public static void main(String[] args) {
        push(3);
        push(4);
        push(5);
        push(1);
        poll();
        poll();
    }

}
