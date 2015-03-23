# Congestion-control
Using Log file in between.

Here we are trying to improvise the closed loop implicit congestion control mechanism. I idea here to  maintain the Router.log 
file in the Router Log. So One of the source from the multiple source feels the congestion it checks the Log file to make sure 
that even other source feels the congestion. If not then there is no congestion only this source feels the congestion.

In implemetation part i have used 2 java program using multithreading concept stimulate multiple sender and router and destination.
The Router has a queue and log file which is further used to check the congetsion.

first program sender the packet from source to router queue and another thread removed the packet from the queue simutaneously.
It also creates Log file of every activity in the log file.

Secong program takes the log file as input to analyse the Wrong predicition of the congestion.
