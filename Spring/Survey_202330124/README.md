[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/J9IBm5C7)
# 202330124 이태규

# Spring MVC 설문조사 시스템 구현

이 프로젝트는 Spring MVC를 활용한 설문조사 시스템 구현 과제입니다.

## 개발 환경
- Java 11 이상
- Spring MVC
- MySQL 8.0
- JSP / JSTL
- Maven

## 과제 목표
Spring MVC 아키텍처를 활용하여 설문조사 시스템을 구현합니다. 
이 과제를 통해 다음과 같은 Spring 핵심 개념을 실습하게 됩니다:

1. MVC 패턴 구현
2. Form 처리 및 데이터 바인딩
3. 유효성 검증(Validation)
4. 의존성 주입(DI)과 IoC 컨테이너
5. 데이터베이스 연동(MySQL)

## 프로젝트 구조

프로젝트는 다음과 같은 구조로 구성되어야 합니다:

### 프로젝트명 : Survey_[본인 학번]

### 폴더 구조 
- src>main>java>survey
    - Survey.java
    - SurveyDao.java
    - SurveyRegisterService.java
- src>main>java>controller
    - SurveyController.java
    - SurveyCommand.java
- src>main>webapp>WEB-INF
    - web.xml
- src>main>webapp>WEB-INF>view>survey
    - surveyForm.jsp
    - surveyComplete.jsp
    - surveyList.jsp
- src>main>java>config
    - MvcConfig.java
    - ControllerConfig.java
    - SurveyConfig.java

## 테이블 구조

```sql
CREATE TABLE SURVEY
(
    ID             int auto_increment primary key,
    Q1             varchar(255), -- 희망분야 답변
    Q2             varchar(255), -- 개발도구 답변
    Q3             varchar(255), -- 하고싶은말 답변
    RespondentName varchar(100), -- 응답자 이름
    RespondentAge  int(3), -- 응답자 나이
    REGDATE        datetime -- 등록일
) ENGINE = InnoDB
  CHARACTER SET = utf8;
