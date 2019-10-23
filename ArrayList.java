import java.util.Arrays;

public class ArrayList<T> implements List<T> {


	int listSize ;
	T arr[];


	//create array of size ten, and set size to 0(0 itmes)
	public ArrayList(){
		listSize = 0;
		arr =  (T[]) new Object[10];
	}

	//add item to the end
	@Override
	public void add(T item) {
		if(listSize == arr.length) {
			grow();
		}

		arr[listSize++] = item;
	}


	//add to specific position
	@Override
	public void add(int pos, T item) {
		if(listSize == arr.length) {
			grow();
		}
		arr[pos] = item;
		++listSize;
	}


	//get item at position
	@Override
	public T get(int pos) {
		return arr[pos];
	}


	//get size of Array
	@Override
	public int size() {
		return listSize;
	}

	//remove item
	@Override
	public T remove(int pos) {
		T item = arr[pos];
		--listSize;
		for(int i = pos; i < arr.length-1; i++){
			arr[i] = arr[i+1];
		}

		return item;
	}


	//grow array
	public void grow(){
		arr = Arrays.copyOfRange(arr,0, arr.length*2);
	}
}