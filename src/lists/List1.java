package lists;

public class List1 implements List<Vehicle>
{
	private class ListElement
	{
		public Vehicle v;
		public ListElement next;
		
		ListElement(Vehicle v, ListElement next)
		{
			this.v = v;
			this.next = next;
		}
		
		public boolean isLast()
		{	
			return next == null;
		}
		
	}
	
	ListElement first = new ListElement(null, null);
	
	public void add(Vehicle v)
	{
		ListElement newElement = new ListElement(v, first);
		first = newElement;
	}

	public void delete(int index)
	{
		if(index < size() && index >= 0)
		{
			if(index != 0)
				getListElement(index-1).next = getListElement(index).next;
			else
				first = first.next;
		}
	}

	public Object get(int index)
	{
		ListElement out = first;
		for(int i = 0; i < index; i++)
		{
			if(!out.isLast())
				out = out.next;
			else
				out = null;
				//break;
		}
		return out == null?null:out.v;
	}

	private ListElement getListElement(int index)
	{
		ListElement out = first;
		for(int i = 0; i < index; i++)
		{
			if(!out.isLast())
				out = out.next;
			else
				out = null;
				//break;
		}
		return out;
	}
	
	public void set(int index, Vehicle v)
	{
		ListElement temp = first;
		for(int i = 0; i < index; i++)
		{
			if(!temp.isLast())
				temp = temp.next;
			else
			{
				temp = null;
				break;
			}
		}
		
		if(temp != null)
			temp.v = v;
	}

	public boolean isEmpty()
	{
		return first.isLast();
	}

	public int size()
	{
		int out = 0;
		ListElement temp = first;
		while(!temp.isLast())
		{
			out++;
			temp = temp.next;
		}
		
		return out;
	}

	public void clear()
	{
		first = new ListElement(null, null);
	}
	
}
