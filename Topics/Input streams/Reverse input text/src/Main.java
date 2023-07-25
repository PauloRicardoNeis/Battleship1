import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, (char)reader.read());
        } while (reader.ready());
        System.out.println(sb.toString());

        reader.close();
    }
}