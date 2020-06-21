 pipeline {
     environment {
    registry = "ramana96/karthik"
    registryCredential = 'dockerhub'
    
}
       agent any
         tools { 
        maven 'maven-jenkins' 
        jdk 'jenkins-java' 
    
    } 
         stages {
            stage("git_clone") {
               steps {
                  
                  checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/gangaramana/jenkins-demo.git']]])
                }
             }

             stage("build") {
               
               steps {
              
                       sh "mvn clean package"

               }
             }
             
             stage("docker-build-image"){
                steps{
                    script{
                  dockerImage= docker.build registry+":$BUILD_NUMBER"
                    }
                }
                 
             }
             
             stage('Deploy our image') {
              steps{
                  script {
                        docker.withRegistry( '',registryCredential) {

                                   dockerImage.push()

                                         }
                          }
                 }
            }
            stage('deployment kubernetes'){
            steps{
              script{
                 kubernetesDeploy(configs:"jenki.yml",kubeconfigId:"kub")
              }

            }
            }

           stage('deploy service kubernetes'){
            steps{
              script{
                 kubernetesDeploy(configs:"service.yml",kubeconfigId:"kub")
              }

            }
            }
        }
      }
