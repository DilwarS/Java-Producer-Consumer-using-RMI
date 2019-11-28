# Java-Producer-Consumer-using-RMI
Bank.java is the remote interface which contains two abstarct methods.
SharedBuffer.java , which implements the Bank interface.
Producer.java is the producer which read a customer information from a text file and creates a customer object and put it inot the shared ArrayList.
Consumer.java is the consumer which read the customer object from the shared ArrayList and display.
All the communication takes place through the RMI server.

Implemetation is tested on LAN using RMIServer IP as 192.168.43.13. When you are running on your LAN just all the IPs to your system IP on which you wish to run RMIServer.java
If you want to run this program on localhost just changed the IP to "localhost".
