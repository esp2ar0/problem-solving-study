package programmers.kakao2018;

/**
 * 추석 트래픽
 *
 * 1. 시간을 Long으로 변환시켜 간편하게 비교하자
 * 2. '처리시간은 시작시간과 끝시간을 포함' 주의
 * 3. 해당 구간에서 겹치는 경우는
 *      1) 시작 지점이 포함된 경우,
 *      2) 끝 지점이 포함된 경우,
 *      3) 시작 지점이 왼쪽 벗어난 곳, 끝 지점이 오른쪽 벗어난 곳에 있는(구간이 더 큰) 경우
 *    세 가지 경우가 있다.
 */

public class p1 {

    public int solution(String[] lines) {
        int answer = 0;
        int length = lines.length;
        long[] startTime = getStartTime(lines);
        long[] endTime = getEndTime(lines);

        for (int i = 0; i < length; i++) {
            int count = getCount(startTime, endTime, startTime[i], startTime[i] + 999L);

            if (answer < count) {
                answer = count;
            }

            count = getCount(startTime, endTime, endTime[i], endTime[i] + 999L);
            if (answer < count) {
                answer = count;
            }
        }
        return answer;
    }

    private int getCount(long[] startTime, long[] endTime, long start, long end) {
        int count = 0;

        for (int j = 0; j < startTime.length; j++) {
            if (end <= endTime[j] && startTime[j] <= start ||
                    start <= startTime[j] && startTime[j] <= end ||
                    start <= endTime[j] && endTime[j] <= end) {
                count++;
            }
        }
        return count;
    }

    private long[] getStartTime(String[] lines) {
        long[] endTime = getEndTime(lines);

        for (int i = 0; i < endTime.length; i++) {
            String[] split = lines[i].split(" ")[2].split("\\.");
            long value;

            if (split.length == 1) {
                value = Long.parseLong(split[0].replace("s", "")) * 1000L;
            } else {
                value = Long.parseLong(split[0]) * 1000;

                String s = split[1].replace("s", "");
                long mul = 100;
                for (int j = 0; j < s.length(); j++) {
                    value += (s.charAt(j) - '0') * mul;
                    mul /= 10;
                }
            }
            endTime[i] = endTime[i] - value + 1;
        }
        return endTime;
    }

    private long[] getEndTime(String[] lines) {
        long[] endTime = new long[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] splitLine = lines[i].split(" ");
            String[] time = splitLine[1].split(":");
            long value = (
                    Long.parseLong(time[0]) * 60 * 60
                            + Long.parseLong(time[1]) * 60
                            + Long.parseLong(time[2].split("\\.")[0])
            ) * 1000
                    + Long.parseLong(time[2].split("\\.")[1]);

            endTime[i] = value;
        }

        return endTime;
    }

    public static void main(String[] args) {
//        int solution = new p1().solution(new String[]{
//                "2016-09-15 20:59:57.421 0.351s",
//                "2016-09-15 20:59:58.233 1.181s",
//                "2016-09-15 20:59:58.299 0.8s",
//                "2016-09-15 20:59:58.688 1.041s",
//                "2016-09-15 20:59:59.591 1.412s",
//                "2016-09-15 21:00:00.464 1.466s",
//                "2016-09-15 21:00:00.741 1.581s",
//                "2016-09-15 21:00:00.748 2.31s",
//                "2016-09-15 21:00:00.966 0.381s",
//                "2016-09-15 21:00:02.066 2.62s"
//        });

//        int solution = new p1().solution(new String[]{
//                "2016-09-15 01:00:04.002 2.0s",
//                "2016-09-15 01:00:07.000 2s"
//
//        });

        int solution = new p1().solution(new String[]{
                "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
        });
        System.out.println(solution);
    }
}
