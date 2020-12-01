#!/bin/bash
git pull
mvn install -Dmaven.test.skip=true
tag=`date +%Y%m%d%H%M`
tag='jenkinsfiledemo:'$tag
docker build -t $tag .
echo $tag
docker run -p 8080:8080 --name jenkinsfiledemo -d $tag