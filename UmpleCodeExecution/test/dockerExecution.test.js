const test = require('node:test');
const assert = require('node:assert');
const fs = require('fs');
const os = require('os');
const path = require('path');
const DockerExecution = require('../dockerExecution');

class TestExecution extends DockerExecution {
    readConfig() {
        return { timeoutValue: '20' };
    }
}

function executionWith(t, files) {
    const execution = new TestExecution('/', 'Main', 'model');
    execution.outputFolder = fs.mkdtempSync(path.join(os.tmpdir(), 'umple-exec-test-'));
    t.after(() => fs.rmSync(execution.outputFolder, { recursive: true }));
    for (const [name, content] of Object.entries(files)) {
        fs.writeFileSync(path.join(execution.outputFolder, name), content);
    }
    return execution;
}

function readOutput(execution, error, stderr) {
    return new Promise(resolve => execution.readOutput(error, stderr, (errors, output) => resolve({ errors, output })));
}

test('a completed program is returned even when the wait timed out', async t => {
    const result = await readOutput(executionWith(t, { completed: 'Java result:\ndone\n', errors: '' }), { code: 124 }, '');
    assert.strictEqual(result.output, 'Java result:\ndone\n');
});

test('an unfinished program returns its partial output and the timeout message', async t => {
    const result = await readOutput(executionWith(t, { 'logfile.txt': 'partial\n' }), { code: 124 }, '');
    assert.strictEqual(result.output, 'partial\n\nExecution Timed Out. Maximum allowed time is 20 seconds.');
});

test('a provisioning failure is reported as an error, not as a timeout', async t => {
    const stderr = 'Runner provisioning failed or timed out (limit 25s).\n';
    const result = await readOutput(executionWith(t, {}), { code: 125 }, stderr);
    assert.ok(result.errors.includes('Runner provisioning failed or timed out (limit 25s).'));
    assert.ok(!result.output.includes('Timed Out'));
});

test('two executions of the same main get separate output folders', t => {
    const root = fs.mkdtempSync(path.join(os.tmpdir(), 'umple-exec-test-'));
    t.after(() => fs.rmSync(root, { recursive: true }));
    const folders = [1, 2].map(() => {
        const execution = new TestExecution('/', 'Main', 'model');
        execution.outputFolder = path.join(root, 'model_Main');
        execution.makeOutputFolder();
        return execution.outputFolder;
    });
    assert.notStrictEqual(folders[0], folders[1]);
    folders.forEach(folder => assert.ok(fs.statSync(folder).isDirectory()));
});
