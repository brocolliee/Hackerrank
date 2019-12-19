# Dictionaries and HashMaps

### Hash Tables

*Hackerrank 자료 구조 Hash Table 강의 참고*

#### 정의

키(Key) 와 값(Value)을 저장하는 자료 구조로 배열의 인덱스를 사용하기때문에 삽입, 삭제, 검색이 빠르다.

* Key => Value

* String(Key)를 가지고 Hash Function은 integer인 Hash code를 얻어 저장할 배열의 index 값을 구해 값을 저장하게 된다.

  * String (Key) => Hash Function - Hash Code => index

     <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Hash_table_3_1_1_0_1_0_0_SP.svg/2560px-Hash_table_3_1_1_0_1_0_0_SP.svg.png" alt="img" style="zoom:20%;" /> 

    (출처 :  https://en.wikipedia.org/wiki/Hash_table )

#### Time Complexity

* O(1) : good hash table
* O(n) : terrible hash table 



#### Collision

Hash Table 문제점인 Collision은 Key는 무한하지만 Hash Code는 유한하기 때문에 서로 다른 Key가 같은 Hash Code를 얻어 발생한다.

##### Chaining 

Linked List를 사용하여 충돌 처리 하는 방식

\* *자바에서 사용하는 방식* ( JAVA 8에서는 데이터가 많아지면 Linked List 대신 트리를 사용)

```
class Hashtable{
	Linkedlist[] data;
	void put(String Key , String Value) {
		int hashcode = getHashCode(Key);
		int index = convertToIndex(hashcode);
		LinkedList list = data[index];
		list.insert(Key, Value);
	}
}
```

 <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Hash_table_5_0_1_1_1_1_1_LL.svg/2880px-Hash_table_5_0_1_1_1_1_1_LL.svg.png" alt="img" style="zoom:20%;" /> 

(출처 :  https://en.wikipedia.org/wiki/Hash_table )

##### Open Addressing

비어 있는 공간을 찾아 사용 하는 방법으로 데이터를 삭제할때 처리가 비효율적이다. 

* **선형 조사법 (linear probing)**
  * 충돌이 일어나면 i 만큼 이동해 비어있는 해시에 데이터를 저장 ( i = 1 ... n)
  * 키들이 데이터가 몰리는 현상인 clustering되는 경향이 있어 탐색 시간을 증가시키기도 한다. 
* **이차 조사법 (quadratic probing)**
  * 충돌이 일어나면 i 제곱 만큼 이동해 비어있는 해시에 데이터를 저장 ( i = 1 ... n)
* **이중 해시 (double hashing)**
  * 충돌이 일어나면 다른 해시 함수를 사용하는 방법