# NHSBSA FINANCE

# GitLab
https://bsa2468.atlassian.net/wiki/display/NHSBSA/Accessing+project+repos

##### Install homebrew (Type into Terminal)
- /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

##### Install Java SDK (Type into Terminal)
- brew update
- brew cask install java

# NPM
- brew install npm
- gem install sass (required for website-assets to build)

# Docker

##### Getting started with Docker
  - download + install Docker from https://www.docker.com/products/overview
  - download + install Docker-toolkbox from https://www.docker.com/products/docker-toolbox
 > You may be interested in:  https://docs.docker.com/docker-for-mac/

##### Docker setup
 - docker-machine create --driver virtualbox default
 - docker-machine env default
 
##### IDE
- We use IntelliJ from JetBrains https://www.jetbrains.com/idea/
You can use other IDE if you wish, e.g. Eclipse, but make sure the formatting of code follow our standards.

##### Lombok
We use Lombok https://projectlombok.org/ which adds annotations to Java and simplify our code. 
To allow IntelliJ to support Lombok install the plugin:
- Preferences > Plugins > Browse Repositories... > search Lombok > Install
- Preferences > search Annotation processes (ensure enabled for all)

##### HostFile
- You will need to set your host file to redirect 127.0.0.1 (localhost) for backend-api etc.
- sudo vi /etc/hosts 
- add a line similar to this as required
- 192.168.99.100 database #Docker IP - check with:  docker-machine env
- 192.168.99.100 authorization
- 192.168.99.100 authorization_database
- 192.168.99.100 backend-api

##### Building the project
- You need to get shared modules:  git submodule update --init --recursive
- Type: ./up.sh -b
- Project should now be accessible e.g. 192.168.99.100:8080/login

##### Docker & Postgres setup
- https://bsa2468.atlassian.net/wiki/pages/viewpage.action?pageId=10977291

##### JIRA
- https://bsa2468.atlassian.net

##### Confluence
- https://bsa2468.atlassian.net/wiki/display/FIC/Financial+Information+Collection

##### SonarLint Intellij plugin
- Preferences > Plugins > Browse Repositories... > search SonarLint > Install (Intellij will want to re-start)
- Preferences > Other Settings > SonarLint General Settings > Add a new Server (+)
- Enter a Server Name i.e. 54.194.171.164
- Enter the Server URL: http://54.194.171.164:9000
- Authentication Type: Token (keep other default settings and Test Connection)
- After adding a new SonarQube server configuration, a local update will immediately be triggered. 
- Once the update has completed - Preferences > Other Settings > SonarLint Project Settings
- Tick 'Enable binding to remote SonarQube server
- Select the server you created earlier in the 'Bind to Serveer' list
- Select 'nhs-pensions' project from the SonarQube project list
- Apply changes

