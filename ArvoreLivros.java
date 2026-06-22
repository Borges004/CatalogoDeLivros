public class ArvoreLivros {
    private No raiz;

    public void inserir(Livro livro) {
        raiz = inserirRec(raiz, livro);
    }

    private No inserirRec(No raiz, Livro livro) {
        if (raiz == null) {
            return new No(livro);
        }

        if (livro.compareTo(raiz.livro) < 0) {
            raiz.esquerda = inserirRec(raiz.esquerda, livro);
        } else {
            raiz.direita = inserirRec(raiz.direita, livro);
        }

        return raiz;
    }

    public Livro buscar(String titulo) {
        return buscarRec(raiz, titulo);
    }

    private Livro buscarRec(No raiz, String titulo) {
        if (raiz == null) return null;

        int comp = titulo.compareToIgnoreCase(raiz.livro.getTitulo());

        if (comp == 0) return raiz.livro;
        else if (comp < 0) return buscarRec(raiz.esquerda, titulo);
        else return buscarRec(raiz.direita, titulo);
    }

    public void remover(String titulo) {
        raiz = removerRec(raiz, titulo);
    }

    private No removerRec(No raiz, String titulo) {
        if (raiz == null) return null;

        int comp = titulo.compareToIgnoreCase(raiz.livro.getTitulo());

        if (comp < 0) {
            raiz.esquerda = removerRec(raiz.esquerda, titulo);
        } else if (comp > 0) {
            raiz.direita = removerRec(raiz.direita, titulo);
        } else {
            if (raiz.esquerda == null && raiz.direita == null) {
                return null;
            }
            else if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }
            else {
                No sucessor = menorValor(raiz.direita);
                raiz.livro = sucessor.livro;
                raiz.direita = removerRec(raiz.direita, sucessor.livro.getTitulo());
            }
        }

        return raiz;
    }

    private No menorValor(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    public void emOrdem() {
        emOrdemRec(raiz);
    }

    private void emOrdemRec(No raiz) {
        if (raiz != null) {
            emOrdemRec(raiz.esquerda);
            System.out.println(raiz.livro);
            emOrdemRec(raiz.direita);
        }
    }

    public void preOrdem() {
        preOrdemRec(raiz);
    }

    private void preOrdemRec(No raiz) {
        if (raiz != null) {
            System.out.println(raiz.livro);
            preOrdemRec(raiz.esquerda);
            preOrdemRec(raiz.direita);
        }
    }

    public void posOrdem() {
        posOrdemRec(raiz);
    }

    private void posOrdemRec(No raiz) {
        if (raiz != null) {
            posOrdemRec(raiz.esquerda);
            posOrdemRec(raiz.direita);
            System.out.println(raiz.livro);
        }
    }
}
