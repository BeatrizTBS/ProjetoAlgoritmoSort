/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.org.core.project.bussinesLogic;


public enum AlgoritimosEnum {
   BUBBLE_SORT("Buble Sort"),
   IMPROVED_BUBBLE_SORT("Improved Bubble Sort"),
   INSERTION_SORT("Insertion Sort"),
   SELECTION_SORT("Selection Sort"),
   MERGE_SORT("Merge Sort"),
   QUICK_SORT("Quick Sort"),
   HEAP_SORT("Heap Sort");
   
   private final String value;
   
   AlgoritimosEnum(String value){
   this.value=value;
   }
   
   
   public String getValue(){
    return this.value;
   }
   
   
   
}
