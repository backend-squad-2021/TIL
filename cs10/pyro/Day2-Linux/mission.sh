DIR_PREFIX=day # 폴더명
PORT=1234 # 본인이 포트포워딩한 포트번호
USERNAME=g # 본인 시스템의 유저 이름

NUM=$(seq 1 16)
FILES_FOR_ZIP=""

for i in $NUM
do
  DIRNAME=$DIR_PREFIX$i
  CS_FILES=($(find ./$DIRNAME -name "*.cs"))

  if [ ${#CS_FILES[@]} == 0 ]; then
    echo $DIRNAME is empty
  else
    FILES_FOR_ZIP+=${CS_FILES[@]}
    FILES_FOR_ZIP+=" "
  fi
done

ZIP_FILE=backup_$(date "+%Y%m%d")
zip $ZIP_FILE $FILES_FOR_ZIP

scp -P $PORT ./$ZIP_FILE.zip $USERNAME@127.0.0.1:/backup
