## VeterinaryManagementSystem
Bu proje, katmanlı bir mimariyi takip eden, IoC ve DI kullanımı ile constructor injection'ı benimseyen, PostgreSQL ve MySQL veritabanları ile entegrasyon içeren bir Java Spring Boot uygulamasının demonstrasyonudur. Proje, entityler için CRUD operasyonlarını, istisna yönetimini ve API dokümantasyonunu içermektedir.

## Kullanılan Teknolojiler
Spring Boot
Spring Data JPA
PostgreSQL
MySQL
## Proje Yapısı
Proje, endişelerin açık bir şekilde ayrıldığı katmanlı bir mimariyi takip eder. Ana bileşenler şunlardır:

Controller Katmanı: HTTP isteklerini ele alır, girişleri doğrular ve servis katmanına iletilir.

Servis Katmanı: İş mantığını içerir, repository ile etkileşimde bulunur ve işlemleri uygular.

Repository Katmanı: Veritabanı işlemleri ve entity etkileşimleri için sorumludur.

Entity Sınıfları: Veri modelini temsil eder ve entityler arasındaki ilişkileri tanımlar.

DTO (Veri Transfer Objesi): Katmanlar arası iletişimde ve istek-cevap formatını şekillendirmekte kullanılır.

## Veritabanı Konfigürasyonu
Proje, hem PostgreSQL hem de MySQL veritabanlarını destekler.
