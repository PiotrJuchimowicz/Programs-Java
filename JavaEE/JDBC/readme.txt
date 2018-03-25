Z powodu ograniczen  licencyjnych nalozonych przez Oracle,aby moc uzywac sterownika do bazy danych
nalezy pobrac plik ojdbc14.jar ze strony 
					http://www.oracle.com/technetwork/apps-tech/jdbc-10201-088211.html
oraz w mavenie uruchomic nastepujace polecenie,kt�re doda sciagniety plik do lokalnego repozytorium mavena:

						 mvn install:install-file
						-Dfile={path/to/your/ojdbc.jar} 
						-DgroupId=com.oracle 
						-DartifactId=ojdbc14 -Dversion=10.2.0.4.0 -Dpackaging=jar




W pliku ClientID oraz AccountID znajduja sie liczby okreslajace ilosc juz utworzonych krotek. Dzieki nim po ponownym uruchomieniu
programu kazde ID bedzie unikalne oraz automatycznie inkrementowane.