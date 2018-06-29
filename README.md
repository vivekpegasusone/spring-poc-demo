# spring-poc-demo
In order to run the project - 
  1. Clone project from repository
  2. Import as maven project in eclipse
  3. Build maven project, it will create war file under target directory (mvn clean install)
  4. Deploy war in tomcat (copy war file in tomcat webapps dir and start tomcat)
  5. Open browser and type "http://localhost:8080/spring-poc-example/" on address bar (please validate host and port of your tomcat)
  
The index page in project takes an input string and order in which the words from the input string, will be sorted.
The program counts the number of occurrences of each word in a given text and sort them as per input. 
