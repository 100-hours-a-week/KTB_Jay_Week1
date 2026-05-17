# [KTB4 1주차 Jay 과제]

---

## 주제: 배달 CLI 프로그램을 간단하게 만들어보자.

생각해야될 사용자 flow

> 1. 회원가입  
> 2. 로그인  
> 3. 주문
> 4. 주문 시에 주문 수에 따른 등급 결정
> 5. 등급에 따른 할인율 적용
> 6. 주문 완료
## 1. Domain - 어떤 객체가 필요할까
1. User: 사용자의 정보를 담고 있음  
1-1. 사용자의 등급을 세분화한 enum 클래스
2. Item: 상품의 정보를 담고 있음
3. Order: 주문 번호부터 시작해서 주문과 관련된 모든 정보를 담고 있음
4. DiscountPolicy: abstract 메서드를 이용하여 상속을 활용해 등급별 할인 적용 정보 넣기

## 2. Service - 실제 로직을 어떻게 처리할까
Domain에 실제 객체가 담긴다면 Service에서는 실제 로직을 처리하는 코드를 담았습니다.   
먼저 UserService에는 회원가입과 로그인  
OrderService에는 주문과 주문 칸을 눌렀을 때 상품을 보여주는 함수  
ItemService에서는 repository와의 연결을 해주었습니다.

## 3. Controller - view에서 요청한 것을 서비스까지 연결
Controller는 직접적인 로직처리가 아닌 view에서 요청한 작업을 서비스에게 시키는 역할입니다.  
마치 안내 데스크라고 생각했습니다. 그 안에 service는 주방장인 것처럼 말이죠.  
총 두가지 컨트롤러를 구현하였고 order, user 컨트롤러를 구현하였습니다.

## 4. View -  사용자에게 보여지는 화면 
사용자는 먼저 회원가입, 로그인 부터 확인하게 됩니다.  
로그인에 성공하게 되면 그 다음 주문 view로 넘어가죠

## - 실제 work flow
사용자가 프로그램을 실행하면  
<img width="352" height="120" alt="Image" src="https://github.com/user-attachments/assets/88eae335-5079-4d7f-8a96-2472c88e6f8c" />  
다음 화면이 나오게 됩니다.

### 로그인  

만약 로그인이 되어있지 않다면(csv 파일에 저장하기 때문에 껐다가 다시켜도 정보는 저장되어 있습니다.)  
회원가입을 통해 회원가입을 하면 됩니다.  

만약 회원가입이 되어있다면
<img width="340" height="116" alt="Image" src="https://github.com/user-attachments/assets/52536b4f-18a2-415d-8251-080a2fdb15cb" />  
다음 화면이 나오면서 초기로 돌아가게 됩니다.  

로그인에 성공하게 되면
<img width="438" height="160" alt="Image" src="https://github.com/user-attachments/assets/ebdda79f-e351-40c2-996f-f49e47c97929" />  
다음 화면과 함께 로그인할 준비가 완료됩니다.  

### 주문

회원가입이 완료되면 각각 10000원의 금액이 주어집니다.  
<img width="328" height="70" alt="Image" src="https://github.com/user-attachments/assets/6f4c9319-fbad-4572-8530-2d9e9b0db6cc" />  

다음 화면에서 1번을 누르고 주문에 들어가게 되면  
<img width="378" height="380" alt="Image" src="https://github.com/user-attachments/assets/7c28b0cf-f22c-4cab-b174-c536909c8bf1" />  

상품 목록과 함께 상품 id를 입력할 수 있는 칸이 나옵니다.

만약 상품번호에 없는 번호를 입력하면  
<img width="308" height="71" alt="Image" src="https://github.com/user-attachments/assets/2ca0f64f-f753-4777-8671-51d023df4d82" />  

상품이 존재하지 않는다는 말이 나오고  

자신이 가진 금액보다 큰 상품을 주문하면  
<img width="376" height="125" alt="Image" src="https://github.com/user-attachments/assets/3e0eb306-1655-4e26-9b64-e6f0fc6fde82" />  

잔액 부족 표시가 나옵니다.  

성공적으로 구매를 완료하게 되면  
<img width="328" height="72" alt="Image" src="https://github.com/user-attachments/assets/15e4b46f-1ea1-4f53-b7fa-0b79f37bf0a2" />  

주문완료와 함께 결제 금액까지 나오게 됩니다.

## 추후 수정해볼만한 포인트
1. 현재 내가 가지고 있는 금액을 표시할 수 있는 칸 만들기
2. 돈을 벌 수 있는 방법 만들어보기
3. 판매자 입장에서 상품을 올릴 수 있는 판매자 칸을 따로 만들기 
4. vip별 쿠폰을 지급하여 구매할 때 사용해볼 수 있게 하기
5. 배달을 활성화 시켜 배달까지 상태를 enum 클래스로 설정하고 배달 상태에 따른 배달까지의 소요시간도 표시해보기
6. 실제 시간과 연동시켜서 재미를 올려보기

## [회고 URL](https://www.notion.so/CLI-3617bf5f5a85802d8b88f714b923ff3b?source=copy_link)

