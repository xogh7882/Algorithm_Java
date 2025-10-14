class Solution {
    static int[] answer;
    static int maxNum = -1;
    static int maxPrice = -1;
    static int emoNum;
    static int arr[];

    public int[] solution(int[][] users, int[] emoticons) {
        arr = new int[emoticons.length];
        emoNum = emoticons.length;
        subset(0, users, emoticons);
        answer = new int[2];
        answer[0] = maxNum;
        answer[1] = maxPrice;
        return answer;
    }

    private static void subset(int cnt, int[][] users, int[] emoticons){
        if(cnt==emoNum){
            check(users, emoticons);
            return;
        }

        for(int i=10;i<=40;i=i+10){
            arr[cnt] = i;
            subset(cnt+1, users, emoticons);
            arr[cnt] = -1;
        }
    }

    private static void check(int[][] users, int[] emoticons){
        int price = 0;
        int num = 0;
        double calc = 0;

        for(int i=0;i<users.length;i++){
            calc = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[j] >= users[i][0]) {
                    double k = (arr[j] / 100.0);
                    calc += (emoticons[j] * (1-k));
                }
            }
            if(calc >= users[i][1]) num++;
            else price+=calc;
        }

        if(num > maxNum){
            maxNum = num;
            maxPrice = price;
        }
        else if(num == maxNum){
            if(price > maxPrice){
                maxPrice = price;
            }
        }
        else return;
    }
}