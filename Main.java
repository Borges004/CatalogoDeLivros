import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreLivros arvore = new ArvoreLivros();

        // Inserção 
        arvore.inserir(new Livro("A Metamorfose", "Franz Kafka", "9788571646858", 1915));
        arvore.inserir(new Livro("O Cortiço", "Aluísio Azevedo", "9788542221145", 1890));
        arvore.inserir(new Livro("Vinte Mil Léguas Submarinas", "Júlio Verne", "9788500016448", 1871));
        arvore.inserir(new Livro("A Morte de Ivan Ilitch", "Liev Tolstói", "9780307388865", 1886));
        arvore.inserir(new Livro("Tite", "Camila Mattoso", "8578885953", 2016));
        arvore.inserir(new Livro("Livro do Desassossego", "Fernando Pessoa", "8535908498", 1982));
        arvore.inserir(new Livro("Cem Anos de Solidão", "Gabriel García Márquez", "9780060929794", 1967));
        arvore.inserir(new Livro("Jantar Secreto", "Raphael Montes", "9786559214549", 2016));
        arvore.inserir(new Livro("Tabacaria", "Fernando Pessoa", "9789897241161", 1933));
        arvore.inserir(new Livro("Tormenta", "Lauren Kate", "9788551013748", 2010));

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Inserir livro");
            System.out.println("2. Buscar livro");
            System.out.println("3. Remover livro");
            System.out.println("4. Exibir em ordem");
            System.out.println("5. Pré-ordem");
            System.out.println("6. Pós-ordem");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();

                    arvore.inserir(new Livro(titulo, autor, isbn, ano));
                    break;

                case 2:
                    System.out.print("Digite o título: ");
                    String busca = sc.nextLine();
                    Livro livro = arvore.buscar(busca);

                    if (livro != null)
                        System.out.println(livro);
                    else
                        System.out.println("Livro não encontrado.");
                    break;

                case 3:
                    System.out.print("Título para remover: ");
                    String rem = sc.nextLine();
                    arvore.remover(rem);
                    break;

                case 4:
                    arvore.emOrdem();
                    break;

                case 5:
                    arvore.preOrdem();
                    break;

                case 6:
                    arvore.posOrdem();
                    break;

            }

        } while (opcao != 0);

        sc.close();
    }
}
