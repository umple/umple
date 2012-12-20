#!/bin/bash
echo "Generating Updated Umple Reference Documentation"
cd /h/ralph/umple/trunk/ && java -jar dist/umpledocs.jar build/reference dist/cruise.umple/reference

echo "Synchronizing Umple Reference Documentation"
rsync -vaz --exclude=.svn/ --exclude=reference/ /h/ralph/sites/www/html/umple /h/ralph/sites/www/html
rsync -var --exclude=.svn/ /h/ralph/sites/www/html/reference /h/ralph/sites/www/html/umple

echo "Synchronizing UmpleOnline"
rsync -vaz --exclude=.svn/ --exclude=ump/ /h/ralph/umple/trunk/umpleonline /h/ralph/sites/www/html

echo "Synchronizing BumpleOnline"
rsync -vaz --exclude=.svn/ --exclude=bump/ /h/ralph/sites/www/html/bumpleonline /h/ralph/sites/www/html

echo "done."
