pipeline {
    agent any 
    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
        stage('SonarQube') {
            steps {
                sh './gradlew -Dsonar.host.url=http://sonarqube:9000 jacocoTestReport sonarqube'
            }
        }
    }
}
