# AI-poc

This repository contains a minimal Java demo and example GitHub Actions workflows.

Java demo
---------

Files included for the Java demo:

- `src/HelloWorld.java` — single-file Java program (default package) that prints `Hello, world!`.
- `scripts/build.ps1` — PowerShell script to compile and run the program on Windows (pwsh).
- `scripts/build.sh` — Bash script to compile and run the program on Linux/macOS.

Build and run (PowerShell):

```powershell
pwsh -c "javac src/HelloWorld.java; if ($LASTEXITCODE -eq 0) { java -cp src HelloWorld }"
```

Build and run (bash):

```bash
bash -lc "javac src/HelloWorld.java && java -cp src HelloWorld"
```

If `javac` / `java` are not installed, install a JDK (OpenJDK 11+ recommended) and retry.