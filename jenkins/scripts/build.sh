#!/bin/bash
git pull
mvn install -Dmaven.test.skip=true
tag=`date +%Y%m%d%H%M`
tag='jenkinsfileDemo:'$tag
docker build -t $tag .
echo $tag