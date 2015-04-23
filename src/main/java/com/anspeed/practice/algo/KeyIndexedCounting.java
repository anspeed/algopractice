package com.anspeed.practice.algo;

public class KeyIndexedCounting {
	
	public static void printArray(int sample[]){
		for(int i=0;i<sample.length;i++){
			//char[] keyArray = {'a','b','c','d','e'};
			System.out.print(sample[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
  public static void main(String args[]){
	  int a[]={3,0,2,5,5,1,3,1,5,1,4,0};
	  int length = a.length;
	  int aux[] = new int[a.length];//Auxiliary array for storing swapped content.
	  int R = 6;//number of keys.
	  int count[] =new int[R+1];
	  
	  //Step 1 count frequencies of each letter using key as index.
	  //Step 2 compute frequency cumulates which specify destinations.
	  //step 3 access cumulates using key as index to move items.
	  //copy back to original array.
      System.out.println("count frequencies of each letter using key as index.");
	  for(int i=0;i<length;i++){
		  count[a[i]+1]++;
		  printArray(count);
	  }
	  //Step 2
      System.out.println("compute frequency cumulates which specify destinations.");
      for(int r=0;r<R;r++){
    	  count[r+1]+=count[r];
		  printArray(count);
      }
      
	  //step 3 access cumulates using key as index to move items.
      System.out.println("access cumulates using key as index to move items ");
      for(int i=0;i<length;i++){
    	  aux[count[a[i]]]=a[i];
    	  count[a[i]]++;
		  printArray(count);
		  printArray(aux);
      }
    //copy back
      for(int i=0;i<length;i++){
    	  a[i]=aux[i];
      }
	  
	  
  }
}
