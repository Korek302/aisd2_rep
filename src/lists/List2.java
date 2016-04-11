package lists;

public class List2 implements List<Vehicle>
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
			return next == first;
		}
		
	}
	
	ListElement first = null;
	
	private ListElement getLast()
	{
		ListElement temp = first;
		while(!temp.isLast())
			temp = temp.next;
		
		return temp;
	}
	
	public void add(Vehicle v)
	{				
		ListElement newElement = new ListElement(v, first);
		if(first == null)
		{
			first = newElement;
			first.next = first;
		}
		else
		{	
			ListElement last = getLast();
			last.next = newElement;
			
			newElement.next  = first;
			first = newElement;
					
			ListElement temp = first;
			
			while(temp.v.age > temp.next.v.age && !temp.isLast())
			{
				Vehicle tempV = temp.v;
				temp.v = temp.next.v;
				temp.next.v = tempV;
				
				temp = temp.next;				
			}
		}
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
		if(index < size() && index >= 0)
		{
			delete(index);
			add(v);
		}
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public int size()
	{
		if(first == null)
			return 0;
		else
		{
			int out = 1;
			ListElement temp = first;
			while(temp != null && !temp.isLast())
			{
				out++;
				temp = temp.next;
			}
			return out;
		}
	}

	public void clear()
	{
		first = null;
	}
}
