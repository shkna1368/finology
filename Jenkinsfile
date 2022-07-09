pipeline {
    agent any 
    stages {
        
        
        
        
        stage('Build') { 
            steps {
                echo "start"
                // 
            }
        }
        
         stage('Checkout external proj') {
        steps {
            git branch: 'main',
               
                url: 'https://github.com/shkna1368/finology/'

          
        }
    }
        
        
        stage('CLEAN-PACHAGE') { 
            steps {
               bat "mvn clean package"
            }
        }
        stage('RUN') { 
            steps {
               bat "java -jar C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\pipline-test@2\\target\\car-1.0-SNAPSHOT.jar"
               echo "end"
            }
        }
    }
