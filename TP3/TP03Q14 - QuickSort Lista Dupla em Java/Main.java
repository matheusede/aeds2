import java.io.*;
import java.io.FileReader;
import java.io.File;  
import java.io.IOException;
import java.util.Scanner;

class Serie{
    //declaração dos atributos
    private String name;
    private String format;
    private String duration;
    private String country;
    private String language;
    private String broadcaster;
    private String streaming;
    private int seasons;
    private int episodes;
    //construtor primário
    public Serie(){
        name = "";
        format = "";
        duration = "";
        country = "";
        language = "";
        broadcaster = "";
        streaming = "";
        seasons = 0;
        episodes = 0;
    }
    //construtor secundário
    public Serie(String name, String format, String duration, String country, String language, String broadcaster, String streaming, int seasons, 
    int episodes){
        this.name = name;
        this.format = format;
        this.duration = duration;
        this.country = country;
        this.language = language;
        this.broadcaster = broadcaster;
        this.streaming = streaming;
        this.seasons = seasons;
        this.episodes = episodes;
    }
    //método para setar o atributo name
    public void setName(String name){
        this.name = name;
    }
    //método para setar o atributo formato
    public void setFormat(String format){
        this.format = format;
    }
    //método para setar o atributo duration
    public void setDuration(String duration){
        this.duration = duration;
    }
    //método para setar o atributo country
    public void setCountry(String country){
        this.country = country;
    }
    //método para setar o atributo language
    public void setLanguage(String language){
        this.language = language;
    }
    //método para setar o atributo broadcaster
    public void setBroadcaster(String broadcaster){
        this.broadcaster = broadcaster;
    }
    //método para setar o atributo streaming
    public void setStreaming(String streaming){
        this.streaming = streaming;
    }
    //método para setar o atributo seasons
    public void setSeasons(int seasons){
        this.seasons = seasons;
    }
    //método para setar o atributo episodes
    public void setEpisodes(int episodes){
        this.episodes = episodes;
    }
    //método para retornar o atributo name
    public String getName(){ 
        return this.name; 
    }
    //método para retornar o atributo format
    public String getFormat(){ 
        return this.format; 
    }
    //método para retornar o atributo duration
    public String getDuration(){ 
        return this.duration; 
    }
    //método para retornar o atributo country
    public String getCountry(){ 
        return this.country; 
    }
    //método para retornar o atributo language
    public String getLanguage(){ 
        return this.language; 
    }
    //método para retornar o atributo broadcaster
    public String getBroadcaster(){ 
        return this.broadcaster; 
    }
    //método para retornar o atributo streaming
    public String getStreaming(){ 
        return this.streaming; 
    }
    //método para retornar o atributo seasons
    public int getSeasons(){ 
        return this.seasons; 
    }
    //método para retornar o atributo episodes
    public int getEpisodes(){ 
        return this.episodes; 
    }
    //método para clonar a classe
    public Serie clone(){
        Serie resp = new Serie();
        resp.name = this.name;
        resp.format = this.format;
        resp.duration = this.duration;
        resp.country = this.country;
        resp.language = this.language;
        resp.broadcaster = this.broadcaster;
        resp.streaming = this.streaming;
        resp.seasons = this.seasons;
        resp.episodes = this.episodes;
        return resp;
    }
    //método para printar a classe
    public void printClass(){
        System.out.println(this.name + " " + this.format + " " + this.duration.trim() + " " + this.country.trim() + " " + this.language.trim() + " " + this.broadcaster.trim() + " " +
        this.streaming.trim() + " " + this.seasons + " " + this.episodes);
    }
    //método para tratar a linha, deixar apenas números e converter o retorno de String para Integer
    public int justInt(String line){
        String resp = "";
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){ //caso o caracter seja um número ele é concatenado a variável resp
                resp += line.charAt(i);
            } else { //caso seja outro caracter, o i recebe o valor da condição de parada e o método de repetição é encerrado
                i = line.length();
            }
        }
        return Integer.parseInt(resp); //conversão da string resp para número inteiro a ser retornado
    }
    //método para a remoção das tags da linha lida do arquivo para retornar apenas o que é desejado
    public String removeTags(String line){
        String resp = "";
        int i = 0;
        while(i < line.length()){ //enquanto i for menor que o tamanho da String linha
            if(line.charAt(i) == '<'){ // é testado para verificar se o contador i ainda está dentro das tags
                i++;
                while(line.charAt(i) != '>') i++; //ao encontrar o sinal de fechamento das tags o laço de repetição é encerrado
            } else if(line.charAt(i) == '&'){ //mesmo tratamento de cima mas para outras exceções presentes em alguns outros arquivos
                i++;
                while(line.charAt(i) != ';') i++;
            } else { //o que estiver fora das tags é concatenado a String resp a ser retornada
                resp += line.charAt(i);
            }
            i++;
        }
        //System.out.println(resp);
        return resp;
    }
    //método para tratar o nome do arquivo e retornar o nome da série
    public String searchName(String fileName){
        String resp = "";
        for(int i = 0; i < fileName.length(); i++){
            if(fileName.charAt(i)  == '_'){ //caso o caracter na posição i seja igual ao '_' a variável resp recebe um espaço em branco
                resp += ' ';
            } else { //caso não tenha espaço em branco o caracter é concatenado à string resp
                resp += fileName.charAt(i);
            }
        }
        return resp.substring(0, resp.length()-5); //retorno da substring resp retirando os 5 últimos caracteres relacionados à extensão do arquivo
    }
    //método para leitura do arquivo .html e tratamento das linhas
    public void readClass(String fileName){
        String line;
        String resp = "";
        String file = "/tmp/series/" + fileName;
        try {
            FileReader fileReader = new FileReader(file); //declaração da variável fileReader que será recebida pelo bufferedReader

            BufferedReader br = new BufferedReader(fileReader); //declaração do bufferedReader para leitura do arquivo
            
            //set nome da série
            this.name = searchName(fileName);
            
            //set Formato da série
            while(!br.readLine().contains("Formato"));
            this.format = removeTags(br.readLine());

            //set duração da série
            while(!br.readLine().contains("Duração"));
            this.duration = removeTags(br.readLine());

            //set país da série
            while(!br.readLine().contains("País de origem"));
            this.country = removeTags(br.readLine());
            this.country = this.country.trim();

            //set idioma da série
            while(!br.readLine().contains("Idioma original"));
            this.language = removeTags(br.readLine());

            //set emissora da série
            while(!br.readLine().contains("Emissora de televisão"));
            this.broadcaster = removeTags(br.readLine());

            //set transmissão original da série
            while(!br.readLine().contains("Transmissão original"));
            this.streaming = removeTags(br.readLine());

            //set temporadas da série
            while(!br.readLine().contains("N.º de temporadas"));
            this.seasons = justInt(removeTags(br.readLine()));

            //set episódios da série
            while(!br.readLine().contains("N.º de episódios"));
            this.episodes = justInt(removeTags(br.readLine()));
            
            
            //fechamento do bufferedReader
            br.close();         
        //Tratamento de exceções
        } catch(FileNotFoundException e) {
                          
        } catch(IOException e) {
            
        }
    }
}

