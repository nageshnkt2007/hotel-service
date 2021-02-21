# hotel-service

## Steps to run.


  ### 1. Clone this Repository
  
  
    `git clone https://github.com/nageshnkt2007/hotel-service.git`
    
    
  ### 2. Go to project directory
    `cd hotel-service`
  ### 3.Build this Project using below command
    `mvnw clean install`
    
    
  ### 4. To ignore test cases while build use command
    `mvnw clean install -Dmaven.test.skip=true`
    
    
  ### 5. Run Docker build to build a docker image of this project
    `docker build -f Dockerfile -t hotel-service.jar .`
    
    
  ### 6. Use docker run to run this project on 8080 port (make sure no other app is running on the same port)
    `docker run -p 8080:8080 hotel-service.jar`
