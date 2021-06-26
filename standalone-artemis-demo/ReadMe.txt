Two dependencies are set up
1. Spring web
2. artemis

this will use external artemis for messaging.

Create broker-test in the artemis installation place:

>./artemis create broker-test --user=admin --password=test

New folder broker-test is created in current bin directory

Next step, go into broker-test/bin

$./artemis-service.exe install

error, access denied.

I have to restart git bash shell as administrator

now it works.

Next step, start it
$./artemis-service.exe start


Now go to web browser:

localhost:

it does not work, not sure if it's because property setup in application.properties


sren@sren-desktop MINGW64 /c/ServiceServers/apache-artemis-2.17.0/bin
$ ./artemis create broker-test --user=admin --password=admin                    <== both admin, that's default
Creating ActiveMQ Artemis instance at: C:\ServiceServers\apache-artemis-2.17.0\bin\broker-test

--allow-anonymous | --require-login: is a mandatory property!
Allow anonymous access?, valid values are Y,N,True,False
y    <== say Y, I used to say N                      I have to use Y ,now it's working


Auto tuning journal ...
done! Your system can make 0.93 writes per millisecond, your journal-buffer-timeout will be 1072000

You can now start the broker by executing:

   "C:\ServiceServers\apache-artemis-2.17.0\bin\broker-test\bin\artemis" run

Or you can setup the broker as Windows service and run it in the background:

   "C:\ServiceServers\apache-artemis-2.17.0\bin\broker-test\bin\artemis-service.exe" install
   "C:\ServiceServers\apache-artemis-2.17.0\bin\broker-test\bin\artemis-service.exe" start

   To stop the windows service:
      "C:\ServiceServers\apache-artemis-2.17.0\bin\broker-test\bin\artemis-service.exe" stop

   To uninstall the windows service
      "C:\ServiceServers\apache-artemis-2.17.0\bin\broker-test\bin\artemis-service.exe" uninstall


run application, then the queue will be created!!!

build with mvn, clean install

Spring-boot:run

Yes I can see the
    test-queue


ReceiverService:
    It has JmsListener annotation, it works like charm!!! it calls log to output message into log file. That's good enough.

        @JmsListener(destination="${jms.queue}")
        public void receiveMessage(String message) {
            log.info("Received message: " + message);   // how come? no JmsTemplate?
        }