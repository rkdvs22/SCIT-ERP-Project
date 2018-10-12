# callback함수란? 

* 동기 처리 vs 비동기 처리    

    이전까지 웹에서의 이벤트 처리는 먼저 실행한 순서대로 그리고 해당 로직의 순서대로 앞에 것이 끝날 때까지 대기한 후에야 순차적으로 실행하는 동기 처리 방식이었다. 하지만 이러한 처리는 굉장히 비효율적이고 현대의 웹 개발 방식에는 맞지 않는다. 지금의 웹 구조를 보면 불필요한 페이지 이동은 삼가면서 단일 페이지에서 필요한 최소한의 정보만 바꾸는 SPA가 대세이며(SPA가 항상 정답은 아니다 - 문제점 있음) 이에 따라 대부분의 이벤트 처리가 앞에 작업을 기다리지 않고 바로바로 해당 비지니스 로직을 처리하는 비동기 방식을 통해 처리되고 있다.

        - SPA의 문제점

        http://m.mkexdev.net/374


* 비동기 처리의 대표적인 예

    1. Jquery의 ajax(비동기 처리 대표적인 예)
    2. setTimeout() 

    = 2번의 경우는 이벤트에 대한 처리 및 결과를 시간을 설정해 두고 처리하는 방식이다. 

* 비동기 처리의 문제점 

    javascript는 본래 java나 c같이 절차적 언어와는 다르게 비동기 처리를 하는 언어이다. 비동기 처리는 앞서한 로직의 결과를 기다리지 않고 바로 실행해버린다. 이는 효율적이고 빠른 결과값을 가져올 수 있지만 만약 해당 로직들이 일련의 순서가 있다면? 
    
        예를 들어 A가 성공하면 B를 실행하고 그 결과값을 가지고 C를 실행해야하는 로직이 있는데 B가 시간이 소요되는 로직이었다 
        → 비동기 통신이므로 B를 기다리지 않고 C를 바로 실행함 
        → 예상 결과와는 전혀 다름

    이러한 문제점을 해결하기 위해 callback 함수를 사용한다. callback 함수란 쉽게 말해 함수를 부르는 것이다. 하지만 그냥 부르는 것이 아니라 특정 조건하에 해당 함수를 부르는 것이다. 즉 함수를 엮어서 순서대로 로직이 처리될 수 있도록 하는 것이다. 대표적인 예가 ajax이다. ajax통신을 통해 success가 될수도 error상태가 될 수도 있다. 이러한 각각의 상태, 조건에 따라 호출되는 콜백함수도 다를 것이다. 

* callback 지옥

    callback함수를 사용하다보면 로직에 따라 끝없이 함수가 엮이면서 역피라미드형의 끔찍한 구조의 코딩형태를 볼 수 있다..

    ```
        $.get('url', function (response) {
            parseValue(response, function (id) {
                auth(id, function (result) {
                    display(result, function (text) {
                        console.log(text);
                    });
                });
            });
        });
    ```

    위의 ajax를 예로 들면
    
        통신에 성공 → 결과값 뷰에 맞게 파싱 → 사용자 인증 → 결과값 출력

    그렇게 긴 로직도 아닌데 벌써 몇 개의 함수가 엮이면서 복잡해지고 있는 것을 볼 수 있다. (여기에 if, switch, while등의 조건문이나 예외처리 구문까지 합쳐지면 처음보는 사람은 못 읽는다..ㅋㅋㅋ)
    이런 경우 가독성도 떨어질 뿐만 아니라 유지보수할 때 굉장히 어려워진다.

* callback 지옥 해결책

    크게 3가지가 있다고 한다.

    * Async 모듈 
    * Promise (ES6에 도입되었다. - 표준이며 추천이 많음)
    * 코딩 패턴으로 처리(그냥 노가다임.. 함수를 밖에서 미리 엮어 놓는 것임.)

