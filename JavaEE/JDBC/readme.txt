This app provides handling 2 tables(Client and Account) by using JDBC.


You must download oracle driver from:
					http://www.oracle.com/technetwork/apps-tech/jdbc-10201-088211.html
and run in maven:

						 mvn install:install-file
						-Dfile={path/to/your/ojdbc.jar} 
						-DgroupId=com.oracle 
						-DartifactId=ojdbc14 -Dversion=10.2.0.4.0 -Dpackaging=jar




