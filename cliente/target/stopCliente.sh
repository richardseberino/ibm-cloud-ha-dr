ps -ef | grep cliente.jar | awk '{ print "kill -9 " $2 }'| bash