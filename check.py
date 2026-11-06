"""Compile and test in temporary storage using only Python's standard library."""
from pathlib import Path
import subprocess
import tempfile

ROOT = Path(__file__).resolve().parent
sources = sorted(ROOT.glob("*/src/*.java")) + sorted((ROOT / "tests").glob("*.java"))
with tempfile.TemporaryDirectory(prefix="java-console-check-") as directory:
    subprocess.run(["javac", "--release", "8", "-proc:none", "-encoding", "UTF-8", "-d", directory,
                    *map(str, sources)], check=True, timeout=30)
    subprocess.run(["java", "-cp", directory, "ConsoleProjectsTest"], check=True, timeout=15)
    for main, input_text in [("Company", "1\n1 Alex 2 500 IT\n5\nIT\n6\n"),
                             ("TestBank", "1\nAlex 100\n4\nAlex 100\n7\nAlex\n9\n")]:
        result = subprocess.run(["java", "-cp", directory, main], input=input_text,
                                capture_output=True, text=True, timeout=15, check=True)
        expected = "highest salary in IT" if main == "Company" else "Alex 0.0 SR"
        if expected not in result.stdout:
            raise AssertionError(f"Unexpected console result: {main}")
        print(f"{main}: scripted console check passed.")
