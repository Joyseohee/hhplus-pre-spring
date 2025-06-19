# 게시판 서비스 구현

## ✨ 사용 기술
* Java 21 
* Spring Boot 3.5.0 
* Gradle 8.15

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
