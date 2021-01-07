NUM=$(seq 1 16)
for i in $NUM
do
  DIRNAME="day"$i
  CS_FILES=($(find ./$DIRNAME -name "*.cs"))

  if [ ${#CS_FILES[@]} == 0 ]; then
    echo $DIRNAME is empty
  else
    echo ${CS_FILES[@]}
  fi

done
