import java.util.Arrays;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        /*boolean isCorrectName = false;
        while (!isCorrectName) {
            String name = scanner.nextLine(); //Считывает строку из System.in
            isCorrectName = checkName(name);
            if (!isCorrectName) {
                System.out.println("Введите корректное имя!");
            } else {
                System.out.println(formatName(name));
            }
        }*/
        /*boolean isCorrectNumber = false;
        while (!isCorrectNumber) {
            String phoneNumber = scanner.nextLine(); //Считывает строку из System.in
            isCorrectNumber = checkPhoneNumberIsCorrect(phoneNumber);
            if (!isCorrectNumber) {
                System.out.println("Введите корректный номер!");
            } else {
                System.out.println(formatNumber(phoneNumber));
            }
        }*/
        /*String palindrome = "Еще бы, рту дадут рыб еще";
        char[] array = concat("String", "Concatenation");
        System.out.println(Arrays.toString(array));
        System.out.println(removeSpaces("А роза упала на лапу Азора"));
        System.out.println(isPalindrome(palindrome));*/
        System.out.println(formatString("Первая строка", "Вторая строка", 44));
    }

    private static char[] concat(String str1, String str2) {
        char[] letters = new char[str1.length()+str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            letters[i] = str1.charAt(i);
        }
        for (int i = 0; i < str2.length(); i++) {
            letters[i+str1.length()] = str2.charAt(i);
        }
        return letters;
    }
    private static String removeWhiteSpaces(String str) {
        String wordWithoutSpace = "";
        char[] letters = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' '){
                wordWithoutSpace += str.charAt(i);
            }
        }
        return  wordWithoutSpace;
    }
    public static boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();
        char[] letters = new char[clean.length()];
        for (int i = 0; i < clean.length(); i++) {
            letters[i] = clean.charAt(i);
        }
        for (int i = 0; i < letters.length; i++) {
           // System.out.println(letters[i] + " " + letters[letters.length - 1 - i]);
            if (letters[i] == letters[letters.length - 1 - i])
                continue;
            else return false;
        }
        return true;
    }
    public static String removeSpaces(String str){
            return str.replace(' ', '\0');
    }
    public static boolean checkName(String fullName){
        String[] name = fullName.trim().split(" ");
        if (name.length != 3)
            return false;
        else return true;
    }
    public static String formatName(String fullName){
        String[] name = fullName.trim().split(" ");
        String result = "";
        for (int i = 0; i < name.length; i++){
            char firstLetter = name[i].charAt(0);
            if(!Character.isUpperCase(firstLetter)){
                result += Character.toUpperCase(firstLetter) + name[i].substring(1) + " ";
            }
            else{
                result += name[i].substring(1) + " ";
            }
        }
        return result;
    }
    public static String sortFullNameBYLength(String fullName){
        String[] name = fullName.trim().split(" ");
        boolean repeat = true;
        while (repeat) {
            repeat = false;
            String bufer = "";
            for (int i = 0; i < name.length - 1; i++) {
                if (name[i].length() > name[i + 1].length()) {
                    bufer = name[i + 1];
                    name[i + 1] = name[i];
                    name[i] = bufer;
                    repeat = true;
                }
            }
        }
        return name[0] + " " + name[1] + " " + name[2];
    }
    public static boolean checkPhoneNumberIsCorrect (String phoneNumber){
       String number = phoneNumber.replaceAll("[^0-9]", "");
       return number.length() == 11;
    }
    public static String formatNumber (String phoneNumber){
        String cleanNumber = phoneNumber.replaceAll("[^0-9]", "");
        String result = cleanNumber.substring(1,4) + " " +
                cleanNumber.substring(4,7) + " " +
                cleanNumber.substring(7,9) + " " +
                cleanNumber.substring(9);
        return result;
    }
    private  static String formatString(String str1, String str2, int number){
        return String.format("Было получено 2 строки: " + "str1 = %s "
                + "str2 = %s" +
                ", а так же число " + "num = %d", str1,str2,number);
    }
}
