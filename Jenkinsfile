pipeline {
  agent {
    Dockerfile true
  }

  stages {
    stage ('check agent') {
      steps {
        sh "mvn --version"
      }
    }
  }

}
