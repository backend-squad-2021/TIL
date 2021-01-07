NUM=$(seq 1 16)
FILES_FOR_ZIP=""

for i in $NUM
do
  DIRNAME="day"$i
  CS_FILES=($(find ./$DIRNAME -name "*.cs"))

  if [ ${#CS_FILES[@]} == 0 ]; then
    echo $DIRNAME is empty
  else
    FILES_FOR_ZIP+=${CS_FILES[@]}
    FILES_FOR_ZIP+=" "
  fi
done

DATE=$(date "+%Y%m%d")
zip backup_$DATE $FILES_FOR_ZIP