class CCelula {
	public Serie item;
	public CCelula prox;    	
    public CCelula anterior;
    public CCelula(Serie valorItem, CCelula proxCelula, CCelula celulaAnterior)
    {
        item = valorItem;
        prox = proxCelula;
        anterior = celulaAnterior;
    }    
    public CCelula(Serie valorItem, CCelula proxCelula)
    {
        item = valorItem;
        prox = proxCelula;
        anterior = null;
    }    			
    public CCelula(Serie valorItem)
    {
        item = valorItem;
        prox = null;
        anterior = null;
    }    			        	
    public CCelula()
    {
    	item = null;
        prox = null;
        anterior = null;
    }    			        	
}

class CLista {

	private CCelula primeira; // Referencia a c�lula cabe�a
	private CCelula ultima; // Referencia a �ltima c�lula da lista
	private int qtde; // Contador de itens na lista. Deve ser incrementado sempre que um item for
						// inserido e decrementado quando um item for exclu�do.

	// Fun��o construtora. Aloca a c�lula cabe�a e faz todas as refer�ncias
	// apontarem para ela.
	public CLista() {
		primeira = new CCelula();
		ultima = primeira;
	}

	// Verifica se a lista est� vazia. Retorna TRUE se a lista estiver vazia e FALSE
	// se ela tiver elementos.
	public boolean vazia() {
		return primeira == ultima;
	}

