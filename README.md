# Java Coursework Archive and Project Index

هذا المستودع يجمع نسخة أرشيفية من ملفات الدراسة. المشاريع المختارة لها الآن مستودعات مستقلة موضحة أدناه، مع اسم المادة وتاريخ المشروع الأصلي. تواريخ النشر في GitHub تختلف عن تاريخ إنجاز المشاريع.

This is the legacy source archive. Selected projects are maintained in their own repositories. Original local files remain unchanged.

## Selected standalone projects

| Project | Course / المادة | Original project period | Publication |
| --- | --- | --- | --- |
| [Bank simulation](https://github.com/aldamegh/java-bank-simulation) | CSC 111 - Computer Programming I | 11-12 December 2020 | Independent repository |
| [Employee manager](https://github.com/aldamegh/java-employee-manager) | CSC 111 - Computer Programming I | 9-11 December 2020 | Independent repository |
| [Social network recommender](https://github.com/aldamegh/social-network-recommender) | CSC 212 - Data Structures | May 2022 | Independent repository |
| [String matching algorithms](https://github.com/aldamegh/string-matching-algorithms) | CSC 311 - Algorithms Design and Analysis | January-February 2023 | Independent repository |
| [Boolean search engine](https://github.com/aldamegh/boolean-search-engine) | CSC 484 - Information Retrieval | Spring 2024; source saved 6 May | Independent repository |
| [Naive Bayes spam classifier](https://github.com/aldamegh/naive-bayes-spam-classifier) | CSC 484 - Information Retrieval | Spring 2024; source saved 10 May | Independent repository |
| [Graduation project: Arabic NLP](https://github.com/aldamegh/turing-test-revisited) | Computer Science Graduation Project; local report labeled CSC 496 | March-May 2024; later cleaning variant saved December 2025 | Existing focused repository |

Original dates above come from surviving source timestamps, ZIP-entry timestamps, and course briefs. A due date is distinguished from a source-save date in each project's README. Publication review and restructuring: **9 November 2026**.

## What the existing archive contains

The original upload contained two reviewed console examples, plus the larger coursework archive; it was not a single course project.

- `bank/src/` and `employees/src/`: reviewed descendants of Eclipse `AldameghFinal` and `AldameghProject`, respectively, from December 2020 (CSC 111).
- `archive/eclipse/`: **234 Java source files** from **53 nonempty Eclipse project folders**. All 234 were matched against the local Eclipse sources after ignoring comments and the privacy-safe package rename. The original workspace also had seven folders without Java source.
- `archive/notebooks/`: **56 sanitized notebooks** spanning Boolean search, Naive Bayes variants, Arabic graduation experiments, and medical coursework variants. They include duplicates and incomplete experiments; their [index](archive/NOTEBOOKS.md) records topics.
- `archive/level-eight/` and `archive/archive-variants/`: additional course-folder/archive source, including Python, Java, Android/Kotlin and configuration fragments. Lecture slides, exams, datasets, and compiled output were excluded.

### Course mapping for the older sources

| Source family | Course/date evidence | Status |
| --- | --- | --- |
| Early Java assignments, labs, bank and employees | CSC 111; local sources span September-December 2020 | Selected bank/employee versions have separate repositories |
| `PA`, `PA212`, `PA test`, `Project`, `testf` graph variants | CSC 212 friend-recommendation brief; due 17 May 2022, final local variants through 22 May | One reviewed variant selected |
| `p311`, `project311` | CSC 311 brief, January-February 2023 | Reviewed `project311` variant selected |
| `227*`, `porject 227`, `project227p2` scheduling variants | CSC 227 - Operating Systems; original files/ZIP span January-February 2023 | Multiple partially working variants; retained as archive |
| Boolean index/search and spam-classifier sources | CSC 484 project briefs, Spring 2024; selected sources saved in May | Separate reviewed repositories |
| Arabic article/review/tweet training variants | Graduation project; March-May 2024 source versions, with some later saves | Consolidated in the focused graduation repository |
| Other tutorials, exams, medical and Android fragments | Folder labels alone do not establish a verified course, date, or individual contribution | Archival; not selected as independent portfolio projects |

Some Eclipse folder names are misleading: a folder labeled as a 2021 programming assignment contains later scheduling code. Course labels were checked against actual source content and surviving briefs rather than applied solely from directory names. Course titles can be checked in the [KSU catalog](https://ccis.ksu.edu.sa/en/cs/cs-prog-guides).

See the [archive catalog](archive/CATALOG.md) for original compilation findings and known defects. Archive code is not covered by the validation of the selected standalone releases.

## Legacy console copies

The two original console copies remain below for compatibility. Use their independent repositories for the reviewed publication versions.

## Build and run

Requires JDK 11 or newer for compilation, with `javac` and `java` on PATH. The commands target Java 8 or newer runtimes. No external Java dependencies.

```sh
mkdir build
javac --release 8 -encoding UTF-8 -d build bank/src/*.java employees/src/*.java
java -cp build Company
# Or:
java -cp build TestBank
```

Use single-word names and department names at the prompts. All records exist only in memory and are discarded when the program exits. The bank menu starts a second bank with two fictional sample clients, Mike and Joe.

## Verification

With Python 3 and a JDK installed:

```sh
python check.py
```

This compiles in temporary storage, runs 38 assertions, and exercises both console menus with synthetic input.


## Privacy and provenance

Student identifiers, faculty names, machine-specific paths, keystores, raw data, notebook outputs, attachments, compiled files, and IDE history are excluded from the current source tree. A student identifier previously embedded in an archived package path was replaced with `coursework` during this review.

The broader archive includes collaborative work and supplied scaffolding, and does not claim that every file was written solely by the repository owner. No blanket open-source license is applied. Original reports, slides, and exam materials remain local.
