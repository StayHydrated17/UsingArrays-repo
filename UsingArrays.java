//This program demonstrates arrays
//With tasks like inserting, deleting, and finding elements of an array.
//@author StayHydrated17 github.com/StayHydrated17
//@date 3/11/2021
//@version 1.0

import java.util.Random; //rng class
import java.util.Scanner; //Scanner class for getting user input


public class UsingArrays
{
	private int[] myArray = new int[50];
	//creating an int array with 51 units that can be used, given the arrayRNG method is changed
	
	private int arraySize = 10;
	//this is to be used for printing out parts of the array that hold values,   
	//as well as having the array size predetermined, set to 10 spots.
	//the number of 10 can be altered up to 51.
	
	///arrayRNG method
	///returns: none, parameters: none
	///Used to populate the array(myArray) with 10 different numbers
	public void arrayRNG()
	{
		for(int i = 0; i < arraySize; i++)
		{
			myArray[i] = (int)(Math.random()*10)+10;
		}
	}
	//arrayRNG
	
	
	///displayArray method
	///This method is to display the contents of the array created
	///returns: none , parameters: none
	public void displayArray()
	{
		System.out.println("-----------");
		for(int i = 0; i < arraySize; i++)
		{
			System.out.print("| " + i + " | ");
			System.out.println(myArray[i] + " | ");
			System.out.println("-----------");
		}
	}
	//displayArray
	
	
	///getArrayValue
	///this method is to find a specific value at an index
	///int parameter of index, returns index
	public int getArrayValue(int index)
	{
		if(index < arraySize) return myArray[index];
		
		return 0;
	}
	//getArrayValue
	
	
	//deleteIndex
	///this method is to delete a requested index from the array, and then pushing up the index in order to fill in the deleted spot
	///return: none parameter: int needed
	public void deleteIndex(int index)
	{
		if(index < arraySize)
		{
			for(int i = index; (i < arraySize - 1); i++)
			{
				myArray[i] = myArray[i+1];
			}
			//this for loop writes the value indicated by index and continues
			//to override the array until the end of the array is met
			//essentially moving up every value of the array aside from the deleted index
		}
		
		arraySize--;
		//decrementing the arraySize to go along with the deleted index spot
	}
	//deleteIndex
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//creating an input object from the scanner class for user input
		int userIndex;
		//used to ask user to search for an index number to search the array (used in getArrayValue() method)
		
		int userDelete;
		//used to ask user to delete an indicated index from the array (used in deleteIndex() method)
		
		UsingArrays newArray = new UsingArrays();
		//creating an object of the UsingArray class called: newArray
		
		newArray.arrayRNG();
		//calling the arrayRNG method from the UsingArrays Class
		newArray.displayArray();
		//calling the displayArray method from the UsingArrays class
		
		System.out.print("\nEnter an index number to get a value: ");
		userIndex = input.nextInt();
		//getting the user input and storing it into userIndex
		
		while(userIndex > newArray.arraySize || userIndex < 0)
		{
			System.out.print("\nEnter a valid index number to get a value: ");
			userIndex = input.nextInt();
		}
		//this while loop catches the user if there is an index out of bounds
		
		System.out.println("The value of: " + newArray.getArrayValue(userIndex) + " is at index " + userIndex);
		//calling the getArrayValue method and getting the number at the requested index, in this using userIndex as a parameter to enter the method correctly.
		
		System.out.print("\nEnter an index number to delete from the array: ");
		userDelete = input.nextInt();
		//asking the user which index they want to remove, storing their choice in the userDelete variable to then be used in the deleteIndex method.
		
		while(userDelete > newArray.arraySize || userDelete < 0)
		{
			System.out.print("\nEnter a valid index number to delete: ");
			userDelete = input.nextInt();
		}
		//this while loop catches the user if there is an index out of bounds
		
		newArray.deleteIndex(userDelete); //calling the deleteIndex method, using the userDelete input as the parameter
		newArray.displayArray();
		//displaying the updated array after the user chooses which index to delete
		
	
	}
	//main
}
//UsingArrays