	// Insere um novo Item no fim da lista.
	public void insereFim(Serie valorItem) {
		ultima.prox = new CCelula(valorItem, null, ultima);
		ultima = ultima.prox;
		qtde++;
	}

	// Insere um novo Item no come�o da lista
	public void insereComeco(Serie valorItem) {
		CCelula aux = primeira.prox;
		primeira.prox = new CCelula(valorItem, aux, primeira);
		if (aux == null)
			ultima = primeira.prox;
		qtde++;
	}

	public void insereComeco_old(Serie valorItem) {
		primeira.prox = new CCelula(valorItem, primeira.prox);
		if (primeira.prox.prox == null)
			ultima = primeira.prox;
		qtde++;
	}

	// Insere o Item passado por par�metro na posi��o determinada.
	// O par�metro "valorItem" � o item a ser inserido na lista.
	// O par�metro "posicao" � a posi��o na qual o elemento ser� inserido. O
	// primeiro elemento est� na posi��o 1, e assim por diante.
	// Se a posi��o existir e o m�todo conseguir inserir o elemento, retorna TRUE.
	// Caso a posi��o n�o exista, retorna FALSE.
	public boolean insereIndice(Serie valorItem, int posicao) {
		// Verifica se � uma posi��o v�lida e se a lista possui elementos
		if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {
			int i = 0;
			CCelula aux = primeira;
			while (i < posicao - 1) {
				aux = aux.prox;
				i++;
			}
            CCelula nova = new CCelula(valorItem, aux.prox, aux);
			aux.prox = nova;
			qtde++;
			return true;
		}
		return false;
	}

	// Imprime todos os elementos da lista usando o comando while
	public void imprime() {
		CCelula aux = primeira.prox;

		while (aux != null) {
            aux.item.printClass();
			aux = aux.prox;
		}
	}

	// Imprime todos os elementos da lista usando o comando for
	public void imprimeFor() {
		for (CCelula aux = primeira.prox; aux != null; aux = aux.prox)
			System.out.print(aux.item + " ");
	}

	// Imprime todos os elementos simulando formato de lista:
	// [/]->[7]->[21]->[13]->null
	public void imprimeFormatoLista() {
		System.out.print("[/]->");
		for (CCelula aux = primeira.prox; aux != null; aux = aux.prox)
			System.out.print("[" + aux.item + "]->");
		System.out.println("null");
	}

	// Imprime todos os elementos simulando formato de lista:
	// [/]->[7]->[21]->[13]->null
	public void imprimeFormatoLista(String titulo) {
		System.out.println(titulo + "\n");
		System.out.print("[/]->");
		for (CCelula aux = primeira.prox; aux != null; aux = aux.prox)
			System.out.print("[" + aux.item + "]->");
		System.out.println("null");
	}

	// Verifica se o elemento passado como par�metro est� contido na lista.
	// O par�metro "elemento" � o item a ser localizado. O m�todo retorna TRUE caso
	// o Item esteja presente na lista.
	public boolean contem(Serie elemento) {
		boolean achou = false;
		CCelula aux = primeira.prox;
		while (aux != null && !achou) {
			achou = aux.item.equals(elemento);
			aux = aux.prox;
		}
		return achou;
	}

	// Verifica se o elemento passado como par�metro est� contido na lista. (Obs:
	// usando o comando FOR)
	// O par�metro "elemento" � o item a ser localizado. O m�todo retorna TRUE caso
	// o Item esteja presente na lista.
	public boolean contemFor(Serie elemento) {
		boolean achou = false;
		for (CCelula aux = primeira.prox; aux != null && !achou; aux = aux.prox)
			achou = aux.item.equals(elemento);
		return achou;
	}
		
	// Retorna um Serie contendo o primeiro Item da lista. Se a lista estiver vazia
	// a fun��o retorna null.
	public Serie retornaPrimeiro() {
		if (primeira != ultima)
			return primeira.prox.item;
		else
			return null;
	}

