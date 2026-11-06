# Coursework source archive

Source-only copies from the owner's local coursework and Eclipse workspace, included at his request. This is an educational archive, including incomplete projects, alternative versions, and starter interfaces. It is not a collection of independently validated production applications.

- [Catalog and build results](CATALOG.md)
- [Notebook index](NOTEBOOKS.md)
- `eclipse/`: Java source grouped by its original project name.
- `level-eight/`: Python, Java, Kotlin, HTML, and Gradle configuration found in the course folders.
- `notebooks/`: numbered Jupyter notebooks with no saved results or embedded attachments.
- `archive-variants/`: source versions found inside course archives.

## Attribution and reuse

The collection may include collaborative work and supplied coursework scaffolding. Individual contributions and source provenance are not fully documented yet. Existing code credits are retained where present. The repository does not claim that its owner wrote every file. No blanket open-source license is applied, and publishing the archive does not relicense third-party dependencies or datasets.

## Privacy and publication changes

Student identifiers, course-section headers, machine-specific absolute paths, notebook outputs, execution counters, original notebook metadata, and attachments were excluded or removed. Embedded Arabic inference quotations were replaced with synthetic sentences. One Windows-1252 Java source was converted to UTF-8. No original files were modified.

Datasets, medical records, email collections, checkpoints, trained weights, pickle files, keystores, compiled binaries, screenshots, reports, lecture materials, editor history, and bundled OpenCV source/binaries are not included. Empty notebooks and automatic notebook checkpoints are omitted. Files with `.c` extensions that contained lecture notes rather than standalone source were also omitted.

## Running archived code

Each Eclipse project is separate; many define classes with the same names. Do not compile the whole archive as one Java project. Some projects require missing libraries or contain known compilation errors. The catalog records the original project's compilation result, not a promise that all examples work correctly.

No notebook training, model download, network crawler, or original dataset loading was run during publication. Notebook dependencies are not pinned; supply your own authorized data and review each cell before running it. Paths such as `data/input.csv` are placeholders. Historical notebook metrics and outputs are not published as validated results.

A syntax comparison covered 1,803 notebook code cells (ignoring standalone notebook command lines). Fourteen cells already had parsing problems or depended on cross-cell syntax; the sanitization introduced no additional parsing failures. The archive preserves these unfinished variants rather than presenting them as runnable notebooks.

The medical notebooks are unvalidated coursework experiments, not clinical decision tools. The Android entries are source fragments with missing bundled modules/resources, not a verified OCR application. The Flask classifier requires separately supplied model assets and template setup, and its historical debug setting is unsuitable for a public server.
