# Java Console Projects

Two small coursework applications from Mohammed AlDamegh's early Java projects: an employee manager and an in-memory bank simulation. They demonstrate classes, arrays, searching, and menu-driven console interaction.

The repository also includes a broader [coursework source archive](archive/README.md): Java projects from Eclipse, Python/Jupyter experiments, and Android source fragments. The archive includes unfinished and duplicate variants; it is separate from the two maintained examples below. See the [project catalog](archive/CATALOG.md) for validation results and known limitations.

## Applications

| Application | Entry point | Features |
| --- | --- | --- |
| Employee manager | `Company` | Add and find employees, calculate example bonuses, find the highest salary within a department |
| Bank simulation | `TestBank` | Add and remove clients, deposit, withdraw, transfer between clients and banks, display balances |

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

## Scope and provenance

The original source headers credit Mohammed AlDamegh. This publication copy removes student/course identifiers and includes small correctness fixes plus new regression checks; see [CHANGES.md](CHANGES.md). The original local files were preserved. No Eclipse metadata, compiled binaries, real employee records, banking records, or original Git history is included.

That authorship statement applies to the two maintained examples. The broader archive can include collaborative work and supplied coursework scaffolding. Individual contributions and upstream provenance have not all been documented; no claim of sole authorship or blanket license is made for the archive.

These are educational console examples, not production payroll or banking software. They use fixed-capacity arrays and `double` for example amounts, have no persistence or authentication, and expect correctly typed console input. No additional open-source license is granted by this release.
