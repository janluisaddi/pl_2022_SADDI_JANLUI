public class LabAct2
{
    public static void main(String[] args)
    {
        String state = "q0";
        String input = "1001001";
        for (int x = 0; x < input.length(); x++)
        {
            if (state.equals("q0") && input.charAt(x) == '0')
            {
                state = "q1";
            }
            else if (state.equals("q0") && input.charAt(x) == '1')
            {
                state = "q0";
            }
            else if (state.equals("q1") && input.charAt(x) == '0')
            {
                state = "q1";
            }
            else if (state.equals("q1") && input.charAt(x) == '1')
            {
                state = "q2";
            }
            else if (state.equals("q2") && input.charAt(x) == '0')
            {
                state = "q1";
            }
            else if (state.equals("q2") && input.charAt(x) == '1')
            {
                state = "q0";
            }
            else
            {
                System.out.println("Invalid input.. Exiting automaton");
            }
        }

        if (state.equals("q2"))
        {
            System.out.println("String accepted");
        }
        else
        {
            System.out.println("String not accepted");
        }
    }
}