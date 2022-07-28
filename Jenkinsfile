pipeline {
  agent {
    docker {Dockerfile true}
  }

  stages {
    stage ('check agent') {
      steps {
        sh "mvn --version"
      }
    }
  }

}
