public class Main
{

    public static void replaceExpressions(String input, char A, char B, char C){
        while(input.length() > 1) 
        {
            if( input.length() == 1){ break;}
            input = input.replace(" ", "");
            input = input.replace('A', A);
            input = input.replace('B', B);
            input = input.replace('C', C);
            input = input.replace("not(0)", "1");
            input = input.replace("not(1)", "0");
            input = input.replace("or(1,0)", "1");
            input = input.replace("or(0,1)", "1");
            input = input.replace("or(1,1)", "1");
            input = input.replace("or(0,0)", "0");
            input = input.replace("or(1,0,0)", "1");
            input = input.replace("or(1,0,1)", "1");
            input = input.replace("or(1,1,1)", "1");
            input = input.replace("or(0,0,1)", "1");
            input = input.replace("or(0,1,1)", "1");
            input = input.replace("or(0,1,0)", "1");
            input = input.replace("or(1,1,0)", "1");
            input = input.replace("or(0,0,0)", "0");
            input = input.replace("or(0,0,0,0)", "0");
            input = input.replace("or(0,0,0,1)", "1");
            input = input.replace("or(0,0,1,0)", "1");
            input = input.replace("or(0,0,1,1)", "1");
            input = input.replace("or(0,1,0,0)", "1");
            input = input.replace("or(0,1,0,1)", "1");
            input = input.replace("or(0,1,1,0)", "1");
            input = input.replace("or(0,1,1,1)", "1");
            input = input.replace("or(1,0,0,0)", "1");
            input = input.replace("or(1,0,0,1)", "1");
            input = input.replace("or(1,0,1,0)", "1");
            input = input.replace("or(1,0,1,1)", "1");
            input = input.replace("or(1,1,0,0)", "1");
            input = input.replace("or(1,1,0,1)", "1");
            input = input.replace("or(1,1,1,0)", "1");
            input = input.replace("or(1,1,1,1)", "1");
            input = input.replace("and(1,0)", "0");
            input = input.replace("and(0,1)", "0");
            input = input.replace("and(0,0)", "0");
            input = input.replace("and(1,1)", "1");
            input = input.replace("and(1,0,0)", "0");
            input = input.replace("and(1,0,1)", "0");
            input = input.replace("and(1,1,1)", "1");
            input = input.replace("and(0,0,1)", "0");
            input = input.replace("and(0,1,1)", "0");
            input = input.replace("and(0,1,0)", "0");
            input = input.replace("and(1,1,0)", "0");
            input = input.replace("and(0,0,0)", "0");
            input = input.replace("and(0,0,0,0)", "0");
            input = input.replace("and(0,0,0,1)", "0");
            input = input.replace("and(0,0,1,0)", "0");
            input = input.replace("and(0,0,1,1)", "0");
            input = input.replace("and(0,1,0,0)", "0");
            input = input.replace("and(0,1,0,1)", "0");
            input = input.replace("and(0,1,1,0)", "0");
            input = input.replace("and(0,1,1,1)", "0");
            input = input.replace("and(1,0,0,0)", "0");
            input = input.replace("and(1,0,0,1)", "0");
            input = input.replace("and(1,0,1,0)", "0");
            input = input.replace("and(1,0,1,1)", "0");
            input = input.replace("and(1,1,0,0)", "0");
            input = input.replace("and(1,1,0,1)", "0");
            input = input.replace("and(1,1,1,0)", "0");
            input = input.replace("and(1,1,1,1)", "1");

        }

        MyIO.println(input);

    }
	public static void main(String[] args) {

        String[] in = new String[1000];
        String[] out = new String[1000];
        int inputNumber = 0;
        char A = 'a', B = 'b', C = 'c';
        String subString = "";

        do{
            in[inputNumber] = MyIO.readLine();

            int aux = in[inputNumber].charAt(0) - 48;

            int counter = 0; 

            for(int i = 2; i < aux*3; i += 2)
            {
                if(counter == 0){A = in[inputNumber].charAt(i); }
                if(counter == 1){B = in[inputNumber].charAt(i); }
                if(counter == 2){C = in[inputNumber].charAt(i); }
                counter++;
            }
            subString = in[inputNumber].substring(aux*2 + 2);
            replaceExpressions(in[inputNumber], A, B, C);
        }while(in[inputNumber++] != 0);


	}
}