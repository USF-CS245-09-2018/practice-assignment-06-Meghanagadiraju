import java.util.*;

public class ArrayQueue implements Queue 
{
	
	private Object data[]; 
	private int head;
	private int tail;
	private int len;
	private int defaultsize = 10;

	ArrayQueue(int maxsize) 
	{
		data = new Object[maxsize];
		head = 0;
		tail = 0;
		len = maxsize;
	}

	ArrayQueue() 
	{
		data = new Object[defaultsize];
		head = 0;
		tail = 0;
		len = defaultsize;
	}


	public void enqueue(Object item) 
	{
		
		if ((tail + 1) % len == head) 
		{
			growQueue();
		}
		data[tail] = item;
		tail = (tail + 1) % len;

	}

	public Object dequeue() 
	{
		Object retval;

		if (head == tail)	
			return null;
		retval = data[head];
		head = (head + 1) % len;
		return retval;
	}

	public boolean empty() 
	{
		return head == tail;
	}

	protected void growQueue()
	{
		int m = 0;
		Object [] newData;
		newData =  new Object[len*2];

		if (head >tail)
		{
			for (int i = head; i<tail; i++)
			{
				newData[m++] = data[i];
			}
			head = 0;
			tail = data.length-1;
		}
		else
		{
			for (; m<len; m++)
			{
				newData[m] = data[m];
			}
		}
			data = newData;
			len = len*2;

	}


}