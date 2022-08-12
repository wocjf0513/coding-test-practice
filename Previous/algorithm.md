>dynamic algorithm
>>각 단계의 최적의 해가 다음 단계의 최적의 해에 영향을 끼치는 것

</br>

>greedy algorithm
>>각 단계에서 수 많은 선택 중 최적이라 생각하는 선택을 하는 것

</br>

>dfs
>>if(count > minVal) return; //가지치기 - 이미 count가 minVal보다 커졌다면 return; , for 문이 아니어도 dfs 가능
```java
public static void dfs(String source, String target, int count,String[] words){
        if(source==target){
            if(min_search>count)
            min_search=count;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(alpha1(source,words[i]) && !checked[i]){
                checked[i]=true;
                dfs(words[i],target,count+1,words);
                checked[i]=false;
            }

        }
    }
```

</br>


> bfs

```java
public static void bfs(int n,int v, int[][] numbers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()){
            v=queue.poll();
            visited[v]=true;
            for(int i=0; i<n; i++){
                if(numbers[v][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        answer++;
        for(int i=0; i<n; i++){
            if(visited[i]==false)
            bfs(n, i, numbers, visited);
        }
    }
```

</br>

> 2중 배열 sorting
>>
```java
Arrays.sort(time, new Comparator<int[]>(){
         @Override 
         public int compare(int[] o1, int[] o2){
             if(o1[1]==o2[1]) //int[0][1] int[1][1]의 값이 같으면 
                return o1[0] - o2[0];  //int [0][0] int [1][0] 의 값을 비교해서 오름차순 
            else
                return o1[1]-o2[1]; 
        }
    });
```
</br>

> int -> integer, integer -> int
```java
Integer[] b_int=Arrays.stream(b).boxed().toArray(Integer[]::new);
        Arrays.sort(b_int, Comparator.reverseOrder());
        b=Arrays.stream(b_int).mapToInt(j->j).toArray();
```
