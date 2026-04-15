import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, M;
    static int map[][];
    static int result = 0;
    static int dr[] = {0, -1, 1, 0, 0};
    static int dc[] = {0, 0, 0, 1, -1};

    static class shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static HashMap<Integer, shark> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());  // r
            int c = Integer.parseInt(st.nextToken());  // c
            int s = Integer.parseInt(st.nextToken());  // 속력
            int d = Integer.parseInt(st.nextToken());  // 이동방향


            if (d == 1 || d == 2) {
                s = s % (2 * (R - 1));
            } else {
                s = s % (2 * (C - 1));
            }

            int z = Integer.parseInt(st.nextToken());  // 크기
            hashMap.put(i, new shark(r, c, s, d, z));
            map[r][c] = i;  // 상어 존재
        }


        // 1, 낚시왕이 오른쪽으로 한 칸 이동한다.
        for (int i = 1; i <= C; i++) {

            // 2. 낚시왕이 있는 열에 있는 상어 중에 땅과 제일 가까운 상어를 잡는다.
            for (int j = 1; j <= R; j++) {
                if (map[j][i] != 0) {
                    result += hashMap.get(map[j][i]).z;
                    hashMap.remove(map[j][i]);
                    map[j][i] = 0;
                    break;
                } else continue;
            }
            int newMap[][] = new int[R + 1][C + 1];
            HashSet<Integer> delete = new HashSet<>();

            // 3. 상어가 이동한다
            for (Integer key : hashMap.keySet()) {
                shark nowShark = hashMap.get(key);


                for (int k = 0; k < nowShark.s; k++) {
                    int nr = nowShark.r + dr[nowShark.d];
                    int nc = nowShark.c + dc[nowShark.d];

                    if (!check(nr, nc)) {
                        if (nowShark.d == 1) nowShark.d = 2;
                        else if (nowShark.d == 2) nowShark.d = 1;
                        else if (nowShark.d == 3) nowShark.d = 4;
                        else if (nowShark.d == 4) nowShark.d = 3;

                        nr = nowShark.r + dr[nowShark.d];
                        nc = nowShark.c + dc[nowShark.d];
                    }

                    nowShark.r = nr;
                    nowShark.c = nc;
                }

                if (newMap[nowShark.r][nowShark.c] == 0) newMap[nowShark.r][nowShark.c] = key;
                else {
                    int nSharkId = newMap[nowShark.r][nowShark.c];
                    if (nowShark.z > hashMap.get(nSharkId).z) {
                        delete.add(nSharkId);
                        newMap[nowShark.r][nowShark.c] = key;
                    } else {
                        delete.add(key);
                    }
                }
            }

            for (Integer idx : delete) {
                hashMap.remove(idx);
            }

            map = newMap;
        }

        System.out.println(result);

    }

    static boolean check(int r, int c) {
        return r >= 1 && r <= R && c >= 1 && c <= C;
    }

    static void printMap() {
        System.out.println("-----Map-----");
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


}
