
package com.org.core.project.bussinesLogic;
import java.util.Random;

public class GeradorDeNumeros{
    
    // Retorna um array de números ordenados no intervalo [start, end]
    public int[] getSortedNumbers(int start, int end) {
        int size = end - start + 1;
        int[] sortedNumbers = new int[size];

        for (int i = 0; i < size; i++) {
            sortedNumbers[i] = start + i;
        }

        return sortedNumbers;
    }

    // Retorna um array de números desordenados e aleatórios no intervalo [start, end]
    public int[] getRandomNumbers(int start, int end) {
        int size = end - start + 1;
        int[] randomNumbers = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomNumbers[i] = random.nextInt(end - start + 1) + start;
        }

        return randomNumbers;
    }

    // Retorna um array de números em ordem decrescente no intervalo [start, end]
    public int[] getDescendingNumbers(int start, int end) {
        int size = end - start + 1;
        int[] descendingNumbers = new int[size];

        for (int i = 0; i < size; i++) {
            descendingNumbers[i] = end - i;
        }

        return descendingNumbers;
    }
}

