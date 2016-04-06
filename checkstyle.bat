for /r "E:\University\Semester 4\OOP\JagatRaya\src" %i in (*.java) do java -jar C:\Users\Rmx\Downloads\checkstyle-6.17-all.jar -c /google_checks.xml %i > "%i.checkstyle"

