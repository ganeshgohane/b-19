pipeline {
    agent any 
    stages {
        stage('PULL') { 
            steps {
                git 'https://github.com/ganeshgohane/b-19.git'
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn package clean'
            }
        }
        stage('Test') { 
            steps {
                echo 'PIPELINE TEST SUCCESSFULLY'
            }
        }
        stage('Deploy') { 
            steps {
                echo 'PIPELINE DEPLOY SUCCESSFULLY'
            }
        }
    }
}