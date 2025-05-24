#!/bin/bash

# Attendre que MySQL soit prêt
while ! bash -c "</dev/tcp/$MYSQL_HOST/3306" 2>/dev/null; do
    echo "[INFO] Attente de MySQL..."
    sleep 2
done

# Attendre que HDFS soit prêt
echo "[INFO] Attente de HDFS (5s)..."
sleep 5

# Démarrer l'import Sqoop de toutes les tables
echo "[INFO] Démarrage de l'import Sqoop..."

sqoop import-all-tables \
  --connect jdbc:mysql://mysql:3306/socialmediadb \
  --username root \
  --password root \
  --driver com.mysql.jdbc.Driver \
  --fetch-size 1000 \
  --verbose 
  

echo "[INFO] Import terminé."
