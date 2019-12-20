@echo off
rem ======================================================================
rem windows startup script
rem
rem author: yanxiang.huang
rem date: 2019-12-20
rem ======================================================================

rem Open in a browser
rem start "" "http://localhost:8080/example/hello?name=123"

rem startup jar
java -jar ../boot/@project.build.finalName@.jar --logging.config=../config/logback-spring.xml --spring.config.location=../config/

pause
