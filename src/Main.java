import java.util.Random;
import java.util.Scanner;

public class Main {


    public static int findSymbolOccurrence(String str, char symbol) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == symbol) {
                count++;
            }
        }
        return count;
    }


    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }


    public static String stringReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        String reversed = stringReverse(str);
        return str.equalsIgnoreCase(reversed);
    }


    public static void playWordGuessingGame(String[] words) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String secretWord = words[random.nextInt(words.length)];
        StringBuilder hint = new StringBuilder("###############");

        System.out.println("Комп'ютер загадав слово. Спробуйте вгадати!");

        while (true) {
            System.out.print("Ваше слово: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.equals(secretWord)) {
                System.out.println("Вітаємо! Ви вгадали слово!");
                break;
            } else {

                for (int i = 0; i < guess.length() && i < secretWord.length(); i++) {
                    if (guess.charAt(i) == secretWord.charAt(i)) {
                        hint.setCharAt(i, guess.charAt(i));
                    }
                }
                System.out.println("Підказка: " + hint);
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {

        System.out.println("findSymbolOccurrence: " + findSymbolOccurrence("hello", 'l')); // 2
        System.out.println("findWordPosition: " + findWordPosition("Apollo", "pollo")); // 1
        System.out.println("stringReverse: " + stringReverse("hello")); // "olleh"
        System.out.println("isPalindrome: " + isPalindrome("ERE")); // true
        System.out.println("isPalindrome: " + isPalindrome("Allo")); // false


        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"
        };


        playWordGuessingGame(words);
    }
}
