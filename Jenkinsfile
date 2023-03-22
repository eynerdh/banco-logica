pipeline{
    agent any
    stages{
        stage("Clean Up"){
            steps{
                deleteDir()
            }
        }
        stage("Clone Repo"){
            steps{
                sh "git clone https://github.com/eynerdh/banco-logica.git"
            }
        }
        stage("Build"){
            steps{
                echo "Esta en Build en rama NewPipelineJenkis"
                }
            }
        stage("Final"){
            steps{
                echo "Stage Final NewPipelineJenkis"
                }
            }
    }
}   
