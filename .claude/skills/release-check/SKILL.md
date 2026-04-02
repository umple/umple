---
name: release-check
description: Use before cutting a release to verify build, tests, and packaging.
disable-model-invocation: true
---

## 1. Version bump

- [ ] Update version in `build/umpleversion.txt` (e.g. `1.37.0`)

## 2. Build and test (local)

- [ ] Full build passes: `bumple`
- [ ] No test failures in `dist/qa/` reports
- [ ] Example tests pass: `ant -Dmyenv=local -f build.exampletests.xml allUserManualAndExampleTests`
- [ ] Testbed passes: `ant -Dmyenv=local -f build.testbed.xml test`

## 3. Documentation (local)

- [ ] User manual updated if syntax/semantics changed (`build/reference/`)
- [ ] Docs build: `dumple`

## 4. UmpleOnline (local)

- [ ] Package: `pumple`
- [ ] Smoke test at localhost:8000 — loads and compiles a simple class

## 5. Docker (local build, remote push)

- [ ] Build image: `bdock`
- [ ] Tag: `docker tag <image> umple/umpleonline:v1.X.Y`
- [ ] Push (requires Docker Hub credentials for `umple` org): `docker push umple/umpleonline:v1.X.Y` and `docker push umple/umpleonline:latest`

## 6. Platform packages (local, optional)

- [ ] Debian: `./gradlew packageDeb` (requires `dpkg-deb`)
- [ ] RPM: `./gradlew packageRpm` (requires `rpmbuild`, not installed on Debian by default)
- [ ] Chocolatey: `./gradlew updateChocolateySpec`

## 7. Tag and release (remote)

- [ ] Git tag: `git tag v1.X.Y`
- [ ] Push tag: `git push origin v1.X.Y`
- [ ] Create GitHub release from the tag
- [ ] Update `build/umpleversion.last.txt` to the new release version

## Output

Pass / Fail per item. Any Fail blocks the release.
