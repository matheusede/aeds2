public class Main {

    //Função que finaliza o programa
    public static boolean returnEnd(String fim){
        boolean result;

        result = (fim.length() == 3 && fim.charAt(0) == 'F' && fim.charAt(1) == 'I' && fim.charAt(2) == 'M');

        return result;
    }

    public static String verifyVogals(String input){
        String result = "SIM";

        for(int i = 0; i < input.length(); i ++){

        }
        return result;
    }

    public static String verifyConsonants(String input){
        String result = "SIM";

        for(int i = 0; i < input.length(); i ++){
            
        }
        return result;
    }

    public static String verifyInteger(String input){
        String result = "SIM";

        for(int i = 0; i < input.length(); i ++){
            
        }
        return result;
    }

    public static String verifyReal(String input){
        String result = "SIM";

        for(int i = 0; i < input.length(); i ++){
            
        }
        return result;
    }

    public static void main(String[] args) {
        String[] in = new String[1000];
        String[] out = new String[1000];
        String x1, x2, x3, x4;
        int inputNumber = 0;

        do{
            in [inputNumber] = MyIO.readLine();
            x1 = verifyVogals(in[inputNumber]);
            x2 = verifyConsonants(in[inputNumber]);
            x3 = verifyInteger(in[inputNumber]);
            x4 = verifyReal(in[inputNumber]);
            out [inputNumber] = x1 + " " + x2 + " " + x3 + " " + x4;
            
        } while (returnEnd(in[inputNumber++]) == false);
    }
}