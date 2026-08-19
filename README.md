# 📚 Library Management System

Eine vollständige Java-Webanwendung zur Verwaltung von Büchern, Autoren, Kategorien und Verlagen – entwickelt mit Spring Boot, Spring MVC und JPA/Hibernate. Die Anwendung bildet den kompletten Lebenszyklus einer Bibliotheksverwaltung ab: Anlegen, Anzeigen, Bearbeiten und Löschen (CRUD) für alle vier Kernentitäten, inklusive serverseitig gerenderter Formulare mit Validierung.

---

## 🎯 Überblick

Das Projekt ist als klassische mehrschichtige Spring-MVC-Anwendung aufgebaut (Controller → Service → Repository → Entity) und deckt für **jede** der vier Entitäten – Buch, Autor, Kategorie, Verlag – den vollständigen CRUD-Zyklus ab. Bücher können dabei mehreren Autoren, Kategorien und Verlagen gleichzeitig zugeordnet werden, was eine realistische m:n-Datenmodellierung erforderlich machte.

---

## 🛠️ Tech Stack

| Technologie | Zweck |
|---|---|
| Java | Programmiersprache |
| Spring Boot | Anwendungs-Framework |
| Spring MVC | Controller-Schicht, serverseitiges Rendering |
| Spring Data JPA / Hibernate | ORM & Datenbankzugriff |
| Thymeleaf (Views) | Serverseitig gerenderte HTML-Templates |
| Lombok | Reduzierung von Boilerplate-Code (`@Getter`, `@Setter`) |
| Maven | Build- und Dependency-Management |
| Relationale Datenbank (SQL) | Persistenzschicht |

---

## 🧩 Domänenmodell & Beziehungen

Vier Entitäten, verknüpft über m:n-Beziehungen mit eigenen Join-Tabellen:

```
Book ──< m:n >── Author      (books_authors)
Book ──< m:n >── Category    (books_categories)
Book ──< m:n >── Publisher   (books_publishers)
```

Die `Book`-Entität ist Eigentümerin aller drei Beziehungen (`@JoinTable`), die Gegenseiten (`Author`, `Category`, `Publisher`) sind über `mappedBy` verknüpft – dadurch bleibt das Datenmodell konsistent und die Fremdschlüssel-Verwaltung liegt an einer zentralen Stelle.

Damit Beziehungen nicht versehentlich einseitig gesetzt werden, pflegt `Book` eigene, bidirektionale Zuordnungsmethoden:

```java
public void addAuthor(Author author){
    this.authors.add(author);
    author.getBooks().add(this);
}

public void removeAuthor(Author author){
    this.authors.remove(author);
    author.getBooks().remove(this);
}
```

Analoge Methoden existieren für `Category` und `Publisher`. Dieses Muster verhindert inkonsistente Objektgraphen, die bei m:n-Beziehungen ein häufiger Fehlerquell sind.

---

## ⚙️ Architektur

Die Anwendung folgt strikt dem Schichtenmodell:

```
Controller  →  Service  →  Repository  →  Entity
```

- **Controller** (`AuthorController`, `BookController`, `CategoryController`, `PublisherController`, `HomeController`, `InfoController`) – nehmen Requests entgegen, validieren Formulareingaben über `BindingResult` und steuern das Routing zwischen Listen-, Detail-, Formular- und Redirect-Views.
- **Service** (`AuthorService`, `BookService`, `CategoryService`, `PublisherService`) – kapseln die Geschäftslogik und werfen kontrollierte Exceptions, wenn eine Entität nicht gefunden wird (`RuntimeException` mit sprechender Meldung statt stillem `null`).
- **Repository** (`AuthorRepository`, `BookRepository`, `CategoryRepository`, `PublisherRepository`) – reine `JpaRepository`-Interfaces, Datenzugriff läuft vollständig über Spring Data JPA ohne manuelles SQL.
- **Entity** – JPA-Entities mit Lombok-Annotationen (`@Getter`, `@Setter`) statt manueller Getter/Setter, alle Listen standardmäßig sortiert nach ID (`Sort.by("id").ascending()`).

---

## 🔄 Funktionsumfang (CRUD je Entität)

Für **Bücher, Autoren, Kategorien und Verlage** ist jeweils der vollständige CRUD-Zyklus implementiert:

| Aktion | Route (Beispiel: Buch) |
|---|---|
| Liste anzeigen | `GET /books` |
| Detailansicht | `GET /book/{id}` |
| Neu anlegen (Formular) | `GET /add-book` |
| Neu anlegen (speichern) | `POST /save-book` |
| Bearbeiten (Formular) | `GET /update-book/{id}` |
| Bearbeiten (speichern) | `POST /save-update/{id}` |
| Löschen | `GET /remove-book/{id}` |

Für Autoren, Kategorien und Verlage existieren identische Routen nach demselben Muster (`/authors`, `/categories`, `/publishers` usw.).

Beim Bearbeiten eines Buchs werden zusätzlich alle verfügbaren Autoren, Kategorien und Verlage ans Formular übergeben, damit die m:n-Zuordnung direkt im UI angepasst werden kann:

```java
model.addAttribute("categories", categoryService.getAllCategories());
model.addAttribute("authors", authorService.getAllAuthors());
model.addAttribute("publishers", publisherService.getAllPublishers());
```

Zusätzlich gibt es eine **Startseite** (`/`) und eine **Info-Seite** (`/benefits`), die den Funktionsumfang der Anwendung vorstellt.

---

## ✅ Validierung & Fehlerbehandlung

- Formulareingaben werden über Spring's `BindingResult` validiert; bei Fehlern wird das ursprüngliche Formular erneut mit den eingegebenen Werten angezeigt, statt die Daten zu verwerfen.
- Die Service-Schicht wirft aussagekräftige Exceptions (z. B. *„Book with this Id cannot be found!"*), wenn eine angefragte ID nicht existiert, statt `null` durchzureichen – das verhindert `NullPointerException`s in der Controller- und View-Schicht.

---

## 🚀 Setup & Start

```bash
# Repository klonen
git clone https://github.com/LyuboslavValkanov/LibraryMS.git
cd LibraryMS

# Projekt bauen und starten
mvn spring-boot:run
```

Anschließend ist die Anwendung unter `http://localhost:8080` erreichbar.

---

## 💡 Was ich dabei gelernt habe

- Modellierung bidirektionaler m:n-Beziehungen in JPA/Hibernate inklusive eigener Join-Tabellen und konsistenter Zuordnungsmethoden
- Aufbau einer sauber geschichteten Spring-MVC-Anwendung (Controller/Service/Repository) für **vier** parallele CRUD-Ressourcen
- Umgang mit serverseitiger Formularvalidierung über `BindingResult` und kontrolliertem Fehlerhandling in der Service-Schicht
- Wiederverwendung eines konsistenten Controller-Musters (Liste, Detail, Anlegen, Bearbeiten, Löschen) über mehrere Entitäten hinweg

---

## 📌 Nächste Schritte

- REST-Schnittstelle (JSON) als Alternative zur serverseitigen Ansicht ergänzen
- Such- und Filterfunktionen (z. B. Bücher nach Autor oder Kategorie) implementieren
- Unit- und Integrationstests für die Service-Schicht mit JUnit & Mockito
- Authentifizierung/Autorisierung ergänzen, um Verwaltungsfunktionen abzusichern

---

## 👤 Autor

**Lyuboslav Valkanov**
[GitHub](https://github.com/LyuboslavValkanov) · [LinkedIn](https://www.linkedin.com/in/lyuboslav-valkanov-8443293b8/)
