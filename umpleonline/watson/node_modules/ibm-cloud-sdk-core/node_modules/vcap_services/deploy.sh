git reset --hard
git pull origin master
npm version patch
git push --tags
git push origin master
npm publish
