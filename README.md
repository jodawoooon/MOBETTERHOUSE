# ๐  *Mo Better House* ๐ 
๋ ์ข์ ์ง์ ์ฐพ๊ธฐ ์ํ ์ง์นจ์.  
์ฃผํ ๊ฑฐ๋ ์ ๋ณด ํ๋ซํผ

SSAFY ๊ดํตํ๋ก์ ํธ ์ต์ฐ์์ ๐ฅ

![image](https://user-images.githubusercontent.com/38212743/123923071-9cf3b700-d9c3-11eb-9d96-6ed5b8e9f4eb.png)

<br><br>

<h2> 1๏ธโฃ ๊ธฐํ๋ฐฐ๊ฒฝ </h2>

*์ด ๊ณณ ์  ๊ณณ ๋น๊ตํ์ง ์๊ณ , ํ ๊ณณ์์ ์ํ๋ ์กฐ๊ฑด์ ์ง์ ์ฐพ์ ์ ์์๊น?*
<br>

์ด์ฌ๋ฅผ ํ๊ณ ์ ํ  ๋๋ค์์ ์ํ๋ ์ฃผํ์ ์ฐฟ์๋ผ ๋ชฉ์ ์ผ๋ก ์ฃผํ ๋งค๋ฌผ, ๋๋ค ์ ๋ณด ๋ฑ์ ์กฐํํ๊ณ  ์ฌ์ฉ์ ํธ์์ฑ์ ๋์ผ ๋๋ค ์ปค๋ฎค๋ํฐ ๋ฑ ๋ค์ํ ์๋น์ค๋ฅผ ์ ๊ณตํ๊ณ ์ ํ๋ค.

<br>

## 2๏ธโฃ ๋ชฉํ

1. ๋ค์ํ ๋งค๋ฌผ ์ ๋ณด ๊ฒ์
2. ์ฌ์ฉ์ ๋ง์ถค ์๋น์ค ์ ๊ณต 
    - ๊ด์ฌ ๋งค๋ฌผ, ๊ด์ฌ ๋๋ค๋ฅผ ๋ฑ๋กํ๊ณ  ํ ๋์ ๋ชจ์๋ณผ ์ ์๋๋ก ํ๋ค.
3. ์์น๊ตฌ ๋ณ ํต๊ณ ๋ฐ ํ๊ตฐ ์ ๋ณด ์ ๊ณต
    - ์ด์ฌ๊ฐ ๋๋ค๋ฅผ ๋น๊ตํ๊ณ  ์ ํํ๋๋ฐ ๋์์ ์ค๋ค
4. ์ฐ๋ฆฌ๋๋ค ์ปค๋ฎค๋ํฐ๋ก ํ์ฉ
    - ์ง์ญ ์ปค๋ฎค๋ํฐ ํ์ฑํ์ ๊ธฐ์ฌํ๋ค.
<br>

## 3๏ธโฃ ์ญํ 

<h3>Backend (Spring) & Front-end(Vue)</h3>

  - ๋ก๊ทธ์ธ, ํ์๊ฐ์, ๋ง์ดํ์ด์ง ๊ฐ๋ฐ  
  - ์ง์ญ ๋ณ ํต๊ณ ์ ๋ณด ๊ฒ์ ํ์ด์ง ๊ฐ๋ฐ  
  - ํ๊ตฐ ์ ๋ณด ๊ฒ์ ํ์ด์ง ๊ฐ๋ฐ  
  - ๋ฉ์ธ ํ์ด์ง ๋ฐ ํ ์๊ฐ ํ์ด์ง ๊ฐ๋ฐ  
<br>

## 4๏ธโฃ ๊ฐ๋ฐ ํ๊ฒฝ & ๊ธฐ์  ์คํ
  - ์ด์์ฒด์  : Window 10, Mac OS X
  - Front : Vue.js, Vue-CLI, Vue-router, Vuex, axios, HTML5, CSS5, BootStrap5, JavaScript, Chart.js
  - Back : SpringBoot, MyBatis, GSON
  - Database : MySQL
  - Etc : Git, Gitlab
<br>

## 5๏ธโฃ ํ๋ก์ ํธ ์ค๊ณ

### Client (Vue)
```
happy-house
.
dist/
public/
src/
    assets/
        css/
        img/
        upload/
    common/
        axios.js
        kakao.js
        ...
    components/
        modals/
        Bookmark.vue
        BookmarkArea.vue
        ...
    routers/
        router.js
    store/
        store.js
    vendor/
        notyf/
        sweetalert2/
    App.vue
    main.js
babel.config.js
package.js
package-lock.json
README.md
    
```

### Server (Spring Boot)

```
HappyHouse
.
bin/
gradle/
src/
    main/
        java/
            com.ssafy.happyhouse/
                common/
                    LoggerAspect.java
                    LoginInterceptor.java
                config/
                    GlobalExceptionHandler.java
                    WebMvcConfig.java
                controller/
                    BoardController.java
                    CodeController.java
                    ...
                dao/
                    BoardDao.java
                    CodeDao.java
                    ...
                dto/
                    BoardDto.java
                    BoardFileDto.java
                    ...
                service/
                    BoardService.java
                    BoardServiceImpl.java
                    ...
                HappyHouseApplication.java
        resources/
            config/
            mapper/
                board_query.xml
                code_query.xml
                ...
            static/
                css/
                img/
                js/
                upload/
                favicon.ico
                index.html
            logback.xml
    test/
build.gradle
gradlew
gradlew.bat
settings.gradle
...

```

1. ERD  
    ![image](https://user-images.githubusercontent.com/38212743/123883235-90e80500-d983-11eb-8961-2e69441046a6.png)

2. Class Diagram  
    - DTO  
        ![image](https://user-images.githubusercontent.com/38212743/123883257-a0674e00-d983-11eb-8ee6-9c9e422d81be.png)

    - Controller  
        ![image](https://user-images.githubusercontent.com/38212743/123883264-a3623e80-d983-11eb-982c-d4ffd3af1e27.png)
    
    - Service  
        ![image](https://user-images.githubusercontent.com/38212743/123883278-aa894c80-d983-11eb-923b-da42726aad3f.png)

    - DAO  
        ![image](https://user-images.githubusercontent.com/38212743/123883288-af4e0080-d983-11eb-985f-60f2f93ed1c4.png)



<br>

## 6๏ธโฃ ๊ฐ๋ฐ ๋ด์ฉ / ์ฑ๊ณผ

  - **๊ณต๊ณต ๋ฐ์ดํฐ**๋ฅผ ํ์ฉํ ์์ธ์ ์ํํธ ๋งค๋ฌผ, ํ๊ต, ํต๊ณ ์ ๋ณด (์ธ๊ตฌ์ ์ธ 7๊ฐ์ง) **DB ์์ฑ**
  - Kakao Map API๋ฅผ ํ์ฉํ **๋งค๋ฌผ ์ ๋ณด, ํ๊ตฐ ์ ๋ณด** ์๊ฐํ
  - Interceptor๋ฅผ ํ์ฉํ ๋ก๊ทธ์ธ, Kakao API๋ฅผ ํ์ฉํ **SNS ๋ก๊ทธ์ธ** ๊ตฌํ
  - ํ์์ ๋ณด ์์ , ํํด, ํ๋กํ ์ฌ์ง ์๋ก๋(ํ์ผ ์๋ก๋)๊ฐ ๊ฐ๋ฅํ **MY PAGE** ๊ตฌํ
  - **Validation๊ณผ ์ ์ฌ์ฉํ ํ์๊ฐ์** ๊ตฌํ
  - ์ฌ์ฉ์ ์ค์ฌ **MY ๊ด์ฌ ์๋น์ค** ๊ตฌํ (๊ด์ฌ ๋งค๋ฌผ, ๊ด์ฌ ์ง์ญ ์ค์ )
  - **Chart.js**๋ฅผ ํ์ฉํ ์์น๊ตฌ๋ณ ํต๊ณ ์ ๋ณด ์๊ฐํ
  - File Upload, Pagenation, CkEditor๋ฅผ ์ ์ฉํ **์ปค๋ฎค๋ํฐ** ๊ตฌํ
  - **Git**์ ํ์ฉํ ํ์๊ด๋ฆฌ


  ํ๋ก์ ํธ ๊ฒฝ์ง๋ํ ์ต์ฐ์์ ์์
  
<br>

## 8๏ธโฃ ๋ฐํ ์๋ฃ / ์์ฐ ๋์์
![์ฌ๋ผ์ด๋1](https://user-images.githubusercontent.com/38212743/119929581-c7afb180-bfb8-11eb-9d56-e7378800666b.PNG)
![์ฌ๋ผ์ด๋2](https://user-images.githubusercontent.com/38212743/119929585-c9797500-bfb8-11eb-843c-c47d63b9df7e.PNG)
![์ฌ๋ผ์ด๋3](https://user-images.githubusercontent.com/38212743/119929587-c9797500-bfb8-11eb-8463-8598712e9735.PNG)
![์ฌ๋ผ์ด๋4](https://user-images.githubusercontent.com/38212743/119929589-caaaa200-bfb8-11eb-8581-dfe3575a4301.PNG)
![์ฌ๋ผ์ด๋5](https://user-images.githubusercontent.com/38212743/119929591-caaaa200-bfb8-11eb-8f07-9123a5b58a8b.PNG)
![์ฌ๋ผ์ด๋6](https://user-images.githubusercontent.com/38212743/119929592-cb433880-bfb8-11eb-8866-379d90f50be3.PNG)
![์ฌ๋ผ์ด๋7](https://user-images.githubusercontent.com/38212743/119929593-cbdbcf00-bfb8-11eb-9d7d-87f011096c1f.PNG)
![์ฌ๋ผ์ด๋8](https://user-images.githubusercontent.com/38212743/119929595-cc746580-bfb8-11eb-90c7-0a40856bef6e.PNG)
![์ฌ๋ผ์ด๋9](https://user-images.githubusercontent.com/38212743/119929596-cc746580-bfb8-11eb-9451-b1b6ed46f3fe.PNG)
![์ฌ๋ผ์ด๋10](https://user-images.githubusercontent.com/38212743/119929597-cd0cfc00-bfb8-11eb-9a8c-13c7aecbd831.PNG)
![์ฌ๋ผ์ด๋11](https://user-images.githubusercontent.com/38212743/119929599-cda59280-bfb8-11eb-8e99-e358218a062a.PNG)
![์ฌ๋ผ์ด๋12](https://user-images.githubusercontent.com/38212743/119929601-ce3e2900-bfb8-11eb-94ba-8fa96ba46186.PNG)
![์ฌ๋ผ์ด๋13](https://user-images.githubusercontent.com/38212743/119929603-ced6bf80-bfb8-11eb-8b1b-733c1f0ebcdb.PNG)
![์ฌ๋ผ์ด๋14](https://user-images.githubusercontent.com/38212743/119929605-ced6bf80-bfb8-11eb-9c48-4ffead311ade.PNG)
![์ฌ๋ผ์ด๋15](https://user-images.githubusercontent.com/38212743/119929606-cf6f5600-bfb8-11eb-8dd4-7dda26d086ed.PNG)
![์ฌ๋ผ์ด๋16](https://user-images.githubusercontent.com/38212743/119929610-d007ec80-bfb8-11eb-9895-f8ca5dee44a3.PNG)
![์ฌ๋ผ์ด๋17](https://user-images.githubusercontent.com/38212743/119929613-d007ec80-bfb8-11eb-9e7b-088ed9b111b6.PNG)
![์ฌ๋ผ์ด๋18](https://user-images.githubusercontent.com/38212743/119929620-d0a08300-bfb8-11eb-88d3-e4a97d8f4cbc.PNG)
![์ฌ๋ผ์ด๋19](https://user-images.githubusercontent.com/38212743/119929621-d1391980-bfb8-11eb-88b9-d73e50d76e9b.PNG)
![์ฌ๋ผ์ด๋20](https://user-images.githubusercontent.com/38212743/119929623-d1d1b000-bfb8-11eb-81cf-e6d5dd8683e6.PNG)
![์ฌ๋ผ์ด๋21](https://user-images.githubusercontent.com/38212743/119929625-d1d1b000-bfb8-11eb-9c27-e10c724d0daf.PNG)

### ์์ฐ์์
https://youtu.be/WNUg9eH2q6s
