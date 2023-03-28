import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileDemo {
    /**
     * 1 запись
     * @param arr массив
     * @param stream байтовый поток для записи
     */
    public static void RecordingB(int[] arr, OutputStream stream) throws IOException {
        for (int i : arr) {
            stream.write(i);
        }
    }

    /**
     * 1 чтение
     * @param read двоичный поток с массивом
     * @param arr массив
     */
    public static void ReadingB(InputStream read, int[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = read.read();
        }
    }

    /**
     * 2 запись
     * @param arr массив
     * @param writer символьны поток для записи
     */
    public static void RecordingS(int[] arr, Writer writer) throws IOException {
        for (int j : arr) {
            writer.write(j);
            writer.write(' ');
        }
    }

    /**
     * 2 чтение
     * @param read символьны поток с массивом
     * @param arr массив
     * @throws IOException чтоб читалось
     */
    public static void ReadingS(Reader read, int[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = read.read();
            read.read();
        }
    }

    /**
     * 3
     * @param read файл для чтения
     * @param arr массив
     * @param x с этого места читать
     * @throws IOException чтоб читалось
     */
    public static void ReadingFromAGivenLocation(RandomAccessFile read, int[] arr, int x) throws IOException {
        read.seek(x);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = read.read();
        }
    }

    /**
     * 4
     * @param directory каталог
     * @param ext расшиение (в виде ".расширение")
     * @return список файлов с данным расширением
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
