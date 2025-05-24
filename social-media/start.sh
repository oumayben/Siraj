#!/bin/sh
##
/wait-for-it.sh mysql:3306 -t 60 -- echo "MySQL is up, starting app..."
#java -jar ./app.jar
exec java -jar app.jar
