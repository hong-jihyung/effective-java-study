# Comparable을 구현할지 고려하라
- compareTo 는 단순 동치성 비교에 더해 순서까지 비교할 수 있으며 제네릭하다
- comparable 을 구현 --> 자연적인 순서가 있음을 의미
- Arrays.sort(a);
- 순서가 명확한 값 클래스를 작성한다면 Comparable 을 꼭 구현하자

### 일반 규약
- equals 와 비슷
- p88
  + 두 객체 참조 순서를 바꿔도 예상한 결과가 나와야 함
  + 추이성
  + 크기가 같은 객체들끼린 서로 바꿔서 비교해도 같아야 함

- 타입이 다른 객체가 주어지면 ClassCastException
- 다른 타입은 보통 공통 interface 를 매개로 비교함
- compareTo 규약을 지키지 못하면, 비교를 활용하는 클래스랑 못 어울림
  + 정렬된 컬렉션 treeset, treemap
  + 검색과 정렬 알고리즘을 활용하는 유틸 클래스 Collections, Arrays

- comparable 구현체를 확장하고 싶으면?
  + 확장하지 말고 composition
  + 이렇게 하면 새 클래스에 원하는 compareTo 메서드를 구현해넣을 수 있다

- 동치성을 비교할 때 equals 대신 compareTo 를 사용함
  + new BigDecimal("1.0"), new BigDecimal("1.00")
  + !equals --> hashset 2개
  + compareTo 0 --> treeset 1개

- Comparable 은 타입을 인수로 받는 제네릭 인터페이스이므로 compareTo 메서드의 인수 타입은 컴파일타임에 정해짐
  + 인수타입이 잘못되면 컴파일이 안된다. (편안)
  + 14-1
 
- compareTo 메서드에서 관계 연산자 <, > 를 사용하는 방식은 거추장스럽고 오류를 유발하니 비추
 
- 비교자 생성 메서드를 활용한 비교자 14-3
  + comparingInt, thenComparingInt
  + 14-4 --> 5 --> 6

- 핵심정리 p94
