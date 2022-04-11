# university

Summary of design considerations

I finished to all requires at code assignment. While I doing that I used Springboot framework. 
As I'm building my back end services in Spring Boot, this Controller-Service-Repository pattern provide a lot of benefit. It keeps our code clean, it keeps our tests simple, and it makes it clear where new code should go. And it provide scalability. 
I created unit test only on servise layer. It shows that I can handle what we need. 
I applied swagger-ui so I could test easy.
I cared about clean code. So I used lombok library. Lombok library generates automaticaly class getter/setter and constructor by anotations. Maybe I could also use the Modelwrapper library for clean code. But I didn't.
For schedule table, id column does not exist in the code assignment, but I prefered to use id column. Because it is easy to understand and to manage code with it. Other way I could use composite key.
I created a database it"s name university. Maybe you dont have it. So you can change its configuration on application.yml file.


Proposed next steps/improvements

Authentication 
Exception handling
Logging 
Validation
Can be improved endpoint response mechanism.
