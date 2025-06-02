# SpringBoot Project

Spring Boot 기반의 미니 프로젝트입니다. RESTful API 서버를 구현하고 다양한 백엔드 기능을 실습하기 위해 제작되었습니다.

## 🔗 GitHub
[https://github.com/KTAIVLE-MINIPROJECT/SpringBoot](https://github.com/KTAIVLE-MINIPROJECT/SpringBoot)

## 🚀 주요 기능
- RESTful API 설계
- 도서 및 카테고리 CRUD
- 예외 처리 (GlobalExceptionHandler)
- 정적 리소스를 활용한 간단한 UI
- H2/MySQL 연동 가능
- 초기 데이터 로딩 (data.sql)

## 🛠 기술 스택
- Java 17
- Spring Boot 3.5.0
- Spring Web, Spring Data JPA
- Lombok, H2
- Gradle

## 📁 디렉토리 구조 요약

```
src
├── main
│ ├── java/com.aivle1_3.BookApi
│ │ ├── controller # API 컨트롤러
│ │ ├── dto # DTO 클래스
│ │ ├── entity # JPA 엔티티
│ │ ├── exception # 예외 처리
│ │ ├── repository # JPA 리포지토리
│ │ └── service # 비즈니스 로직
│ └── resources
│ ├── application.yaml # 환경 설정
│ ├── data.sql # 초기 데이터
│ └── static # 정적 웹 자원
└── test
└── BookApiApplicationTests.java
```

## ⚙️ 실행 방법

```bash
git clone https://github.com/KTAIVLE-MINIPROJECT/SpringBoot.git
cd SpringBoot
./gradlew bootRun
```
→ http://localhost:8080에서 정적 웹 페이지 확인 가능

---

😎 created by : 최인규, 허유찬, 이윤영, 이동섭
