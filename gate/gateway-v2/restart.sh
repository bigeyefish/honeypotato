#!/bin/bash
pid=`ps -ef | grep 'gateway' | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ]
then
  echo =======================shutdown=======================
  kill -9 $pid
fi
jar_file=`ls  -t | grep jar | head -1`
echo ======================== startup ==============================
nohup java -jar $jar_file gateway  --spring.profiles.active=prod >> data.log &