Madcamp_Week1
================
팀원: [김은수](https://github.com/EunsuKim03), [유석원](https://github.com/cactus-y)    

몰입캠프 1주차 공통 프로젝트 

**Tab1: 연락처 탭**
--------------
> **MainActivity**: 연락처를 이미지, 이름, 전화 번호 3가지 요소로 화면에 RecyclerView형태로 표시.
> - 각 연락처 터치: 해당 연락처의 DetailPage가 실행됨.
> - 연락처 추가 버튼: 우측 상단 Toolbar에 위치하며 터치시 ContactAddPage가 실행됨.
> - 최초 실행시 아무 연락처가 없으며 연락처 추가 버튼를 통해 연락처를 사용자가 입력해서 추가해야 함.
>   
> **DetailPage**: 조금 더 큰 사진과 나머지 정보를 표시함.
> - 전화 번호 터치: 전화 앱으로 해당 전화 번호가 입력되어 연결됨.
> - 연락처 삭제 버튼: 우측 상단 Toolbar에 위치, 터치시 해당 연락처를 삭제하며, MainActivity로 돌아감. (DeleteBehavior)
> 
> **ContactAddPage**: 이미지 추가, 연락처 이름 입력, 전화 번호 입력란.
> - 이미지 추가: 기본 갤러리 그림(ImageView) 터치시 휴대폰 갤러리와 연결되어 이미지 하나를 선택함.
> - 이름 입력: EditText로 키보드로 입력 가능.
> - 전화번호 입력: EditText로 키보드로 입력 가능.
> - Done 버튼: 모든 연락처 요소 입력시 색깔이 바뀌고 터치가 활성화 됨. 터치 시 연락처를 저장하고, MainActivity로 돌아감.
   
**Tab2: 갤러리 탭**
--------------
> **MainActivity**: 실제 식당의 음식 사진, 이름, 주소, 전화 번호를 관리. 화면에 사진이 3열의 RecyclerView형태로 표시됨
> - 각 사진 터치: 해당 식당의 DetailPage가 실행됨.
> - 사진 추가 버튼: 우측 상단 Toolbar에 위치하며 터치시 GalleryAddPage가 실행됨.
> - 최초 실행시 아무 사진이 없으며 사진 추가 버튼을 통해 식당 정보를 사용자가 입력해서 추가해야 함.
>   
> **DetailPage***: 사진 원본 및 나머지 식당 정보를 표시함.
> - 주소 터치: 해당 주소와 식당 이름을 매개변수로 MapPage를 실행함.
> - 전화 번호 터치: 전화 앱으로 해당 전화 번호가 입력되어 연결됨.
> - 사진 삭제 버튼: 우측 상단 Toolbar에 위치하며 터치 시, 해당 식당 정보를 삭제하고 MainActivity로 돌아감.
>   
> **MapPage**: 카카오맵 Api를 이용하여 MapView형태로 한 화면 전체에 해당 주소의 위치를 보여줌.
> - MapBehavior를 바탕으로 해당 식당의 위도 경도 좌표를 검색하며 이를 지도로 보여줌.
> - 인터넷 연결이 있어야 작동함.
>
> **GalleryAddPage**: 이미지 추가, 연락처 이름 입력, 주소 입력란, 전화 번호 입력란.
> - 이미지 추가: 기본 갤러리 그림(ImageView) 터치시 휴대폰 갤러리와 연결되어 이미지 하나를 선택함.
> - 이름 입력: EditText로 키보드로 입력 가능.
> - 주소 입력: EditText로 키보드로 입력 가능.
> - 전화번호 입력: EditText로 키보드로 입력 가능.
> - Done 버튼: 모든 연락처 요소 입력시 색깔이 바뀌고 터치가 활성화 됨. 터치 시 식당 정보를 저장하고, MainActivity로 돌아감.

**Tab3: 자유 주제**
------------




.   
.   
.   
.   
.   

개발 노트
-----------

Day1
-----

Kotlin 문법 공부 및 xml 코드 이해
Gallery Recycler View 구현 시도

Day2
------

Gallery Recycler View 구현:
> ListItem 하나에 3개의 사진이 들어가도록 했으며 이를 나타내는 class: Photo3를 만듦   
> Photo3 class를 이용하여 GalleryListAdapter 구현   
> 
  
  
Day3
-----

