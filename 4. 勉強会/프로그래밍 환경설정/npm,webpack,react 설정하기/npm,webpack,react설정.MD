## <npm과 webpack, react 설정 및 연동해서 웹프로젝트 구성하기>

1. 인터넷에서 Node.js설치
2. Node.js를 설치한 후 CMD에서  webpack과 webpack-dev-server 설치(전역설치)
        ```
		npm install -g babel webpack webpack-dev-server
        ```
3. 프로젝트 폴더 생성 및 해당 폴더로 이동
    ```
	mkdir react-tutorial && cd react-tutorial
    ```
4. 폴더 내 package.json 파일 생성
	```
    npm init
    ```
5. React, React-dom, lodash 설치 및 ––save속성을 이용해 package.jsom에 의존성 주입
    ```
	npm install --save react react-dom lodash
    ```
6. babel에서 사용될 플러그인 설치 – 해당 모델들은 개발 환경에서만 사용되므로 –save-dev옵션 설정 (node_modules 폴더 생성 및 dependan)
    ```
    npm install --save-dev babel-core babel-loader babel-preset-react babel-preset-es2015 webpack webpack-dev-server
    ```
7. webpack4.0이후 버전은 webpack-cil을 따로 설치해줘야 함
    ```
    npm i -D webpack webpack-cli
    ```
8. package.json 파일을 열어서 버전 확인
9. package.json 스크립트 부분 수정
    ```
    "scripts": {
        "start": " webpack-dev-server --hot --host 0.0.0.0 --mode development
    ",
        "dev": "webpack --mode development",
        "build": "webpack --mode production"
    },
    ```

10. 해당 폴더 아래 프로젝트 하위 폴더 생성(해당 폴더를 프로젝트 파일로 잡고)
11. webpack 설정 – webpack.config.js 생성 및 내부 설정
    ```
    module.exports = {
        entry: './src/index.js',

        output: {
            path: __dirname + '/public/',
            filename: 'bundle.js'
        },

        devServer: {
            inline: true,
            port: 7777,
            contentBase: __dirname + '/public/'
        },

        module: {
                rules: [
                    {
                        test: /\.js$/,
                        loader: 'babel-loader',
                        exclude: /node_modules/,
                        query: {
                            cacheDirectory: true,
                            presets: ['es2015', 'react']
                        }
                    }
                ]
            }
    };
    ```
12. public 폴더에 index.html을 생성, src폴더에는 components폴더 와 index.js를 생성 및 작성. components폴더 내에는  App.js를 생성 및 작성

13. 팩킹해야할 때는 - 개발시에는 npm run dev, 빌드할 때는 npm run build로 실행
     (webpack이 여러 모듈을 합쳐서 하나의 js인 bundle.js를 생성함)


14. 실행할 시npm start로 시작한 뒤
브라우저를 띄우고 주소:포트/ 입력해서 접속. App.js등 여러 모듈을 바꿀 때마다 실시간으로 브라우저에 반영됨(새로고침 필요없음)
