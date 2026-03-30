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

## Commits and PRs

- Commit format: `type(scope): summary` with issue references (e.g. `fix(parser): handle nested state machines, Fixes #1234`)
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
