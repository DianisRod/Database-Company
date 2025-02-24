
*Database connection*

the project use a mySQL database.

You must access first to "XAMP" and start mySQL and Apache. 
after you can have a view of the tables through http://localhost/phpmyadmin/

Another way in Termina you can start the Befehl  
```bash  
mysql -u Admin -p 
```
and use the password in the Database connection class. 

then you have to install the treiber
       👉 MySQL Connector/J [Download](https://dev.mysql.com/downloads/connector/j/)
        
    add the .jar-Datei as Library:
    IntelliJ: File → Project Structure → Libraries → + → .jar hinzufügen
    Eclipse: Rechtsklick auf Projekt → Properties → Java Build Path → Add External JARs


Then you have already checked that all information is right, then you can have a connection with the database. 
