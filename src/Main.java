import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("/home/hug/Desktop/sample folder/sample.txt");
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isDirectory());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));

        File file2 = new File("/home/hug/Desktop/sample folder/sample2.txt");

        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (file2.exists()) {
            boolean silindiMi = file2.delete();
            System.out.println(silindiMi);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya yolu: ");
        String path = scanner.nextLine();

        System.out.print("Dosya ismi: ");
        String fileName = scanner.nextLine();

        File newFile = new File(path  + "/" + fileName + ".txt");

        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        FileWriter fileWriter = null;

        String line = null;
        System.out.println("yazı gir, bitirmek için yeni bir satıra quit yaz:");

        try {
            fileWriter = new FileWriter(newFile);

            while (!(line = scanner.nextLine()).equals("quit")) {
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        String[] icerik = new File(newFile.getParent()).list();
        for (String s: icerik) {
            System.out.println(s);
        }

        scanner.close();


        System.out.println(newFile.length());



    }

}
