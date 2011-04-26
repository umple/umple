#!/bin/bash
echo "Moving Umple Reference Documentation"
rm -rf /h/ralph/sites/www/html/umple
cd /h/ralph/umple/trunk/ && java -jar dist/umpledocs.jar build/reference dist/cruise.umple/reference
cp -r /h/ralph/umple/trunk/dist/cruise.umple/reference /h/ralph/sites/www/html/
mv /h/ralph/sites/www/html/reference/ /h/ralph/sites/www/html/umple
cp -r /h/ralph/cruise/dev_umple/ElevatorPhp /h/ralph/sites/www/html/umple

echo "Removing UmpleOnline"
rm -rf /h/ralph/sites/www/html/umpleonline
rm -rf /h/ralph/sites/www/html/umpleonlineold

echo "Removing BumpleOnline"
rm -rf /h/ralph/sites/www/html/bumpleonline

echo "Moving UmpleOnline"
cp -r /h/ralph/umple/trunk/umpleonline /h/ralph/sites/www/html/

echo "Moving UmpleOnlineOld"
cp -r /h/ralph/umple/trunk/dist/playground /h/ralph/sites/www/html/
mv /h/ralph/sites/www/html/playground /h/ralph/sites/www/html/umpleonlineold

echo "Moving BumpleOnline"
cp -r /h/ralph/cruise/dev/bumpleonline /h/ralph/sites/www/html/

echo "Updating Permissions"
cd /h/ralph/sites/www/html/
chown -R ralph umple
chgrp -R ralph umple
chown -R ralph umpleonline
chgrp -R ralph umpleonline
chown -R ralph umpleonlineold
chgrp -R ralph umpleonlineold
chown -R ralph bumpleonline
chgrp -R ralph bumpleonline

cd /h/ralph/sites/www/html/umpleonline
chown -R apache ump
chgrp -R apache ump

cd /h/ralph/sites/www/html/umpleonlineold
chown -R apache ump
chgrp -R apache ump

cd /h/ralph/sites/www/html/bumpleonline
chown -R apache bump
chgrp -R apache bump

echo "Removing .svn files"
cd /h/ralph/sites/www/html/umple
rm -rf `find . -type d -name .svn`

cd /h/ralph/sites/www/html/umpleonline
rm -rf `find . -type d -name .svn`

cd /h/ralph/sites/www/html/umpleonlineold
rm -rf `find . -type d -name .svn`

cd /h/ralph/sites/www/html/bumpleonline
rm -rf `find . -type d -name .svn`

echo "done."
