import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileDemoTest {

    @org.junit.jupiter.api.Test
    void B() throws IOException {
        int[] arr1 = { 1, 2, 3, 7000 };
        try(FileOutputStream file1 = new FileOutputStream("test.txt")) {
            FileDemo.RecordingB(arr1, file1);
        }
        int[] arr2 = new int[4];
        try(FileInputStream file2 = new FileInputStream("test.txt")) {
            FileDemo.ReadingB(file2, arr2);
        }
        assertArrayEquals(arr1, arr2);
    }

    @org.junit.jupiter.api.Test
    void S() throws IOException {
        int[] arr1 = { 1, 2, 65, 700000 };
        try(FileWriter file1 = new FileWriter("test1.txt")) {
            FileDemo.RecordingS(arr1, file1);
        }
        int[] arr2 = new int[4];
        try(FileReader file2 = new FileReader("test1.txt")) {
            FileDemo.ReadingS(file2, arr2);
        }
        assertArrayEquals(arr1, arr2);
    }

    @Test
    void readingFromAGivenLocation() throws IOException {
        int[] arr1 = { 1, 2, 3, 7, 99, 66, 780000 };
        try(FileOutputStream file1 = new FileOutputStream("test3.txt")) {
            FileDemo.RecordingB(arr1, file1);
        }
        int[] arr2 = new int[4];
        try(RandomAccessFile file2 = new RandomAccessFile("test3.txt", "r")) {
            FileDemo.ReadingFromAGivenLocation(file2, arr2, 3);
        }
        assertArrayEquals(new int[] { 7, 99, 66, 780000 }, arr2);
    }

    @Test
    void listOfExtensions() {
        File directory1 = new File("C:\\Users\\yura6\\INFORMAT_JaVa\\tmp");
        List<File> list1 = new ArrayList<>(List.of(new File("C:\\Users\\yura6\\INFORMAT_JaVa\\tmp\\t1.txt"),
                new File("C:\\Users\\yura6\\INFORMAT_JaVa\\tmp\\t2.txt"),
                new File("C:\\Users\\yura6\\INFORMAT_JaVa\\tmp\\t5.txt")));
        assertEquals(list1, FileDemo.ListOfExtensions(directory1, ".txt"));
    }
}