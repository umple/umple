echo "Upgrading Elevator"
rm -rf /h/ralph/sites/www/html/elevatorphp/
cp -R /h/ralph/umple/trunk/examples/elevatorphp/ /h/ralph/sites/www/html/
chown -R ralph /h/ralph/sites/www/html/elevatorphp
rm -rf `find /h/ralph/sites/www/html/elevatorphp -type d -name .svn`

echo "Upgrading umple.jar"
cp -f /h/ralph/umple/trunk/dist/umple.jar /h/ralph/sites/www/html/elevatorphp/class/