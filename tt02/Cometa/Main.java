import java.util.Scanner;

public class Main{

    //Função usada para calcular os anos em que o cometa passa.
    public static int yearsCalculator(int input, int years){
        years = 1986;
        while(input >= years){
            years += 76; //Seleciona o ano mais próximo após o ano inserido.
        }
        return years;
    }
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int input = 1, years = 0, output;

        while(input != 0){
            input = keyboard.nextInt();
            if(input == 0)
                break;
            output = yearsCalculator(input, years);
            System.out.println(output);
        }
    }
}