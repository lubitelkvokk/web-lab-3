@echo off

REM Сохранение пути к корневой папке проекта в переменную
set "project_root=C:\Users\Alex\IdeaProjects\web-lab-3"
set "project_name=web-lab-3-1.0"

REM Сборка JavaScript кода
cd "%project_root%\src\main\js" && call npm run build

call copy "public\bundle.js" "..\webapp\resources\js"


REM Выполнение команд Maven
cd "%project_root%" && call mvn clean install



REM Копирование WAR архива в директорию WildFly
cd "%project_root%" && call copy "target\%project_name%.war" "C:\Users\Alex\wildfly-28.0.1.Final\standalone\deployments"