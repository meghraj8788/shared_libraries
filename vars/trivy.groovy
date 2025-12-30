def trivy_f(){
  sh "trivy fs . -o result.json"
}
