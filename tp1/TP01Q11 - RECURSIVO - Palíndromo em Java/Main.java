public class Main {
    
    //Função que finaliza o programa
    public static boolean returnEnd(String fim){
        boolean result;

        result = (fim.length() == 3 && fim.charAt(0) == 'F' && fim.charAt(1) == 'I' && fim.charAt(2) == 'M');

        return result;
    }

    //Funçaõ que chama a recursiva
    public static String verifyPalindrome(String input){
        return verifyPalidrome(input, 0, input.length() - 1);
    }

    //Função que verifica se é palindromo
    public static String verifyPalidrome(String input, int i, int j) {
       
        String result = "SIM";
        if (i < j)
            if (input.charAt(i) == input.charAt(j))
                result = verifyPalidrome(input, i + 1, j - 1);
        else
            result = "NAO";

        return result;

    }
    //Metódo main
    public static void main(String[] args) {
        String[] in = new String[1000];
        String[] out = new String[1000];
        int inputNumber = 0;

        do{
            in [inputNumber] = MyIO.readLine();
            out [inputNumber] = verifyPalindrome(in[inputNumber]);
            MyIO.println(out[inputNumber]);
            
        } while (returnEnd(in[inputNumber++]) == false);
    }
}