# payment-service
spring rest api example

server.port=8081

db:
user postgres
pass 123


Ссылки для проверки:
http://localhost:8081/account/getBalance/1
Баланс

http://localhost:8081/account/getBalance/3
AccountNotFoundException

http://localhost:8081/account/takeMoney/id=1&amount=99999999999999
NotEnoughMoneyException

http://localhost:8081/account/takeMoney/id=1&amount=9
Success

http://localhost:8081/account/takeMoney/id=3&amount=9
AccountNotFoundException

http://localhost:8081/operation/getOperationList/1
Список операций по id, все операции

http://localhost:8081/operation/sendMoney/senderId=1&recipientId=2&amount=5
перевод денег

http://localhost:8081/operation/sendMoney/senderId=1&recipientId=2&amount=999999999
NotEnoughMoneyException

http://localhost:8081/operation/sendMoney/senderId=1&recipientId=3&amount=999999999
AccountNotFoundException

http://localhost:8081/operation/getOperationList/id=2&timestamp=1681594950
не работает

Запрос баланса тоже записывается в операции
