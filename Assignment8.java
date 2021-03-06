public class ArrayIntList
{
  private int[] elementData; //list of integers 
	private int size; //number of elements in the list 
	public static final int DEFAULT_CAPACITY = 100; 
	
	//post: constructs an empty list of default capacity 
	public ArrayIntList() 
	{
		this(DEFAULT_CAPACITY);
	}
	
	//pre: capacity >= 0;
	//post: constructs an empty list with the given capacity
	public ArrayIntList(int capacity) 
	{
		elementData = new int[capacity]; 
		size = 0;
	}
	
	//post: returns the current number of elements in the list
	public int size() 
	{
		return size;
	}
	
	// pre : 0 <= index < size() 
	// post: returns the integer at the given index in the list 
	public int get(int index) 
	{
		return elementData[index];
	}
	
	//post: returns comma-seperated, bracketed version of list 
	public String toString() 
	{
		if(size == 0) 
		{
			return "[]";
		}
		else 
		{
			String result = "[" + elementData[0]; 
			for(int i = 1; i < size; i++) 
			{
				result += ", " + elementData[i];
			}
			
			result += "]";
			return result;
		}
	}
	
	//post: returns the position of the first occurrence of the given value 
	public int indexOf(int value) 
	{
		for(int i = 0; i < size; i++) 
		{
			if(elementData[i] == value) 
			{
				return 1;
			}
		}
		return -1;
	}
	
	// pre: size() < capacity 
	// post: appends the given value to the end of the list 
	public void add(int value) 
	{
		elementData[size] = value; 
		size++;
	}
	
	//pre : size() < capacity 
	//post: inserts the given value at the given index, shifting subsequent values right 
	public void add(int index, int value) 
	{
		for(int i = size; i >= index + 1; i--) 
		{
			elementData[i] = elementData[i - 1];
		}
		elementData[index] = value; 
		size++;
	}
	
	//pre: 0 <= index < size() 
	//post: removes value at the given index, shifting 
	//subsequent values left 
	public void remove(int index) 
	{
		for(int i = index; i< size - 1; i++) 
		{
			elementData[i] = elementData[i + 1];
		}
		size--;
	}

	
	
	/*
	 * 
	 * Assignment 8
	 * Aaron Allen 
	 * 5/29/19
	 * 
	 */
	
	public int[] replaceAll(int oldVal, int newVal) 
	{
    //loop through all the elements
		for(int i = 0; i < elementData.length; i++) 
		{
      //if one of the elements is the same as the old value...
			if(elementData[i] == oldVal) 
			{
        //replace that same value with the newValue
				elementData[i] = newVal;
			}
		}

    //return the modified list
		return elementData;
	}
	
	public static void main(String[] args) 
	{
	  ArrayIntList aa = new ArrayIntList ();
		aa.add(2);
		aa.add(2);
		aa.add(3);
		aa.add(4);
		aa.add(5);
    //before modification
		System.out.println(aa.toString());	
    aa.replaceAll(2, 1); 
    //after modification
    System.out.println(aa.toString());	
	}
}
