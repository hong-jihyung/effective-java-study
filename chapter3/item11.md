# equals 를 재정의하려거든 hashcode 도 재정의해라
- 여길 지나려거든 나를 밟고 가라

### 왜?
- hashmap 이나 hashset 사용에 문제가 생긴다.
  + 최적화 방식에 따라, hashcode 가 다르면 다른 놈으로 간주해서 equals 하지도 않음.

#### Object 명세
- 객체 값의 변경이 없다면 hashcode 는 항상 같은 값을 반환한다.
- equals(object) 가 같다고 판단했다면, hashcode 는 같은 값을 반환한다.
- 두 객체가 not equals 여도, hashcode 가 같을 수는 있다. 단, 충돌이 날수록 해시테이블 성능이 떨어진다.

### 모두에게 같은 해시코드?
- 홍채님이 달려와서 때린다
- o(1) --> o(n) 의 기적
- 이상적인 해시함수는 32비트 정수 범위에 균일하게 분배되는 거.

### 좋은 hashcode 를 작성하는 요령
- p68-69
  + 뭔소리지?! --> 그렇다면 lombok 으로 가즈아.
- 동치인 인스턴스가 서로 다른 hashcode 를 반환하면 꼭 해결하자.
- 파생 필드는 무시해도 됨
- equals 비교에 사용되지 않은 필드는 반드시 제외
- 31 은 prime. "소중한 전통입니다."

### 정리
- 11-2 충분히 훌륭하고 전형적인 hashcode 메서드
- guava com.google.common.hash.Hashing 아주 훌륭함.
- Objects.hash 편한데 느림. (박싱과 언박싱) 11-3
- 해시 계산 비용이 크다면 캐싱도 괜춘.
- 또는 지연초기화. 11-4
- hashcode 생성규칙을 자세히 공개하지 말자???

### 결론
- equals 재정의 했으면 꼭 hashcode 재정의
- 어설프게 만들바엔 lombok 이나 ide 생성 가즈아.
