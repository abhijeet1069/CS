psql -U satyam -d satyam \
  -v ON_ERROR_STOP=1 \
  -f DDL+drop.sql \
  -f smallRelationsInsertFile.sql