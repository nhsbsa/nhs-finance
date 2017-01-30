# NHSBSA FINANCE

# Note - remove these lines from pom.xml to build project
    <module>modules/nhs-base-docker</module>
    <module>modules/database-docker</module>
    <module>modules/website-assets</module>
    <module>modules/authorization</module>

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

##### Lombok
- Preferences > Plugins > Browse Repositories... > search Lombok > Install
- Preferences > search Annotation processes (ensure enabled for all)

##### HostFile
- You will need to set your host file to redirect 127.0.0.1 (localhost) for backend-api etc.
- sudo vi /etc/hosts 
- add a line similar to this as required
- 192.168.99.100 database #Docker IP
- 192.168.99.100 authorization
- 192.168.99.100 authorization_database
- 192.168.99.100 backend-api

##### Building the project
- Navigate to the scripts folder 
- Type "./runme.sh"
- Project should now be accessible e.g. 192.168.99.100:8080/login

##### Docker & Postgres setup
- https://bsa2468.atlassian.net/wiki/pages/viewpage.action?pageId=10977291

##### JIRA
- https://bsa2468.atlassian.net

##### Confluence
- https://valtech-uk.atlassian.net/

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

