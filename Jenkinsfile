pipeline{
    agent any
    tools{
        maven 'maven-3.9.4'
    }
    stages{
        stage('Build Maven'){
            steps{
                git branch: 'main', credentialsId: 'jenkins-auth', url: 'https://github.com/dineshk999/aws-apigateway-codepipeline-example.git'
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t dineshk9999/aws-apigateway-example2 .'
                }
            }

        }
        stage('Push docker image'){
            steps{
                script{
                    sh 'docker push dineshk9999/aws-apigateway-example2'
                }
            }

        }
    }
}