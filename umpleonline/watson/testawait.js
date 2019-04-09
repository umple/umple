console.log("testawait.js started");

var global = 0;

async function m () {
  wait(1000);
  global = 1;
  return global;
}

function wait(ms) {
  var start = new Date().getTime();
  var end = start;
  while (end < start + ms) {
    end = new Date().getTime();
  }
}

console.log(global);

(async () => {
  await m();
})();

console.log(global);
