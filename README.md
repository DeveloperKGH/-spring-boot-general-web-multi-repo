## :closed_book: Description
Spring Boot 기반 웹서비스  
* Multi Repo Practice

## :muscle: Skills
<p>
<img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-v3.0.3-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white">
<img alt="MySQL" src="https://img.shields.io/badge/MySQL-v8.0.32-4479A1?style=flat-square&logo=MySQL&logoColor=white">
</p>

---
## Running the app

```bash
# docker-compose.yml 에 정의되어 있는 모든 서비스 컨테이너 실행
$ docker-compose up -d

# build
$ ./gradlew build -x test

# run
$ nohup java -jar multi-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=default &> /dev/null 2>&1 &
```

