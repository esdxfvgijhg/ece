cd ~/Bureau/JAVA/EmploiDuTemps1/Serveur

export CLASSPATH=$CLASSPATH:/home/aghiles/Bureau/JAVA/EmploiDuTemps1/Serveur/lib/smtp.jar
export CLASSPATH=$CLASSPATH:/home/aghiles/Bureau/JAVA/EmploiDuTemps1/Serveur/lib/pop3.jar
export CLASSPATH=$CLASSPATH:/home/aghiles/Bureau/JAVA/EmploiDuTemps1/Serveur/lib/mailapi.jar
export CLASSPATH=$CLASSPATH:/home/aghiles/Bureau/JAVA/EmploiDuTemps1/Serveur/lib/mail.jar
export CLASSPATH=$CLASSPATH:/home/aghiles/Bureau/JAVA/EmploiDuTemps1/Serveur/lib/jdom.jar
export CLASSPATH=$CLASSPATH:/home/aghiles/Bureau/JAVA/EmploiDuTemps1/Serveur
export CLASSPATH=$CLASSPATH:/home/aghiles/Bureau/JAVA/EmploiDuTemps1/Serveur/bin

javac -d bin -sourcepath src src/Systeme/Serveur.java
java Systeme.Serveur

javac -d bin -sourcepath src src/be4gi/CryptoInputStream.java
java be4gi.CryptoInputStream.java
