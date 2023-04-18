import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileDemoTest {

    @org.junit.jupiter.api.Test
    void B() throws IOException {
        int[] arr1 = { 100, -2009859, 3, 7000 };
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
        int[] arr1 = { 10, 2, 65, 700000 };
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
        FileDemo.ReadingFromAGivenLocation("test3.txt", arr2, 3);
        assertArrayEquals(new int[] { 7, 99, 66, 780000 }, arr2);
    }

    @Test
    void listOfExtensions() throws IOException, URISyntaxException {
        File directory1 = new File("src/test/resources/tmp");
        //System.out.println("dir " + directory1.exists());
        List<File> list1 = new ArrayList<>(List.of(new File(directory1, "t1.txt"),
                new File(directory1, "t2.txt"), new File(directory1, "t5.txt")));
        assertEquals(list1, FileDemo.ListOfExtensions(directory1, ".txt"));
    }
}