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

    //Função que chama a recursiva das vogais
    public static String verifyVogals(String input){
        return verifyVogals(input, 0);
    }

    //Função que verifica a string, procurando apenas vogáis
    public static String verifyVogals(String input, int counter){
        String result = "SIM";

        if(counter < input.length()){
            if(input.charAt(counter) > 64 && input.charAt(counter) < 91 || input.charAt(counter) > 96 && input.charAt(counter) < 123){
                if(input.charAt(counter) == 'A' || input.charAt(counter) == 'E' || input.charAt(counter) == 'I' ||input.charAt(counter) == 'O' || input.charAt(counter) == 'U' || 
                input.charAt(counter) == 'a' || input.charAt(counter) == 'e' || input.charAt(counter) == 'i' || input.charAt(counter) == 'o' || input.charAt(counter) == 'u'){
                    result = verifyVogals(input, counter + 1);
                }
                else{
                    result = "NAO";
                }
            }

            else
                result = "NAO";
        }
        
        return result;
    }

    //Função que chama a recursiva das consoantes
    public static String verifyConsonants(String input){
        return verifyConsonants(input, 0);
    }

    //Função que verifica a string, procurando apenas consoantes.
    public static String verifyConsonants(String input, int counter){
        String result = "SIM";

            if(counter < input.length()){
                if(input.charAt(counter) > 64 && input.charAt(counter) < 91 || input.charAt(counter) > 96 && input.charAt(counter) < 123){
                    if(input.charAt(counter) != 'A' && input.charAt(counter) != 'E' && input.charAt(counter) != 'I' &&input.charAt(counter) != 'O' && input.charAt(counter) != 'U' && 
                    input.charAt(counter) != 'a' && input.charAt(counter) != 'e' && input.charAt(counter) != 'i' && input.charAt(counter) != 'o' && input.charAt(counter) != 'u'){
                        result = verifyConsonants(input, counter + 1);
                    }
                    else{
                        result = "NAO";
                    }
                }
                else{
                    result = "NAO";
                }
            }


        return result;
    }

    //Função que chama a recursiva dos números inteiros
    public static String verifyInteger(String input){
        return verifyInteger(input, 0);
    }

    //Função que verifica a string, procurando apenas números inteiros
    public static String verifyInteger(String input, int counter){
        String result = "SIM";

        if(counter < input.length()){
            if(input.charAt(counter) > 47 && input.charAt(counter) < 58){
                result = verifyInteger(input, counter + 1);
            }
            else{
                result = "NAO";
            }
        }

        return result;
    }

    //Função que chama a recursiva dos números reais
    public static String verifyReal(String input){
        return verifyReal(input, 0, 0);
    }

    //Função que verifica a string, procurando apenas números inteiros.
    public static String verifyReal(String input, int counter, int dotCounter){
        String result = "SIM";

            if (counter < input.length()){
                if(input.charAt(counter) > 47 && input.charAt(counter) < 58  || input.charAt(counter) == 46 || input.charAt(counter) == 44){
                    if (input.charAt(counter) == 46 || input.charAt(counter) == 44){
                        dotCounter++;
                    }
                    result = verifyReal(input, counter + 1, dotCounter);
                }
                else{
                    result = "NAO";
                }
            }

        if (dotCounter == 0)
            result = "NAO";
        else if(dotCounter > 1){
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