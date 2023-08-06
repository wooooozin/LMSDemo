# 프로젝트 설명 
### Learning Management System 기능 구현된 프로젝트에 추가 기능을 구현한 프로젝트

## 기존 구현 기능
- 회원가입 및 가입 인증메일 전송
- 로그인 및 로그아웃
- 비밀번호 찾기(비밀번호 초기화 기능)
- 관리자(백오피스) 회원 관리
- 관리자(백오피스) 카테고리 관리
- 관리자(백오피스) 강좌 관리

## 추가 구현 기능
- 회원 로그인시 로그인 히스토리(로그) 기능
  - 프로트 화면에서 회원이 정상적으로 로그인 한 경우<br>
    로그인 히스토리 테이블(login_history)에 로그인 아이디와 로그인 날짜, 접속 IP, 접속 UserAgent를 저장

<img width="600" alt="1" src="https://github.com/wooooozin/LMSDemo/assets/95316662/c6119d91-8e6f-426d-b7b4-ef38e77703f0">
<img width="600" alt="3" src="https://github.com/wooooozin/LMSDemo/assets/95316662/819be56f-f859-4727-9aca-1b6569280cdd">

- 관리자 회원 상세 정보에 로그인 목록 보기 기능
  - 회원 관리 목록의 끝 부분에 회원별 마지막 로그인 날짜 컬럼 추가
  - 회원 관리 사용자 상세 정보 아래쪽에 로그인 접속 목록 표시
  
<img width="600" alt="2" src="https://github.com/wooooozin/LMSDemo/assets/95316662/bb9bc406-f66a-45a8-8e6f-28b15369ac8c">
<img width="600" alt="2" src ="https://github.com/wooooozin/LMSDemo/assets/95316662/d2b43039-d208-45f5-b4a0-22315e5328c1">


- 배너관리(백오피스 기능)
  - 배너 등록 구현
  - 배너 관리 조회 구현
  
<img width="600" alt="10" src="https://github.com/wooooozin/LMSDemo/assets/95316662/ad6d61a4-f2d0-43d4-a1ac-05af836a58de">
<img width="600" alt="20" src="https://github.com/wooooozin/LMSDemo/assets/95316662/47d93356-dac1-4512-8442-c04192e35f3d">
<img width="600" alt="30" src="https://github.com/wooooozin/LMSDemo/assets/95316662/bccd85dc-746e-4a79-8d42-8a82b66346a1">



- 프론트 배너 노출 기능
  - 로그인 시 공개 상태인 배너 목록 보여주기
    
![111](https://github.com/wooooozin/LMSDemo/assets/95316662/7c1a700d-dcf2-48d2-a252-2d61922cda36)


# 🐯 실습 프로젝트 및 과제 후기
스프링부트 기반 웹페에지 구현을 해보니 controller, service, dto, entity, datainput 등 관계와 로직을 조금이라도 이해할 수 있었고<br>
처음 접해보는 MyBatis, Mapper, DataInput 등 기존 구현 기능을 참고하며 구현했지만 내 것으로 만들기엔 부족했다고 생각한다. <br>
<br>
특히 DB에서 이미지를 보여주는 것은 오랜 시간이 걸렸고 이미지를 blob으로 처리하는게 적당한가에 대한 생각도 들었다.<br>
외에도 프로젝트 안내서를 꼼꼼히 확인하지 않아 중간 중간에 엔티티나 dto를 수정하는 일도 있어 <br>
DB에 이미 생성된 column과도 매칭이 안되어 잦은 에러가 발생했고<br>
프론트 스와이퍼 라이브러리 사용에도 꽤나 오랜 시간을 소모했다.
<br>
<br>
이번 과제를 통해 스프링부트 기반 웹 프로그래밍을 접할 수 있어 <br>지난 자바 기반 프로젝트를 어떻게 리팩토링하면 좋을지 감이 안왔는데 가이드가 된것 같고 <br>
새로운 기능과 라이브러리 사용 그리고 로직 설계 등에서 역량을 향상시키는 중요한 경험이었다고 생각한다.
