import java.io.*;
import java.util.StringTokenizer;

public class grade_sort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int[] counts = new int[101];

        int grade;
        for (int i = 0; i < N; i++) {
            grade = Integer.parseInt(tokens.nextToken());
            counts[grade]++;
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < counts[i]; j++) {
                output.append(i);
                output.append(' ');
            }
        }
        output.deleteCharAt(output.length() - 1);
        output.append('\n');
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(output.toString());
        writer.flush();
    }
}
