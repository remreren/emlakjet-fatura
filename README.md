## Fatura Projesi [Satın Alma Uzmanları İçin]
### Gereksinimler
* Java 11+ yüklü olmalı.
* Maven yüklü olmalı.
#### Opsiyonel:
* Docker.
* Graalvm JDK 11+
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

### Projenin native image alınarak çalıştırılması.
Öncelikle bilgisayarınızda GraalVM ve Docker yüklü olup çevre değişkenlerinin ayarlanmış olması gerekmektedir.
Daha sonra aşağıdaki komutu çalıştırarak native image alıyoruz. Bu işlem biraz uzun sürebilir.
```bash
mvn clean spring-boot:build-image
```
Bu işlem tamamlandıktan sonra komut satırı üzerinden aşağıdaki komutu vererek oluşturulan görüntüyü listede görebilirsiniz.
```bash
docker images
```
Bu komutu girdikten sonra karşımıza fatura isimli bir repository çıkması gerekir.
Ardından uygulamamızın versiyonuna göre aşağıdaki komutu giriyoruz. Şuanki versiyon 1.0'dır.
```bash
docker run -d -p 8080:8080 fatura:[versiyon] --name [isim]
```
Tebrikler! Artık native görüntü kullanarak oluşturduğunuz konteyneriniz ayakta.