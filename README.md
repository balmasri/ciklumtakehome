## Requirements
This project requires the following installed

* Java 8
* Maven

 Stack: Spring + Thymleaf
 
 Front End: Used images and some code from this example https://javascript.plainenglish.io/building-a-rock-paper-scissors-game-with-javascript-bce23d39509d

To verify everything is working fine make sure the project builds via

`mvn clean install`


To use, run the project's driver, and specify only the first parameter
 
 `mvn exec:java -Dexec.mainClass="com.ciklum.lottoland.LottolandApplication"`

 
 
 Usage:
 After you've launched the webapp 2 endpoints will be available
 * Create a new game http://localhost:8080/api/game/new (It shows a UI where the user can play a game along with information about played rounds)
 * View statistics of all games http://localhost:8080/api/statistics
