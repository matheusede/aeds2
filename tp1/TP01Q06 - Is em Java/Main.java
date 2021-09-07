public class Main {

    //Função que finaliza o programa
    public static boolean returnEnd(String fim){
        boolean result;

        result = (fim.length() == 3 && fim.charAt(0) == 'F' && fim.charAt(1) == 'I' && fim.charAt(2) == 'M');

        return result;
    }

    //Função que transforma uma string em um vetor de char.
    public static char [] stringToChar(String input){
        
        char [] characters = new char [input.length()];

        for(int i = 0; i < input.length(); i++){
            char aux = (char)(input.charAt(i));
            characters[i] = aux;
        }

        return characters;
    }

    //Função que transforma um vetor de char em uma string.
    public static String charToString(char [] array){
        String str = new String(array);
        return str;
    }

    //Função que verifica a string, procurando apenas vogáis
    public static String verifyVogals(String input){
        String result = "NAO";

        char [] characters = stringToChar(input);

        for(int i = 0; i < input.length(); i++){
            if(characters[i] > 64 && characters [i] < 91 || characters[i] > 96 && characters[i] < 123){
                if(characters[i] == 'A' || characters[i] == 'E' || characters[i] == 'I' ||characters[i] == 'O' || characters[i] == 'U' || 
                characters[i] == 'a' || characters[i] == 'e' || characters[i] == 'i' || characters[i] == 'o' || characters[i] == 'u'){
                    result = "SIM";
                }
                else{
                    result = "NAO";
                    break;
                }
            }
            else{
                result = "NAO";
                break;
            }
        }
        return result;
    }

    //Função que verifica a string, procurando apenas consoantes.
    public static String verifyConsonants(String input){
        String result = "NAO";

        char [] characters = stringToChar(input);

        for(int i = 0; i < input.length(); i++){
            if(characters[i] > 64 && characters [i] < 91 || characters[i] > 96 && characters[i] < 123){
                if(characters[i] != 'A' && characters[i] != 'E' && characters[i] != 'I' &&characters[i] != 'O' && characters[i] != 'U' && 
                characters[i] != 'a' && characters[i] != 'e' && characters[i] != 'i' && characters[i] != 'o' && characters[i] != 'u'){
                    result = "SIM";
                }
                else{
                    result = "NAO";
                    break;
                }
            }
            else{
                result = "NAO";
                break;
            }
        }
        return result;
    }

    //Função que verifica a string, procurando apenas números inteiros
    public static String verifyInteger(String input){
        String result = "NAO";

        char [] characters = stringToChar(input);

        for(int i = 0; i < input.length(); i++){
            if(characters[i] > 47 && characters[i] < 58){
                result = "SIM";
            }
            else{
                result = "NAO";
                break;
            }
        }
        return result;
    }

    //Função que verifica a string, procurando apenas números inteiros.
    public static String verifyReal(String input){
        String result = "NAO";
        int counter = 0;

        char [] characters = stringToChar(input);


        for(int i = 0; i < input.length(); i++){
            if(characters[i] > 47 && characters[i] < 58  || characters[i] == 46 || characters[i] == 44){
                if (characters[i] == 46 || characters[i] == 44){
                    counter++;
                }
                result = "SIM";
            }
            else{
                result = "NAO";
                break;
            }
        }

        if (counter == 0)
            result = "NAO";
        else if(counter > 1){
            result = "NAO";
        }
        return result;
    }

    //Metódo main
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
            MyIO.println(out[inputNumber]);

        } while (returnEnd(in[inputNumber++]) == false);
    }
}