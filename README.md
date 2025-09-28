<img width="740" height="416" alt="Image" src="https://github.com/user-attachments/assets/e45c9fb7-bfe6-4d7e-bc92-78aff9bf0cc9" />

<br>

# 🚶 워킹토끼
AI와 지도 기반 미션으로 동대문을 걸으며 나만의 식물 도감을 만들어가는 참여형 보행 플랫폼

<br>

- **개발 기간**: 2025.08 (2주)  
- **팀 구성**: FE 2명, BE 1명, AI 1명


<br>
  
##  프로젝트 개요  


현재 도심 속 보행은 목적지까지 빠르게 이동하는 데 집중되어, 지역 자원과 정서적으로 연결될 수 있는 콘텐츠가 부족합니다.
워킹토끼는 단순히 걷기를 유도하고 기록하는 것을 넘어, **AI와 챗봇 기반 참여형 미션**을 통해 보행 경험을 확장하고, 개인화된 식물 도감을 구축할 수 있도록 설계된 서비스입니다.

서비스명은 **무전기(walkie-talkie)** 와 **걸음(Walking)** 에서 착안하여, “걸음을 잇는 소통”이라는 의미를 담고 있습니다.

무전기를 들고 있는 토끼 캐릭터의 챗봇과 미션을 주고받고, 사용자가 찍은 사진에 대한 정보도 실시간으로 공유할 수 있는 참여형 보행 플랫폼입니다.


<br>


##  기술 스택  
| 분야       | 기술 |
|------------|----------------------------------|
| Language   | Java |
| Framework  | Spring Boot |
| Database   | MySQL |
| Infra      | AWS EC2, AWS RDS, GCP Storage |
| Tools      | Git, GitHub, Figma, Discord, Notion |


<br>

##  주요 기능  

 **사용자 인증 및 회원 관리**
  - 카카오 로그인: 카카오 OAuth2.0 API를 연동해 소셜 로그인 기능 제공
  - JWT 기반 인증/인가 처리: 로그인 이후 모든 API 요청 시 JWT 검증을 통해 보안 강화

 **AI 기반 미션 생성 및 수행**  
  - Gemini 기반 '오늘의 미션' 자동 생성: 랜덤한 비율로 지역 데이터 정보와 혼합된 미션 제공
  - 미션 수행 과정 기록: AI로 부터 응답 받은 성공 결과를 지도·캘린더에 표시

 **AI 챗봇 식물 인식**  
  - 사진 업로드 → 식물 종 추정: 사용자가 촬영한 식물을 AI 모델과의 통신을 통해 식물 종 판별
  - 대화형 설명 제공: 챗봇이 해당 식물의 특징, 서식지, 계절성 등을 설명하고 사용자 질문에 응답하는 대화형 인터페이스 제공
  - 대화 기억 및 심화 학습: 동일 유저의 같은 종에 대한 이전 대화를 기억하여 반복 질문 시 심화된 설명 제공
 
 **도감 기록 관리**
  - 발견 기록 저장 및 조회: 날짜·위치·식물명·사진·설명 등을 기록하여 유저별 개인 도감 형태로 축적
  - 지도와 캘린더 기반 기록 시각화: 식물 발견 위치를 지도 위에 표시, 일자별로 어떤 식물 발견했는지 요약 표시
  - 도감 수 기준 랭킹 제공: 전체 사용자 간 도감 수 비교하여 전체/개인별 랭킹 표시

 **사용자 피드백**
  - 보행 환경 개선 의견 수집: 사용자가 위치 정보와 함께 보행에 불편한 장소에 대한 피드백 저장
  - 행정 활용 가능성: 축적된 피드백 데이터를 동대문구청 등 행정기관에 제공하여, 실제 보행 환경 개선 자료로 활용될 수 있음

<br>

## 아키텍처

<img width="538" height="352" alt="Image" src="https://github.com/user-attachments/assets/8ae97d4b-4e69-43e6-b9cf-6af008ef4a78" />

<br>

 ## 주요 설계

  🔹 JWT 기반 인증 구조
   - 목적: 카카오 로그인 이후 stateless 구조를 유지하고, 서버 확장 시에도 인증 일관성을 보장하기 위해 JWT 기반 인증 방식을 사용
   - 구성: 클라이언트가 카카오 로그인 성공시 JWT 생성하여 전달하여 API 요청시 JWT를 헤더에 포함해 인증/인가 처리, 토큰 유효성 검증 및 사용자 권한 확인 후 자원 접근 허용.

  🔹 WebClient 기반 AI 연동
   - 목적: Gemini API와 식물 인식 모델 호출 시 비동기 처리를 지원하고, 안정적인 응답 파싱 및 확장성을 확보하기 위함
   - 구성: 클라이언트로부터 사진 업로드 및 미션 요청 수신하면 서버에서 WebClient를 통해 AI 모델 API 호출하여 응답을 전달

  🔹 GCP Storage를 이용한 이미지 관리
   - 목적: 서버의 부담을 줄이고, 이미지 파일의 확장성과 관리 효율성을 높이기 위해 외부 스토리지로 사용
   - 구성: 클라이언트가 이미지를 요청하면, 서버는 GCP Storage에 이미지를 업로드하고 해당 파일에 접근할 수 있는 URL을 데이터베이스에 저장.

<br>

## 발표 자료
<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/e45c9fb7-bfe6-4d7e-bc92-78aff9bf0cc9" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/4023e815-1861-44f6-8ac2-02a7c1a73504" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/81774505-8efe-4089-8cca-5c3c87357f04" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/ce25ab25-2414-47af-b663-5ba857a43f58" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/096dbc62-d7e2-4178-8434-5f06390d3098" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/55c8ac88-29cf-4c7b-b225-6d60cda337e1" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/27884ffc-2244-47ff-82a4-44870a0f284f" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/a1e126cd-6569-4727-9ca0-dcc2dc523a0b" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/30f67907-cc75-4a88-a172-f5b3d13a43d1" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/ef18117c-c305-48e6-bbb6-046a267fb55c" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/030a517c-944b-46d7-ace1-37123fc82cd9" />

<img width="1479" height="831" alt="Image" src="https://github.com/user-attachments/assets/c35de9f9-d94a-4a8d-b01d-3596029206e8" />
