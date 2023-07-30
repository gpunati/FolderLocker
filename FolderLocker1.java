import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FolderLocker1 {
    private static final String FOLDER_PATH = "C:\\Users\\sreelakshmi\\Desktop\\CodeClause";
    public static void lockFolder() {
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            System.out.println("Folder does not exist.");
            return;
        }

        try {
            Path folderPath = Paths.get(FOLDER_PATH);
            Files.setAttribute(folderPath, "dos:hidden", true);
            Files.setAttribute(folderPath, "dos:readonly", true);
            System.out.println("Folder locked successfully.");
        } catch (Exception e) {
            System.out.println("Failed to lock the folder: " + e.getMessage());
        }
    }
    public static void unlockFolder() {
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            System.out.println("Folder does not exist.");
            return;
        }

        try {
            Path folderPath = Paths.get(FOLDER_PATH);
            Files.setAttribute(folderPath, "dos:hidden", false);
            Files.setAttribute(folderPath, "dos:readonly", false);
            System.out.println("Folder unlocked successfully.");
        } catch (Exception e) {
            System.out.println("Failed to unlock the folder: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("1. Lock Folder");
        System.out.println("2. Unlock Folder");
        System.out.print("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                lockFolder();
                break;
            case 2:
                unlockFolder();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}