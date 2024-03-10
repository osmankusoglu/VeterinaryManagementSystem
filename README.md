## Veteriner Yönetim Sistemi
Bu proje, katmanlı bir mimariyi takip eden, IoC ve DI kullanımı ile constructor injection'ı benimseyen, PostgreSQL  veritabanı ile entegrasyon içeren bir Java Spring Boot uygulamasının demonstrasyonudur. Proje, entityler için CRUD operasyonlarını, istisna yönetimini ve API dokümantasyonunu içermektedir.

## Kullanılan Teknolojiler
Spring Boot
Spring Data JPA
PostgreSQL
## Proje Yapısı
Proje, endişelerin açık bir şekilde ayrıldığı katmanlı bir mimariyi takip eder. Ana bileşenler şunlardır:

Controller Katmanı: HTTP isteklerini ele alır, girişleri doğrular ve servis katmanına iletilir.

Servis Katmanı: İş mantığını içerir, repository ile etkileşimde bulunur ve işlemleri uygular.

Repository Katmanı: Veritabanı işlemleri ve entity etkileşimleri için sorumludur.

Entity Sınıfları: Veri modelini temsil eder ve entityler arasındaki ilişkileri tanımlar.

DTO (Veri Transfer Objesi): Katmanlar arası iletişimde ve istek-cevap formatını şekillendirmekte kullanılır.

## Veritabanı Konfigürasyonu
Proje, hem PostgreSQL hem de MySQL veritabanlarını destekler.

