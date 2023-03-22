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
                echo "Esta en Build"
                }
            }
        stage("Final"){
            steps{
                echo "Termino"
                }
            }
    }
}   
