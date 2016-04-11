package lists;

public interface List<T>
{
	public void add(T t);
	public void delete(int index);
	public Object get(int index);
	public void set(int index, T t);
	public boolean isEmpty();
	public int size();
	public void clear();
}