* Promise방식

    <MDN 공식사이트>
    " Promise 객체는 비동기 계산을 위해 사용됩니다. Promise는 아직은 아니지만 나중에 완료될 것으로 기대되는 연산을 표현합니다. "

    단어 그대로 "약속"과 같은 개념이죠.
    Promise는 비동기 동작이 완료된 후 결과 값 또는 실패의 이유를 콜백 함수로 전달합니다.
    따라서 비동기 동작이 정상적으로 완료되었는지, 오류가 발생했는지 알 수 있도록 상태가 정의되어 있어야 합니다.

    ex)

    ```
    var test = function(bool){
    return new Promise(function(resolve, reject){
        setTimeout( function(){
        if(bool){
            resolve("fulfilled가 수행되었습니다. then으로 연결됩니다.");
        }
        else{
            reject("rejected되었습니다. catch로 연결됩니다.");
        }
        }, 1000)
    })
    }
    
    test(true).then( function(result){
    console.log(result);
    }).catch( function(err){
    console.log(err)
    })

    ```

    Promise Prototype은 then()메서드와 catch()메서드로 2가지가 있는데, 성공시 then(), 실패시 catch()에서 처리한다. 이를 이용하여 비동기동작을
    연결하여 사용할 수 있다.

    ```
    var test = function(bool){
    return new Promise(function(resolve, reject){
        setTimeout( function(){
        if(bool){
            resolve("fulfilled가 수행되었습니다. then으로 연결됩니다.");
        }
        else{
            reject("rejected되었습니다. catch로 연결됩니다.");
        }
        }, 1000)
    })
    }
    
    test(true).then( function(result){
    console.log("1 " + result);
    return test(true);
    
    }).then( function(result){
    console.log("2 " + result);
    return test(false);
    
    }).then( function(result){
    console.log("3 " + result);
    return test(true)
    
    }).catch( function(result){
    console.log("4 " + result);
    return test(true)
    
    }).then( function(result){
    console.log("5 " + result);
    return test(true)
    })

    ```
    1 - 2 - 4 - 5가 실행된다.(2번에서 false이므로 catch()로 빠지고 다시 여기서 true를 반환했으므로 5을 실행)

    Promise를 잘못사용하면 다시 콜백지옥으로 빠질 수 있다.(정확히 이해하고 사용해야 한다.) Promise는 어떻게 보면 근본적인 대안은 아니다.. 

    Promise를 정확히 알고 사용하는 것이 중요

    1. 다른 promise를 return
    2. 발생한 값 이나 undefined를 return 
    3. throw 에러

    ex) 또다른 예시

    ```
        //Promise 선언
        var _promise = function (param) {

            return new Promise(function (resolve, reject) {

                // 비동기를 표현하기 위해 setTimeout 함수를 사용 
                window.setTimeout(function () {

                    // 파라미터가 참이면, 
                    if (param) {

                        // 해결됨 
                        resolve("해결 완료");
                    }

                    // 파라메터가 거짓이면, 
                    else {

                        // 실패 
                        reject(Error("실패!!"));
                    }
                }, 3000);
            });
        };

        //Promise 실행
        _promise(true)
        .then(function (text) {
            // 성공시
            console.log(text);
        }, function (error) {
            // 실패시 
            console.error(error);
        })
    ```

    * Promise의 상태

        1. pending (아직 약속을 수행중인 상태 - fulfilled나 rejected 전                상태)
        2. fulfilled (약속이 지켜진 상태)
        3. rejected (약속이 안지켜진 상태)
        4. settled (약속이 지켜지든 안지켜지든 결론이 난 상태)
    
    현재 Promise는 크롬은 지원을 하고 있는 상태이나 IE에서는 지원을 하고 있지 않다..  사용하려면 코드를 작성하고 트렌트파일러인 babel을 사용하는 수 밖에 없다. 
    위에 작성한 것은 Promise의 아주 기본적인 사항이기 때문에 이것을 기본으로 Promise의 메서드나 실질적인 사용방법에 대해 알아두자