/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.core.project.bussinesLogic;

import static com.org.core.project.bussinesLogic.AlgoritimosEnum.BUBBLE_SORT;
import static com.org.core.project.bussinesLogic.AlgoritimosEnum.HEAP_SORT;
import static com.org.core.project.bussinesLogic.AlgoritimosEnum.IMPROVED_BUBBLE_SORT;
import static com.org.core.project.bussinesLogic.AlgoritimosEnum.INSERTION_SORT;
import static com.org.core.project.bussinesLogic.AlgoritimosEnum.MERGE_SORT;
import static com.org.core.project.bussinesLogic.AlgoritimosEnum.QUICK_SORT;
import com.org.core.project.dto.Caso;
import com.org.core.project.dto.InformacaoDoLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;


public class ComponentsLoader  extends AlgotimosSorter{
    
    private GerenciadorDeLog gerenciadorDeLog;
    
    public ComponentsLoader(){
     super();
      gerenciadorDeLog = new GerenciadorDeLog();       
    }

    public DefaultComboBoxModel getComboBoxAlgoritimos() {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        ArrayList<AlgoritimosEnum> listDeAlgoritimos = new ArrayList();
        listDeAlgoritimos.add(AlgoritimosEnum.HEAP_SORT);
        listDeAlgoritimos.add(AlgoritimosEnum.BUBBLE_SORT);
        listDeAlgoritimos.add(AlgoritimosEnum.IMPROVED_BUBBLE_SORT);
        listDeAlgoritimos.add(AlgoritimosEnum.INSERTION_SORT);
        listDeAlgoritimos.add(AlgoritimosEnum.MERGE_SORT);
        listDeAlgoritimos.add(AlgoritimosEnum.QUICK_SORT);
        listDeAlgoritimos.add(AlgoritimosEnum.SELECTION_SORT);
        for (AlgoritimosEnum values : listDeAlgoritimos) {
            defaultComboBoxModel.addElement(values);
        }
        return defaultComboBoxModel;
    }

