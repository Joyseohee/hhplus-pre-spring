# 📝 게시판 API 프로젝트

항해 플러스 백엔드 스프링 사전 스터디로 진행한 게시판 API 프로젝트입니다.   
RESTful API 설계, Spring Boot 백엔드 개발, JPA를 사용한 객체 지향적인 개발을 연습합니다.

---

## 🚀 프로젝트 소개

- **회원가입 및 로그인 기능**
- **게시글 CRUD 기능**
- **JWT 인증 기반 보안 적용**
- **Spring Boot + JPA 기반 개발**

---

## 🛠️ 기술 스택

| Category | Stack                          |
| -------- |--------------------------------|
| Language | Java 21                        |
| Framework | Spring Boot 3.5.0              |
| Build Tool | Gradle                         |
| Database | PostgreSQL                     |
| ORM | Spring Data JPA                |
| Authentication | JWT                            |
| Documentation | SpringDoc OpenAPI (Swagger UI) |
| Test | JUnit5, Mockito                |

---

## 📂 프로젝트 구조
```project-root
src
└── main
├── java
│ └── com.example.board
│   ├── api # 컨트롤러 (API 엔드포인트)
│   ├── application # 서비스 (비즈니스 로직)
│   ├── domain # 도메인 (도메인 객체, 구현 로직)
│   ├── db # 영속 (엔티티, 리포지토리)
│   └── support # 공통 기능 (Exception, ApiResponse, Utils, Security 등)
└── resources
└── application.yaml
```
---

## 📑 API 명세
https://documenter.getpostman.com/view/25428915/2sB2x8Gruc

---

## 💾 DB ERD
https://dbdiagram.io/e/685164f83cc77757c834e43f/685fedb6f413ba35084e479e

---



### lint
```bash
./gradlew spotlessApply      # 💡 코드 자동 정리
./gradlew spotlessCheck      # 💡 포맷 규칙 검사 (CI에서 유용)
```
```bash
./gradlew detekt
```

## ✅ 커밋 메시지 컨벤션

형식:
imoji type(scope): subject

### type
- feat: 새로운 기능
- fix: 버그 수정
- chore: 빌드/설정 변경
- docs: 문서 관련
- style: 코드 포맷팅 (기능 변화 없음)
- refactor: 리팩토링
- test: 테스트 코드

### 예시
- ✨ feat(user): 회원가입 기능 추가
- 🐛 fix(order): 주문 수량 계산 오류 수정
- 🔧 chore: spotless 설정 추가

| Type     | Emoji | 설명           |
| -------- | ----- | ------------ |
| feat     | ✨     | 새로운 기능       |
| fix      | 🐛    | 버그 수정        |
| docs     | 📝    | 문서 관련 수정     |
| style    | 🎨    | 포맷팅, 들여쓰기 등  |
| refactor | ♻️    | 리팩토링         |
| chore    | 🔧    | 설정, 빌드, 잡일 등 |
| test     | ✅     | 테스트 코드 추가    |
| remove   | 🔥    | 코드/파일 제거     |
| perf     | 🚀    | 성능 개선        |
| security | 🔒    | 보안 관련        |
