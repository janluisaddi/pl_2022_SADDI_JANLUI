import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabAct3
{
    public static void main(String[] args)
    {
        String input;
        String regexPattern = "(\".+\\s*.*\")|;|=|(\\w+)";

        Scanner sc = new Scanner(System.in);
        Tokenizer tokenizer = new Tokenizer();

        while(true)
        {
            System.out.print("Enter Source Language: ");
            input = sc.nextLine();

            List<String> inputSort = new ArrayList<String>();
            Matcher matcher = Pattern.compile(regexPattern).matcher(input);

            while(matcher.find())
            {
                inputSort.add(matcher.group());
            }

            List<String> listOfTokens = new ArrayList<String>();

            for(String lexeme: inputSort)
            {
                if(tokenizer.isDataType(lexeme))
                {
                    listOfTokens.add("<data_type>");
                    continue;
                }
                if(tokenizer.isIdentifier(lexeme))
                {
                    listOfTokens.add("<identifier>");
                    continue;
                }
                if(tokenizer.isValue(lexeme))
                {
                    listOfTokens.add("<value>");
                    continue;
                }
                if(lexeme.equals("="))
                {
                    listOfTokens.add("<assignment_operator>");
                    continue;
                }
                if(lexeme.equals(";"))
                {
                    listOfTokens.add("<delimiter>");
                    continue;
                }
                listOfTokens.add("<unknown_lexeme>");
            }
            String printer = "Output is: ";
            for(String token: listOfTokens)
            {
                printer += token + " ";
            }
            System.out.println(printer + "\n");
        }

    }
}

class Tokenizer {
    public boolean isDataType(String input) {
        boolean bo = input.equals("int") || input.equals("double") || input.equals("String") || input.equals("char");
        return bo;
    }

    public boolean isIdentifier(String input)
    {
        String pat = "[a-zA-z_]\\w*";
        boolean bo = Pattern.matches(pat , input);
        return bo;
    }

    public boolean isValue(String input)
    {
        String pat = "(-*\\d+)|" +  //for int
                "(-*\\d+\\.*\\d*)|" + //for double
                "(\".+\")|" + //for String
                "(\'.\')"; //for char

        boolean bo = Pattern.matches(pat , input);
        return bo;
    }

}