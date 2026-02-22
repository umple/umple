import warnings
warnings.filterwarnings("ignore", category=FutureWarning)

import google.generativeai as genai
import umple_skills

API_KEY = "" 
genai.configure(api_key=API_KEY)

MODEL_ID = 'models/gemini-flash-latest'

SYSTEM_INSTRUCTIONS = (
    "You are the Umple Master AI. Your goal is to provide perfectly verified Umple models.\n"
    "TOOLS RULES:\n"
    "1. Never provide Umple code without calling 'validate_umple_code' first.\n"
    "2. If you get an error, fix it and re-validate. Do this until it's perfect.\n"
    "3. Use 'generate_multi_language_code' only when the user asks for a specific target like Java or PHP.\n"
    "4. Use 'generate_diagram_svg' to ensure the visual layout is possible.\n"
    "5. Use 'check_best_practices' to ensure the user is making a high-quality model."
)

model = genai.GenerativeModel(
    model_name=MODEL_ID,
    tools=[
        umple_skills.validate_umple_code, 
        umple_skills.generate_multi_language_code,
        umple_skills.generate_diagram_svg,
        umple_skills.check_best_practices
    ],
    system_instruction=SYSTEM_INSTRUCTIONS
)

chat = model.start_chat(enable_automatic_function_calling=True)

print(f"\n=== UMPLE MASTER AI ONLINE (Issue #2302) ===")
print("System: All CLI skills (Validation, Multi-lang, Diagrams, Best Practices) are active.")
print("Commands: exit, quit, stop\n")

while True:
    user_input = input("User: ")
    if user_input.lower() in ["exit", "quit", "stop"]: break
    
    response = chat.send_message(user_input)
    print(f"\nGemini: {response.text}\n")