# api定義：管理者

* **URL**
  * `moviehunter/`
    - マスター：`/manager`
  * URL例
    - マスター
     : `http://localhost:8080/moviehunter/manager/example`


* **データのタイプ**
  * JSON

* **メソッドのタイプ**
  * POST

* **Input data format**
  - data : 各APIによるデータ
  - InputForm 形式例
  ```json
    {
      "userId": "exmapleId",
      "userPw": "exmaplePw",
      "userAge": "exmapleAge",
      "userGender": "exampleGender",
      "userMobile": "exmapleMobile"
    }
  ```

* **Output data format**
  - status : 処理結果
    `200：正常、500：エラー`
  - message : エラー時のメッセージ
  - data : 各APIによるデータ


---

## 目次
####　マスター　API
1. 映画
1.1. addMovieInfo
1.2. findMovieInfo
1.3. updateMovieInfo
1.4. deleteMovieInfo

2. 会員
2.1. findOneUser
2.2. findMultiUser
2.3. updateUser
2.4. deleteUser

3. 予約管理
3.1. findReservation
3.2. updateReservation
3.3. deleteReservation

4. 映画館管理
4.1. addScreen
4.2. findScreen
4.3. updateScreen
4.4. deleteScreen

5. 売上管理
5.1. getStatisticsInfo
5.2. statistics(OPTION)


### マスター API(URL : `/moviehunter/manager/`)

#### 1. 映画

###### 1.1.  映画追加
* **URL**
`/addMovieInfo`

* **Input data**
  * MovieModel
    * screen_SEQ：映画館のID
    * movie_name：映画名
    * content：未定（忘れた。。）
    * movie_category：映画の種類
    * image：映画のイメージ

  * **Output data**
    * boolean

###### 1.2. 映画検索

* **URL**
`/findMovieInfo`

###### 1.3. 映画編集

###### 1.4. 映画削除

#### 2. 会員

###### 2.1.  会員検索（一人）

###### 2.2. 会員検索（多数）

###### 2.3. 会員編集

###### 2.4. 会員削除

#### 3. 予約管理

###### 3.2. 予約検索

###### 3.3. 予約編集

###### 3.4. 予約削除

#### 4. 映画館管理

###### 4.1.  映画館追加
* **URL**
`/addCinema`

* **Input data**
  * CinemaModel
    <!-- * cinemaId: -->
    * theNumberOfSeats :

* **Output data**
  *

###### 4.2. 映画館検索

###### 4.3. 映画館編集

###### 4.4. 映画館削除

#### 5. 売上管理

###### 5.1. 売上検索

###### 5.2. 統計（オプション）
