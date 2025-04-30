# TODOLIST-APP

Opis zadania: System zarządzania zadaniami z
wykorzystaniem Spring Boot i ANgular
Cel projektu
Stwórz aplikację internetową do zarządzania zadaniami. Użytkownicy będą mogli tworzyć, edytować i usuwać
zadania, które są przypisane do nich. Każde zadanie może należeć do określonej kategorii. Aplikacja powinna
umożliwiać:
Logowanie użytkownika.
Opcjonalnie rejestrację nowych użytkowników.
Tworzenie i zarządzanie kategoriami (każdy użytkownik ma swoje unikalne kategorie).
Tworzenie i zarządzanie zadaniami oraz ich statusem.
Wymagania funkcjonalne
1. Moduł zarządzania użytkownikami
Implementacja logowania z wykorzystaniem Spring Security.
Powiązanie danych (kategorii i zadań) z zalogowanym użytkownikiem.
Własny formularz logowania.
Możliwość wylogowania użytkownika.
Opcjonalnie rejestracja nowych użytkowników.
2. Moduł zarządzania kategoriami
Użytkownicy mogą tworzyć kategorie i zarządzać nimi.
Kategorie są unikalne dla danego użytkownika (ta sama nazwa kategorii może istnieć u różnych
użytkowników, ale jeden użytkownik nie może posiadać dwóch kategorii o tej samej nazwie).
Każda kategoria ma nazwę i jest przypisana do użytkownika.
3. Moduł zarządzania zadaniami
Użytkownicy mogą tworzyć zadania, edytować je, zmieniać ich status, usuwać i wyświetlać.
Zadanie zawiera:
Tytuł.
Opis.
Status (NEW, IN_PROGRESS, COMPLETED).
Kategorię.
Zadania są przypisane do użytkownika.
4. Opcjonalnie: moduł zarządzania statusami
Użytkownik może tworzyć własne statusy, aby przypisywać je do zadań.
Użytkownik może edytować statusy.
Użytkownik może usuwać statusy, po uprzedniej walidacji sprawdzającej, że nie są one powiązane z
zadaniami.


Statusy są przypisane do użytkownika.
Jeden użytkownik nie może posiadać dwóch takich samych statusów.
5. Widoki aplikacji (Thymeleaf)
Formularze i tabele do zarządzania kategoriami i zadaniami.
Widoki:
Lista zadań.
Formularz tworzenia nowego zadania.
Formularz edycji zadania.
Lista kategorii.
Formularz tworzenia kategorii.
Formularz edycji kategorii.
Poszczególne widoki powinny składać się z fragmentów i gdzie to możliwe nie duplikować kodu.
Wymagania techniczne
1. Framework: Spring Boot 3.
2. Baza danych: H2 z wykorzystaniem JPA i Hibernate, oraz Liquibase z formatem XML do tworzenia
danych inicjalnych.
3. Interfejs użytkownika: ASngular z Bootstrapem.
4. Bezpieczeństwo: Spring Security.
5. Walidacja: Walidacja danych na poziomie serwisów oraz encji.
