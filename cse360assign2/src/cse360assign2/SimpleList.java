//Name: Jiachen Lin
//Class: CSE360 Monday
//ASU ID: 1213764095
//class id: 175
//assignment 1: SimpleList.java, SimpleListTest.java


package cse360assign2;

import java.util.Arrays;

public class SimpleList {
   private int list[];
   private int count;

   public SimpleList() { // Create an array to hold 10 integers and set count to 0.
       list = new int[10];
       this.count = 0;
       
   }

   public void add(int num) {
       if (count < 10) {
           for (int i = count; i > 0; i--) {
               list[i] = list[i-1];
           }
           list[0] = num;
           count++;
           
       } else {
    	   
    	   list[count - 1] = 0;
    	   
           for (int i = count-1; i > 0; i--) {
               list[i] = list[i-1];
           }
           list[0] = num;
           count = 10;
           
           
       }
       
       
       System.out.println("Number added");
   }

   public void remove(int num) {
       int index = search(num); //using search to find the number for removing

       if (index != -1) {
           // remove the number and other numbers moved down.
           for (int i = index; i < count - 1; i++) {
               list[i] = list[i + 1];
           }
           count--;
           System.out.println("Number removed");
       } else {
           System.out.println(num + " number not found");
           System.out.println(num + " number not found!!");
       }
   }

   public int count() {
       return count;
   }
   
   public String toString() {
       String output = "";
       for (int i = 0; i < count; i++) {
    	   output += list[i]; 
           if (i != count - 1) {
        	   output += " ";
           }
       }
       return output;
   }

   public int search(int num) {
       int index = -1; //return -1 if the parameter is not in the list
       for (int i = 0; i < count; i++) {
           if (list[i] == num) {
               index = i;
           }
       }
       return index;
   }


   

}