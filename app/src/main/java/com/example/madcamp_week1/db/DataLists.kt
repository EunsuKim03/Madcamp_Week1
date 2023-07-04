package com.example.madcamp_week1.db

import com.example.madcamp_week1.db.contactRoom.ContactEntity
import java.time.LocalDate
import java.time.Month

//var ContactList : ArrayList<ContactEntity> = arrayListOf(
//    ContactEntity("AAA", "010-1111-1111"),
//    ContactData("BBB", "010-1111-2222"),
//    ContactData("CCC", "010-1111-3333"),
//    ContactData("DDD", "010-1111-4444"),
//    ContactData("EEE", "010-1111-5555"),
//    ContactData("FFF", "010-1111-6666"),
//    ContactData("GGG", "010-1111-7777"),
//    ContactData("HHH", "010-1111-8888"),
//    ContactData("III", "010-1111-9999"),
//    ContactData("JJJ", "010-1111-0000"),
//    ContactData("KKK", "010-2222-2222"),
//    ContactData("LLL", "010-2222-3333"),
//    ContactData("MMM", "010-2222-4444"),
//    ContactData("NNN", "010-2222-5555"),
//    ContactData("OOO", "010-2222-6666"),
//    ContactData("PPP", "010-2222-7777"),
//    ContactData("QQQ", "010-2222-8888"),
//    ContactData("RRR", "010-2222-9999"),
//    ContactData("SSS", "010-2222-0000")
//)

//var RestaurantList : ArrayList<RestaurantData> = arrayListOf(
//    RestaurantData("잇마이타이", "photo_eatmythai", "042-335-5466", "대전 유성구 어은로58번길 62 1층 잇마이타이"),
//    RestaurantData("훌랄라참숯바베큐치킨", "photo_hoolala", "042-863-5577", "대전 유성구 어은로48번길 9-9"),
//    RestaurantData("맑음", "photo_malgm", "042-861-0244", "대전 유성구 어은로42번길 27"),
//    RestaurantData("처갓집양념치킨", "photo_cheogajip", "042-861-9255", "대전 유성구 어은로48번길 9-5"),
//    RestaurantData("엉클부대찌개", "photo_uncleboodae", "042-867-0102", "대전 유성구 어은로48번길 26"),
//    RestaurantData("아소부", "photo_asobu", "042-825-2995", "대전 유성구 어은로48번길 14"),
//    RestaurantData("하레", "photo_hare", "070-8126-4139", "대전 유성구 어은로48번길 12 2층"),
//    RestaurantData("어은스시", "photo_eounsushi", "042-863-5306", "대전 유성구 어은로48번길 9-11"),
//    RestaurantData("연취", "photo_yeonchui", "042-825-6239", "대전 유성구 대학로163번길 31 1층"),
//    RestaurantData("초원돌구이", "photo_chowon", "0507-1490-3395", "대전 유성구 대학로145번길 21"),
//    RestaurantData("궁칼국수", "photo_gungkal", "042-861-1551", "대전 유성구 어은로58번길 9-13 2층"),
//    RestaurantData("경성양꼬치", "photo_kyeongsung", "042-825-1999", "대전 유성구 궁동 406-18"),
//    RestaurantData("오모이데", "photo_omoidae", "042-824-9046", "대전 유성구 대학로163번길 407-8"),
//    RestaurantData("내가찜한닭", "photo_naejjimdak", "042-823-1238", "대전 유성구 궁동 410-6"),
//    RestaurantData("청년다방", "photo_chungnyeon", "042-824-2338", "대전 유성구 궁동 399-8"),
//    RestaurantData("대학생치킨", "photo_daehaksaeng", "042-825-9993", "대전 유성구 어은로52번길 15 1F"),
//    RestaurantData("폼프리츠", "photo_fompriz", "042-862-3678", "대전 유성구 어은동 112-9"),
//    RestaurantData("오늘은파스타", "photo_today_pasta", "042-826-0198", "대전 유성구 궁동 412-14"),
//    RestaurantData("핵밥", "photo_haekbob", "042-867-9731", "대전 유성구 어은로57번길 41 채움빌 101호"),
//    RestaurantData("한마음정육식당", "photo_han_ma_eum", "042-867-2292", "대전 유성구 어은동 115-1"),
//    RestaurantData("정통집", "photo_jungtongjip", "042-823-9289", "대전 유성구 궁동 410-8"),
//)

//var ReservationList : ArrayList<ReservationData> = arrayListOf(
//    ReservationData(RestaurantList[0],  arrayListOf(ContactList[0], ContactList[2]), "2023/06/30"),
//    ReservationData(RestaurantList[3],  arrayListOf(ContactList[2], ContactList[9]), "2023/06/30"),
//    ReservationData(RestaurantList[5],  arrayListOf(ContactList[13]), "2023/07/15"),
//    ReservationData(RestaurantList[2],  arrayListOf(ContactList[5], ContactList[3], ContactList[17]), "2023/08/14"),
//    ReservationData(RestaurantList[9],  arrayListOf(ContactList[8], ContactList[6], ContactList[14]), "2023/07/02"),
//    ReservationData(RestaurantList[11], arrayListOf(ContactList[1]), "2023/07/12"),
//    ReservationData(RestaurantList[13], arrayListOf(ContactList[10]), "2023/07/12"),
//    ReservationData(RestaurantList[10], arrayListOf(ContactList[4]), "2023/07/05"),
//    ReservationData(RestaurantList[19], arrayListOf(ContactList[6]), "2023/07/05"),
//    ReservationData(RestaurantList[7],  arrayListOf(ContactList[1], ContactList[2], ContactList[3], ContactList[4], ContactList[5]), "2023/07/20"),
//    ReservationData(RestaurantList[6],  arrayListOf(ContactList[12]), "2023/07/25"),
//    ReservationData(RestaurantList[18], arrayListOf(ContactList[15]), "2023/08/01"),
//    ReservationData(RestaurantList[20], arrayListOf(ContactList[18]), "2023/08/11"),
//    ReservationData(RestaurantList[4],  arrayListOf(ContactList[7], ContactList[11]), "2023/07/21"),
//    ReservationData(RestaurantList[1],  arrayListOf(ContactList[16]), "2023/07/23")
//)


