pipeline{
    agent{
        docker{
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages{
        stage("Build"){
            steps{
                echo "Maven compiling"
                sh 'mvn compile'
            }
            post{
                success{
                    echo "========Maven compile stage executed successfully========"
                }
                failure{
                    echo "========Maven compile stage execution failed========"
                }
            }
        }
        stage("Test"){
            steps{
                echo "Maven compiling"
                sh 'mvn test'
            }
            post{
                success{
                    junit 'target/surefire-reports/**/*.xml'
                    echo "========Maven Test stage executed successfully========"

                }
                failure{
                    echo "========Maven Test stage execution failed========"
                }
            }
        }
         stage("Packaging"){
            steps{
                echo "Maven Packaging"
                sh 'mvn package'
            }
            post{
                success{
                    archiveArtifacts 'target/*.jar'
                    echo "========Maven Packaging stage executed successfully========"

                }
                failure{
                    echo "========Maven Packaging stage execution failed========"
                }
            }
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}
