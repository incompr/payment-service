# payment-service
spring rest api example

server.port=8081

db:
user postgres
pass 123

operation type
0 - запрос баланса
1 - put money
2 - take money
3 - send money


Ссылки для проверки:
http://localhost:8081/account/getBalance/1
Баланс
Запрос баланса тоже записывается в операции

http://localhost:8081/account/getBalance/3
AccountNotFoundException

http://localhost:8081/account/takeMoney/id=1&amount=99999999999999
NotEnoughMoneyException

http://localhost:8081/account/takeMoney/id=1&amount=9
takeMoney Success
http://localhost:8081/account/takeMoney/id=2&amount=99999999999999
takeMoney NotEnough money

http://localhost:8081/account/takeMoney/id=3&amount=9
AccountNotFoundException

http://localhost:8081/account/putMoney/id=1&amount=5
putMoney

http://localhost:8081/operation/getOperationList
http://localhost:8081/operation/getOperationList/1
Все операции, Список операций по id

http://localhost:8081/operation/sendMoney/senderId=1&recipientId=2&amount=5
перевод денег

http://localhost:8081/operation/sendMoney/senderId=1&recipientId=2&amount=999999999
NotEnoughMoneyException

http://localhost:8081/operation/sendMoney/senderId=1&recipientId=3&amount=999999999
AccountNotFoundException

http://localhost:8081/operation/getOperationList/id=2&timestamp=1681594950
http://localhost:8081/operation/getOperationList/id=2&timestamp=2023-04-16T00:41:30+01:00[Europe/Paris]
 не работает

