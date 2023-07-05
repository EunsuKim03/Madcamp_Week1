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

Trouble Shooting
=================

연락처/식당 데이터 삭제 관리 (DeleteBehavior)
----------------------------------------------
> Tab3의 예약 정보는 Tab1과 Tab2의 연락처, 식당 데이터와 연관되어 있다.   
> 따라서 각각의 데이터베이스 내의 존재 여부는 각 데이터에 영향을 줄 수 있다.   
> 예를 들어, 예약 정보가 7월 6일에 식당 X에 사람 A, B의 예약이 있는 상황에서,   
> - Tab1에서 사람 A 또는 B를 삭제 한다면? Tab2에서 식당 X를 삭제한다면?
>   
> 구현 방식에 따라 Nullpointer로 문제가 생기거나, 원하는 동작이 되지 않을 수 있다.   
> 이를 방지하기 위해 아래와 같이 삭제 동작을 정의하였다.   
<pre><code>Delete contact: cid
	-> Walk Reservation 
		-> If a reservation has cid in friends list 
			-> Delete it from friends list
				-> After delete, if the friends list becomes empty
					-> Delete that reservation
	-> Delete contact

Delete restaurant: rtid
	-> Walk Reservation
		-> If a reservation's restaurant.rtid == rtid
			-> Delete that rerservation
	-> Delete restaurant

Delete reservation: rsid
	-> Delete reservation
</code></pre>

이미지 권한 문제
------------------
> 이미지 표시하기 위해 Glide를 사용하였으며, Local 저장소에서 Uri를 가져와서 출력하도록 하였다.   
> Android 버전에 따라 SDK33 이상에서는 READ_MEDIA_IMAGES, 33 미만에서는 READ_EXTERNAL_STORAGE 권한을   
> 정상적으로 설정하고도 다음과 같은 문제가 발생했다.   
> - AddPage에서 연락처 사진을 추가 -> MainFragment에서 정상적으로 이미지가 출력됨 -> DetailPage에서 이미지가 표시되지 않음   
>   
> Logcat를 확인한 결과, 권한을 설정하지 않은 문제로 발생하는 Exception과 조금 다른 Exception이 발생하는 것을 발견했으며,   
> 구글링하여 다음을 발견:   
> - 로컬 요소의 Uri마다 권한이 존재하며, 권한을 가지고 있지 않은 activity에서 접근 시 이를 막는다.
>
> 이를 해결하기 위해 아래의 방법을 시도함. (작동 방식을 확실하게는 모르겠음)
<pre><code>applicationContext.grantUriPermission(applicationContext.packageName, ///URI///, Intent.FLAG_GRANT_READ_URI_PERMISSION)
</code></pre>
> 위 함수는 두 번째 매개 변수인 Uri에 대한 권환을 첫 번째  argument에게 넘겨준다.   
> - 이 때, 첫 번째 인자에 이 application의 pakageName을 넣어주면,   
> - application의 모든 activity에서 해당 Uri에 접근이 가능할 것으로 생각함.   
> 다행히 해당 함수 추가 이후에 이미지 uri 접근이 deny되는 문제는 사라짐.   
>

Android Room(DB) 문제 
--------------------
> 내부저장소에 데이터를 저장하는 방식으로는 Android Room을 사용 했음.
> 다른 관계형 DB처럼 table을 만들고 쿼리 문을 함수로 만들어 데이터를 접근하는 방식임.
> 처음 써보는 방식이라 여러 문제가 있었음.
> 
> Android Room의 entity에는 기본적으로 Primitive type만 허용하며, ArrayList는 허용되지 않음.
> Reservation의 경우 Restaurant과 Contact의 data를 가져와야 하기 때문에 테이블이 생각보다 복잡해짐.
> 
> 처음에 Contact를 ArrayList로 저장했다가 빌드 에러가 나서 List로 고쳐 줌.
> List로 넘기는 경우, putExtra로 넘길 수 없기 때문에 (putExtra는 primitive나 serializable한 데이터만 허용 함) json도 활용 함.
> ContactEntity 객체의 리스트를 gson 라이브러리를 활용해 json string 으로 넘겨 준 뒤, 받는 activity에서 다시 파싱해서 정보를 받아오는 식으로 처리 했음.
> 
> 또한 app.gradle 설정이 복잡해 처음에는 블로그 등을 참고해 의존성을 추가하다가 빌드 에러가 생겨 공식 문서를 참고해서 해결 했음.
> 
> 우리 프로그램은 특성상 동시에 DB의 데이터를 처리 할 일은 없기 때문에 처음에는 메인 스레드로 처리 하려 했음.
> 그러나 Android Room은 main thread에서 사용하면 lock 될 위험이 있기 때문에 허용 되지 않음.
> 따라서 coroutine을 사용해서 해결 함 (비동기적으로 처리 함)
> 그냥 coroutine 함수를 실행하면 에러가 생겨서 runBlocking을 통해 다시 동기적으로 처리해주었음.


Recyclerview 안뜨던 버그
------------------------
> ReservationDetailPage에서 식당 사진이 나오고, 식당 정보들을 TextView로 보여준 다음 일행들을 recyclerview로 화면에 표현하려 함.
> 문제는 실행하면 어떤 reservation에서는 사진만 나오고, 어떤 reservation은 사진과 정보까지는 나오는 등 제각각이였음.
> 공통적으로 recyclerview는 나오지 않았음.
> 
> 식당 정보가 잘리는 것은 식당 사진의 크기가 제각각이라 잘리는 것이였음.
> 사진의 크기를 고정사이즈로 제한을 두는 것으로 해결함.
> 
> Recyclerview를 보이게 하기 위해 전체 레이아웃을 ScrollView로 감싼 뒤, LinearLayout으로 한 번 감싸고, 그 안에 식당 사진과 정보를 넣음. 그 다음 RelativeLayout을 만들고 그 안에 RecyclerView를 넣는 것으로 문제를 해결 할 수 있었음.
> Recyclerview의 특성 때문에 화면에 나오지 않았던 것 같음.
