pipeline {
    agent {
        docker {
            label 'macos'
            image 'maven:3.6.3'
            args '-v $HOME/apache-maven-3.6.3'
        }
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/wangkuixing/demo.git'

                // Run Maven on a Unix agent.
                sh "mvn -B -DskipTests clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }

    post {
        // If Maven was able to run the tests, even if some of the test
        // failed, record the test results and archive the jar file.
        success {
            echo 'deploy success!'
        }
    }
}