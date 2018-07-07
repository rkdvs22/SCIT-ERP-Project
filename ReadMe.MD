
## 사용하는 기술

* **Framework**
  * Spring Framework

* **디자인 패턴**
  * view (확장자 - html) + API(순수 로직 담당 – Spring boot REST API방식)

* **데이터 교환 방식**
  * json을 기본 방식으로. view페이지 이벤트에서 API를 호출
    (고유 IP주소 + 포트번호 + 프로젝트 루트 + 컨트롤러 및 메서드 맵핑주소)
    * ex) `new-master-project/book`
    * URL例：`http://localhost:8080/new-master-project/book/getBookList`

* **사용언어**
  * 서버사이드 : JAVA(1.8version)
  * 프론트사이드 : HTML, CSS, JavaScript(ES5), Jquery(Ajax 포함), Bootstrap

* **Server 및 데이터베이스**
  * 서버 : Apache Tomcat 8.5.31
  // GEUNTAEK MySQL 써보는 것도 어떨까 하는 생각이 있음. 어차피 겐바에서는 MySQL 많이 쓴다는 개인적인 의견때문..?
  * 데이터베이스 : mysql community-8.0.11.0 window 64비트
     * MyBatis , JDBC 방식

* **버전 관리**
  * Git : Git + Github(원격저장소)
  * 관리 UI Tool : SourceTree

* **그 외 사용툴**
  * visual studio : README.MD 파일 등 작성시 효율적 (자유 사용)
  * Advanced Rest Client : API테스트 할 시 사용(가상으로 논리 로직 확인 가능) // chrome app store
  * projectlombok : API

* **Method Type**
  * POST


* **Input Data Format**
  - data: 각 API 보낼 data 객체
  - InputForm 형식 예시： json
    ```
    {
      "token": "test",
      "data": {
        "roomName": "test",
        "roomDesc": "test",
        "enableFlg": "1"
      }
    }
    ```

* **Output Data Format**
  * status：처리결과  
    `200：정상、500：에러`
  * message：에러 발생시의 메세지 내용
  * data：각 API 처리 결과의 결과물   


---

## 프로젝트 개요  

* **프로젝트 명**
  * moviehunter   

* **목적**
  * 영화예매사이트로 관리자, 일반사용자를 대상으로 한다.
    CRUD기능을 중점으로 비지니스로직을 구축한다.

* **주요 기능**
  * 기능

    * 공통
      * 로그인
      * 로그아웃
    * 관리자
      * 영화
        * 영화정보 추가
        * 영화정보 조회
        * 영화정보 수정(삭제 포함)
      * 회원 관리
        * 회원조회
        * 회원정보 수정
        * 회원정보 삭제
      * 예매 관리
        * 예매정보 조회
        * 예매정보 수정
        * 예매정보 삭제
      * 상영관
        * 상영관 추가
        * 상영관정보 조회
        * 상영관정보 수정(삭제 포함)
      * 매출관리
        * 조회(기간, 연령)
        * 통계 (옵션)

    * 일반사용자
      * 영화
        * 조회
      * 회원정보
        * 가입
        * 수정
        * 탈퇴
      * 예매 관리
        * 추가
          * 회원정보, 예매정보(영화명, 상영관, 금액, 좌석, 시간) API로 이동
        * 조회
          * 현재 시간을 기준으로 예매 가능한 데이터만 출력
        * 삭제
      * 리플 평점 (후기) - 리플
        * 추가
        * 수정
        * 삭제
