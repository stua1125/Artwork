# 프로젝트 요약

도메인 주도 설계(DDD) 관점에서 개발된 예제로, 사용자가 작품에 대해 평가할 수 있는 기능을 중심으로 구성되어 있습니다. 
사용자는 작품에 대해 '좋아요'나 '싫어요'를 표시하고, 댓글을 남길 수 있습니다. 
또한, 작품의 조회 이력을 관리하고, 특정 조건에 부합하는 사용자 또는 작품 데이터를 조회하는 기능을 포함하고 있습니다.

## 요구사항

- **평가 기능**: 사용자는 작품에 대해 좋아요, 싫어요를 표시하고 댓글을 남길 수 있습니다.
- **평가 조회**: '좋아요'와 '싫어요'가 가장 많은 작품들을 조회할 수 있습니다.
- **작품 방문자 조회**: 특정 작품을 방문한 모든 사용자의 목록을 조회할 수 있습니다.
- **성인 작품 방문자 조회**: 성인 작품을 조회한 사용자의 목록을 조회할 수 있으며, 이는 페이징 처리됩니다.
- **작품 가격 변경**: 작품을 무료 또는 유료로 변경할 수 있으며, 유료 변경 시 금액 범위는 100원에서 500원입니다.
- **사용자 삭제**: 특정 사용자를 삭제할 경우, 해당 사용자의 평가 및 조회 이력도 모두 삭제됩니다.

## DDD Aggregate 정리

### 작품 (Artwork)

- **속성**: 작품명, 작가, 금액, 서비스 제공일, 유형(성인 여부).
- **작품 방문 히스토리**: 작품 아이디, 유저 아이디, 생성일, 수정일.

### 평가 (Comment)

- **속성**: 유저 아이디, 평가(좋아요/싫어요), 댓글 내용, 생성일, 수정일.
- **조건**: 작품당 사용자는 하나의 평가만 가능하며, 여러 작품에 대해 평가할 수 있습니다.

### 유저 (User)

- **속성**: 이름, 이메일, 성별, 유형(성인/미성년자), 서비스 등록일.

### 방문기록ArtworkViewHistory)

- **속성**: 작품 아이디, 유저 아이디, 생성일, 수정일.


## E2E 테스트

프로젝트의 테스트 환경 설정을 위해, import.sql 파일을 사용하여 데이터베이스를 초기화했습니다. 이 접근 방법은 애플리케이션 시작 시 자동으로 실행됩니다.
하위에는 테스트 API 목록을 서술했습니다. 
> 인텔리제이 편집기에서 실행 버튼을 클릭하거나 터미널에서 명령어 입력으로 실행합니다. 

## API 정의 및 실행 방법 
### 평가 생성/수정 API

- **평가 생성**: 사용자가 작품에 대해 '좋아요/싫어요'와 댓글을 남길 수 있습니다.

    ```shell
    curl -X POST http://localhost:8080/api/comments \
    -H "Content-Type: application/json" \
    -d '{"artworkId": 1, "userId": 1, "good": 1, "dislike": 0, "comment": "This is a test comment"}'
    ```

- **댓글 특수문자 오류 케이스**:

    ```shell
    curl -X POST http://localhost:8080/api/comments \
    -H "Content-Type: application/json" \
    -d '{"artworkId": 1, "userId": 1, "good": 1, "dislike": 0, "comment": "This is a test ##comment"}'
    ```

### 좋아요/싫어요가 가장 많은 작품 조회 API

- **'좋아요'가 가장 많은 작품 조회**:

    ```shell
    curl -X GET http://localhost:8080/api/comments/top-liked
    ```

- **'싫어요'가 가장 많은 작품 조회**:

    ```shell
    curl -X GET http://localhost:8080/api/comments/top-disliked
    ```

### 작품 조회 이력 API

- **작품별 조회 이력 조회**:

    ```shell
    GET http://localhost:8080/api/artwork-view-histories/1 
    ```

### 성인 작품 방문자 목록 조회 API

- ** 최근 1주일간 등록 사용자 중 성인 작품을 3개 이상 조회한 사용자 목로글 조회하는 API **:

    ```shell
    curl -X GET http://localhost:8080/api/artwork-view-histories/frequent-adult-viewers
    ```

### 작품 가격 변경 API

- **가격 변경 (정상 케이스)**:

    ```shell
    curl -X POST http://localhost:8080/api/artworks/1/change-price \
    -H "Content-Type: application/json" \
    -d '{"newPrice": 500}'
    ```

- **가격 변경 (오류 케이스)**:

    ```shell
    curl -X POST http://localhost:8080/api/artworks/1/change-price \
    -H "Content-Type: application/json" \
    -d '{"newPrice": 501}'
    ```

### 사용자 삭제 API

- **특정 사용자 및 관련 데이터 삭제**:

    ```shell
    curl -X DELETE http://localhost:8080/api/users/1
    ```