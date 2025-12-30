def call(String credID, String image){
  withCredentials([
        usernamePassword(
            credentialsId: credID,
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh '''
            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
            docker push "$DOCKER_USER/'${image}'"
        '''
    }
}
