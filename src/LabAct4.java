import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class LabAct4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstPattern = "<data_type><identifier><assignment_operator><value><delimiter>";
        String secondPattern = "<data_type><identifier><delimiter>";
        String thirdPattern = "<identifier><assignment_operator><value><delimiter>";
        String input = "<data_type><identifier><assignment_operator><value><delimiter>";
        List<PatternChecker> patternCheckerList = new ArrayList<PatternChecker>();

        PatternChecker patternCheck1 = new PatternChecker(firstPattern);
        PatternChecker patternCheck2 = new PatternChecker(secondPattern);
        PatternChecker patternCheck3 = new PatternChecker(thirdPattern);

        patternCheckerList.add(patternCheck1);
        patternCheckerList.add(patternCheck2);
        patternCheckerList.add(patternCheck3);

        loopOut:
        while (true) {
            System.out.print("Enter Tokens: ");
            input = sc.nextLine();
            input = input.replaceAll("\\s", "");
            PatternChecker inputStore = new PatternChecker(input);

            for (PatternChecker patCheck : patternCheckerList) {
                if (inputStore.isMatching(patCheck)) {
                    pr(true);
                    continue loopOut;
                }
            }
            pr(false);
        }
    }

    static class PatternChecker {
        public String patt;

        public PatternChecker(String patt) {
            this.patt = patt;
        }

        public boolean isMatching(PatternChecker obj) {
            return (patt.equals(obj.patt));
        }
    }

    static void pr(boolean isCorrect) {
        if (isCorrect)
            System.out.println("Syntax is Correct!\n");
        else
            System.out.println("Syntax is Error!\n");
    }
}

