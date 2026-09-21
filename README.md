# 도서관 업무 로직 | Iterator·TreeSet 실습

도서·이용자·대출·반납 이력을 객체로 나누고, 컬렉션 순회로 도서관 업무를 구현한 Java 학습 프로젝트입니다.

**Java · Iterator · TreeSet · Comparable · BlueJ**

## 주요 기능

- 이용자·도서 등록과 중복 식별자 확인
- 대출 가능한 도서와 대출 중인 도서 목록 조회
- 이용자·도서 존재 여부, 대출 가능 권수와 상태를 확인한 대출 처리
- 반납 시 대출 기록 제거, 도서 상태 변경과 반납 이력 저장
- 이용자별 반납 이력 조회

## 설계

| 구성 | 역할 |
|---|---|
| [LibraryApplication.java](LibraryApplication.java) | 도서관 업무 흐름 통합 |
| [DB](DB/) | 도서·이용자·대출·이력 저장과 조회 |
| [Object](Object/) | `Book`, `Borrower`, `Loan`, `History` 도메인 객체 |

`TreeSet`과 객체의 `Comparable` 구현으로 정렬 기준을 정의하고, `Iterator`로 조건에 맞는 객체를 찾습니다.

## 실행·확인 방법

이 저장소에는 `main` 진입점이 없습니다. BlueJ에서 `package.bluej`를 열고 전체 클래스를 컴파일한 뒤 `LibraryApplication(String name)` 객체를 생성해 메서드를 호출합니다.

확인할 흐름:

1. 이용자와 도서 등록
2. `displayBookForLoan()`으로 대출 가능 목록 조회
3. `loanOneBook(number, catalogueNumber)` 호출
4. `displayBookOnLoan()`으로 상태 변경 확인
5. `returnOneBook(catalogueNumber)` 호출 후 이력 확인

`DB` 클래스의 샘플 자료와 중복 ID 검증을 고려해 새로운 식별자를 사용합니다.

## 학습 범위

객체 관계, 컬렉션 정렬과 순회, 대출 전후 상태 변경을 다룹니다. 화면은 포함하지 않으며 데이터는 실행 중 메모리에 저장됩니다. GUI 연동 코드는 [programming-2](https://github.com/kara320090/programming-2)에서 확인할 수 있습니다.
