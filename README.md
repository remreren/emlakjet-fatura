## Fatura Projesi [Satın Alma Uzmanları İçin]
### Gereksinimler
* Java 11+ yüklü olmalı.
* Maven yüklü olmalı.
#### Opsiyonel:
* Docker.
### Projenin Çalıştırılması
#### 1. Yöntem: Paket Oluşturduktan Sonra Çalıştırmak
Programımızın çalıştırılması için öncelikle uygulamayı maven kullanarak build etmeliyiz.
```bash
mvn install
```
Uygulamamız build edildikten sonra ise başlatmalı ya da Docker kullanarak ayağa kaldırmalıyız.

Uygulamayı başlatmak isterseniz;
```bash
java -jar ./target/fatura.jar
```
şeklinde uygulamayı başlatabilirsiniz ya da aşağıdaki komutu kullanarak Docker görüntüsü oluşturup daha sonra başlatabilirsiniz.
```bash
docker build . --file Dockerfile --tag [isim]
docker run -d -p 8080:8080 [isim]
```
#### 2. Yöntem: Maven ve Spring-Boot Yardımıyla Çalıştırmak
Yukarıdaki yönteme alternatif olarak uygulamanızı tek komutla lokalde çalıştırmak isterseniz aşağıdaki komut işinizi görecektir.
```bash
mvn spring-boot:run
```