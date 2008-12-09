@echo off
set JAVA=java -cp ..\lib\easyaccept.jar;..\lib\commons-beanutils.jar;..\lib\commons-logging.jar;..\lib\log4j-1.2.11.jar;..\bin easyaccept.EasyAccept br.edu.uepb.escolaDeIngles.Facade
%JAVA% us1.txt us2.txt us3.txt us4.txt us5.txt us6.txt us7.txt us8.txt us10.txt us11.txt