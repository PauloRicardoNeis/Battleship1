import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        int current = inputStream.read();

        while (current != -1){

            System.out.print(current);
            current = inputStream.read();

        }


    }
}