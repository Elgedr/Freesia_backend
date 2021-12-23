# FREESIA BACKEND

**Freesia** is a web application for booking intergalactic flight tickets. As humanity goes farther and farther into space, intergalactic travel becomes more and more accessible for the common folk. We at Freesia believe in going at the same pace as the world around us, which means providing our clients with an easy-to-use website for booking the flight to any planet of our system.

### Freesia team members:
- Julia Djomina
- Ellina Gedrojets
- Erika Maksimova

### "But how do I access your website?"
The project is still in development, but don't worry! it's only going to take... well, let's see. From a couple of minutes to an hour to get it up and running on your own computer. Here:
1. First, please clone our [frontend repository](https://gitlab.cs.ttu.ee/elgedr/iti0302-2021-front) as well as this backend repository.
2. Our SQL database is resided in the Docker image included with the backend repository. Please build the Docker image as following:
    - `docker build`
    - `docker-compose -f docker-compose.yml up -d`
    - `docker-compose -f docker-compose.liquibase.yml up -d`

3. When the database is up and running, go to `server/src/main/java/com/freesia/server/ServerApplication.java` in the backend repo and run the `ServerApplication.java` file. Congrats! Backend is now running on `localhost:8081`.
4. Only when the backend is all set up and running, you can run frontend. Please open the frontend repository in your terminal and run `ng serve --open`. Our website will open on `localhost:4200`.
5. You did it! If you can see a list of flights in the Flights tab on our site under the weather component, everything is working.

### How to run backend tests?
If you're using IntellijIDEA:
1. Please go to the File tab. Then, 
2. In `File > Settings > Build, Execution, Deployment > Build Tools > Gradle`, please change the dropdown list select from Gradle to IntellijIDEA in both `Build and run using:` and `Run tests using`. Again, it should now display IntellijIDEA! And then you can run tests with coverage without any errors in your way.
