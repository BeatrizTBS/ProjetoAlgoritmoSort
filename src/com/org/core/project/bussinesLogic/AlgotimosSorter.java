/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.core.project.bussinesLogic;

import java.util.Arrays;


public class AlgotimosSorter {
    
    
    // Método para ordenar um array usando o algoritmo Bubble Sort
    protected static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca os elementos se estiverem fora de ordem
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // Se nenhum elemento foi trocado, o array está ordenado
            if (!swapped) {
                break;
            }
        }
    }
    
     // Método para ordenar um array usando o Improved Bubble Sort
    protected static void improvedBubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca os elementos se estiverem fora de ordem
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // Se nenhum elemento foi trocado, o array está ordenado
            if (!swapped) {
                break;
            }
        }
    }
    
     // Método para ordenar um array usando o algoritmo Insertion Sort
    protected static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Mover os elementos do array[0..i-1] que são maiores que a chave
            // para uma posição à frente de sua posição atual
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }
    
    // Método para ordenar um array usando o algoritmo Selection Sort
    protected static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            // Encontrar o menor elemento no array não ordenado
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Trocar o menor elemento com o primeiro elemento não ordenado
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
     // Método para ordenar um array usando o algoritmo Merge Sort
    protected static void mergeSort(int[] array) {
        int n = array.length;

        if (n > 1) {
            int mid = n / 2;

            // Dividir o array em duas metades
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, n);

            // Recursivamente ordenar as duas metades
            mergeSort(left);
            mergeSort(right);

            // Combinar as duas metades ordenadas
            merge(array, left, right);
        }
    }

    protected static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copiar os elementos restantes de left, se houver
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copiar os elementos restantes de right, se houver
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
     protected static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Encontrar a posição correta do pivô no subarray
            int pi = partition(array, low, high);

            // Recursivamente ordenar os elementos antes e depois do pivô
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // Comparação para ordenar em ordem crescente
            if (array[j] < pivot) {
                i++;

                // Trocar array[i] e array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Trocar array[i + 1] e array[high] (ou seja, o pivô)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
    
     // Método para ordenar um array usando o algoritmo Heap Sort
    protected static void heapSort(int[] array) {
        int n = array.length;

        // Construir um heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extrair elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Trocar a raiz (maior elemento) com o último elemento
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Chamar heapify no heap reduzido
            heapify(array, i, 0);
        }
    }

    protected static void heapify(int[] array, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // Verificar se o filho da esquerda é maior que o pai
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Verificar se o filho da direita é maior que o pai
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // Se o maior elemento não for o pai, trocar e chamar heapify recursivamente
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }
}
