import java.io.*;
import java.util.*;

public class Main {
    static class Team {
        int id;
        int[] score;
        int submitCnt;
        int lastTime;
        int totalScore;

        Team(int id, int k) {
            this.id = id;
            this.score = new int[k + 1];
            this.submitCnt = 0;
            this.lastTime = 0;
            this.totalScore = 0;
        }

        void calcTotal() {
            int sum = 0;
            for (int i = 1; i < score.length; i++) {
                sum += score[i];
            }
            this.totalScore = sum;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n + 1];
            for (int i = 1; i <= n; i++) {
                teams[i] = new Team(i, k);
            }

            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                Team team = teams[teamId];
                team.submitCnt++;
                team.lastTime = i;
                team.score[problem] = Math.max(team.score[problem], score);
            }

            List<Team> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                teams[i].calcTotal();
                list.add(teams[i]);
            }

            list.sort((a, b) -> {
                if (a.totalScore != b.totalScore)
                    return b.totalScore - a.totalScore;
                if (a.submitCnt != b.submitCnt)
                    return a.submitCnt - b.submitCnt;
                return a.lastTime - b.lastTime;
            });

            int rank = 1;
            for (Team team : list) {
                if (team.id == t) {
                    sb.append(rank).append('\n');
                    break;
                }
                rank++;
            }
        }

        System.out.print(sb);
    }
}