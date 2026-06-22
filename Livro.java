public class Livro implements Comparable<Livro> {
    private String titulo;
    private String autor;
    private String isbn;
    private int ano;

    public Livro(String titulo, String autor, String isbn, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public int compareTo(Livro outro) {
        return this.titulo.compareToIgnoreCase(outro.titulo);
    }

    public String toString() {
        return "Título: " + titulo +
               " | Autor: " + autor +
               " | ISBN: " + isbn +
               " | Ano: " + ano;
    }
}
