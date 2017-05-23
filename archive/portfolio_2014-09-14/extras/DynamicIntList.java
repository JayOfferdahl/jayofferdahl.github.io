
public class DynamicIntList {
	private int currentCapacity, currentSize;
	private int[] array;
	
	/**
	 * Create a DynamicIntList with starting size of 10
	 */
	public DynamicIntList() {
		currentCapacity = 10;
		array = new int[10];
		currentSize = 0;
	}
	
	/**
	 * Create a new DynamicIntList with specified starting size
	 * @param startSize - size of desired IntList
	 */
	public DynamicIntList(int startSize) {
		currentCapacity = startSize;
		array = new int[startSize];
		currentSize = 0;
	}
	
	/**
	 * Gets the value at the specified index
	 * @param index
	 * @return "-->" followed by a 0 to indicate the value has not been initialized yet.
	 */
	public int get(int index) {
		if(index < 0 || index >= currentSize) {
			System.out.print("\n\n--> ");
			return 0;
		}
		//Insert exception handling here
		else 
			return array[index];
	}
	
	/**
	 * Adds the input int to the DynamicIntList, if the list is full, resize then add
	 * @param toAdd
	 */
	public void add(int toAdd) {
		if(currentSize == currentCapacity) {
			int[] holder = array;
			array = new int[currentCapacity + 1];
			currentCapacity += 1;
			
			for(int index = 0; index < holder.length; index++) {
				array[index] = holder[index];
			}
		}
		currentSize++;
		this.array[currentSize - 1] = toAdd;
		
	}
	
	/**
	 * Removes the current index in the DynamicIntList
	 * Should the requested index not be initialized yet (
	 * @param indexToRemove
	 */
	public void remove(int index) {
		if(index < 0 || index >= currentSize)
			System.out.println("Out of Bounds Exception: Method get(int index) of DynamicIntList");
		else {
			for(int currentIndex = index; currentIndex < currentSize; currentIndex++) {
				this.array[currentIndex] = this.array[currentIndex + 1];
			}
			currentSize--;
		}
	}
	
	//Returns the current size of the DynamicIntList 
	public int getSize() {
		return this.currentSize;
	}
	
	public int getCurrentCapacity() {
		return this.currentCapacity;
	}
}
