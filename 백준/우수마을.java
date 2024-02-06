import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 우수마을 {

    static int numberOfVillage;
    static int[] numberOfPeoleByVillage;
    static ArrayList<Integer>[] villageMap;
    static int[][] maxPeopleByVillage;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        numberOfVillage = Integer.parseInt(br.readLine());
        numberOfPeoleByVillage = new int[numberOfVillage];
        villageMap = new ArrayList[numberOfVillage];
        maxPeopleByVillage = new int[numberOfVillage][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numberOfVillage; i++) {
            numberOfPeoleByVillage[i] = Integer.parseInt(st.nextToken());
            villageMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfVillage - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int village1 = Integer.parseInt(st.nextToken()) - 1;
            int village2 = Integer.parseInt(st.nextToken()) - 1;
            villageMap[village1].add(village2);
            villageMap[village2].add(village1);
        }

        search(0,-1);
        bw.append(Math.max(maxPeopleByVillage[0][1], maxPeopleByVillage[0][0])+"\n");
        bw.flush();
    }
    public static void search(int curVillage, int prevVillage) {

        for (int connectedVillage : villageMap[curVillage]) {
            if (connectedVillage != prevVillage) {
                search(connectedVillage, curVillage);
                maxPeopleByVillage[curVillage][1] += maxPeopleByVillage[connectedVillage][0];
                maxPeopleByVillage[curVillage][0] += Math.max(maxPeopleByVillage[connectedVillage][0],maxPeopleByVillage[connectedVillage][1]);
            }
        }

        maxPeopleByVillage[curVillage][1] += numberOfPeoleByVillage[curVillage];
    }


}
