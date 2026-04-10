## Build system

Umple uses Ant (`build/` directory). Use the dev-tool shortcuts in `dev-tools/`:

| Script | What it does |
|--------|-------------|
| `bumple` | Full build with all tests (use before PRs) |
| `fbumple` | First-time build after clone |
| `qbumple` | Quick recompile + main umple.jar only (~10-20s) |
| `qfbumple` | Quick recompile + all jars |
| `tumple` | Unit tests only, no rebuild |
| `pumple` | Package UmpleOnline (copies jars, minifies JS, rebuilds Docker/CodeMirror) |
| `uminify` | Minify UmpleOnline JS only (quicker than `pumple` when only JS changed) |

See `dev-tools/README.md` for the full list.

### Compile and Test Guidelines

#### Builds
- For build and test tasks, agents MUST prefer scripts under `dev-tools/` over direct `Ant` or `Gradle` commands whenever a script covers the task.
- During development, agents SHOULD use the narrowest `dev-tools/` script that covers the change.
  - The scripts listed here are examples, not an exhaustive list.
  - If the right script is not obvious, agents MUST check `dev-tools/README.md` before choosing a compile or package step, and MUST NOT default to `bumple` first.
  - Typical cases: `qbumple` for changes limited to Java in the main `umple.jar`; `uminify` for JS-only changes; `bumple` only when a full build with tests is required.
- See `dev-tools/README.md` for the full script list. Additional guidance is available at `https://github.com/umple/umple/wiki/CheatSheet` and `https://github.com/umple/umple/wiki/DevelopmentSetUp`.

#### Tests
- Before running `tumple`, if any file changed after the last compile step, agents MUST run the appropriate compile step first, even for test-only changes.
- If the correct compile step is unclear, agents MUST determine it from `dev-tools/README.md`, local context, and recent changes; if still unclear, they MUST ask the user rather than default to `bumple`.
- When running `bumple`, set the execution-tool timeout to at least 15 minutes. `bumple` already includes `tumple`; do not run it again. Except for full-repo testing or pre-PR validation, prefer a sufficient partial compile followed by `tumple`.

## Commits and PRs

- Commit format: `type(scope): summary` with issue references (e.g. `fix(parser): handle nested state machines, Fixes #1234`)
  - Common types: `feat`, `fix`, `docs`, `refactor`, `test`, `chore`
- Branch naming: `issue#<number>_<short-description>`
- When making a PR, read `.github/PULL_REQUEST_TEMPLATE.md` for detailed guidelines on PR titles, descriptions, and content requirements.
- When making an issue, read `.github/ISSUE_TEMPLATE.md` for detailed guidelines.

## Safety rails

### ALWAYS
- Run `bumple` before opening a PR
- Show diff before committing
- Update user manual in `build/reference/` when changing Umple syntax or semantics

## Post-Work

For compiler changes (`cruise.umple/src/`):
- `tumple` must pass
- For grammar or parser changes, run full `bumple`

For code generation template changes (`UmpleTo*/`):
- `tumple` must pass
- Run relevant testbed tests: `ant -Dmyenv=local -f build.testbed.xml test`

For UmpleOnline changes (`umpleonline/`):
- JS-only changes: run `uminify` (minification only, much faster)
- Other changes (compiler, jars, Docker, CodeMirror): run `pumple` (full package)

For syntax/semantics changes:
- Update `build/reference/` user manual
