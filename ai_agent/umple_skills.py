import subprocess
import os

OUTPUT_DIR = "generated_code"

def _ensure_dir():
    """Ensure the output directory exists."""
    if not os.path.exists(OUTPUT_DIR):
        os.makedirs(OUTPUT_DIR)

def _run_umple(args):
    """Internal helper to run Umple CLI commands."""
    _ensure_dir()
    cmd = ['umple'] + args
    result = subprocess.run(cmd, capture_output=True, text=True)
    return result

def validate_umple_code(code: str) -> str:
    """Validates Umple syntax. Essential for AI self-correction."""
    print(f"\n[SKILL] Validating code...")
    _ensure_dir()
    filename = os.path.join(OUTPUT_DIR, "temp_check.ump")
    
    with open(filename, "w") as f: 
        f.write(code)
    
    res = _run_umple([filename])
    if os.path.exists(filename): 
        os.remove(filename)
    
    if res.returncode == 0:
        return "SUCCESS: Code is syntactically correct."
    return f"ERROR: Issues detected:\n{res.stdout}\n{res.stderr}"

def generate_multi_language_code(code: str, language: str) -> str:
    """Generates code in a specific language (Java, PHP, Python, etc.)."""
    print(f"\n[SKILL] Generating {language} code...")
    _ensure_dir()
    filename = os.path.join(OUTPUT_DIR, f"temp_{language}.ump")
    
    with open(filename, "w") as f: 
        f.write(code)
    
    res = _run_umple(['-c', language, filename])
    if os.path.exists(filename): 
        os.remove(filename)
    
    if res.returncode == 0:
        return f"SUCCESS: {language} code generated in '{OUTPUT_DIR}' folder."
    return f"GENERATION ERROR: {res.stdout}"

def generate_diagram_svg(code: str) -> str:
    """Generates a GraphViz Class diagram in SVG format."""
    print(f"\n[SKILL] Generating SVG Diagram...")
    _ensure_dir()
    filename = os.path.join(OUTPUT_DIR, "temp_diag.ump")
    
    with open(filename, "w") as f: 
        f.write(code)
    
    res = _run_umple(['-g', 'GvClass', filename])
    if os.path.exists(filename): 
        os.remove(filename)
    
    if res.returncode == 0:
        return "SUCCESS: SVG diagram source generated."
    return f"DIAGRAM ERROR: {res.stdout}"

def check_best_practices(code: str) -> str:
    """Checks the model against Umple best practices."""
    print(f"\n[SKILL] Checking best practices...")
    _ensure_dir()
    filename = os.path.join(OUTPUT_DIR, "temp_best.ump")
    
    with open(filename, "w") as f: 
        f.write(code)
    
    res = _run_umple([filename])
    if os.path.exists(filename): 
        os.remove(filename)
    
    if "Warning" in res.stdout:
        return f"ADVICE: The code is valid but follow these best practices:\n{res.stdout}"
    return "SUCCESS: The model follows all best practices."