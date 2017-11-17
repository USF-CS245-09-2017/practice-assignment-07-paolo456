
public class Hashtable {
	
	
	
	class Hashnode{
		
		String key;
		String value;
		Hashnode next;
	
	
	public Hashnode(String key, String value){
		next = null;
		this.key = key;
		this.value = value;
	}
	}
	
	public Hashnode[] arr = new Hashnode[314527];
	public int elements;
	
	public void put(String key, String value){
		Hashnode node = new Hashnode(key, value);
		
		int pos = key.hashCode() % arr.length;
		Hashnode temp = arr[pos];
		
		node.next = temp; 
		arr[pos]= node;
		elements++;
		
	}
	
	public String get(String key){
		int pos = key.hashCode() % arr.length;
		Hashnode temp = arr[pos];
		
		//O(n)
		while(temp != null){
			
			if(temp.key.equals(key))
				return temp.value;
			temp = temp.next;
		}
		return null;
	}
	
	public String remove(String key){
		int pos = key.hashCode() % arr.length;
		Hashnode temp = arr[pos];
		
		if(temp == null)
			return null;
		
		while(temp != null){
			
			if(temp.key == key){
				String r = temp.value;
				arr[pos] = temp.next;
				--elements;
				return r;
				}
		
				temp = temp.next;
		}
		
		return null;
		}
	
	public boolean containsKey(String key){
		int pos = key.hashCode() % arr.length;
		if(arr[pos] != null)
			return true;
		else
			return false;
	}
	
	
	

}
