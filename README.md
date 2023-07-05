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
> **DetailPage**: 사진 원본 및 나머지 식당 정보를 표시함.
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
> **MainActivity**: Recyclerview 안에 날짜 별 약속들이 CardView 형태로 들어있음.
> - CardView들은 날짜 순으로 정렬되어 있음.
> - CardView를 클릭하면 접힌 것이 열리면서 해당 날짜에 있는 약속 목록이 보임.
> - 약속 목록에서는 식당 사진의 썸네일과 식당 이름, 일행의 이름들이 보인다. 
> - 일행이 네 명 이상일 경우, 두 명까지만 표시하고 나머지는 외 n - 2 명으로 표현된다.
> - 약속 item을 하나 클릭하면 DetailPage가 실행 됨.
> - 최초 실행 시 아무 약속이 없고 우상단의 추가 버튼을 눌러 ReservationAddPage로 넘어가 연락처와 갈 식당을 선택해서 추가해야 함.
> 
> **DetailPage**: 식당의 사진과 식당의 정보 (이름, 위치, 전화번호)를 보여주고 같이 가는 일행의 목록이 recyclerview에 들어있음.
> - 지도 버튼을 클릭하면 Gallery의 DetailPage와 같은 방식으로 지도를 띄운다.
> - 식당의 전화 버튼을 클릭하면 Contact의 DetailPage와 같이 전화 앱으로 넘어감.
> - 일행의 목록은 Contact의 MainActivity와 같은 방식으로 보여주고, 클릭하면 Contact의 DetailPage로 넘어간다.
> - 우상단의 삭제 버튼을 누르면 삭제하고 다시 Reservation의 MainActivity로 돌아오게 된다.
> 
> **ReservationAddPage**: 날짜, 식당, 같이 갈 일행을 고르는 화면이 나옴
> - 식당과 일행을 고르지 않으면 reservation을 만들 수 없음 (날짜는 기본적으로 현재 날짜를 default 값으로 가짐)
> - 캘린더를 조작하는 것으로 약속 날짜를 정할 수 있음.
> - 식당 선택과 일행 선택은 AlertDialogue를 통해 선택창이 나옴.
> - EditText의 restaurant를 누르면 현재 Gallery에 등록해둔 식당의 목록이 나옴 (하나만 선택 가능. radiobutton)
> - Add friends 버튼을 누르면 일행을 추가 할 수 있음 (여러 명 선택 가능. checkbox)
> - Dialogue에서 일행을 다 고르면 아래에 같이 가는 일행의 이름들이 TextView로 표현 됨.
> - 식당과 일행이 비어있지 않다면 Done 버튼이 파란색으로 활성화 되고 reservation을 추가 할 수 있음.

