package br.com.dio.collection.set;

import java.util.*;


/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
LinguagemFavorita:
nome: Python, anoCriacao: 1989, IDE: JupyterNotebbok
nome: C#, anoCriacao: 1999, IDE: VSCode
nome: Java, anoCriacao: 1991, IDE: Intellij
*/
public class ExercicioProposto2 {
    public static void main(String[] args) {

        Set<LinguagemFavorita> minhasLinguagens = new HashSet<>(){
            {
                add(new LinguagemFavorita("Python", 1989, "JupyterNotebook"));
                add(new LinguagemFavorita("C#", 1999, "VSCode"));
                add(new LinguagemFavorita("Java", 1991, "Intellij"));
            }};
        for(LinguagemFavorita linguagem: minhasLinguagens) System.out.println(linguagem.getNome() + " - "
                + linguagem.getAnoCriacao() + " - " + linguagem.getIDE());



        System.out.println("--\tOrdem Inserção\t--");
        Set<LinguagemFavorita> minhasLinguagens1 = new LinkedHashSet<>(
                Arrays.asList(

                new LinguagemFavorita("Python", 1989, "JupyterNotebook"),
                new LinguagemFavorita("C#", 1999, "VSCode"),
                new LinguagemFavorita("Java", 1991, "Intellij")

                )
        );
        for(LinguagemFavorita linguagem: minhasLinguagens1) System.out.println(linguagem.getNome() + " - "
                + linguagem.getAnoCriacao() + " - " + linguagem.getIDE());


        System.out.println("--\tOrdem Natural(Nome)\t--");
        Set<LinguagemFavorita> minhasLinguagens2 = new TreeSet<>(minhasLinguagens);
        for(LinguagemFavorita linguagem: minhasLinguagens2) System.out.println(linguagem.getNome() + " - "
                + linguagem.getAnoCriacao() + " - " + linguagem.getIDE());

        System.out.println("--\tOrdem IDE\t--");
        Set<LinguagemFavorita> minhasLinguagens3 = new TreeSet<LinguagemFavorita>(new ComparatorIDE());
        minhasLinguagens3.addAll(minhasLinguagens);
        for(LinguagemFavorita linguagem: minhasLinguagens3) System.out.println(linguagem.getNome() + " - "
                + linguagem.getAnoCriacao() + " - " + linguagem.getIDE());


        System.out.println("--\tOrdem Ano de Criação e Nome\t--");
        Set<LinguagemFavorita> minhasLinguagens4 = new TreeSet<LinguagemFavorita>(new ComparatorAnoCriacaoENome());
        minhasLinguagens4.addAll(minhasLinguagens);
        for(LinguagemFavorita linguagem: minhasLinguagens4) System.out.println(linguagem.getNome() + " - "
                + linguagem.getAnoCriacao() + " - " + linguagem.getIDE());

        System.out.println("--\tOrdem Nome e Ano de Criação e IDE\t--");
        Set<LinguagemFavorita> minhasLinguagens5 = new TreeSet<LinguagemFavorita>(new ComparatorNomeAnoCriacaoIDE());
        minhasLinguagens5.addAll(minhasLinguagens);
        for(LinguagemFavorita linguagem: minhasLinguagens5) System.out.println(linguagem.getNome() + " - "
                + linguagem.getAnoCriacao() + " - " + linguagem.getIDE());

    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{

    private String nome;
    private Integer anoCriacao;
    private String IDE;

    public LinguagemFavorita(String nome, Integer anoCriacao, String IDE) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.IDE = IDE;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoCriacao() {
        return anoCriacao;
    }

    public String getIDE() {
        return IDE;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoCriacao=" + anoCriacao +
                ", IDE='" + IDE + '\'' +
                '}';
    }


    @Override
    public int compareTo(LinguagemFavorita linguagem) {

        return this.getNome().compareTo(linguagem.getNome());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }


}
class ComparatorIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {

        return l1.getIDE().compareToIgnoreCase(l2.getIDE());

    }
}
class ComparatorAnoCriacaoENome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoCriacao = Integer.compare(l1.getAnoCriacao(), l2.getAnoCriacao());
        if (anoCriacao != 0) return anoCriacao;
        return l1.getNome().compareToIgnoreCase(l2.getNome());
    }
}

class ComparatorNomeAnoCriacaoIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
        int anoCriacao = Integer.compare(l1.getAnoCriacao(), l2.getAnoCriacao());
        if (nome != 0) return nome;
        if (anoCriacao != 0) return anoCriacao;
        return l1.getIDE().compareToIgnoreCase(l2.getIDE());
    }
}
