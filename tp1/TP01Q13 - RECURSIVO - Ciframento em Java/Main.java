public class Main {
    
    //Função que finaliza o programa
    public static boolean returnEnd(String fim){
        boolean result;

        result = (fim.length() == 3 && fim.charAt(0) == 'F' && fim.charAt(1) == 'I' && fim.charAt(2) == 'M');

        return result;
    }

    //Função que chama o ciframento
    public static String encryption(String input){
        return encryption(input, 0);
    }

    //Função que executa o ciframento
    public static String encryption(String input, int counter){
        String result = "";
        if (counter < input.length()){
            char aux = (char) (input.charAt(counter) + 3);
            result += aux;
            result += encryption(input, counter + 1);
        }

        return result;
    }


    public static void main(String[] args) {
        String[] in = new String[1000];
        String[] out = new String[1000];
        int inputNumber = 0;

        do{
            in [inputNumber] = MyIO.readLine();
            out [inputNumber] = encryption(in[inputNumber]); //chamada da fução do ciframento.
            MyIO.println(out[inputNumber]);
            
        } while (returnEnd(in[inputNumber++]) == false);
    }

}
