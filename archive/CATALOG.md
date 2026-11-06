# Project catalog

The original Eclipse sources were compiled independently with `javac -proc:none -encoding UTF-8`, writing output only to temporary review folders. Of 60 project folders, 44 passed compilation, 9 failed, and 7 contained no Java source. Compilation alone is not a functional test.

## Review highlights

| Family | Finding | Recommendation |
| --- | --- | --- |
| Bank and employee console apps | Maintained copies outside this archive pass 38 assertions and two scripted console checks | Best small runnable examples in this release |
| String matching (`project311`, `p311`) | Both compile. GUI algorithms fail the repeated-character KMP case and Boyer-Moore throws for Arabic characters; empty-pattern behavior differs | Repair and document algorithm provenance before featuring |
| CPU scheduling variants | Most compile. The `227 P CH` FCFS test produces Infinity/NaN and its one-job SJF test throws; other variants were not behaviorally validated | Coursework archive; choose and repair one version |
| Graph recommendation variants | `PA`, `Project`, and `testf` compile; other variants fail. Starter-style interfaces and duplicate versions are present | Document individual contributions; add behavioral tests |
| Boolean search notebook | Query `alpha & beta` returns the union in a synthetic test instead of the intersection | Fix query parsing before presenting as a search engine |
| Naive Bayes spam coursework | Multiple implementations and scaffold versions; corpus excluded | Review numerical behavior and document code contributions |
| Constraint scheduling | Backtracking example; purported tree decomposition only creates singleton bags | Small exercise, not a complete tree-decomposition solver |
| Android coursework | Main activity remains largely a template; OpenCV, OCR data, and generated assets excluded | Source fragment only |
| Medical ML notebooks | Authorship/contributions not fully documented; datasets, pickle models, and outputs excluded | Archival, no performance or clinical claims |
| Graduation NLP variants | Many overlapping experiments; model assets and shared data excluded | Existing focused repository remains the clearer portfolio entry |
| Digital signature | Keystore/output artifacts present but no Java source in Eclipse | Omitted; never publish the keystore |
| Email crawler | Small coursework example requiring jsoup; not executed | Archive only; no collected addresses included |

## Every Eclipse project

