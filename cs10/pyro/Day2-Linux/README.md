# Day2-Linux [미션] 쉘 스크립트

## 교육 사이트

- [ShellCheck](https://www.shellcheck.net) : 본인이 짠 shell 이 말이 되는지 확인하기 위해 좋다.
- [Bash Scripting Tutorial for Beginners](https://linuxconfig.org/bash-scripting-tutorial-for-beginners) : 막막할 때 읽어볼만한 문서
- [Learn Shell](https://www.learnshell.org) : 풀어볼만한 shell 연습문제들

## 참고 사이트

- [Check whether a certain file type/extension exists in directory](https://stackoverflow.com/questions/3856747)
- [how do I zip a whole folder tree in unix, but only certain files?](https://stackoverflow.com/questions/1112468)

## 실행법

```sh
sh generate.sh # mission.sh 를 위한 디렉토리와 파일 생성
sh mission.sh # mission 에 해당하는 스크립트
rm -rf day* backup* # gitignore 에 해당하는 파일 및 폴더 삭제
```

## sh 파일별 설명

### generate.sh

day1 부터 day16 까지 폴더를 만들고 안에 mission.sh 를 실행하기 위한 파일들을 만든다.

### mission.sh

[쉘 스크립트 미션](https://lucas.codesquad.kr/main/course/2021-Masters-CS-10/day2-linux/%EC%89%98-%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8)에서 요구하는 기능들을 구현
