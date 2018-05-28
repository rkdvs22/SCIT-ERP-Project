
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
  * 프론트사이드 : HTML, CSS, JavaScript, Jquery(Ajax 포함)

* **Server 및 데이터베이스**
  * 서버 : Apache Tomcat 8.5.31
  // GEUNTAEK MySQL 써보는 것도 어떨까 하는 생각이 있음. 어차피 겐바에서는 MySQL 많이 쓴다는 개인적인 의견때문..?
  * 데이터베이스 : Oracle 12g 12.1.0.2.0 SE2 window 64비트
     * MyBatis , JDBC 방식

* **버전 관리**
  * Git : Git + Github(원격저장소)
  * 관리 UI Tool : SourceTree

* **그 외 사용툴**
  * visual studio : README.MD 파일 등 작성시 효율적 (자유 사용)
  * oracle SQL Developer : 쿼리 날리기, 결과 확인 용의
  * Advanced Rest Client : API테스트 할 시 사용(가상으로 논리 로직 확인 가능)
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

* **목적**
  * 사원 관리 프로그램으로서 주 고객은 일반 회사들을 목표로 한다.

* **주요 기능**
  * 기능

    * 게시판 CRUD
    // GEUNTAEK 게시판 등록 기능의 유무?
        * 공지사항 및 파일첨부 (조회수, 댓글)
        * 조회 (페이징 -
                여러 주제별로(제목, 작성자, 기간))
        * 수정
        * 삭제

    * 사원 관리 CRUD
        * 등록
        * 조회 (페이징 -
               여러 주제별로(매출, 근무기간, 이름, 부서별, 거래처별, 평가별))
        * 정보 변경 (Master)   
        * 삭제

    * 거래처 관리 CRUD
        * 등록
        * 조회 (페이징)
        * 정보 변경 (Master)   
        * 삭제    

    * 업무 관리
        * 프로젝트별 매출 조회(년도별, 매출정도별 , 부서별) - 통계사용
        * 부서 관리 (사원 이동 등)