    public void Work(InformacaoDoLog informacaoDoLog) {
        GeradorDeNumeros geradorDeNumeros = new GeradorDeNumeros();
          ArrayList<Caso> casos = new ArrayList();
        // Exemplo de utilização dos métodos
        switch (informacaoDoLog.algoritimo) {
            case HEAP_SORT: {
                int[] sortedNumbers = geradorDeNumeros.getSortedNumbers(0, informacaoDoLog.valores);                
                int[] randomNumbers = geradorDeNumeros.getRandomNumbers(0, informacaoDoLog.valores);                
                int[] descendingNumbers = geradorDeNumeros.getDescendingNumbers(0, informacaoDoLog.valores);
                //CASO 1
                Caso caso1 = new Caso();
                caso1.setDescCaso("[CRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso1.setDateInicio(new Date());
                caso1.setInicio( System.currentTimeMillis());                
                AlgotimosSorter.heapSort(sortedNumbers);
                caso1.setDateFim(new Date());
                caso1.setFim(System.currentTimeMillis());
                caso1.setTotal(caso1.getFim() - caso1.getInicio());
                casos.add(caso1);
                //CASO 2
                Caso caso2 = new Caso();
                caso2.setDescCaso("[MISTURADO]" +  " 0 ... "+informacaoDoLog.valores );
                caso2.setDateInicio(new Date());
                caso2.setInicio( System.currentTimeMillis());
                AlgotimosSorter.heapSort(randomNumbers);
                caso2.setDateFim(new Date());
                caso2.setFim(System.currentTimeMillis());
                caso2.setTotal(caso2.getFim() - caso2.getInicio());
                casos.add(caso2);
                
                //CASO 3
                Caso caso3 = new Caso();
                caso3.setDescCaso("[DECRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso3.setDateInicio(new Date());
                caso3.setInicio( System.currentTimeMillis());
                AlgotimosSorter.heapSort(descendingNumbers);
                caso3.setDateFim(new Date());
                caso3.setFim(System.currentTimeMillis());
                caso3.setTotal(caso3.getFim() - caso3.getInicio());
                casos.add(caso3);
                
                informacaoDoLog.setCasos(casos);
                gerenciadorDeLog.EscreveLog(informacaoDoLog);
                
                break;
            }
            case BUBBLE_SORT: {
                 int[] sortedNumbers = geradorDeNumeros.getSortedNumbers(0, informacaoDoLog.valores);                
                int[] randomNumbers = geradorDeNumeros.getRandomNumbers(0, informacaoDoLog.valores);                
                int[] descendingNumbers = geradorDeNumeros.getDescendingNumbers(0, informacaoDoLog.valores);
                //CASO 1
                Caso caso1 = new Caso();
                caso1.setDescCaso("[CRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso1.setDateInicio(new Date());
                caso1.setInicio( System.currentTimeMillis());                
                AlgotimosSorter.bubbleSort(sortedNumbers);
                caso1.setDateFim(new Date());
                caso1.setFim(System.currentTimeMillis());
                caso1.setTotal(caso1.getFim() - caso1.getInicio());
                casos.add(caso1);
                //CASO 2
                Caso caso2 = new Caso();
                caso2.setDescCaso("[MISTURADO]" +  " 0 ... "+informacaoDoLog.valores );
                caso2.setDateInicio(new Date());
                caso2.setInicio( System.currentTimeMillis());
                AlgotimosSorter.bubbleSort(randomNumbers);
                caso2.setDateFim(new Date());
                caso2.setFim(System.currentTimeMillis());
                caso2.setTotal(caso2.getFim() - caso2.getInicio());
                casos.add(caso2);
                
                //CASO 3
                Caso caso3 = new Caso();
                caso3.setDescCaso("[DECRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso3.setDateInicio(new Date());
                caso3.setInicio( System.currentTimeMillis());
                AlgotimosSorter.bubbleSort(descendingNumbers);
                caso3.setDateFim(new Date());
                caso3.setFim(System.currentTimeMillis());
                caso3.setTotal(caso3.getFim() - caso3.getInicio());
                casos.add(caso3);
                
                informacaoDoLog.setCasos(casos);                  
                gerenciadorDeLog.EscreveLog(informacaoDoLog);
                break;
            }
            case IMPROVED_BUBBLE_SORT: {
                int[] sortedNumbers = geradorDeNumeros.getSortedNumbers(0, informacaoDoLog.valores);                
                int[] randomNumbers = geradorDeNumeros.getRandomNumbers(0, informacaoDoLog.valores);                
                int[] descendingNumbers = geradorDeNumeros.getDescendingNumbers(0, informacaoDoLog.valores);
                //CASO 1
                Caso caso1 = new Caso();
                caso1.setDescCaso("[CRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso1.setDateInicio(new Date());
                caso1.setInicio( System.currentTimeMillis());                
                AlgotimosSorter.improvedBubbleSort(sortedNumbers);
                caso1.setDateFim(new Date());
                caso1.setFim(System.currentTimeMillis());
                caso1.setTotal(caso1.getFim() - caso1.getInicio());
                casos.add(caso1);
                //CASO 2
                Caso caso2 = new Caso();
                caso2.setDescCaso("[MISTURADO]" +  " 0 ... "+informacaoDoLog.valores );
                caso2.setDateInicio(new Date());
                caso2.setInicio( System.currentTimeMillis());
                AlgotimosSorter.improvedBubbleSort(randomNumbers);
                caso2.setDateFim(new Date());
                caso2.setFim(System.currentTimeMillis());
                caso2.setTotal(caso2.getFim() - caso2.getInicio());
                casos.add(caso2);
                
                //CASO 3
                Caso caso3 = new Caso();
                caso3.setDescCaso("[DECRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso3.setDateInicio(new Date());
                caso3.setInicio( System.currentTimeMillis());
                AlgotimosSorter.improvedBubbleSort(descendingNumbers);
                caso3.setDateFim(new Date());
                caso3.setFim(System.currentTimeMillis());
                caso3.setTotal(caso3.getFim() - caso3.getInicio());
                casos.add(caso3);
                
                informacaoDoLog.setCasos(casos);                  
                gerenciadorDeLog.EscreveLog(informacaoDoLog);
                break;
            }
            case MERGE_SORT: {
                int[] sortedNumbers = geradorDeNumeros.getSortedNumbers(0, informacaoDoLog.valores);                
                int[] randomNumbers = geradorDeNumeros.getRandomNumbers(0, informacaoDoLog.valores);                
                int[] descendingNumbers = geradorDeNumeros.getDescendingNumbers(0, informacaoDoLog.valores);
                //CASO 1
                Caso caso1 = new Caso();
                caso1.setDescCaso("[CRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso1.setDateInicio(new Date());
                caso1.setInicio( System.currentTimeMillis());                
                AlgotimosSorter.mergeSort(sortedNumbers);
                caso1.setDateFim(new Date());
                caso1.setFim(System.currentTimeMillis());
                caso1.setTotal(caso1.getFim() - caso1.getInicio());
                casos.add(caso1);
                //CASO 2
                Caso caso2 = new Caso();
                caso2.setDescCaso("[MISTURADO]" +  " 0 ... "+informacaoDoLog.valores );
                caso2.setDateInicio(new Date());
                caso2.setInicio( System.currentTimeMillis());
                AlgotimosSorter.mergeSort(randomNumbers);
                caso2.setDateFim(new Date());
                caso2.setFim(System.currentTimeMillis());
                caso2.setTotal(caso2.getFim() - caso2.getInicio());
                casos.add(caso2);
                
                //CASO 3
                Caso caso3 = new Caso();
                caso3.setDescCaso("[DECRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso3.setDateInicio(new Date());
                caso3.setInicio( System.currentTimeMillis());
                AlgotimosSorter.mergeSort(descendingNumbers);
                caso3.setDateFim(new Date());
                caso3.setFim(System.currentTimeMillis());
                caso3.setTotal(caso3.getFim() - caso3.getInicio());
                casos.add(caso3);
                
                informacaoDoLog.setCasos(casos);                  
                gerenciadorDeLog.EscreveLog(informacaoDoLog);
                break;
            }
            
            case INSERTION_SORT: {
                int[] sortedNumbers = geradorDeNumeros.getSortedNumbers(0, informacaoDoLog.valores);                
                int[] randomNumbers = geradorDeNumeros.getRandomNumbers(0, informacaoDoLog.valores);                
                int[] descendingNumbers = geradorDeNumeros.getDescendingNumbers(0, informacaoDoLog.valores);
                //CASO 1
                Caso caso1 = new Caso();
                caso1.setDescCaso("[CRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso1.setDateInicio(new Date());
                caso1.setInicio( System.currentTimeMillis());                
                AlgotimosSorter.insertionSort(sortedNumbers);
                caso1.setDateFim(new Date());
                caso1.setFim(System.currentTimeMillis());
                caso1.setTotal(caso1.getFim() - caso1.getInicio());
                casos.add(caso1);
                //CASO 2
                Caso caso2 = new Caso();
                caso2.setDescCaso("[MISTURADO]" +  " 0 ... "+informacaoDoLog.valores );
                caso2.setDateInicio(new Date());
                caso2.setInicio( System.currentTimeMillis());
                AlgotimosSorter.insertionSort(randomNumbers);
                caso2.setDateFim(new Date());
                caso2.setFim(System.currentTimeMillis());
                caso2.setTotal(caso2.getFim() - caso2.getInicio());
                casos.add(caso2);
                
                //CASO 3
                Caso caso3 = new Caso();
                caso3.setDescCaso("[DECRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso3.setDateInicio(new Date());
                caso3.setInicio( System.currentTimeMillis());
                AlgotimosSorter.insertionSort(descendingNumbers);
                caso3.setDateFim(new Date());
                caso3.setFim(System.currentTimeMillis());
                caso3.setTotal(caso3.getFim() - caso3.getInicio());
                casos.add(caso3);
                
                informacaoDoLog.setCasos(casos);                  
                gerenciadorDeLog.EscreveLog(informacaoDoLog);
                break;
            }
            
            case QUICK_SORT: {
                int[] sortedNumbers = geradorDeNumeros.getSortedNumbers(0, informacaoDoLog.valores);                
                int[] randomNumbers = geradorDeNumeros.getRandomNumbers(0, informacaoDoLog.valores);                
                int[] descendingNumbers = geradorDeNumeros.getDescendingNumbers(0, informacaoDoLog.valores);
                //CASO 1
                Caso caso1 = new Caso();
                caso1.setDescCaso("[CRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso1.setDateInicio(new Date());
                caso1.setInicio( System.currentTimeMillis());                
                AlgotimosSorter.quickSort(sortedNumbers, 0 ,informacaoDoLog.valores );
                caso1.setDateFim(new Date());
                caso1.setFim(System.currentTimeMillis());
                caso1.setTotal(caso1.getFim() - caso1.getInicio());
                casos.add(caso1);
                //CASO 2
                Caso caso2 = new Caso();
                caso2.setDescCaso("[MISTURADO]" +  " 0 ... "+informacaoDoLog.valores );
                caso2.setDateInicio(new Date());
                caso2.setInicio( System.currentTimeMillis());
                AlgotimosSorter.quickSort(randomNumbers, 0 ,informacaoDoLog.valores );
                caso2.setDateFim(new Date());
                caso2.setFim(System.currentTimeMillis());
                caso2.setTotal(caso2.getFim() - caso2.getInicio());
                casos.add(caso2);
                
                //CASO 3
                Caso caso3 = new Caso();
                caso3.setDescCaso("[DECRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso3.setDateInicio(new Date());
                caso3.setInicio( System.currentTimeMillis());
                AlgotimosSorter.quickSort(descendingNumbers, 0 ,informacaoDoLog.valores);
                caso3.setDateFim(new Date());
                caso3.setFim(System.currentTimeMillis());
                caso3.setTotal(caso3.getFim() - caso3.getInicio());
                casos.add(caso3);
                
                informacaoDoLog.setCasos(casos);                  
                gerenciadorDeLog.EscreveLog(informacaoDoLog);
                break;
            }
            
            case SELECTION_SORT: {
                int[] sortedNumbers = geradorDeNumeros.getSortedNumbers(0, informacaoDoLog.valores);                
                int[] randomNumbers = geradorDeNumeros.getRandomNumbers(0, informacaoDoLog.valores);                
                int[] descendingNumbers = geradorDeNumeros.getDescendingNumbers(0, informacaoDoLog.valores);
                //CASO 1
                Caso caso1 = new Caso();
                caso1.setDescCaso("[CRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso1.setDateInicio(new Date());
                caso1.setInicio( System.currentTimeMillis());                
                AlgotimosSorter.selectionSort(sortedNumbers);
                caso1.setDateFim(new Date());
                caso1.setFim(System.currentTimeMillis());
                caso1.setTotal(caso1.getFim() - caso1.getInicio());
                casos.add(caso1);
                //CASO 2
                Caso caso2 = new Caso();
                caso2.setDescCaso("[MISTURADO]" +  " 0 ... "+informacaoDoLog.valores );
                caso2.setDateInicio(new Date());
                caso2.setInicio( System.currentTimeMillis());
                AlgotimosSorter.selectionSort(randomNumbers);
                caso2.setDateFim(new Date());
                caso2.setFim(System.currentTimeMillis());
                caso2.setTotal(caso2.getFim() - caso2.getInicio());
                casos.add(caso2);
                
                //CASO 3
                Caso caso3 = new Caso();
                caso3.setDescCaso("[DECRESCENTE]" +  " 0 ... "+informacaoDoLog.valores );
                caso3.setDateInicio(new Date());
                caso3.setInicio( System.currentTimeMillis());
                AlgotimosSorter.selectionSort(descendingNumbers);
                caso3.setDateFim(new Date());
                caso3.setFim(System.currentTimeMillis());
                caso3.setTotal(caso3.getFim() - caso3.getInicio());
                casos.add(caso3);
                
                informacaoDoLog.setCasos(casos);                  
                gerenciadorDeLog.EscreveLog(informacaoDoLog);
                break;
            }
        }

    }
}
