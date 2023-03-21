import java.io.*;

public class FileDemo {
    /**
     * 1 запись
     *
     * @param arr массив
     * @return двоичный поток с массивом
     */
    public static ByteArrayOutputStream RecordingB(int[] arr) {
        ByteArrayOutputStream res = new ByteArrayOutputStream();
        res.write(arr.length);
        for (int i : arr) {
            res.write(i);
        }
        return res;
    }

    /**
     * 1 чтение
     * @param read двоичный поток с массивом
     * @return массив
     */
    public static int[] ReadingB(ByteArrayInputStream read) {
        int[] arr = new int[read.read()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = read.read();
        }
        return arr;
    }

    /**
     * 2 запись
     * @param arr массив
     * @return символьны поток с массивом
     */
    public static CharArrayWriter RecordingS(int[] arr) {
        CharArrayWriter res = new CharArrayWriter();
        res.write(arr.length);
        for (int j : arr) {
            res.write(' ');
            res.write(j);
        }
        return res;
    }

    /**
     * 2 чтение
     * @param read символьны поток с массивом
     * @return массив
     * @throws IOException чтоб читалось
     */
    public static int[] ReadingS(CharArrayReader read) throws IOException {
        int[] arr = new int[read.read()];
        for (int i = 0; i < arr.length; i++) {
            //read.read();
            arr[i] = read.read();
        }
        return arr;
    }





}
