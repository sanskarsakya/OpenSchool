cd Web-Module\target
set CATALINA_HOME="C:\xampp\tomcat"
copy Web-Module-1.0.war %CATALINA_HOME%\webapps
"C:\xampp\tomcat\server_start.bat" run