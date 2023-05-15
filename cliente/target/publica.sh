scp cliente.jar root@10.250.64.10:/root
scp cliente.jar root@10.250.128.8:/root
scp stopCliente.sh root@10.250.64.10:/root
scp stopCliente.sh root@10.250.128.8:/root
ssh root@10.250.64.10 "./stopClient.sh;export AMBIENTE=Producao-VM2;nohup java -jar cliente.jar > cliente.log &"
ssh root@10.250.128.8  "./stopClient.sh;export AMBIENTE=Producao-VM3;nohup java -jar cliente.jar > cliente.log &"
