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

- When running `bumple`, use a timeout of at least 15 minutes. 
- For testing purposes other than the full pre-PR validation run, prefer the combination of `qbumple` or `qfbumple` followed by `tumple` whenever that combination is sufficient to achieve the goal.

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
- For file reads, writes, creates, deletions, searches, and edits, use the system-provided tools such as `read`, `grep`, `search`, `edit`, and `apply_patch`. Unless a developer explicitly approves or requires it, do not use general script execution tools including `bash`, `pwsh`, `python`, or similar mechanisms to bypass those tools for file operations. If a provided file tool rejects a request, follow its error information to determine the next step. If the rejection is clearly caused by a system mechanism such as permissions, do not try to bypass it with script execution tools; instead, reassess whether the action is compliant and necessary, or ask the user for a decision.
- Before running `tumple`, if any file has been modified since the last compile step such as `qfbumple`, `qbumple`, or `bumple`, run `qfbumple` or `qbumple` first, regardless of whether the changes are in project code or tests. If the agent does not know when the last compile happened, or whether any files changed after it, default to running `qfbumple` or `qbumple` before `tumple`.

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
