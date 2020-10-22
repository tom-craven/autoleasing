#!/usr/bin/env bash
pkill -f 'java -jar' && sleep 20 && rm -f /home/ec2-user/thymeleaf-vue-spring-boot-0.1.0.jar
#&&
#service codedeploy-agent stop && sleep 40 && rm -rf /opt/codedeploy-agent/deployment-root/* && service codedeploy-agent start
#service tomcat stop ps aux | grep java
#export JAVA_HOME=/usr/java/jdk1.8.0_181 && export CATALINA_HOME=/usr/share/tomcat &&
 #export PATH=$JAVA_HOME/bin:$PATH
 #./usr/share/tomcat/bin/shutdown.sh