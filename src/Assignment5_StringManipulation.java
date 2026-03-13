import java.util.Scanner;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1:
                    task1(scanner);
                    break;
                case 2:
                    task2(scanner);
                    break;
                case 3:
                    task3(scanner);
                    break;
                case 4:
                    task4(scanner);
                    break;
                case 5:
                    task5(scanner);
                    break;
                case 6:
                    task6(scanner);
                    break;
                case 7:
                    task7(scanner);
                    break;
                case 8:
                    task8(scanner);
                    break;
                case 0:
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int count = 0;
        String lower = input.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String lower = input.toLowerCase();
        String rev = new StringBuilder(lower).reverse().toString();
        boolean isPalindrome = lower.equals(rev);

        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        int wordCount = 0;
        String trimmed = sentence.trim();
        if (!trimmed.isEmpty()) {
            wordCount = trimmed.split("\\s+").length;
        }

        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String noSpaces = input.replace(" ", "");

        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String[] words = sentence.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                sb.append(Character.toUpperCase(words[i].charAt(0)));
                sb.append(words[i].substring(1));
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        String result = sb.toString();

        System.out.println(result);
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("The string is empty!");
            return;
        }
        int[] freq = new int[256];
        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i)]++;
        }
        char mostFrequent = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (freq[input.charAt(i)] > freq[mostFrequent]) {
                mostFrequent = input.charAt(i);
            }
        }

        System.out.println("The most frequent character is: " + mostFrequent);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        char[] a = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] b = str2.replaceAll("\\s", "").toLowerCase().toCharArray();
        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);
        boolean areAnagrams = java.util.Arrays.equals(a, b);

        System.out.println(areAnagrams ? "Yes" : "No");
    }
}