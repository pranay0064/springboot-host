# file-storage-service
Spring Boot code to create and delete buckets using localstack s3

below api call is to create bucket

`curl --location --request POST 'http://localhost:9191/localstack/create?bucketName=test2' \
--header 'Content-Type: application/json'`



below api call is to delete bucket

`curl --location --request DELETE 'http://localhost:9191/localstack/delete?bucketName=test2' \
--header 'Content-Type: application/json'`
