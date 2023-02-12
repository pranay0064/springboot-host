# file-storage-service
Spring Boot code to create and delete buckets using localstack s3

below api call is to create bucket

`curl --location --request POST 'http://localhost:9191/localstack/create?bucketName=test1' \
--header 'Content-Type: application/json'`



below api call is to delete bucket

`curl --location --request DELETE 'http://localhost:9191/localstack/delete?bucketName=test1' \
--header 'Content-Type: application/json'`


Below api is to upload a file into s3 bucket, but make sure you have bucket "test1" created since its hardcoded 

`curl --location --request POST 'http://localhost:9191/localstack/upload' \
--header 'Content-Type: application/json' \
--form 'file=@"/Users/pgarlapati/Downloads/123temp.rtf"'`
