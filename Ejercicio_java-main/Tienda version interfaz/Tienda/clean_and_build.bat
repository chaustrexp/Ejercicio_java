@echo off
echo ==================================================
echo   LIMPIEZA Y COMPILACION - VERSION INTERFAZ
echo ==================================================
echo.
echo [1/3] Limpiando archivos .class anteriores...
del /s /q *.class 2>nul
echo.
echo [2/3] Creando carpeta 'build' si no existe...
if not exist build mkdir build
echo.
echo [3/3] Compilando el proyecto hacia 'build'...
javac -d build @sources.txt
echo.
if %ERRORLEVEL%==0 (
    echo Compilacion exitosa. Ejecutando la aplicacion...
    echo.
    java -cp build Main.TiendaParking
) else (
    echo ERROR: La compilacion fallo. Revisa los mensajes anteriores.
)
echo.
pause
