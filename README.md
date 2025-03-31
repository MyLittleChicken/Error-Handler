# ResponseEntity 프로젝트

RFC7807 표준을 준수하는 ProblemDetail을 사용한 예외 처리 예제 프로젝트입니다.

## 프로젝트 구조

- 상품 관리 REST API (CRUD 기능)
- RFC7807 표준을 준수하는 예외 처리 구현
- MySQL 데이터베이스 사용
- Spring Data JPA로 DB 접근

## Docker를 사용한 실행 방법

### 전체 애플리케이션 실행 (Spring Boot + MySQL)

```bash
# Docker Compose로 빌드 및 실행
docker-compose up --build
```

위 명령어를 실행하면 다음과 같이 실행됩니다:
1. MySQL 이미지를 다운로드하고 컨테이너를 실행합니다.
2. Spring Boot 애플리케이션을 빌드하고 컨테이너를 실행합니다.
3. 두 컨테이너는 docker-compose 네트워크로 연결됩니다.

### 컨테이너 중지 및 삭제

```bash
# 컨테이너 중지
docker-compose down

# 컨테이너 중지 및 볼륨 삭제 (데이터베이스 초기화)
docker-compose down -v
```

## API 접근 방법

애플리케이션이 실행된 후 다음 URL로 API에 접근할 수 있습니다:

- 상품 목록 조회: http://localhost:8080/api/products (GET)
- 특정 상품 조회: http://localhost:8080/api/products/{id} (GET)
- 상품 생성: http://localhost:8080/api/products (POST)
- 상품 수정: http://localhost:8080/api/products/{id} (PUT)
- 상품 삭제: http://localhost:8080/api/products/{id} (DELETE)

## API 요청 예제

### 상품 생성 요청 예시

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"테스트 상품","description":"테스트 상품 설명","price":10000,"stockQuantity":100}'
```

### 상품 목록 조회 예시

```bash
curl -X GET http://localhost:8080/api/products
```
