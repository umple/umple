# Umple AI Master Agent - Issue #2302

This project implements an AI Agent that integrates with the local Umple CLI to provide an automated modeling experience.

## Features
- **CLI Automation**: The agent can validate, compile, and analyze models using the local `umple.jar`.
- **Self-Correction Loop**: Using Gemini, the agent automatically fixes syntax errors by analyzing compiler feedback.
- **Multi-Language Support**: Capable of generating source code for multiple targets.

## Available Skills
- `validate_umple_code`: Real-time syntax checking using the official compiler.
- `generate_multi_language_code`: Generates Java, PHP, Ruby, etc.
- `generate_diagram_svg`: Creates SVG diagram layouts.
- `check_best_practices`: Provides architectural advice based on compiler warnings.

## Setup
1. Ensure `umple` CLI is installed and mapped to `umple.jar`.
2. Install dependencies: `pip install -U google-generativeai`.
3. Provide your Google AI Studio API Key in `main_agent.py`.
4. Run: `python3 main_agent.py`.

## Authors
- Rayan Saadani Hassani (Team 08)