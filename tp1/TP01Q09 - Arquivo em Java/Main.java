import java.io.File;
import java.io.RandomAccessFile;
public class Main {

    public static void main(String[] args) {
        
        int inputLimit = MyIO.readInt(); //Prmeira linha -> Número de números reais que serão lidos

        //Escreve o input no arquivo
        try {
            File originalFile = new File("arquivo.txt");

            if (!originalFile.exists())
                originalFile.createNewFile();
                
            RandomAccessFile randomAccess = new RandomAccessFile(originalFile, "rw");

            for (int i = 0; i < inputLimit; i++) {
                double input = MyIO.readDouble();
                randomAccess.writeDouble(input);
            }

            randomAccess.close();
        } 
        
        catch (Exception error) {
            MyIO.println("ERRO");
        }

        //Escreve o input inverso no arquivo
        try {
            File inverseFile = new File("arquivo.txt");
            if (!inverseFile.exists())
                throw new Exception();

            RandomAccessFile randomAccess = new RandomAccessFile(inverseFile, "r");

            for (int i = 0; i < inputLimit; i++) {

                randomAccess.seek((inputLimit - 1 - i) * 8);
                double numero = randomAccess.readDouble();

                if (numero % 1 != 0)
                    MyIO.println(numero);

                else
                    MyIO.println((int) numero);
            }
            randomAccess.close();

        } 

        catch (Exception error) {
            MyIO.println("ERRO");
        }

    }
}