package Java;
import java.util.*;
import java.io.*;

public class StacksAndQueues {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in=new Scanner(new FileReader("index3.txt"));
		Stack<Queue<String>> s=new Stack<Queue<String>>();
		int level=-1;
		while(in.hasNext()){
			String line=in.nextLine();
			int ind=indentation(line);
			if(ind>level){
				level=ind;
				s.push(new LinkedList<String>());
			}
			while(ind<level){
				if(!s.empty())
					if(!isSorted(s.pop())){
						System.out.println(s);
						System.out.println("no");
						return;
					}
				level--;
			}
			if(!s.empty())
				s.peek().add(line);
			//System.out.println(indentation(line));
		}
		while(!s.empty()){
			if(!isSorted(s.pop())){
				System.out.println(s);
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");
	}
	public static boolean isSorted(Queue<String> list){
		String lastStr=list.poll();
		String str=list.poll();
		while(str!=null){
			if(str.compareTo(lastStr)<0)
				return false;
			lastStr=str;
			str=list.poll();
		}
		return true;
	}
	public static int indentation(String line){
		int i;
		for(i=0;i<line.length() && line.substring(i,i+1).equals("\t");i++){}
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
