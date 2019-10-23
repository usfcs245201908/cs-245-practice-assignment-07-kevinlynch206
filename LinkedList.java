public class LinkedList<T> implements List<T> {

	int listSize;
	Node<T> head;


	//constructor to set head to null and size 0
	public LinkedList(){

		head = null;
		listSize = 0;
	}


	//retrieve item from position
	@Override
	public T get(int pos) {
		Node node = head;
		for(int i = 0; i < pos;i++) {
			node = node.getNext();
		}
		return (T) node.getData();
	}


	//adds item to end of list, or beginning if no head
	@Override
	public void add(T item) {

		if(head == null) {
			Node<T> newNode = new Node(item);
			head = newNode;
		}

		else{
			Node<T> prev = head;
			for(int i = 0; i < listSize-1; i++) {
				prev = prev.getNext();
			}
			Node<T> newNode = new Node(item);
			prev.setNext(newNode);
		}
		listSize++;
	}

	//add to specific position
	@Override
	public void add(int pos, T item) {

		if (pos==0){
			Node<T> newNode = new Node(item);
			newNode.setNext(head);
			head = newNode;
		}

		else{
			Node prev = head;
			for(int i = 0; i < pos-1;i++) {
				prev = prev.getNext();
			}
			Node<T> newNode = new Node(item);
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);

		}
		++listSize;
	}



   //remove item
	@Override
	public T remove(int pos) {
		Node<T> node = head;
		if(pos==0){
			head = head.getNext();
			--listSize;
			return  node.getData();
		}

		for(int i = 0; i < pos-1;i++) {
			node = node.getNext();
		}
		Node<T> toDelete = node.getNext();
		node.setNext(toDelete.getNext());
		--listSize;
		return  toDelete.getData();
	}

	//get size of array
	@Override
	public int size() {
		return listSize;
	}
}