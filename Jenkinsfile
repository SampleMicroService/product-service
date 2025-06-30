pipeline {
    agent any

    tools {
        maven "Maven3"
    }

    environment {
        DOCKER_IMAGE = "nitheskannaa/product-service"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '118ac47d-e79e-4d79-b2a7-cb0e542b4720', url: 'https://github.com/SampleMicroService/product-service']])
            }
        }

        stage('Build') {
            steps {
                bat "mvn clean install"
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: '7c1356a5-0d01-4511-829f-aac5c659b177', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    bat 'echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t %DOCKER_IMAGE% ."
            }
        }

        stage('Push Docker Image') {
            steps {
                bat "docker push %DOCKER_IMAGE%"
            }
        }
    }
}
