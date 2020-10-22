#!/usr/bin/env bash
#chmod +x /etc/init.d/lal
export JAVA_HOME=/usr/java/jdk1.8.0_181 && export PATH=$JAVA_HOME/bin:$PATH && nohup java -jar /home/ec2-user/thymeleaf-vue-spring-boot-0.1.0.jar --server.port=80 &
# $ chmod +x /etc/init.d/yourapp
# export CATALINA_HOME=/usr/share/tomcat &&
 #cd /home/ec2-user &&
 #./usr/share/tomcat/bin/startup.sh
#export JAVA_HOME=/usr/java/jdk1.8.0_181 && export PATH=$JAVA_HOME/bin:$PATH && java -jar /home/ec2-user/thymeleaf-vue-spring-boot-0.1.0.jar --server.port=8080 &
#nohup java -jar /home/ec2-user/thymeleaf-vue-spring-boot-0.1.0.jar --server.port=80 &
#--server.port=8080
#Vue.js Bootstrap
#Thymeleaf, Spring Boot, DynamoDb