	// Retorna um Serie contendo o �ltimo Item da lista. Se a lista estiver vazia a
	// fun��o retorna null.
	public Serie retornaUltimo() {
		if (primeira != ultima)
			return ultima.item;
		else
			return null;
	}

	// Retorna o Item contido na posi��o passada por par�metro
	public Serie retornaIndice(int posicao) {
		// EXERC�CIO : deve retornar o elemento da posi��o p passada por par�metro
		// [cabe�a]->[7]->[21]->[13]->null
		// retornaIndice(2) deve retornar o elemento 21. retornaIndice de uma posi�ao
		// inexistente deve retornar null.
		// Verifica se � uma posi��o v�lida e se a lista possui elementos
		if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {

			// Procura a posicao a ser retornada
			CCelula aux = primeira.prox;
			for (int i = 1; i < posicao; i++, aux = aux.prox)
				;
			return aux.item;
		}
		return null;
	}

	// Remove e retorna o primeiro item da lista (remo��o f�sica, ou seja, elimina a
	// c�lula que cont�m o elemento).
	// Retorna um Serie contendo o Item removido ou null caso a lista esteja vazia.
	public Serie removeRetornaComeco() {
		// Verifica se h� elementos na lista
		if (primeira != ultima) {
			CCelula aux = primeira.prox;
			primeira.prox = aux.prox;
			primeira.anterior = aux.anterior;
			if (primeira.prox == null) // Se a c�lula cabe�a est� apontando para null, significa que o �nico elemento
										// da lista foi removido
				ultima = primeira;
			qtde--;
			return aux.item;
		}
		return null;
	}

	// Remove e retorna o primeiro item da lista (remo��o l�gica, ou seja, remove a
	// c�lula cabe�a fazendo com que a c�lula seguinte ela se torne a nova c�lula
	// cabe�a).
	// Retorna um Serie contendo o item removido ou null caso a lista esteja vazia.
	public Serie removeRetornaComecoSimples() {
		// Verifica se h� elementos na lista
		if (primeira != ultima) {
			primeira = primeira.prox;
			qtde--;
			return primeira.item;
		}
		return null;
	}

	// Remove o primeiro item da lista fazendo com que a c�lula seguinte � c�lula
	// cabe�a se torne a nova c�lula cabe�a. N�o retorna o item removido.
	public void removeComecoSemRetorno() {
		if (primeira != ultima) {
			primeira = primeira.prox;
			qtde--;
		}
	}

	// Remove o �ltimo Item da lista.
	// Retorna um Serie contendo o Item removido ou null caso a lista esteja vazia.
	public Serie removeRetornaFim() {
		if (primeira != ultima) {
			CCelula aux = primeira;
			while (aux.prox != ultima)
				aux = aux.prox;
			CCelula aux2 = aux.prox;
			ultima = aux;
			ultima.prox = null;
			qtde--;
			return aux2.item;
		}
		return null;
	}

	// Remove o �ltimo Item da lista sem retorn�-lo.
	public void removeFimSemRetorno() {
		if (primeira != ultima) {
			CCelula aux = primeira;
			while (aux.prox != ultima)
				aux = aux.prox;
			ultima = aux;
			ultima.prox = null;
			qtde--;
		}
	}

	// Localiza o Item passado por par�metro e o remove da Lista
	// O par�metro "valorItem" � o item a ser removido da lista.
	public void remove(Serie valorItem) {
		if (primeira != ultima) {
			CCelula aux = primeira;
			boolean achou = false;
			while (aux.prox != null && !achou) {
				achou = aux.prox.item.equals(valorItem);
				if (!achou)
					aux = aux.prox;
			}
			if (achou) {
				// achou o elemento
				aux.prox = aux.prox.prox;
				if (aux.prox == null)
					ultima = aux;
				qtde--;
			}
		}
	}

	// Remove o elemento na posi��o passada como par�metro.
	// O par�metro "posicao" � a posi��o a ser removida. OBS: o primeiro elemento
	// est� na posi��o 1, e assim por diante.
	// O m�todo retorna TRUE se a posi��o existe e foi removida com sucesso, e FALSE
	// caso a posi��o n�o exista.
	public boolean removeIndice(int posicao) {
		// Verifica se � uma posi��o v�lida e se a lista possui elementos
		if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {
			int i = 0;
			CCelula aux = primeira;
			while (i < posicao - 1) {
				aux = aux.prox;
				i++;
			}
			aux.prox = aux.prox.prox;
			if (aux.prox == null)
				ultima = aux;
			qtde--;
			return true;
		}
		return false;
	}

