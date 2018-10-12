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
3.4. addReservation

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

* **movie model**
  * movie_seq : 映画番号
  * movie_name：映画名
  * content：未定（忘れた。。）
  * movie_category：映画の種類
  * image：映画のイメージ


###### 1.1.  映画追加
* **URL**
`/addMovieInfo`

* **Input data**
  * screen_SEQ：映画館のID
  * movie_name：映画名
  * content：未定（忘れた。。）多分。。映画ファイル
  * movie_category：映画の種類
  * image：映画のイメージ

* **Output data**
  * boolean

###### 1.2. 映画検索

* **URL**
`/findMovieInfo`

* **Input data**
  * movie_name：映画名

* **Output data**
  * ArrayList(MovieDAO)
    * movie_seq : 映画番号
    * movie_name：映画名
    * content：未定（忘れた。。）多分。。映画ファイル
    * movie_category：映画の種類
    * image：映画のイメージ

###### 1.3. 映画編集

* **URL**
`/updateMovieInfo`

* **Input data**
  * movie_seq : 映画番号
  * movie_name：映画名
  * content：未定（忘れた。。）
  * movie_category：映画の種類
  * image：映画のイメージ

* **Output data**
  * boolean

###### 1.4. 映画削除
* **URL**
`/deleteMovieInfo`

* **Input data**
  * movie_seq : 映画番号

* **Output data**
  * boolean

#### 2. 会員

* user model
  * user_seq: ユーザー番号
  * name：お名前
  * age：年齢
  * gender：性別
  * phone：電話番号
  * count：映画を見た回数
  * email：メール

###### 2.1.  会員検索（一人）

* **URL**
`/findOneUser`

* **Input data**
  * name：お名前
  * phone：電話番号

* **Output data**
  * UserDAO
    * user_seq: ユーザー番号
    * name：お名前
    * age：年齢
    * gender：性別
    * phone：電話番号
    * count：映画を見た回数
    * email：メール

###### 2.2. 会員検索（多数）

* **URL**
`/findMultiUser`

* **Input data**
  * age：年齢

* **Output data**
  * ArrayList(UserDAO)
  * user_seq: ユーザー番号
  * name：お名前
  * age：年齢
  * gender：性別
  * phone：電話番号
  * count：映画を見た回数
  * email：メール

###### 2.3. 会員編集

* **URL**
`/updateUser`

* **Input data**
  * user_seq: ユーザー番号
  * name：お名前
  * age：年齢
  * gender：性別
  * phone：電話番号
  * count：映画を見た回数
  * email：メール

* **Output data**
  * boolean

###### 2.4. 会員削除

* **URL**
`/deleteUser`

* **Input data**
  * user_seq: ユーザー番号

* **Output data**
  * boolean

#### 3. 予約管理

* Reservation Model
  * reservation_seq：予約番号
  * user_seq：ユーザー番号
  * settingInfo_seq：映画と映画館の情報と連結されている番号
  * reserve_price：予約金額

###### 3.1. 予約検索

* **URL**
`/findReservation`

* **Input data**
  * user_seq：ユーザー番号

* **Output data**
  * ArrayList(ReservationDAO)
    * reservation_seq：予約番号
    * user_seq：ユーザー番号
    * settingInfo_seq：映画と映画館の情報と連結されている番号
    * reserve_price：予約金額

###### 3.2. 予約編集

* **URL**
`/updateReservation`

* **Input data**
  * reservation_seq：予約番号
  * user_seq：ユーザー番号
  * settingInfo_seq：映画と映画館の情報と連結されている番号
  * reserve_price：予約金額

* **Output data**
  * boolean

###### 3.3. 予約削除

* **URL**
`/deleteReservation`

* **Input data**
  * reservation_seq：予約番号

* **Output data**
  * boolean

###### 3.4. 予約追加

* **URL**
`/addReservation`

* **Input data**
  * user_seq：ユーザー番号
  * settingInfo：予約された映画と映画館情報
    * movie_seq：映画番号
    * screen_seq：映画館番号
  * reserve_price：予約金額

  InputForm例
    ```json
    {
      "user_seq": "example_user_seq",
      "settingInfo": {
        "movie_seq": "example_movie_seq",
        "screen_seq": "example_screen_seq"
      },
      "reserve_price": "example_reserve_price"
    }
    ```

* **Output data**
  * boolean

#### 4. 映画館管理

* Screen model
  * screen_seq：映画館番号
  * showTime_seq：映画時間番号
  <!-- * seat_seq -->
  * screen_number：席番号
  * size：忘れた。。

###### 4.1.  映画館追加

* **URL**
`/addScreen`

* **Input data**
  * showTime：映画時間
    * weekDay：平日の場合1、それとも0
    * startTime：映画が始まる時間
    * endTime：映画終了時間
  * screen_number：席番号
  * size：忘れた。。

### showtimes 테이블에 있는 screen_seq가 필요한지?
### screen 등록과 동시에 showtime과 seat 설정이 되어야 하는 것 아닌지?
### 그렇다면 screen_seq를 빼거나 하는게 옳지 않은지? screen 테이블의 자식테이블 외부키도 마찬가지

  InputForm例
    ```json
      {
          "showTime" : {
            "weekDay" : "example",
            "startTime" : "example",
            "endTime" : "example"
          }
      }
    ```

* **Output data**
  *

###### 4.2. 映画館検索

* **URL**
`/findScreen`

* **Input data**

* **Output data**

###### 4.3. 映画館編集

* **URL**
`/updateScreen`

* **Input data**

* **Output data**

###### 4.4. 映画館削除

* **URL**
`/deleteScreen`

* **Input data**

* **Output data**

#### 5. 売上管理

* SaleManagementDAO
  * sale_seq：売上番号
  * reservation_seq：予約番号
  * total_amount：総合金額

###### 5.1. 売上検索

* **URL**
`/getStatisticsInfo`

* **Input data**
  * なし

* **Output data**
  * sale_seq：売上番号
  * reservation_seq：予約番号
  * total_amount：総合金額

###### 5.2. 統計（オプション）

* **URL**
`/statistics(OPTION)`

* **Input data**

* **Output data**
