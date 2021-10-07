@REM CLEAR THE SCREEN
CLS

@REM COMPILE THE FILES
javac -cp ".;lib/*" -sourcepath src -d bin src/registrationSystem/controller/*java src/registrationSystem/view/*java src/registrationSystem/model/*java

@REM RUN
java -cp ".;lib/*;bin" registrationSystem.controller.AppController

@REM DON'T SUDDENLY QUIT
PAUSE