	// Remove e retorna o elemento na posi��o passada como par�metro.
	// O par�metro "posicao" � a posi��o a ser removida. OBS: o primeiro elemento
	// est� na posi��o 1, e assim por diante.
	// O m�todo retorna um Serie contendo o elemento removido da lista. Caso a
	// posi��o seja inv�lida, retorna null.
	public Serie removeRetornaIndice(int posicao) {
		// Verifica se � uma posi��o v�lida e se a lista possui elementos
		if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {
			int i = 0;
			CCelula aux = primeira;
			while (i < posicao - 1) {
				aux = aux.prox;
				i++;
			}
			CCelula aux2 = aux.prox;
			aux.prox.prox.anterior = aux.prox.anterior;
			aux.prox = aux.prox.prox;
			if (aux.prox == null)
				ultima = aux;
			qtde--;
			return aux2.item;
		}
		return null;
	}

	// M�todo(getter) que retorna a quantidade de itens da lista.
	public int quantidade() {
		return qtde;
	}

}


public class Main{

    public static void matricula(long time, int contador){ 

        try {
            File file = new File("matriculaCountingsort.txt");
            if (file.createNewFile()) {
            } else { }
        } catch (IOException e) {
            e.printStackTrace();
          }
    
        try {
        FileWriter input = new FileWriter("matriculaCountingsort.txt");
        input.write("728764" + "\t" + time + "\t" + contador);
        input.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
    
    }
	//Função que retorna o ponto de parada da leitura.
    public static boolean returnEnd(String fim){
        boolean result;

        result = (fim.length() == 3 && fim.charAt(0) == 'F' && fim.charAt(1) == 'I' && fim.charAt(2) == 'M');

        return result;
    }

    //Função que realiza o quiclsort
    public static void quicksort(int esq, int dir, CLista lista) {
		int i = esq, j = dir;
        Serie pivo = lista.retornaIndice((esq+dir)/2);
		while (i <= j) {
				while (lista.retornaIndice(i).getCountry().compareTo(pivo.getCountry()) < 0 || lista.retornaIndice(i).getCountry().compareTo(pivo.getCountry()) == 0 && lista.retornaIndice(i).getName().compareTo(pivo.getName()) < 0)
						i++;
				while (lista.retornaIndice(j).getCountry().compareTo(pivo.getCountry()) > 0 || lista.retornaIndice(j).getCountry().compareTo(pivo.getCountry()) == 0 && lista.retornaIndice(j).getName().compareTo(pivo.getName()) > 0) 
						j--;

				if (i <= j){ 
                    Serie aux = lista.retornaIndice(i);
					lista.removeIndice(i);
                    lista.insereIndice(lista.retornaIndice(j), i);
					lista.removeIndice(j);
					lista.insereIndice(aux, j);
                    i++; 
                    j--; 
                }
		}
		if (esq < j)
				quicksort(esq, j, lista);
		if (i < dir)
				quicksort(i, dir, lista);
    }

	public static void main(String args[]){

		CLista listaDupla = new CLista();
		Scanner teclado = new Scanner(System.in);
		//Inicialização do timer de execução
		long startTime = System.nanoTime();
        int inputCounter = 0;
        int contaodrDeRepeticoes = 0;
        String input;
        int i = 0;


        //Leitura dos inputs
		while(true){
            Serie serie = new Serie();
			input = teclado.nextLine();
            if(returnEnd(input) == true)
                break;
            serie.readClass(input);
			listaDupla.insereFim(serie);
			inputCounter++;
		}		
	
        //Chamada do quicksort
        quicksort(1, listaDupla.quantidade(), listaDupla);

       listaDupla.imprime();

		long endTime = System.nanoTime(); //Fim do timer
		long duration = (endTime - startTime);  //Cálculo do tempo
        matricula(duration, contaodrDeRepeticoes);

		teclado.close();
    }

}