| Project | Java files | Original compilation | Notes |
| --- | ---: | --- | --- |
| [227 P CH](eclipse/227%20P%20CH/src/) | 1 | pass | Compilation only; not a functional certification |
| [227p](eclipse/227p/src/) | 5 | pass | Compilation only; not a functional certification |
| [227p007](eclipse/227p007/src/) | 5 | pass | Compilation only; not a functional certification |
| [227p1](eclipse/227p1/src/) | 7 | pass | Compilation only; not a functional certification |
| [227p9](eclipse/227p9/src/) | 6 | pass | Compilation only; not a functional certification |
| [227pa](eclipse/227pa/src/) | 6 | pass | Compilation only; not a functional certification |
| [a01](eclipse/a01/src/) | 2 | pass | Compilation only; not a functional certification |
| [a02](eclipse/a02/src/) | 2 | pass | Compilation only; not a functional certification |
| [a03](eclipse/a03/src/) | 4 | pass | Compilation only; not a functional certification |
| [AldameghFinal](eclipse/AldameghFinal/src/) | 4 | pass | Compilation only; not a functional certification |
| [AldameghProject](eclipse/AldameghProject/src/) | 4 | pass | Compilation only; not a functional certification |
| [aldameghQuiz](eclipse/aldameghQuiz/src/) | 1 | pass | Compilation only; not a functional certification |
| [Assignment 8](eclipse/Assignment%208/src/) | 2 | pass | Compilation only; not a functional certification |
| [Assignment01](eclipse/Assignment01/src/) | 2 | pass | Compilation only; not a functional certification |
| [Assignment02](eclipse/Assignment02/src/) | 2 | pass | Compilation only; not a functional certification |
| [Assignment03](eclipse/Assignment03/src/) | 1 | pass | Compilation only; not a functional certification |
| [Assignment04](eclipse/Assignment04/src/) | 4 | pass | Compilation only; not a functional certification |
| [Assignment05](eclipse/Assignment05/src/) | 4 | pass | Compilation only; not a functional certification |
| [Assignment06](eclipse/Assignment06/src/) | 2 | pass | Compilation only; not a functional certification |
| [Assignment07](eclipse/Assignment07/src/) | 2 | pass | Compilation only; not a functional certification |
| [Assignment09](eclipse/Assignment09/src/) | 4 | pass | Compilation only; not a functional certification |
| [Assignment10](eclipse/Assignment10/src/) | 2 | pass | Compilation only; not a functional certification |
| Assignment_2 | 0 | no Java source | No source copied |
| [CSC 212 Tutorial # 1](eclipse/CSC%20212%20Tutorial%20%23%201/src/) | 4 | fail | Inspect separately; unfinished or dependency/configuration issue |
| [CSC 212 Tutorial#4](eclipse/CSC%20212%20Tutorial%234/src/) | 3 | fail | Inspect separately; unfinished or dependency/configuration issue |
| [CSC113 HW1-spring 2021](eclipse/CSC113%20HW1-spring%202021/src/) | 1 | fail | Inspect separately; unfinished or dependency/configuration issue |
| [CSC340 HW1](eclipse/CSC340%20HW1/src/) | 1 | fail | Inspect separately; unfinished or dependency/configuration issue |
| DigitalSignatureProject | 0 | no Java source | No source copied |
| EmailCrawler | 0 | no Java source | No source copied |
| Fan | 0 | no Java source | No source copied |
| [final ex](eclipse/final%20ex/src/) | 4 | pass | Compilation only; not a functional certification |
| [Final Exam](eclipse/Final%20Exam/src/) | 4 | fail | Inspect separately; unfinished or dependency/configuration issue |
| [HW1 CSC340](eclipse/HW1%20CSC340/src/) | 1 | fail | Inspect separately; unfinished or dependency/configuration issue |
| [lab01](eclipse/lab01/src/) | 2 | pass | Compilation only; not a functional certification |
| [lab02](eclipse/lab02/src/) | 5 | pass | Compilation only; not a functional certification |
| [lab03](eclipse/lab03/src/) | 5 | pass | Compilation only; not a functional certification |
| [lab04](eclipse/lab04/src/) | 4 | pass | Compilation only; not a functional certification |
| [lab05](eclipse/lab05/src/) | 5 | pass | Compilation only; not a functional certification |
| [lab06](eclipse/lab06/src/) | 2 | pass | Compilation only; not a functional certification |
| [LAB06EX2](eclipse/LAB06EX2/src/) | 2 | pass | Compilation only; not a functional certification |
| [lab07](eclipse/lab07/src/) | 4 | pass | Compilation only; not a functional certification |
| [lab08](eclipse/lab08/src/) | 2 | pass | Compilation only; not a functional certification |
| [lab09](eclipse/lab09/src/) | 2 | pass | Compilation only; not a functional certification |
| [lab10](eclipse/lab10/src/) | 1 | pass | Compilation only; not a functional certification |
| [lab10p2](eclipse/lab10p2/src/) | 1 | pass | Compilation only; not a functional certification |
| [lab11](eclipse/lab11/src/) | 3 | pass | Compilation only; not a functional certification |
| lab3 | 0 | no Java source | No source copied |
| [miad 1](eclipse/miad%201/src/) | 11 | pass | Compilation only; not a functional certification |
| [miad2](eclipse/miad2/src/) | 2 | pass | Compilation only; not a functional certification |
| [p311](eclipse/p311/src/) | 1 | pass | Compilation only; not a functional certification |
| [PA](eclipse/PA/src/) | 11 | pass | Compilation only; not a functional certification |
| [PA test](eclipse/PA%20test/src/) | 16 | fail | Inspect separately; unfinished or dependency/configuration issue |
| [PA212](eclipse/PA212/src/) | 15 | fail | Inspect separately; unfinished or dependency/configuration issue |
| [porject 227](eclipse/porject%20227/src/) | 8 | fail | Inspect separately; unfinished or dependency/configuration issue |
| [Project](eclipse/Project/src/) | 15 | pass | Compilation only; not a functional certification |
| [project227p2](eclipse/project227p2/src/) | 5 | pass | Compilation only; not a functional certification |
| [project311](eclipse/project311/src/) | 1 | pass | Compilation only; not a functional certification |
| [Quiza1](eclipse/Quiza1/src/) | 6 | pass | Compilation only; not a functional certification |
| Shipping | 0 | no Java source | No source copied |
| [testf](eclipse/testf/src/) | 15 | pass | Compilation only; not a functional certification |

The Eclipse configuration listed one external `StudentCode` project whose referenced location was unavailable. It is not included. No `.git` source history or project-specific `AGENTS.md`/`SKILL.md` was found in the enumerated source roots.
