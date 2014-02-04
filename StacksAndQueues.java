package Java;
import java.util.*;
import java.io.*;

public class StacksAndQueues {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in=new Scanner(new FileReader("index.txt.txt"));
		Stack<Queue<String>> s=new Stack<Queue<String>>();
		while(in.hasNext()){
			int i=0;
			String line=in.nextLine();
			System.out.println(indentation(line));
		}
	}
	public static boolean isSorted(String[] list){
		
		return true;
	}
	public static int indentation(String line){
		int i;
		for(i=0;i<line.length() && line.substring(i,i+1).equals(" ");i++){}
		return i;
	}
}


/*
1) A book’s index contains entries and sub-entries nested to several levels. Sub-entries are 
indicated by deeper indentation. All the sub-entries of a given entry are preceded by the 
same number of spaces; that number is greater than the indentation at the previous level. 
Write a program that reads an index file (index.dat) and verifies that all the entries and 
subentries are in alphabetical order. Skip empty lines.

class
   abstract
   accessors
   constructors
     overloaded
     no-args
   modifiers
method
   private
   public
   static
stack
   for handling nested structures
   methods
     push
     pop
     peekTop
*/
