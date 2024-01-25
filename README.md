# jpa를 사용하여 kbo 버전  who are ya 만들기 위한 프로젝트.
![](https://i.imgur.com/59jvo84.png)
> 출처 : 이스타 티비
## DB 설계 

![](https://i.imgur.com/fAqeBIE.png)


## 기능 설계
- 사용자
1.  첫 페이지 입장 시 랜덤 단일 선수 정보 (문제) 조회.

2.  검색 창 입력 시 선수 DB 에서 정보 보여주면서 자동 완성 기능  > 생년 월일 / 팀 / 포지션 
![](https://i.imgur.com/CcIMwPS.png)
 
3. 사용자가 선수 선택 시 서버로 보내서 랜덤 선수와 비교 
	 ![](https://i.imgur.com/z10HuP4.png) 
	 내가 입력한 값 나오고, 랜덤 선수와 비교를 해서
	 팀 - 나이 ↑ - 포지션 - 등번호 ↓ - 타입(우투/우타) - 키 (ex. 최정 키 ↑)
	이런 식으로 틀리면 틀린 걸 표현해주고 맞으면 
	![](https://i.imgur.com/GnwvebO.png)
	입력값 : 내야수 / 랜덤선수 값 : 내야수 면 초록불 

4.  사용자는 8번의 기회 안에 성공 / 실패 
5. 다시 하기 

- 관리자 
1. 선수 등록 (신인, 육성, 신규 영입) 해당 년도에 뛰는 선수(1/2군)만 등록 하도록 기준
2. 선수 수정 (팀 이적 / 등 번호 교체 등)
3. 선수 삭제 (은퇴 시)


## 필요한 스택
1. spring boot api 서버 
	- 모든 백엔드 기능 처리 
	- Selenium을 이용한 데이터 수집 (크롤링)
1.  react 페이지
	- 사용자 페이지
	- 관리자 페이지
2. DB 
	- mysql
3. WAS / WEB 서버
	- tomcat
	- nginx ( 리버스 프록시 )
4. 그 외
	- 배포는 미정



### 선수 정보
- https://sports.daum.net/team/kbo/389/squad#0 			기아	
- https://sports.daum.net/team/kbo/394601/squad#0		KT
- https://sports.daum.net/team/kbo/387/squad#0			lg
- https://sports.daum.net/team/kbo/172615/squad#0		NC
- https://sports.daum.net/team/kbo/384/squad#0			SSG
- https://sports.daum.net/team/kbo/385/squad#0			두산	
- https://sports.daum.net/team/kbo/386/squad#0			롯데
- https://sports.daum.net/team/kbo/383/squad#0			삼성	
- https://sports.daum.net/team/kbo/382/squad#0			키움	
- https://sports.daum.net/team/kbo/390/squad#0			한화


