import java.util.Arrays;

class 양궁대회 {

    public static void main(String[] args) {
        양궁대회 contest = new 양궁대회();
        contest.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});
    }
    int bestDifferenceScore = -1;

    int[] bestLionShootingInfo;
    int maxAvailableShoots;
    int INFO_LENGTH = 11;

    int[] apeechShootingInfo;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        maxAvailableShoots = n;
        apeechShootingInfo = info;
        return answer;
    }

    public void shootAndSaveInfo(int shootingCount, int[] info){
        if(shootingCount == maxAvailableShoots) {
            int differenceScore = scoreInfoWithApeechInfo(info);
            if(bestDifferenceScore <= differenceScore) {
                bestDifferenceScore = differenceScore;
                bestLionShootingInfo = copyInfo(pickBestInfoWithPreviousBestInfo(info));
            }
            return;
        }

        for(int i = 0; i < INFO_LENGTH; i++) {
            info[i] ++;
            shootAndSaveInfo(shootingCount + 1, info);
            info[i] --;
        }
    }
    public int scoreInfoWithApeechInfo(int[] info) {
        int apeechScore = 0;
        int anwerScore = 0;

        for(int i=0; i <INFO_LENGTH; i++) {
            if(apeechShootingInfo[i] != 0 && info[i] !=0) {
                if (apeechShootingInfo[i] >= info[i]) {
                    apeechScore += 10 - i;
                } else {
                    anwerScore += 10 - i;
                }
            }
        }

        return anwerScore - apeechScore;
    }
    public int[] pickBestInfoWithPreviousBestInfo(int[] info) {
        for(int i = INFO_LENGTH - 1; i >= 0; i--) {
            if(info[i] == bestLionShootingInfo[i]) {
                continue;
            } else if(info[i] < bestLionShootingInfo[i]) {
                return bestLionShootingInfo;
            } else {
                return info;
            }
        }
        return bestLionShootingInfo;
    }
    public int[] copyInfo(int[] source) {
        return Arrays.stream(source).toArray();
    }
}