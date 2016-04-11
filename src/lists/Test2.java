package lists;

public class Test2
{
	public static void main(String[] args)
	{
		List2 l1 = new List2();
		l1.add(new Vehicle("audi", 12));
		l1.add(new Vehicle("audi", 12));
		l1.add(new Vehicle("cudi", 1));
		l1.add(new Vehicle("budi", 0));
		l1.add(new Vehicle("dudi", 6));
		
		System.out.println("Do dodaniu: ");
		System.out.println("Model:\t\twiek: ");
		
		for(int i = 0; i < l1.size(); i++)
		{
			Vehicle v = (Vehicle)l1.get(i);
			System.out.println(v.model + "\t\t" + v.age);
		}
		
		l1.set(2, new Vehicle("honda", 3453));
		l1.set(101, new Vehicle("fiat", 16));
		
		System.out.println("\nPo zamianie: ");
		
		System.out.println("Model:\t\twiek: ");
		
		for(int i = 0; i < l1.size(); i++)
		{
			Vehicle v = (Vehicle)l1.get(i);
			System.out.println(v.model + "\t\t" + v.age);
		}
		
		System.out.println("\nRozmiar: " + l1.size() + "\n");
		
		l1.delete(1);
		
		System.out.println("Po usunieciu: ");
		
		System.out.println("Model:\t\twiek: ");
		
		for(int i = 0; i < l1.size(); i++)
		{
			Vehicle v = (Vehicle)l1.get(i);
			System.out.println(v.model + "\t\t" + v.age);
		}
		
		l1.clear();
		
		System.out.println("\nPo wyczyszczeniu: ");
		
		System.out.println("Model:\t\twiek: ");
		
		for(int i = 0; i < l1.size(); i++)
		{
			Vehicle v = (Vehicle)l1.get(i);
			System.out.println(v.model + "\t\t" + v.age);
		}
	}
}
