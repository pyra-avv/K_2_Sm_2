import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileDemo {
    /**
     * 1 запись
     * @param arr массив
     * @return двоичный поток с массивом
     */
    public static OutputStream RecordingB(int[] arr) throws IOException {
        OutputStream res = new ByteArrayOutputStream();
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
    public static int[] ReadingB(InputStream read) throws IOException {
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
    public static Writer RecordingS(int[] arr) throws IOException {
        Writer res = new CharArrayWriter();
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
    public static int[] ReadingS(Reader read) throws IOException {
        int[] arr = new int[read.read()];
        for (int i = 0; i < arr.length; i++) {
            //read.read();
            arr[i] = read.read();
        }
        return arr;
    }

    /**
     * 4
     * @param directory каталог
     * @param ext расшиение (в виде ".расширение"
     * @return список файлоф с данным расширением
     */
    public static List<File> ListOfExtensions(File directory, String ext) {
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException();
        }
        List<File> res = new ArrayList<>();
        for (File f : Objects.requireNonNull(directory.listFiles())) {
            if (f.getName().endsWith(ext)) {
                res.add(f);
            }
        }
        return res;
    }






}
