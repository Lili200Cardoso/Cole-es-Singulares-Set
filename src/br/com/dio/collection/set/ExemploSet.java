package br.com.dio.collection.set;

import java.util.*;
//import java.util.HashSet;
//import java.util.ArrayList;

public class ExemploSet {
    public static void main(String[] args) {

// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:


        //FORMAS DE INICIARLIZAR UM SET
//  Set notas = new HashSet();  //antes do java 5
//  Set<Double> notas = new HashSet<>(); //Generics(jdk 5)- Diamont Operator(jdk 7)
//  Set<Double> notas = Set.of(7D, 8.5, 9.3, 5D, 7D, 0D, 3.6);
//  notas.add(1D);
//  notas.remove(5D);
//  System.out.println(notas);

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7D, 8.5, 9.3, 5D, 7D, 0D, 3.6));
        System.out.println(notas.toString());//HashSet<>Devolve a lista sem estar na ordem natural ou de incersão

        System.out.println("Exiba a posição da nota 5.0: ");//Qdo estamos trabalhando com o SET nao conseguimos fazer busca de acordo com a posição.
        //Não temos a aqui no HashSet a função IndexOf(), como em List!

        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");//NÃO é possivél trabalhar com indice em hashSet;

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");//Não existe uma função em Set que faça algo assim!

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5D) );//Retornará true, caso verdade.

        System.out.println("Exiba a terceira nota adicionada: ");//Não é ppossivél trabalhar com indices em Set.

        System.out.println("Exiba a menor nota: " + Collections.min(notas));//Faremos como em List.

        System.out.println("Exiba a maior nota: " + Collections.max(notas));//Igual fizemos em list;

        //Usaremos como em List o metódo Iterator();
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0D;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        System.out.println("Exiba a média das notas:  " + (soma/notas.size()));//Pegaremos a soma dos elemntos e dividiremos
        // pela quantidade de elemntos, o metódo que nos retorna a qtd é size().

        System.out.println("Remova a nota 0: ");
        notas.remove(0D);//Usaremos o metódo remove(), não esquecendo de colocar o tipo do objeto, para não dar erro!
        System.out.println(notas);

        System.out.println("Remova a nota da posição 0");//Não é possivél... não trabalha indices...

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");// Para isso vamos criar uma nova lista,
        //usando LinkedHashSet, pois o Hashset, não possui essa função!
        Set<Double>notas2 = new LinkedHashSet<>(Arrays.asList(7D, 8.5, 9.3, 5D, 7D, 0D, 3.6));
        System.out.println(notas2);

        System.out.println("Exiba todas as notas na ordem crescente: ");//usaremos TreeSet e o comparable de Double...
        Set<Double> notas3 = new TreeSet<>(notas2);//TreeSet insere na ordem natural, ou seja, em caso de números, crescente...
        System.out.println(notas3);//Usamos o notas2 como parametros por se tratar de Double e sendo assim, impplementa o comparable

        System.out.println("Apague todo o conjunto: ");
        notas.clear();

        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());


    }
}
