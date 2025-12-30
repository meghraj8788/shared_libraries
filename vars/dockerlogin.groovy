def call(String credID, String image){
  withCredentials([usernamePassword(
                    credentialsId : ${credID},
                    passwordVariable: "dockerpass",
                    usernameVariable : "dockeruser"
                    )]){
                        sh "docker login -u ${env.dockeruser} -p ${env.dockerpass}"
                        sh "docker push ${env.dockeruser}/${image}"
                        
                    }
}
