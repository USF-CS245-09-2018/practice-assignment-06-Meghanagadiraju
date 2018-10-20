import java.util.*;

public class ArrayStack implements Stack 
{
	private int defaultsize = 10;
	private Object data[]; 
	private int top;	   
	private int len; 
	public ArrayStack() 
	{
		data = new Object[defaultsize];
		top = 0;
		len = defaultsize;
	}

	
	public ArrayStack(int initSize) 
	{
		data = new Object[initSize];
		top = 0;
		len = initSize;
	}

	
	public boolean empty() 
	{
		return top == 0;
	}

	
	public void push(Object elem) 
	{
		if (top == len)
		{
			growStack();
		}

		data[top] = elem;
		top++;
	}

	
	public Object pop() 
	{

		if (top > 0)
			return data[--top];
		else
			return null; 
	}

	public Object peek()
	{
		return data[top-1];
	}

	protected void growStack() 
	{
		int i;
		Object newdata[];

		newdata = new Object[len * 2];
		for (i = 0; i < len; i++)
			newdata[i] = data[i];
		data = newdata;
		len = len * 2;
	}
}