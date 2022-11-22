# 

## Model
www.msaez.io/#/storming/uT0urnTrObfzOFwiMgyh3COs8u93/bbb837afb7c1adb2559ab085491ddeea

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- order
- store
- delivery
- payment
- notice


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- order
```
 http :8088/orders orderId="orderId" foodId="foodId" status="status" customerId="customerId" address="address" qty="qty" options="options" 
```
- store
```
 http :8088/foods foodId="foodId" orderId="orderId" status="status" customerId="customerId" address="address" qty="qty" options="options" 
 http :8088/menus menuId="menuId" menuNm="menuNm" 
```
- delivery
```
 http :8088/deliveries riderId="riderId" customerId="customerId" address="address" foodId="foodId" qty="qty" options="options" status="status" 
```
- payment
```
 http :8088/paymentinformations payId="payId" orderId="orderId" customerId="customerId" 
```
- notice
```
 http :8088/noticeInfos noticeId="noticeId" customerId="customerId" messageTypeCd="messageTypeCd" message="message" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

