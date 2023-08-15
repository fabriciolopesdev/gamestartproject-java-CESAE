import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Projeto {
    public Projeto() throws FileNotFoundException {
    }

    public static void lerLinhasDoFicheiro() throws FileNotFoundException {

        // Declarar variáveis
        String linha;
        String[] linhaDividida = new String[9];
        String[][] gaveta = new String[125][9];
        int correrLinha = 0;

        // Para abrir o ficheiro
        File ficheiro = new File("recursos/GameStart.csv");

        // A variável Scanner ficheiro está aramazenando os dados do ficheiro csv
        Scanner scannerFicheiro = new Scanner(ficheiro);

        /* Para pular a primeira linha do ficheiro csv cabeçalho =>
         (idVenda;idCliente;nomeCliente;contacto;email;editora;categoria;jogo;valor) */
        scannerFicheiro.nextLine();

        // Para cada linha do ficheiro ele vai rodar enquanto tiver outra linha.
        while (scannerFicheiro.hasNextLine()) {
            //variavel linha -> Para armazenar cada linha que ele passa.
            linha = scannerFicheiro.nextLine();

            //Variavel linha Dividida divide as informações no (;)
            linhaDividida = linha.split(",");

            // Ciclo para imprimir o array e guardar na matriz (gaveta).
            for (int coluna = 0; coluna < linhaDividida.length; coluna++) {
                //A coluna vai chegar até o 9 dela e depois vai pular pra seguinte, porque tem o correrlinha++
                //[0][0], [0][1]...[0][9]
                //[1][0], [1][1]...[1][9]...
                //[125][0], ... [125][9]
                //Até o tamanho que eu determinei na declaração da variável.
                // String[][] gaveta = new String[126][9];
                gaveta[correrLinha][coluna] = linhaDividida[coluna];
            }
            //Começou com 0 e cada vez que passar o for, acrescenta +1.
            correrLinha++;
        }


        //Imprimir o conteúdo das gavetas (matriz) no console
        for (int linhaImprimir = 0; linhaImprimir < 125; linhaImprimir++) {
            for (int coluna = 0; coluna < 9; coluna++) {//O for de dentro começa por causa da posição de cima, entrando como 0
                // e depois que ele executar tudo o que ta dentro, ele sai e vai para outra linha, assim encrementa (++)

                //Printar a gaveta com as posições da linha e coluna que fez no ciclo.
                System.out.print(" " + gaveta[linhaImprimir][coluna] + " ");
            }
            // Pra ficar bonito.
            System.out.println(" ");
        }
        //Pra fechar o arquivo, porque foi aberto la em cima no programa.
        scannerFicheiro.close();
    }

    public static void selecionarMenu() throws FileNotFoundException {

        //Só para ler o que o usuário insere
        Scanner input = new Scanner(System.in);

        //Declarar as variáveis
        String password = "";
        int opcao, escolhaDoAdmin, escolhaDoCliente;
        //int para o menu

        System.out.println("Escolha uma opcao: 1 - admin ou 2 - cliente");
        opcao = input.nextInt(); // Armazenar a escolha do usuario. a opção vai ser o que o usuário vai digitar (1 ou 2)

        if (opcao == 1) { //Definir se é cliente ou admin
            System.out.println("Admin");
            System.out.println("Digite a password"); //Se sim, pede a password.
            password = input.next(); //Imprime a password

            if (password.equals("123456789")) {//Verifica a password
                System.out.println("Password correta");

                // Para mostrar as opções de menu
                System.out.println("Escolha uma opção: 1. Imprima o seu conteúdo na consola.\n" +
                        "2. Imprima quantas vendas foram executadas e o seu valor total.\n" +
                        "3. Sabendo que a GameStart tem 10% de lucro em cada jogo, calcule o total de lucro.\n" +
                        "4. Dado um idCliente, imprima todas as informações associadas a esse cliente (nome, contacto, email).\n" +
                        "5. Imprima qual o jogo mais caro e os clientes que o compraram ");

                //Imprime e armazena a escolha do Admin
                escolhaDoAdmin = input.nextInt();

                switch (escolhaDoAdmin) {
                    case 1:
                        System.out.println("1. Imprima o seu conteúdo na consola.");
                        escolher1Admin();
                        break;

                    case 2:
                        System.out.println("2. Imprima quantas vendas foram executadas e o seu valor total.");
                        escolher2Admin();
                        break;

                    case 3:
                        System.out.println("3. Sabendo que a GameStart tem 10% de lucro em cada jogo, calcule o total de lucro.");
                        escolher3Admin();
                        break;

                    case 4:
                        System.out.println("4. Dado um idCliente, imprima todas as informações associadas a esse cliente (nome, contacto, email).");
                        escolher4Admin();
                        break;

                    case 5:
                        System.out.println("5. Imprima qual o jogo mais caro e os clientes que o compraram");
                        escolher5Admin();
                        break;

                    default:
                        System.out.println("Opcao inválida.");
                        break;
                }
            } else {
                System.out.println("Password incorreta.Tente novamente.");
            }
        } else {
            System.out.println("Cliente");

            //Para mostrar a escolha do menu para o cliente
            System.out.println("1. Imprima todos os títulos de jogos (sem duplicados).\n" +
                    "2. Dada uma Editora, imprima todas as categorias e os respetivos jogos.\n");

            //Imprime e armazena a escolha do cliente
            escolhaDoCliente = input.nextInt();

            switch (escolhaDoCliente) {
                case 1:
                    System.out.println("1. Imprima todos os títulos de jogos (sem duplicados)");
                    escolher1Cliente();
                    break;

                case 2:
                    System.out.println("2. Dada uma Editora, imprima todas as categorias e os respetivos jogos.");
                    escolher2Cliente();
                    break;

                default:
                    System.out.println("Opcao inválida.");
                    break;
            }
        }

    }

    public static void escolher1Admin() throws FileNotFoundException {

        // Declarar variáveis
        String linha;
        String[] linhaDividida = new String[9];
        String[][] gaveta = new String[125][9];
        int correrLinha = 0;

        // Para abrir o ficheiro
        File ficheiro = new File("recursos/GameStart.csv");

        // A variável Scanner ficheiro está aramazenando os dados do ficheiro csv
        Scanner scannerFicheiro = new Scanner(ficheiro);

        /* Para pular a primeira linha do ficheiro csv cabeçalho =>
         (idVenda;idCliente;nomeCliente;contacto;email;editora;categoria;jogo;valor) */
        scannerFicheiro.nextLine();

        // Para cada linha do ficheiro ele vai rodar enquanto tiver outra linha.
        while (scannerFicheiro.hasNextLine()) {
            //variavel linha -> Para armazenar cada linha que ele passa.
            linha = scannerFicheiro.nextLine();

            //Variavel linha Dividida divide as informações no (;)
            linhaDividida = linha.split(",");

            // Ciclo para imprimir o array e guardar na matriz (gaveta).
            for (int coluna = 0; coluna < linhaDividida.length; coluna++) {
                //A coluna vai chegar até o 9 dela e depois vai pular pra seguinte, porque tem o correrlinha++
                //[0][0], [0][1]...[0][9]
                //[1][0], [1][1]...[1][9]...
                //[125][0], ... [125][9]
                //Até o tamanho que eu determinei na declaração da variável.
                // String[][] gaveta = new String[126][9];
                gaveta[correrLinha][coluna] = linhaDividida[coluna];
            }
            //Começou com 0 e cada vez que passar o for, acrescenta +1.
            correrLinha++;
        }


        //Imprimir o conteúdo das gavetas (matriz) no console
        for (int linhaImprimir = 0; linhaImprimir < 125; linhaImprimir++) {
            for (int coluna = 0; coluna < 9; coluna++) {//O for de dentro começa por causa da posição de cima, entrando como 0
                // e depois que ele executar tudo o que ta dentro, ele sai e vai para outra linha, assim encrementa (++)

                //Printar a gaveta com as posições da linha e coluna que fez no ciclo.
                System.out.print(" " + gaveta[linhaImprimir][coluna] + " ");
            }
            // Pra ficar bonito.
            System.out.println(" ");
        }
        //Pra fechar o arquivo, porque foi aberto la em cima no programa.
        scannerFicheiro.close();
    }

    public static double escolher2Admin() throws FileNotFoundException {
        // Declarar variáveis
        String linha;
        String[] linhaDividida = new String[9];
        String[][] gaveta = new String[125][9];
        int correrLinha = 0;

        // Para abrir o ficheiro
        File ficheiro = new File("recursos/GameStart.csv");

        // A variável Scanner ficheiro está aramazenando os dados do ficheiro csv
        Scanner scannerFicheiro = new Scanner(ficheiro);

        /* Para pular a primeira linha do ficheiro csv cabeçalho =>
         (idVenda;idCliente;nomeCliente;contacto;email;editora;categoria;jogo;valor) */
        scannerFicheiro.nextLine();

        // Para cada linha do ficheiro ele vai rodar enquanto tiver outra linha.
        while (scannerFicheiro.hasNextLine()) {
            //variavel linha -> Para armazenar cada linha que ele passa.
            linha = scannerFicheiro.nextLine();

            //Variavel linha Dividida divide as informações no (;)
            linhaDividida = linha.split(",");

            // Ciclo para imprimir o array e guardar na matriz (gaveta).
            for (int coluna = 0; coluna < linhaDividida.length; coluna++) {
                //A coluna vai chegar até o 9 dela e depois vai pular pra seguinte, porque tem o correrlinha++
                //[0][0], [0][1]...[0][9]
                //[1][0], [1][1]...[1][9]...
                //[125][0], ... [125][9]
                //Até o tamanho que eu determinei na declaração da variável.
                // String[][] gaveta = new String[126][9];
                gaveta[correrLinha][coluna] = linhaDividida[coluna];
            }
            //Começou com 0 e cada vez que passar o for, acrescenta +1.
            correrLinha++;
        }


        //Imprimir o conteúdo das gavetas (matriz) no console
        for (int linhaImprimir = 0; linhaImprimir < 125; linhaImprimir++) {
            for (int coluna = 0; coluna < 9; coluna++) {//O for de dentro começa por causa da posição de cima, entrando como 0
                // e depois que ele executar tudo o que ta dentro, ele sai e vai para outra linha, assim encrementa (++)

                //Printar a gaveta com as posições da linha e coluna que fez no ciclo.
                // System.out.print(" " + gaveta[linhaImprimir][coluna] + " ");
            }
            // Pra ficar bonito.
            // System.out.println(" ");
        }
        //Pra fechar o arquivo, porque foi aberto la em cima no programa.
        scannerFicheiro.close();


        // Declarar variáveis
        int totalVendas = 0; //Variável para o total de vendas
        double valorTotal = 0; //Variável para calcular o valor total de vendas


        for (int linhaImprimir = 0; linhaImprimir < 125; linhaImprimir++) { //Para rodar todas as linhas
            if (gaveta[linhaImprimir][8] != null) { //Se na posição for verdadeira, ele vai retornar diferente de null
                totalVendas++;//Para incrementar
                valorTotal += Double.parseDouble(gaveta[linhaImprimir][8]); //Valor total na posição do valor[8]
            }
        }
        System.out.println("Total de vendas: " + totalVendas);//Printar o total de vendas
        System.out.println("Valor total: " + valorTotal);//Printar o valor total

        return valorTotal; //Returno para utilizar depois para fazer o lucro.
    }


    public static void escolher3Admin() throws FileNotFoundException {

        //Declarar a variável
        double valorTotal = escolher2Admin();//Variavel para guardar o resultado do valor total dentro da função.
        double lucro;// variavel para receber o valor total para verificar o lucro.
        lucro = valorTotal * 0.1;//Cálculo de 10%
        System.out.println("O lucro de 10% do total de cada jogo e: " + lucro);//Printe para imprimir o lucro

    }

    public static void escolher4Admin() throws FileNotFoundException {

        // Declarar variáveis
        String linha;
        String[] linhaDividida = new String[9];
        String[][] gaveta = new String[125][9];
        int correrLinha = 0;

        // Para abrir o ficheiro
        File ficheiro = new File("recursos/GameStart.csv");

        // A variável Scanner ficheiro está aramazenando os dados do ficheiro csv
        Scanner scannerFicheiro = new Scanner(ficheiro);

        /* Para pular a primeira linha do ficheiro csv cabeçalho =>
         (idVenda;idCliente;nomeCliente;contacto;email;editora;categoria;jogo;valor) */
        scannerFicheiro.nextLine();

        // Para cada linha do ficheiro ele vai rodar enquanto tiver outra linha.
        while (scannerFicheiro.hasNextLine()) {
            //variavel linha -> Para armazenar cada linha que ele passa.
            linha = scannerFicheiro.nextLine();

            //Variavel linha Dividida divide as informações no (;)
            linhaDividida = linha.split(",");

            // Ciclo para imprimir o array e guardar na matriz (gaveta).
            for (int coluna = 0; coluna < linhaDividida.length; coluna++) {
                //A coluna vai chegar até o 9 dela e depois vai pular pra seguinte, porque tem o correrlinha++
                //[0][0], [0][1]...[0][9]
                //[1][0], [1][1]...[1][9]...
                //[125][0], ... [125][9]
                //Até o tamanho que eu determinei na declaração da variável.
                // String[][] gaveta = new String[126][9];
                gaveta[correrLinha][coluna] = linhaDividida[coluna];
            }
            //Começou com 0 e cada vez que passar o for, acrescenta +1.
            correrLinha++;
        }


        //Imprimir o conteúdo das gavetas (matriz) no console
        for (int linhaImprimir = 0; linhaImprimir < 125; linhaImprimir++) {
            for (int coluna = 0; coluna < 9; coluna++) {//O for de dentro começa por causa da posição de cima, entrando como 0
                // e depois que ele executar tudo o que ta dentro, ele sai e vai para outra linha, assim encrementa (++)

                //Printar a gaveta com as posições da linha e coluna que fez no ciclo.
                //System.out.print(" " + gaveta[linhaImprimir][coluna] + " ");
            }
            // Pra ficar bonito.
            //System.out.println(" ");
        }
        //Pra fechar o arquivo, porque foi aberto la em cima no programa.
        scannerFicheiro.close();


        //Declarar variável
        String idCliente = ""; //Variável para cliente


        Scanner input = new Scanner(System.in);
        System.out.print("Insira o idCliente: ");//Para perguntar sobre a solicitação do usuário.
        idCliente = input.next();//Para armazenar a solicitação do usuário.


        for (int linhaImprimir = 0; linhaImprimir < 125; linhaImprimir++) {
            //Ciclo para correr todas as linhas e achar o IdCliente identico do usuário.

            if (gaveta[linhaImprimir][1].equals(idCliente)) { //condição para trazer apenas o que for igual ao idCliente

                System.out.println("Informações do cliente:"); //imprimir as informações
                System.out.println("Nome: " + gaveta[linhaImprimir][2]);
                System.out.println("Contacto: " + gaveta[linhaImprimir][3]);
                System.out.println("Email: " + gaveta[linhaImprimir][4]);

                return;//Returno para não retornar o mesmo dado várias vezes. É uma quebra do código. Ele para de correr.
                //É como se fosse um break;
            }
        }
    }

    public static void escolher5Admin() throws FileNotFoundException {

        // Declarar variáveis
        String linha;
        String[] linhaDividida = new String[9];
        String[][] gaveta = new String[125][9];
        int correrLinha = 0;

        // Para abrir o ficheiro
        File ficheiro = new File("recursos/GameStart.csv");

        // A variável Scanner ficheiro está aramazenando os dados do ficheiro csv
        Scanner scannerFicheiro = new Scanner(ficheiro);

        /* Para pular a primeira linha do ficheiro csv cabeçalho =>
         (idVenda;idCliente;nomeCliente;contacto;email;editora;categoria;jogo;valor) */
        scannerFicheiro.nextLine();

        // Para cada linha do ficheiro ele vai rodar enquanto tiver outra linha.
        while (scannerFicheiro.hasNextLine()) {
            //variavel linha -> Para armazenar cada linha que ele passa.
            linha = scannerFicheiro.nextLine();

            //Variavel linha Dividida divide as informações no (;)
            linhaDividida = linha.split(",");

            // Ciclo para imprimir o array e guardar na matriz (gaveta).
            for (int coluna = 0; coluna < linhaDividida.length; coluna++) {
                //A coluna vai chegar até o 9 dela e depois vai pular pra seguinte, porque tem o correrlinha++
                //[0][0], [0][1]...[0][9]
                //[1][0], [1][1]...[1][9]...
                //[125][0], ... [125][9]
                //Até o tamanho que eu determinei na declaração da variável.
                // String[][] gaveta = new String[126][9];
                gaveta[correrLinha][coluna] = linhaDividida[coluna];
            }
            //Começou com 0 e cada vez que passar o for, acrescenta +1.
            correrLinha++;
        }

        //Imprimir o conteúdo das gavetas (matriz) no console
        for (int linhaImprimir = 0; linhaImprimir < 125; linhaImprimir++) {
            for (int coluna = 0; coluna < 9; coluna++) {//O for de dentro começa por causa da posição de cima, entrando como 0
                // e depois que ele executar tudo o que ta dentro, ele sai e vai para outra linha, assim encrementa (++)

            }
            //Pra fechar o arquivo, porque foi aberto la em cima no programa.
            scannerFicheiro.close();

            //***********************************************************************************************
        }

        // Declarar variáveis
        double jogoMaisCaro = 0; //variáveis para preço.
        String nomeDoJogo = " ";//variável pra localizar o jogo mais caro
        int cliente = 0;//variavel cliente

        //Jogo mais caro

        //For para o jogo mais caro
        for (int posicaoLinha = 0; posicaoLinha < 125; posicaoLinha++) {
            if (Double.parseDouble(gaveta[posicaoLinha][8]) > jogoMaisCaro) {//Para comparar qual posição vai ter o maior valor
                jogoMaisCaro = Double.parseDouble(gaveta[posicaoLinha][8]);//Se for mais mais ele troca de lugar. (Porque elas trocam)
            }
        }
        System.out.println("O valor do jogo mais caro e: " + jogoMaisCaro);

        //nome do cliente que comprou

        for (int posicaoLinha = 0; posicaoLinha < 125; posicaoLinha++) {//ciclo pra rodar a posição
            if (Double.parseDouble(gaveta[posicaoLinha][8]) == jogoMaisCaro) {
                String nomeCliente = gaveta[posicaoLinha][2];
                System.out.println("O cliente que comprou e: " + nomeCliente);
            }

        }
    }

    public static void escolher1Cliente() throws FileNotFoundException {

        // Declarar variáveis
        String linha;
        String[] linhaDividida = new String[9];
        String[][] gaveta = new String[125][9];
        int correrLinha = 0;

        // Para abrir o ficheiro
        File ficheiro = new File("recursos/GameStart.csv");

        // A variável Scanner ficheiro está aramazenando os dados do ficheiro csv
        Scanner scannerFicheiro = new Scanner(ficheiro);

        /* Para pular a primeira linha do ficheiro csv cabeçalho =>
         (idVenda;idCliente;nomeCliente;contacto;email;editora;categoria;jogo;valor) */
        scannerFicheiro.nextLine();

        // Para cada linha do ficheiro ele vai rodar enquanto tiver outra linha.
        while (scannerFicheiro.hasNextLine()) {
            //variavel linha -> Para armazenar cada linha que ele passa.
            linha = scannerFicheiro.nextLine();

            //Variavel linha Dividida divide as informações no (;)
            linhaDividida = linha.split(",");

            // Ciclo para imprimir o array e guardar na matriz (gaveta).
            for (int coluna = 0; coluna < linhaDividida.length; coluna++) {
                //A coluna vai chegar até o 9 dela e depois vai pular pra seguinte, porque tem o correrlinha++
                //[0][0], [0][1]...[0][9]
                //[1][0], [1][1]...[1][9]...
                //[125][0], ... [125][9]
                //Até o tamanho que eu determinei na declaração da variável.
                // String[][] gaveta = new String[126][9];
                gaveta[correrLinha][coluna] = linhaDividida[coluna];
            }
            //Começou com 0 e cada vez que passar o for, acrescenta +1.
            correrLinha++;
        }

        //Imprimir o conteúdo das gavetas (matriz) no console
        for (int linhaImprimir = 0; linhaImprimir < 125; linhaImprimir++) {
            for (int coluna = 0; coluna < 9; coluna++) {//O for de dentro começa por causa da posição de cima, entrando como 0
                // e depois que ele executar tudo o que ta dentro, ele sai e vai para outra linha, assim encrementa (++)

            }
            //Pra fechar o arquivo, porque foi aberto la em cima no programa.
            scannerFicheiro.close();


        }
        //***********************************************************************************************

        //Declarar variável
        String titulo = "";

        for (int posicaoLinha = 0; posicaoLinha < 125; posicaoLinha++) {//ciclo pra rodar a posição

            System.out.println("Os titulos sao: " + gaveta[posicaoLinha][7]);


        }
    }

    public static void escolher2Cliente() throws FileNotFoundException {


        // Declarar variáveis
        String linha;
        String[] linhaDividida = new String[9];
        String[][] gaveta = new String[125][9];
        int correrLinha = 0;

        // Para abrir o ficheiro
        File ficheiro = new File("recursos/GameStart.csv");

        // A variável Scanner ficheiro está aramazenando os dados do ficheiro csv
        Scanner scannerFicheiro = new Scanner(ficheiro);

        /* Para pular a primeira linha do ficheiro csv cabeçalho =>
         (idVenda;idCliente;nomeCliente;contacto;email;editora;categoria;jogo;valor) */
        scannerFicheiro.nextLine();

        // Para cada linha do ficheiro ele vai rodar enquanto tiver outra linha.
        while (scannerFicheiro.hasNextLine()) {
            //variavel linha -> Para armazenar cada linha que ele passa.
            linha = scannerFicheiro.nextLine();

            //Variavel linha Dividida divide as informações no (;)
            linhaDividida = linha.split(",");

            // Ciclo para imprimir o array e guardar na matriz (gaveta).
            for (int coluna = 0; coluna < linhaDividida.length; coluna++) {
                //A coluna vai chegar até o 9 dela e depois vai pular pra seguinte, porque tem o correrlinha++
                //[0][0], [0][1]...[0][9]
                //[1][0], [1][1]...[1][9]...
                //[125][0], ... [125][9]
                //Até o tamanho que eu determinei na declaração da variável.
                // String[][] gaveta = new String[126][9];
                gaveta[correrLinha][coluna] = linhaDividida[coluna];
            }
            //Começou com 0 e cada vez que passar o for, acrescenta +1.
            correrLinha++;
        }


        //Imprimir o conteúdo das gavetas (matriz) no console
        for (int linhaImprimir = 0; linhaImprimir < 125; linhaImprimir++) {
            for (int coluna = 0; coluna < 9; coluna++) {//O for de dentro começa por causa da posição de cima, entrando como 0
                // e depois que ele executar tudo o que ta dentro, ele sai e vai para outra linha, assim encrementa (++)

                //Printar a gaveta com as posições da linha e coluna que fez no ciclo.
                //System.out.print(" " + gaveta[linhaImprimir][coluna] + " ");
            }
            // Pra ficar bonito.
            //System.out.println(" ");
        }
        //Pra fechar o arquivo, porque foi aberto la em cima no programa.
        scannerFicheiro.close();


        //Declarar variável
        String editora = ""; //Variável para cliente


        Scanner input = new Scanner(System.in);
        System.out.print("Insira o nome da editora: ");//Para perguntar sobre a solicitação do usuário.
        editora = input.next();//Para armazenar a solicitação do usuário.


        for (int linhaImprimir = 0; linhaImprimir < 125; linhaImprimir++) {
            //Ciclo para correr todas as linhas e achar o IdCliente identico do usuário.

            if (gaveta[linhaImprimir][5].equals(editora)) { //condição para trazer apenas a editora


                System.out.println("Categoria: " + gaveta[linhaImprimir][6]);
                System.out.println("jogos " + gaveta[linhaImprimir][7]);
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {

        selecionarMenu();

    }
}


