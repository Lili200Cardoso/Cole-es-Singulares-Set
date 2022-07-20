package br.com.dio.collection.set;

import java.util.*;

public class Exerciciospropostos {

    public static void main(String[] args) {

        System.out.println("Crie um conjunto contendo as cores do arco-íris: ");
        Set<String> cores = new HashSet<>();
        cores.add("vermelho");
        cores.add("laranja");
        cores.add("amarelo");
        cores.add("verde");
        cores.add("azul");
        cores.add("anil");
        cores.add("violeta");
        System.out.println(cores);

        System.out.println("Exiba todas as cores uma abaixo da outra: ");
        for(String cor : cores){//Usando um foreach,para colocar uma embaixo da outra.
            System.out.println(cor);
        }

        System.out.println("Exiba a quantidade de cores que o arco-íris tem: " + cores.size());

        System.out.println("Exiba as cores em ordem alfabética: ");
        Set<String> cores2 = new TreeSet<>(cores);
        System.out.println(cores2);

        System.out.println("Exiba as cores na ordem inversa da que foi informada: " );
        Set<String> cores3 = new LinkedHashSet<>(Arrays.asList("vermelho", "laranja","amarelo","verde",
                "azul","anil","violeta"));
        System.out.println(cores3);
        List<String> coresList = new ArrayList<>(cores3);
        Collections.reverse(coresList);
        System.out.println(coresList);

        System.out.println("Exiba todas as cores que comecem com a letra v: " );
        for(String cor : cores){
            if(cor.startsWith("v")) System.out.println(cor);//startsWith(), verifica se uma string começa com um caracter
        //Também temos o endsWith(), para verficar se uma string termina com determinado caracter.
        }

        System.out.println("Remova todas as cores que não começam com a letra v: ");
        Iterator<String> iterator2 = cores.iterator();//hasNext(): do iterador,
        // esse metódo retorna true enquanto existe proximo elemento na lista, geralmente usado com o metódo Next().
        while (iterator2.hasNext()){
            if (iterator2.next().startsWith("v")) iterator2.remove();
        }
        System.out.println(cores);

        System.out.println("Limpe o conjunto e Confira se está vazio:");
        cores.clear();
        System.out.println(cores);


    }
}




