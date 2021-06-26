In Config, the orginal code is to instantiate ActiveMQQueue.

In my case, I define String as queue name.

$bin/activemq.bat start

start this application, then check activemq dashboard.

http://localhost:8161

to Access get message:
http://localhost:8080/rest/publish/MyMessage

done.