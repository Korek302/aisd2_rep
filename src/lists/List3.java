package lists;

public class List3 implements List<Vehicle>
{
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	private final int initialCapacity;
	private Vehicle[] array;
	private int size;
	
	public List3()
	{
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public List3(int initialCapacity)
	{
		this.initialCapacity = initialCapacity;
		clear();
	}
	
	/*public List3(Vehicle[] array)
	{
		initialCapacity = array.length;
		clear();
		System.arraycopy(array, 0, this.array, 0, array.length);
		size = array.length;
	}*/
	
	private void ensureCapacity(int capacity)
	{
		if(array.length < capacity)
		{
			Vehicle[] copy = new Vehicle[capacity + capacity/2];
			System.arraycopy(array, 0, copy, 0, size);
			array = copy;
		}
	}
	
	public void add(Vehicle v)
	{			
		int temp = 0;
		while(temp < size && v.age > array[temp].age)
		{
			temp++;
		}
		ensureCapacity(size + 1);
		System.arraycopy(array, temp, array, temp + 1, size - temp);
		array[temp] = v;
		++size;
	}

	public void delete(int index)
	{
		if(index < 0)
			;
		else
		{
			index = getIndex(index);
			int copyFrom = index + 1;
			if(copyFrom < size)
				System.arraycopy(array, copyFrom, array, index, size - copyFrom);
			--size;
		}
	}
	
	public int getIndex(int index)
	{
		if(index == size)
			index = 0;
		else
		{
			while(index > size)
				index = index - size;
		}
		return index;
	}

	public Object get(int index)
	{
		getIndex(index);
		return array[index];
	}

	public void set(int index, Vehicle v)
	{
		if(index < 0)
			return;
		else
		{
			delete(index);
			add(v);
		}
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public int size()
	{
		return size;
	}

	public void clear()
	{
		array = new Vehicle[initialCapacity];
		size = 0;
	}
	
}
