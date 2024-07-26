package list.pesquisa.catalogolivros;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> catalogoLivros;

    public CatalogoLivros() {
        this.catalogoLivros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int ano) {
        catalogoLivros.add(new Livro(titulo, autor, ano));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosMesmoAutor = new ArrayList<>();

        if(!catalogoLivros.isEmpty()) {
            for (Livro l : catalogoLivros) {
                if(l.getAutor().equalsIgnoreCase(autor)) {
                    livrosMesmoAutor.add(l);
                }
            }

            return livrosMesmoAutor;
        }
        return livrosMesmoAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosMesmoIntervalo = new ArrayList<>();

        if(!catalogoLivros.isEmpty()) {
            for (Livro l : catalogoLivros) {
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosMesmoIntervalo.add(l);
                }
            }
        }

        return livrosMesmoIntervalo;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livro =  null;

        if(!catalogoLivros.isEmpty()) {
            for (Livro l : catalogoLivros) {
                if(l.getTitulo().equalsIgnoreCase(titulo)) {
                    livro = l;
                    break;
                }
            }
        }

        return livro;
    }

    public static void main(String [] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 1", 2021);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 4", 2015);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 2", 2016);
        catalogoLivros.adicionarLivro("Livro 5", "Autor 1", 2010);
        catalogoLivros.adicionarLivro("Livro 6", "Autor 3", 2023);

        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 1"));

        System.out.println();

        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2021, 2024));

        System.out.println();

        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 4"));
    }
}
