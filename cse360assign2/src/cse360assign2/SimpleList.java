//Name: Jiachen Lin
//Class: CSE360 Monday
//ASU ID: 1213764095
//class id: 175
//assignment 2: SimpleList.java
//URL: https://github.com/Spen-cer-l/cse360_assign2.git
//head: 4db2b886b0ea14d8540eafecf6443d2ae173a720

package cse360assign2;

import java.util.Arrays;

public class SimpleList {
   private int list[];
   
   private int count;
   private int size;

   public SimpleList() { // Create an array to hold 10 integers and set count to 0.
       list = new int[10];
       this.count = 0;
       size = 10;
       
   }

   public void add(int num) {
       if (count < size) {
           for (int i = count; i > 0; i--) {
               list[i] = list[i-1];
           }
           list[0] = num;
           count++;
           
           
       } else {
    	   //  If the list was initially full, then increase the size by 50% so there will be room.
    	   
    	   int[] temp = list;
    	   size = size + size/2;
    	   list = new int[size];
    	   
    	   
    	   //System.out.println("size" + size);
    	   //System.out.println("count" + count);
    	   
    	   

           for (int i = 0; i < temp.length; i++) {
               list[i] = temp[i];
           }
           
           for (int i = count; i > 0; i--) {
               list[i] = list[i-1];
           }
           list[0] = num;
           count ++;
           
           
       }
       
       
       System.out.println("Number added");
   }

   public void remove(int num) {
       int index = search(num); //using search to find the number for removing

       if (index != -1) {
           // remove the number and other numbers moved down.
           for (int i = index; i < count; i++) {
  	   
               list[i] = list[i + 1];
 
           }
           count--;
           //If the list has more than 25% empty places, the decrease the size of the list
           int x = size - count;
           int y = size / 4;
           if(x > y) {
        	   int[] temp = list;
        	   size = size - y;
        	   list = new int[size];
        	   //System.out.println(temp.length);
        	   for (int j = 0; j < count; j++) {
                   list[j] = temp[j];
               }
           }
           System.out.println("Number removed");
           
           
           
       } else {
           System.out.println(num + " number not found");
           
       }
   }
   
   public void append(int num) {
	   if (count < size) {
           
           list[count] = num;
           count++;
           
       } else {
    	   //f the list was full, then increase the size by 50% so there will be room. 
    	   int[] temp = list;
    	   size = size + size/2;
    	   list = new int[size];

           for (int i = 0; i < temp.length; i++) {
               list[i] = temp[i];
           }
    	   
           list[count] = num;
           count ++;
           
           //System.out.println(size);
       }
       
       
       System.out.println("Number appended");
   }
   
   public int first() {
	   if(count == 0) {
		   return -1;
	   }else {
		   return list[0];
	   }
   }
   
   
   public int last() {
	   if(count == 0) {
		   return -1;
	   }else {
		   return list[count-1];
	   }
   }
   
   public int size() {
	   return size;
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
       
       /*String output1 = "";
       for (int i = 0; i < 10; i++) {
    	   output += temp[i]; 
           if (i != count - 1) {
        	   output += " ";
           }
       }
       
       System.out.println(output1);
       
       */
       //System.out.println(size);
      // System.out.println(output);
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