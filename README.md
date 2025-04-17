🧪 TECHNO STUDY Agile Software Testing Project - 4
---
🎯 OpenMRS TEST PROJESİ
---
📝 PROJE HAKKINDA
Bu projede, Java programlama dili , Selenium test otomasyon ve TestNG test otomasyon kütüphanesi kullanılarak, OpenMRS Hastane Sitesi üzerinde [OpenMRS Sitesi](https://openmrs.org/tr/)çeşitli kullanıcı senaryolarına dayalı otomasyon testleri gerçekleştirilmiştir.
---
📌 PROJE AMACI
Bu sprint kapsamında, OPEN MRSC platformunun hastane , kullanıcı hasta kayıt  ve yönlendirme bağlantıları gibi temel işlevleri test edilmiştir. Amaç; kullanıcı deneyimini, güvenliği ve sistem kararlılığını artırmaya yönelik test süreçlerini yürütmektir.
---
🧩 USER STORY DETAYLARI
1️⃣ US_401 Sisteme Giriş(Login) Hatalarını Kontrol Etmek
Bir kullanıcı olarak, sisteme yapılan hatalı giriş denemelerinde uyarı mesajı görmek istiyorum. Böylece uygulamanın güvenliğini artırmış olurum.
![Ekran görüntüsü 2025-04-16 215625](https://github.com/user-attachments/assets/eb2b1f42-5640-4aa0-b9a1-a7fd48ec62a7)
---
2️⃣ US_402Sisteme Giriş (Login) Yapmak
Bir kullanıcı olarak, sisteme giriş yapabilmek istiyorum, böylece uygulamanın özelliklerinden yararlanabilirim.
![US_402Login](https://github.com/user-attachments/assets/5a4eb53d-0d72-4b87-bbbc-43cb6cef6244)
---
3️⃣ US_403 Sistemden Çıkış (Logout) Yapmak
Bir kullanıcı olarak, sistemden güvenli bir şekilde çıkış yapabilmek istiyorum, böylece uygulamanın açık kalmamış olduğunda emin olurum.
![US_403Logout](https://github.com/user-attachments/assets/78add89c-2398-46d1-8fb7-b5ef413f44ba)
---
4️⃣ US_404 Hasta Kayıt
Bir kullanıcı olarak bilgilerini girerek, sisteme hasta kayıt edebilmeliyim. Böylece hasta bilgilerine ihtiyacım olduğunda başka bir uygulamaya ihtiyacım olmaz.
![US_404PatientRegistration](https://github.com/user-attachments/assets/380bdaf5-60b3-4a17-9c41-eb8a23503ac6)
---
5️⃣ US_405 Hesabım (MyAccount)
Bir kullanıcı olarak, anasayfada hesap ayarlarıma ulaşabileceğim bir icon veya link olmalıdır. Böylece hesabımla ilgili ayarlara hızlıca ulaşabilirim.
![US_405MyAccount](https://github.com/user-attachments/assets/89748178-4cf6-4f8e-965d-faf57a81cc1f)
---
6️⃣ US_406 Hasta Listesinde Arama
Bir doktor olarak, hastaları listelemek; bu liste içinde bir hastayı aramak (adıyla veya ID si ile) ve onun bilgilerine erişmek istiyorum, böylece onu tedavi edebilirim
![US_406FindPatient](https://github.com/user-attachments/assets/c04887e3-8887-40f4-b294-f281066e9edd)
---
7️⃣ US_407 Hasta Silme
Bir doktor olarak, bir hastayı sistemden silmek istiyorum, böylece onun bilgilerinin gizliliğini koruyabilirim.
![US_407PatientDeletion](https://github.com/user-attachments/assets/79ed8423-5d70-4f96-8979-6330459b793e)
---
8️⃣ US_408 Hasta Listeleme
Bir doktor olarak tüm hastaları listelemek istiyorum. Böylece daha rahat bir planlama yapabilirim.
![US_408PatientListSizeAssertion](https://github.com/user-attachments/assets/44e0c387-3657-4532-991c-18e40d03694b)
---
9️⃣ US_409 Hasta Kayıtlarını Birleştirme (Merge)
Bir doktor olarak daha önce girdiğim hasta kayıtlarından istediğim ikisinibirleştirmek istiyorum. Böylece daha kolay bir reçete yönetimi sağlayabilirim.
![US_409MergePatient](https://github.com/user-attachments/assets/5bb18511-fb70-48da-98f4-16eb551654c8)
---
🔟 US_410 Hasta randevusu alırken yanlış sistem saat dilimi
Bir kullanıcı olarak, hasta randevusu oluştururken sistem saatinin GMT+0 dışında bir saate ayarlandığında verilen hata mesajını görebilmeliyim. 
![US_410TimeZone](https://github.com/user-attachments/assets/217e9077-0a35-4c14-bffe-586edfeb80e4)
---
 
### 📚 KULLANILAN TEKNOLOJİLER & KÜTÜPHANELER  
- **Java JDK 17+**  
- **Selenium WebDriver - v4.29.0**  
- **TestNG** (isteğe bağlı yapılandırma)  
- **Maven**  
- **WebDriver Manager**  
- **GitHub**  
- **Jira** (Sprint yönetimi için)  
---
👨‍💻 PROJE EKİBİ
---
| İsim           | GitHub Profili                             |
|----------------|---------------------------------------------|
| Merve Kıtır     | [github.com/mervektr](https://github.com/mervektr)         |
| Mert Saraç      | [github.com/meertsarac](https://github.com/meertsarac)     |
| Barış Sancar    | [github.com/brssncr](https://github.com/brssncr)           |
| Tolga Aktaş     | [github.com/aktstlga](https://github.com/aktstlga)         |
| Mert Canat      | [github.com/MertCanat91](https://github.com/MertCanat91)   |
| Berk Gültekin   | [github.com/berkgltkn](https://github.com/berkgltkn)       |
| Arif Etli       | [github.com/ArfEtl](https://github.com/ArfEtl)             |
---
### 🔁 EK NOTLAR  
- Negatif test senaryoları kullanıcı deneyimini geliştirmek ve sistem kararlılığını artırmak amacıyla özellikle ele alınmıştır.  
- Testler Chrome, Firefox gibi yaygın tarayıcılar ile yürütülmüştür.  
- Testlerde manuel doğrulama ve otomasyon birlikte kullanılmış, bazı senaryolar için ekran kayıtları (GIF) hazırlanmıştır.  
- Sprint boyunca iletişim için Rocket Chat ve Microsoft Teams gibi platformlar tercih edilmiştir.  
