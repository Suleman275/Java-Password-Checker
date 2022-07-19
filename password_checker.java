import java.lang.Character;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//rename file directory to run on your computer
public class password_checker {
    public static void main(String []args){
        System.out.println("Enter a password string");
        Scanner scan = new Scanner(System.in);
        String password = scan.next();
        System.out.println(length_checker(password));
        if(word_checker(password)||endstart_check(password)) {;
            System.out.println("\nThis password not a good password.");
        }
        else
            System.out.println("\nThis password is a good password.");
    }


    public static String length_checker(String str) {
        if((str.length()) < 5) {
            System.err.println("you need to add at least 5 characters");
            System.exit(0);
        }
        return "The length of the password is valid";
    }

    public static Boolean word_checker(String str) {
        boolean result = false;

        try {
            File fileobj = new File("C:\\Users\\Sule\\Desktop\\mostusedpasswords.txt");
            File dictobj= new File("C:\\Users\\Sule\\Desktop\\words.txt");
            Scanner fileReader = new Scanner(fileobj);
            Scanner dictReader= new Scanner(dictobj);

            System.out.println("\nSearching Most Used Passwords.");
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                if(data.equalsIgnoreCase(str)) {
                    System.err.println("Match found. Password is not good.");
                    result = true;
                    break;
                }
                else {
                    result = false;}
            }

            System.out.println("\nSearching The Dictionary.");
            while (dictReader.hasNextLine()) {
                String word = dictReader.nextLine();

                if(word.equalsIgnoreCase(str)) {
                    System.err.println("Match found. Password is not good.");
                    result = true;
                    break;
                }
                else {
                    result = false;
                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean endstart_check(String str) {
        boolean flag = false;

        try {
            File dictobj= new File("C:\\Users\\Sule\\Desktop\\words.txt");
            Scanner dictReader = new Scanner(dictobj);
            System.out.println("\nSearching for prefix and suffix");

            while (dictReader.hasNextLine()) {
                String word = dictReader.nextLine();
                for (int i =0;i<10;i++) {
                    if(str.equalsIgnoreCase(word+""+i)) {
                        flag = true;
                        System.err.println("Word with suffix");
                        break;
                    }
                    if(str.equalsIgnoreCase(i+""+word)) {
                        flag = true;
                        System.err.println("Word with prefix");
                        break;
                    }
                    else {
                        flag = false;}
                }
                if(flag)
                    break;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}








