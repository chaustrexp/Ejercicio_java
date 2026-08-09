@echo off
echo ==================================================
echo   LIMPIEZA Y COMPILACION (CARPETA BUILD)
echo ==================================================
echo.
echo [1/3] Limpiando archivos .class sueltos...
del /s /q *.class 2>nul
echo.
echo [2/3] Creando carpeta 'build' si no existe...
if not exist build mkdir build
echo.
echo [3/3] Compilando el proyecto hacia 'build'...
javac -d build Main/TiendaParking.java
echo.
echo Compilacion finalizada. Para ejecutar la aplicacion, usa:
echo java -cp build Main.TiendaParking
echo.
pause