## Endpoint Yönetimi
**1. Müşterileri Listeleme**
 URL: /v1/customers  
 Method: GET  
 Isımlendirme: cursor  
 Açıklama: Sistemde kayıtlı tüm müşterileri listeler.  
 Parametreler:  
 page: Sayfa numarası (Varsayılan: 0  
 pageSize: Sayfa boyutu (Varsayılan: 5)  
 name: Girilen müşteri adı  

Örnek Kullanım:  
GET http://localhost:8080/v1/customers?page=0&pageSize=5 - Sistemde kayıtlı tüm müşterileri listeler.  
GET http://localhost:8080/v1/customers?page=0&pageSize=10&name=John Doe - Hayvan sahipleri isme göre filtreler (Question 11)  

**2. Belirli Bir Müşteriyi Getirme**  
URL: /v1/customers/{id}  
Method: GET  
Isımlendirme: get  
Açıklama: Belirli bir müşterinin detaylarını getirir.  
Parametreler:  
id: Müşterinin girilen id'si  

Örnek Kullanım:  
GET http://localhost:8080/v1/customers/1  

**3. Yeni Müşteri Ekleme**   
URL: /v1/customers  
Method: POST  
Isımlendirme: save  
Açıklama: Yeni bir müşteri ekler.  
Parametreler:  
name: Müşterinin adı  
phone: Müşterinin telefon numarası  
mail: Müşterinin e-posta adresi  
address: Müşterinin adresi  
city: Müşterinin şehri  

Örnek Kullanım:  
POST http://localhost:8080/v1/customers -  Proje isterlerine göre hayvan sahibi kaydediliyor (Question 10)  

**4. Müşteri Güncelleme**  
URL: /v1/customers  
Method: PUT  
Isımlendirme: update  
Açıklama: Belirli bir müşterinin bilgilerini günceller.  
Parametreler:  
id: Müşterinin girilen id'si  
Diğer parametreler: Güncellenecek müşteri bilgileri  

Örnek Kullanım:  
PUT http://localhost:8080/v1/customers  

**5. Müşteri Silme**  
URL: /v1/customers/{id}  
Method: DELETE  
Isımlendirme: delete  
Açıklama: Belirli bir müşteriyi sistemden siler.  
Parametreler:  
id: Müşterinin girilen id'si  

Örnek Kullanım:  
DELETE http://localhost:8080/v1/customers/1  

**1. Hayvanları Listeleme**  
URL: /v1/animals  
Method: GET  
Isımlendirme: cursor  
Açıklama: Sistemde kayıtlı tüm hayvanları listeler.  
Parametreler:  
page: Sayfa numarası (Varsayılan: 0)  
pageSize: Sayfa boyutu (Varsayılan: 5)  
name: Girilen hayvan adına göre filtreleme  

Örnek Kullanım:  
GET http://localhost:8080/v1/animals?page=0&pageSize=5  - Sistemde kayıtlı tüm müşterileri listeler.  
GET http://localhost:8080/v1/animals?pageSize=100&name=Max  - Hayvanlar isme göre filtreler (Question 13)  

**2. Bir kişiye ait hayvanları görüntüleme işlemi**  
URL: /v1/animals/by-customer  
Method: GET  
Isımlendirme: getByAllCustomerId  
Açıklama: Bir kişiye ait hayvanları görüntüleme işlemi  
Parametreler:  
page: Sayfa numarası (Varsayılan: 0)  
pageSize: Sayfa boyutu (Varsayılan: 5)  
customerId: Girilen müşteri id'si  

Örnek Kullanım:  
GET http://localhost:8080/v1/animals/by-customer?customerId=6&pageSize=3 - Girilen hayvan sahibinin sistemde kayıtlı tüm hayvanlarını görüntüleme (Question 14)  

**3. Belirli Bir Hayvanı Getirme**  
URL: /v1/animals/{id}  
Method: GET  
Isımlendirme: get  
Açıklama: Belirli bir hayvanın detaylarını getirir.  
Parametreler:  
id: Hayvanın girilen id'si  

Örnek Kullanım:  
GET http://localhost:8080/v1/animals/1  

**4. Yeni Hayvan Ekleme**  
URL: /v1/animals  
Method: POST  
Isımlendirme: save  
Açıklama: Yeni bir hayvan ekler.  
Parametreler:  
name: Hayvanın adı  
species: Hayvanın türü  
breed: Hayvanın cinsi  
gender: Hayvanın cinsiyeti  
color: Hayvanın rengi  
dateOfBirth: Hayvanın doğum tarihi (yyyy-MM-dd formatında)  
customerId: Müşterinin girilen id'si  

Örnek Kullanım:  
POST http://localhost:8080/v1/animals - Proje isterlerine göre hayvan kaydediliyor (Question 12)  

**5. Hayvan Güncelleme**  
URL: /v1/animals  
Method: PUT  
Isımlendirme: update  
Açıklama: Belirli bir hayvanın bilgilerini günceller.  
Parametreler:  
id: Hayvanın girilen id'si  
Diğer parametreler: Güncellenecek hayvan bilgileri  

Örnek Kullanım:  
PUT http://localhost:8080/v1/animals  

**6. Hayvan Silme**  
URL: /v1/animals/{id}  
Method: DELETE  
Isımlendirme: delete  
Açıklama: Belirli bir hayvanı sistemden siler.  
Parametreler:  
id: Hayvanın girilen id'si  

Örnek Kullanım:  
DELETE http://localhost:8080/v1/animals/1  

**1. Aşıları Listeleme**  
URL: /v1/vaccines  
Method: GET  
Isımlendirme: cursor  
Açıklama: Sistemde kayıtlı tüm aşıları listeler.  
Parametreler:  
page: Sayfa numarası (Varsayılan: 0)  
pageSize: Sayfa boyutu (Varsayılan: 5)  
startDate: Başlangıç tarihi  
endDate: Bitiş tarihi  

Örnek Kullanım:  
GET http://localhost:8080/v1/vaccines?page=0&pageSize=5 - Sistemde kayıtlı tüm aşıları listeler.  
GET http://localhost:8080/v1/vaccines?pageSize=100&startDate=2022-05-10&endDate=2023-01-01 - Hayvanların aşı kayıtları, girilen tarih aralığına göre doğru şekilde listelenir. (Question 23)  

**2.Bir Hayvana Ait Tüm Aşı Kayıtları Listeleme**  
URL: /v1/vaccines/by-animal  
Method: GET  
Isımlendirme: getByAllAnimalId  
Açıklama: Sistemde kayıtlı tüm aşıları listeler.  
Parametreler:  
page: Sayfa numarası (Varsayılan: 0)  
pageSize: Sayfa boyutu (Varsayılan: 5)  
animalId: Hayvanın girilen id'si  

Örnek Kullanım:  
GET http://localhost:8080/v1/vaccines/by-animal?animalId=13 - Belirli bir hayvana ait tüm aşı kayıtları (sadece bir hayvanın tüm aşı kayıtları) listeler (Question 24)  

**3. Belirli Bir Aşıyı Getirme**  
URL: /v1/vaccines/{id}  
Method: GET  
Isımlendirme: get  
Açıklama: Belirli bir aşının detaylarını getirir.  
Parametreler:  
id: Aşının girilen id'si  

Örnek Kullanım:  
GET http://localhost:8080/v1/vaccines/1  

**4. Yeni Aşı Ekleme**  
URL: /v1/vaccines  
Method: POST  
Isımlendirme: save  
Açıklama: Yeni bir aşı ekler.  
Parametreler:  
name: Aşının adı  
code: Aşının kodu  
protectionStartDate: Aşının koruyuculuk başlangıç tarihi (yyyy-MM-dd formatında)  
protectionFinishDate: Aşının koruyuculuk bitiş tarihi (yyyy-MM-dd formatında)  
animalId : Girilen animalId'si  

Örnek Kullanım:  
POST http://localhost:8080/v1/vaccines -  Proje isterlerine göre hayvana ait aşı kaydediliyor (Question 21)  

**5. Aşı Güncelleme**  
URL: /v1/vaccines  
Method: PUT  
Isımlendirme: update  
Açıklama: Belirli bir aşının bilgilerini günceller.  
Parametreler:  
id: Aşının girilen id'si  
Diğer parametreler: Güncellenecek aşı bilgileri  

Örnek Kullanım:  
PUT http://localhost:8080/v1/vaccines  

**6. Aşı Silme**  
URL: /v1/vaccines/{id}  
Method: DELETE  
Isımlendirme: delete  
Açıklama: Belirli bir aşıyı sistemden siler.  
Parametreler:  
id: Aşının girilen id'si  

Örnek Kullanım:  
DELETE http://localhost:8080/v1/vaccines/1  

**1. Randevuları Listeleme**  
URL: /v1/appointments  
Method: GET  
Isımlendirme: cursor  
Açıklama: Sistemde kayıtlı tüm randevuları listeler.  
Parametreler:  
page: Sayfa numarası (Varsayılan: 0)  
pageSize: Sayfa boyutu (Varsayılan: 5)  

Örnek Kullanım:  
GET http://localhost:8080/v1/appointments?page=0&pageSize=5 - Sistemde kayıtlı tüm randevuları listeler.  

**2. Randevuları tarih aralığına ve hayvana göre filtreleme**  
URL: /v1/appointments/filter-date-and-animal  
Method: GET  
Isımlendirme: getDateAndAnimal  
Açıklama: Sistemde kayıtlı tüm randevuları listeler.  
Parametreler:  
page: Sayfa numarası (Varsayılan: 0)  
pageSize: Sayfa boyutu (Varsayılan: 5)  
startDate: Başlangıç tarihi  
endDate: Bitiş tarihi  
animalId: Hayvanın girilen id'si  

Örnek Kullanım:  
GET http://localhost:8080/v1/appointments/filter-date-and-animal?animalId=10&pageSize=10&startDate=2024-03-12T09:00:00&endDate=2024-04-01T18:00:00 - Randevular kullanıcı tarafından girilen tarih aralığına ve hayvana göre filtrelenir (Question 19)  

**3. Randevuları tarih aralığına ve doktora göre filtreleme**  
URL: /v1/appointments/filter-date-and-doctor  
Method: GET  
Isımlendirme: getDateAndDoctor  
Açıklama: Sistemde kayıtlı tüm randevuları listeler.  
Parametreler:  
page: Sayfa numarası (Varsayılan: 0)  
pageSize: Sayfa boyutu (Varsayılan: 5)  
startDate: Başlangıç tarihi  
endDate: Bitiş tarihi  
doctorId: Doktorun girilen id'si  

Örnek Kullanım:  
GET http://localhost:8080/v1/appointments/filter-date-and-doctor?doctorId=3&pageSize=10&startDate=2024-03-01T10:00:00&endDate=2024-03-30T18:00:00 - Randevular kullanıcı tarafından girilen tarih aralığına ve doktora göre filtrelenir (Question 20)  

**4. Belirli Bir Randevuyu Getirme**  
URL: /v1/appointments/{id}  
Method: GET  
Isımlendirme: get  
Açıklama: Belirli bir randevunun detaylarını getirir.  
Parametreler:  
id: Randevunun girilen id'si  

Örnek Kullanım:  
GET http://localhost:8080/v1/appointments/1  

**3. Yeni Randevu Oluşturma**  
URL: /v1/appointments  
Method: POST  
Isımlendirme: save  
Açıklama: Yeni bir randevu oluşturur.  
Parametreler:
appointmentDate: Randevunun tarihi ve saati (yyyy-MM-ddTHH:mm:ss formatında)  
animalId: Randevu için belirli hayvanın id'si  
doctorId: Randevu için belirli doktorun id'si  

Örnek Kullanım:  
POST http://localhost:8080/v1/appointments - Proje isterlerine göre randevu kaydediliyor (Question 17 )  

**4. Randevu Güncelleme**  
URL: /v1/appointments  
Method: PUT  
Isımlendirme: update  
Açıklama: Belirli bir randevunun bilgilerini günceller.  
Parametreler:  
id: Randevunun girilen id'si  
Diğer parametreler: Güncellenecek randevu bilgileri  

Örnek Kullanım:  
PUT http://localhost:8080/v1/appointments  

**5. Randevu Silme**  
URL: /v1/appointments/{id}  
Method: DELETE  
Isımlendirme: delete  
Açıklama: Belirli bir randevuyu sistemden siler.  
Parametreler:  
id: Randevunun girilen id'si  

Örnek Kullanım:  
DELETE http://localhost:8080/v1/appointments/1  

**1. Doktorları Listeleme**  
URL: /v1/doctors  
Method: GET  
Isımlendirme: cursor  
Açıklama: Sistemde kayıtlı tüm doktorları listeler.  
Parametreler:  
page: Sayfa numarası (Varsayılan: 0)  
pageSize: Sayfa boyutu (Varsayılan: 5)  

Örnek Kullanım:  
GET http://localhost:8080/v1/doctors?page=0&pageSize=5 - Sistemde kayıtlı tüm doktorları listeler.  

**2. Belirli Bir Doktoru Getirme**  
URL: /v1/doctors/{id}  
Method: GET  
Isımlendirme: get  
Açıklama: Belirli bir doktorun detaylarını getirir.  
Parametreler:  
id: Doktorun girilen id'si  

Örnek Kullanım:  
GET "http://localhost:8080/v1/doctors/1"  

**3. Yeni Doktor Ekleme**  
URL: /v1/doctors  
Method: POST  
Isımlendirme: save  
Açıklama: Yeni bir doktor ekler.  
Parametreler:  
name: Doktorun adı  
phone: Doktorun telefon numarası  
mail: Doktorun e-posta adresi  
address: Doktorun adresi  
city: Doktorun şehri  

Örnek Kullanım:  
POST http://localhost:8080/v1/doctors - Proje isterlerine göre doktor kaydetme (Question 15)  

**4. Doktor Güncelleme**  
URL: /v1/doctors  
Method: PUT  
Isımlendirme: update  
Açıklama: Belirli bir doktorun bilgilerini günceller.  
Parametreler:  
id: Doktorun girilen id'si  
Diğer parametreler: Güncellenecek doktor bilgileri  

Örnek Kullanım:  
PUT http://localhost:8080/v1/doctors  

**5. Doktor Silme**  
URL: /v1/doctors/{id}  
Method: DELETE  
Isımlendirme: delete  
Açıklama: Belirli bir doktoru sistemden siler.  
Parametreler:  
id: Doktorun girilen id'si  

Örnek Kullanım:  
DELETE http://localhost:8080/v1/doctors/1  

**1. Doktorun Müsait Günlerini Listeleme**  
URL: /v1/available-dates  
Method: GET  
Isımlendirme: cursor  
Açıklama: Belirli bir doktorun müsait günlerini listeler.  
Parametreler:  
page: Sayfa numarası (Varsayılan: 0)  
pageSize: Sayfa boyutu (Varsayılan: 5)  
  
Örnek Kullanım:  
GET http://localhost:8080/v1/available-dates?page=0&pageSize=5 - Doktorların müsait günlerini listeler.  

**2. Belirli Bir Müsait Günü Getirme**  
URL: /v1/available-dates/{id}  
Method: GET  
Isımlendirme: get  
Açıklama: Belirli bir müsait günün detaylarını getirir.  
Parametreler:  
id: Müsait günün girilen id'si  

Örnek Kullanım:  
GET http://localhost:8080/v1/available-dates/1  

**3. Yeni Müsait Gün Ekleme**  
URL: /v1/available-dates  
Method: POST  
Isımlendirme: save  
Açıklama: Belirli bir doktorun müsait günlerine yeni bir müsait gün ekler.  
Parametreler:  
doctorId: Doktorun id'si  
availableDate: Müsait gün (yyyy-MM-dd formatında)  

Örnek Kullanım:  
POST http://localhost:8080/v1/available-dates - Proje isterlerine göre doktor müsait günü kaydediliyor (Question 16)  

**4. Müsait Gün Güncelleme**  
URL: /v1/available-dates  
Method: PUT  
Isımlendirme: update  
Açıklama: Belirli bir müsait günü günceller.  
Parametreler:  
id: Müsait günün girilen id'si  
availableDate: Güncellenecek müsait gün (yyyy-MM-dd formatında)  

Örnek Kullanım:  
PUT http://localhost:8080/v1/available-dates  

**5. Müsait Gün Silme**  
URL: /v1/available-dates/{id}  
Method: DELETE  
Isımlendirme: delete  
Açıklama: Belirli bir müsait günü sistemden siler.  
Parametreler:  
id: Müsait günün girilen id'si  

Örnek Kullanım:  
DELETE http://localhost:8080/v1/available-dates/1  

