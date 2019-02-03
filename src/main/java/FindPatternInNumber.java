import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPatternInNumber {

    Integer base;
    Integer target;

    List<Integer> matchesList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FindPatternInNumber program = new FindPatternInNumber();
        start(program);
    }

    public static void start(FindPatternInNumber program) {
        program.getNumbers();
        program.showEntered();
        program.findMathes(program.base, program.target);
        program.showResults();
    }

    public void getNumbers() {
        System.out.print("В каком числе искать? ");
        base = scanner.nextInt();

        System.out.print("Что искать? ");
        target = scanner.nextInt();
    }

    public void showEntered() {
        System.out.println("\nВы ввели " + base + " и " + target + ".");
    }

    public boolean findMathes(Integer base, Integer target) {
        boolean answer = false;
        String baseString = "";
        String targetStr = target.toString();

        for (int i = 0; i < base; i++) {
            baseString = String.valueOf(i);

            loop:
            for (int b = 0; b < baseString.length(); b++) {
                for (int t = 0; t < targetStr.length(); t++) {

                    if ((baseString.charAt(b) == targetStr.charAt(t)) &&
                        (b + targetStr.length() <= baseString.length())  &&
                        (targetStr.equals( baseString.substring(b, b + targetStr.length() ) ) ) ){
                        answer = true;
                        matchesList.add(i);
                        break loop;
                    }
                }
            }
        }

        return answer;
    }


    public void showResults() {
        if(matchesList.size() == 0 ){
            System.out.println("Число " + target + " ни разу не встречается в числе " + base + ".");
        } else {
            System.out.println("Число встречается " + matchesList.size() + " раз.\n" );

            for (Integer match : matchesList) {
                System.out.print("#");
                if(matchesList.indexOf(match)+1 < 10){
                    System.out.print("0");
                }
                System.out.print(Integer.valueOf( 1 + matchesList.indexOf(match)) + " - " + match + "\n");
            }
        }
    }

}
