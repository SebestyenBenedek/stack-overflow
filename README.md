# Stack-overflow project

This project is a full-stack Q&A platform, developed using React for the frontend, Java Spring Boot for the backend,
and PostgreSQL for the database. The platform allows users to ask and answer questions,
with features for user authentication and data management.
However, it is currently halfway through its development.

# Table of Contents
    Screenshot
    Installation
    Contribution
    Authors

# Screenshot
![ScreenShot][product-screenshot]
<!-- <img src="" width="720" /> -->

# Installation

Before installing the project, make sure you have Docker installed on your machine. 
Docker can be downloaded and installed from the official Docker website. Here are the links to download Docker for different operating systems:

[Docker Desktop for Windows](https://docs.docker.com/desktop/install/windows-install/)

[Docker Desktop for Mac](https://docs.docker.com/desktop/install/mac-install/)

[Docker Desktop for Linux](https://docs.docker.com/desktop/install/linux-install/)


After downloading and installing Docker, follow these steps to install and run the project:

Clone the repository to your local machine.

Navigate to the root directory of the project.

Run the entrypoint.sh script with three arguments: username, password, and database. Replace <username>, <password>, and <database> with your desired values:

    ./entrypoint.sh <username> <password> <database>

Finally, start the Docker containers using Docker Compose. From the root directory of the project, run:

    docker-compose up

This will build and start the Docker containers defined in the docker-compose.yml file.

Please note that the frontend and backend are not fully connected yet as the project is still under development.

# Contribution

If you'd like to contribute to the project, please follow these guidelines:

- Fork the repository.
- Create a new branch for your feature: git checkout -b feature-name.
- Make your changes and commit: git commit -m 'Add some feature'.
- Push to your fork: git push origin feature-name.
- Open a pull request.

# Authors

List of the contributors to the project:

<a href="https://github.com/SebestyenBenedek/stack-overflow/graphs/contributors">
 <img src="https://contrib.rocks/image?repo=SebestyenBenedek/stack-overflow" />
</a>

[product-screenshot]: src/main/resources/readme-screenshot.png
