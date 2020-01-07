# Sorting



### Bubble Sort

*Hackerrank Algorithm Bubble Sort 강의 참고*

#### 정의 및 특징

- 인접한 요소두개가 sorting이 되어있지 않다면 Swap한다. 모든 원소들이 Sorting 될 때 까지 진행한다.

* 시간 복잡도가 O(n^2) 으로 느리다는 단점이 있다. 
* 공간 복잡도는 O(1)로 추가적인 메모리가 필요하지 않다.

~~~java
	// Code from Hackerrank lecture
	public static void bubbleSort(int[] array) {
		boolean isSorted = false;
		int lastUnsorted = array.length - 1;
		while(!isSorted) {
			isSorted = true;
			for( int i = 0 ; i < lastUnsorted ; i++) {
				if( array[i] > array[i + 1]) {
					swap(array, i , i+ 1);
					isSorted = false;
				}
			}
			lastUnsorted--; // Optimization
		}
	}
	
	public static void swap(int[] array , int i , int j ) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
~~~

