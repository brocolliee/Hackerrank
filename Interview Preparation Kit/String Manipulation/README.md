# String Manipulation



### Strings vs StringBuilder

*Hackerrank 자료 구조 Strings vs StringBuilder 강의 참고*

#### String & StringBuilder & StringBuffer

* 문자열

* 언어에 따라 다르지만 몇몇 언어는 string modifications가 가능하다

  * ex) string a = "hello" -> a[0] = "j" ->  print(a) => "jello"

* Java에서는 String은 불변한다. (+를 통해 String을 늘릴 수는 있다.) 

  - '+' 혹은 concat을 통해 문자열을 늘릴 수는 있찌만 메모리 공간이 변하는 것은 아니다. 

  - '+' 혹은 concat한 문자열은 새로 String 인스턴스가 생성된 것

  - 변경 전의 문자열은 가비지 콜렉터에 의해 처리되야함.

    

* StringBuilder은 가변이라는 특징이 있다.

  * StringBuilder라는 클래스를 만들고 string modification을 진행하면 크기를 변경시켜 문자열을 변경한다.

  * 즉 string modification (문자열 연산)이 많아지면 String Builder를 사용하는 것이 더 좋다.

    ```
    StringBuilder sb =new StringBuilder();
    sb.append();
    sb.append();
    ```

  * 멀티쓰레드일경우 클래스에 동시에 접근이 가능하여 안전하지 않으므로 StringBuffer를 추천한다. 

    * StringBuffer도 가변이라는 특징이 있는 문자열 관련 클래스로 주로 멀티 쓰레드 환경에서 한다. (synchronized가 가능)

