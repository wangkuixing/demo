#!/bin/bash
git pull
mvn install -Dmaven.test.skip=true
tag=`date +%Y%m%d%H%M`
tag='jenkinsfiledemo:'$tag
docker build -t $tag .
echo $tag

app_name='jenkinsfiledemo'
docker stop ${app_name}
echo '----stop container----'
docker rm ${app_name}
echo '----rm container----'
docker rmi `docker images | grep none | awk '{print $3}'`
echo '----rm none images----'
docker run -p 8080:8080 --name jenkinsfiledemo -d $tag
echo '----start container----'