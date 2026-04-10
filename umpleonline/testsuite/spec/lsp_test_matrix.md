# UmpleOnline LSP Test Matrix

This matrix is for browser-level automation in `umpleonline/testsuite/spec`, using the real CodeMirror 6 editor, WebSocket proxy, and LSP server.

The point is not to test one happy path. The point is to cover the failure-prone boundaries:
- single-file vs multi-file workspaces
- active vs passive tabs
- editable vs read-only mode
- clean startup vs reconnect
- success vs no-result vs malformed-result handling

## Environment Gates

These tests should run only when:
- `window.UMPLE_LSP_WS_URL` is present
- the page is not in `readOnly` mode unless the scenario explicitly tests read-only suppression
- the backing LSP server/proxy is available

Tests should skip, not fail, when the environment is intentionally non-LSP.

## Bootstrap

### Single-file editable session
- load plain `umple.php`
- verify LSP becomes active
- verify no console-level transport errors on idle startup

### Multi-file session with remote tabs
- load a session with more than one tab
- verify LSP still becomes active
- verify tab switching does not trigger duplicate initialization

### Blank session
- load a new blank session
- verify LSP becomes active without needing a generated remote file first

### Read-only
- load `umple.php?readOnly`
- verify LSP stays inactive
- verify no reconnect attempts or noisy transport errors

## Diagnostics

### Single-file syntax error
- inject invalid Umple code
- verify diagnostics appear
- fix the code
- verify diagnostics clear

### No stale mapping after full document replacement
- load valid code
- replace the entire document with a larger invalid document
- verify diagnostics map to the new document without range/changeset crashes

### Diagnostics after tab switch
- introduce an error in tab A
- switch to tab B and back
- verify diagnostics remain stable and do not duplicate/crash

## Definition / Navigation

### Same-file definition
- set cursor on a symbol with a same-file definition
- trigger F12
- verify selection jumps to the correct location in the same tab

### Cross-file definition
- define symbol in tab A, reference in tab B
- trigger F12 from tab B
- verify UmpleOnline switches to tab A
- verify cursor lands on the target symbol

### No-result definition
- place cursor on a symbol with no definition
- trigger F12
- verify there is no client crash
- verify current tab and cursor remain valid

### Empty-array responses
- verify definition/declaration/type-definition/implementation commands all tolerate `[]`

## References

### Same-file references
- trigger Shift-F12 on a symbol referenced multiple times in one file
- verify reference panel opens with expected entries

### Cross-file references with inactive tabs
- references in tab A and tab B
- leave one tab inactive
- trigger Shift-F12
- verify the inactive-tab reference is listed
- verify selecting that entry opens the correct tab

### Encoded filenames
- use tab names containing spaces and `%`
- verify references still resolve to the correct tab/file

## Rename

### Same-file rename
- trigger F2 on a symbol
- rename it
- verify all same-file occurrences update

### Cross-file rename
- occurrences in active and inactive tabs
- trigger rename from one tab
- verify inactive-tab content updates too
- switch tabs and verify persisted content matches

### Active tab rename lifecycle
- rename the active tab itself
- verify LSP remains attached to the renamed URI
- verify no stale old-URI behavior after rename

### Passive tab rename lifecycle
- rename an inactive tab
- verify workspace state updates without forcing an unnecessary open

## Tabs / Workspace

### Tab create
- create a new tab after LSP is active
- verify it can become the active file without crashing

### Tab delete
- delete an inactive tab
- verify references/rename no longer target it

### Tab switch
- rapidly switch between tabs
- verify no duplicate `didClose`/`didOpen` symptoms

### Tab names with URL-encoded characters
- spaces
- `%`
- verify F12, references, and rename all continue to work

## Transport / Failure Handling

### Proxy disconnect
- force socket close or LSP process exit
- verify the client detaches immediately
- verify there is no dead-transport spam

### Retryable close
- simulate retryable close code
- verify reconnect happens

### Permanent close
- simulate non-retryable close code
- verify reconnect does not loop

## Suggested Phasing

### Phase 1
- bootstrap editable
- bootstrap read-only
- single-file diagnostics
- no-result F12

### Phase 2
- same-file F12
- cross-file F12
- same-file references
- same-file rename

### Phase 3
- cross-file references
- cross-file rename
- encoded tab names
- reconnect / close-code handling

### Phase 4
- tab create/delete churn
- active/passive tab rename lifecycle
- rapid tab switching stress
