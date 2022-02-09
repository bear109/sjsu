## app/manifests/AndroidManifests.xml

```
<activity android:name=".purchase_detail"
            android:parentActivityName=".JointPurchase"/>
        <activity android:name=".noticeBoard" />
        <activity android:name=".detailImportantNotice" />
        <activity android:name=".detailNotice1" />
```
## app/java/com.example.sjsu

### 공동구매
- JointPurchase(공동구매 메인화면)
- purchase_detail(공동구매 상세화면)
- articleItem(공동구매 그리드뷰 출력을 위한 클래스)
- articleViewer(공동구매 그리드뷰 출력을 위한 클래스)

### 공지사항
- noticeBoard(공지사항 메인화면)
- detailImportantNotice(중요 공지사항 클래스)
- detailNotice1(공지사항1 클래스)

## app/res/drawble
- **border_radius.xml / button.xml / joinbtn.png** -> 버튼 이미지 파일
- **image1~5.png** -> 공동구매 메인화면 이미지
- **detail1~6.png / green.png**  -> 공동구매 상세화면 리스트 이미지
- **importantnotice.png / notice1~6.png** -> 공지사항 메인화면 이미지
- **detail_important_notice.png / detail_notice1.png** -> 공지사항 상세화면 이미지


## app/res/font
- homenaje.xml   -> 제목 폰트
- noto_sans.xml  -> 그 외에 다른 폰트
- noto_sans_bold.xml

## app/res/layout

### 공동구매
- joint_purchase.xml -> 공동구매 메인화면
- purchase_detail.xml -> 공동구매 상세화면
- article.xml -> 공동구매 그리드뷰
- dialog.xml -> 공동구매 팝업창

### 공지사항
- notice_board.xml -> 공지사항 메인화면
- detail_important_notice.xml -> 중요공지사항 화면
- detail_notice1.xml -> 공지사항1 화면
