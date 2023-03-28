import org.junit.jupiter.api.Test;
//import java.lang.AutoCloseable;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FileDemoTest {

    @org.junit.jupiter.api.Test
    void B() throws IOException {
        int[] arr1 = { 1, 2, 3, 7 };
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
        int[] arr1 = { 1, 2, 3, 7 };
        try(FileWriter file1 = new FileWriter("test.txt")) {
            FileDemo.RecordingS(arr1, file1);
        }
        int[] arr2 = new int[4];
        try(FileReader file2 = new FileReader("test.txt")) {
            FileDemo.ReadingS(file2, arr2);
        }
        assertArrayEquals(arr1, arr2);
    }

    @Test
    void readingFromAGivenLocation() throws IOException {
        int[] arr1 = { 1, 2, 3, 7, 99, 66, 78 };
        try(FileOutputStream file1 = new FileOutputStream("test.txt")) {
            FileDemo.RecordingB(arr1, file1);
        }
        int[] arr2 = new int[4];
        try(RandomAccessFile file2 = new RandomAccessFile("test.txt", "r")) {
            FileDemo.ReadingFromAGivenLocation(file2, arr2, 3);
        }
        assertArrayEquals(new int[] { 7, 99, 66, 78 }, arr2);
    }

    @Test
    void listOfExtensions() {
//        try(File directory1 = new File("..\\tmp")){
//
//        }






    }
}