import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabAct5
{
    public static void main(String[] args)
    {

        String input;
        String patternRegex = "(('|\").*\\s*.*(\"|'))|;|=|(-|\\+)*(\\.*\\w+\\.*\\w*)";
        Scanner sc = new Scanner(System.in);
        while(true){
            boolean isValAssigned = false;
            DataType dataVal = DataType.error;
            String val = "";
            System.out.print("Enter Expression: ");
            input = sc.nextLine();
            Matcher match = Pattern.compile(patternRegex).matcher(input);

            while(match.find())
            {
                if(match.group().equals("="))
                {
                    isValAssigned=true;
                    continue;
                }
                if(IsTypeData(match.group()))
                {
                    dataVal = GetTypeData(match.group());
                    continue;
                }
                if(isValAssigned && IsTypeValue(match.group()))
                {
                    val = match.group();
                    break;
                }
            }
            if(!isValAssigned|IsMatchedType(val,dataVal))
            {
                System.out.println("Semantically  Correct!\n");
            }
            else
            {
                System.out.println("Semantically  Incorrect!\n");
            }
        }
    }

    static boolean IsTypeData(String input)
    {
        boolean bl = input.equals("int")||input.equals("double")||
                input.equals("String")||input.equals("char");
        return bl;
    }
    static DataType GetTypeData(String input)
    {
        switch(input){
            case"String":
                return DataType.StringType;
            case"char":
                return DataType.charType;
            case"int":
                return DataType.intType;
            case"double":
                return DataType.doubleType;
            default:
                return DataType.error;
        }
    }

    static boolean IsTypeValue(String input)
    {
        String patternRegex = "(-*\\d+)|"
                            + "(\\d+\\.*\\d*)|"
                            + "(\".+\")|" + "('.')";

        Matcher match = Pattern.compile(patternRegex).matcher(input);
        return match.find();
    }
    static boolean IsMatchedType(String input, DataType dataType)
    {
        String charPattValue ="((\'.{1}\'))";
        String stringPattValue ="(\".*\")";
        String intPattValue ="(-|\\+)?\\d+";
        String doublePattValue ="((-|\\+)?((\\d+)|(\\d+\\.*\\d*)|(\\d*\\.*\\d+)))";
        String valueRegex;

        switch(dataType)
        {
            case StringType:
                valueRegex = stringPattValue;
                break;
            case charType:
                valueRegex = charPattValue;
                break;
            case intType:
                valueRegex = intPattValue;
                break;
            case doubleType:
                valueRegex = doublePattValue;
                break;
            default:
                valueRegex = null;
        }
        if(valueRegex==null)return false;
        Matcher match = Pattern.compile(valueRegex).matcher(input);
        return match.matches();
    }
    enum DataType
    {
        StringType,charType,intType,doubleType,error
    }
}

