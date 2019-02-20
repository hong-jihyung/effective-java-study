- 문제를 회피하는 가장 쉬운 길은 아예 재정의하지 않는 것.

### 다음 중 하나의 상황이라면 재정의 하지 마라
 - 각 인스턴스가 본질적으로 고유함. thread.
 - 인스턴스의 논리적 동치성을 검사할 일이 없음. pattern 같은 건 필요하지만 진짜 필요함?
 - 상위 클래스에서 재정의한 equals 가 하위 클래스에도 딱 맞음
 - 클래스가 private 이거나 package-private 이고 equals 메서드를 호출할 일이 없다.

### 그럼 재정의는 언제?
 - 논리적 동치성을 확인해야 하는데, 상위 클래스의 equals 가 논리적 동치성을 비교하도록 재정의 안돼있을 때. (주로 값 클래스)
  + equals 가 논리적 동치성을 확인하도록 재정의되면, map, set 에 의도대로 사용할 수 있음.
  + enum 은 논리적 동치성 == 객체 식별성

### 재정의 규약 p.53
 - 반사성 : x.equals(x) == true
 - 대칭성 : x.equals(y) && y.equals(x)
 - 추이성 : x.equals(y) && y.equals(z) && z.equals(x)
 - 일관성 : x.equals(y) 항상 같은 결과
 - null-아님 : x != null && x.equals(null) == false

#### p.55 ex
- CaseInsentiveString cis.equals(string) == true, string.equals(cis) == false 될 수 있다
- CaseInsentiveString 의 equals 를 string 과도 연동하겠다는 허황된 꿈을 버려라. 그러면 p56 처럼 조금 편해짐.

#### p.56 ex
- point 와 colorPoint extends point
- 대칭성이 깨진다. 10-2
- 대칭성은 지켜주지만 추이성은 깨지는 모습 10-3
- 구체 클래스를 확장해 새로운 값을 추가하면서 equals 규악을 만족시킬 방법은 없다.
- 리스코프 치환 원칙 위배 10-4
  + 상위 클래스의 모든 메서드는 하위 클래스에서도 똑같이 잘 작동해야 한다.
  + https://nesoy.github.io/articles/2018-03/LSP
  + 상속 대신 composition 을 사용해라.
  + point 를 상속하지 말고, point는 필드로 놓고, point 를 반환하는 view 메서드를 public 으로 ㄲㄲ 10-5
  + java.sql.Timestamp 가 잘못 설계됨. 실수니까 따라하지 마셈

#### 일관성
- 불변 클래스 짱짱
- equals 의 판단에 신뢰할 수 없는 자원이 끼어들면 안된다. 결과의 항상 같음을 보장할 수 없음. network, ...
- 항상 메모리에 존재하는 객체만 사용하는 결정적(deterministic) 계산만 수행해야 한다.

#### null-아님
- o instanceof MyType : null 이면 false 를 반환해준다.

#### summary
- == 연산자를 사용해 입력이 자기 자신인지 보기
- instanceof 연산자로 타입이 올바른지 보기
- 올바른 타입으로 입력 형변환
- 핵심 필드가 일치하는지 하나씩 비교
  + float, double 제외한 기본 필드 ==
  + 참조 equals ( null 까지 감안하면 Object.equals(obj, obj) )
  + Float.compare, Double.compare  (Float.equals, Double.equals 는 오토박싱 수반)
  + 비교할 필드가 복잡하면, 표준형(canonical form)을 저장해서 사용.
  + 뭘 먼저 비교하는가. 다를 가능성이 더 크거나, 비교 비용이 싼거 먼저.
- 다 했으면 체크리스트 10-6
  + 대칭성
  + 추이성
  + 일관성
- equals 재정의 할 거면 hashcode 반드시 재정의
- Object 외 타입을 받는 equals 메서드는 선언하지 말자. 분명 나중에 누군가 삽질함. p65
  + 긍정오류?
  + Override 를 일관되게 사용하면 이런 실수를 예방할 수 있음.
- 그대보단 autovalue (lombok 같은 놈인 듯) 혹은 IDE 가 낫다.

### 마무리
- 하지마~~
- 그래도 하고 싶으면 lombok 가즈아. lombok 싫으면 auto generating 으로 가즈아.

