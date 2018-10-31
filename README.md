# string-processing
Spring Boot Maven Web App project for providing simple REST api's for string processing

Once the Spring Boot app is running you can test the 2 REST api by

1. sending requests to the /stringDedup GET uri:

curl localhost:8080/stringDedup?value=ceciestunechaine 

which will return a string without double characters and ordered alphabeticaly 

{"content":"\"acehinstu"}

2. sending requests to the /writeNumber GET uri:

curl localhost:8080/writeNumber?value=999999

which will return a word representation in english of a given number

{"content":"Nine Hundred Thousand, Ninety Nine Thousand Nine Hundred Ninety Nine "}



