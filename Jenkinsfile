pipeline {
  agent {
    docker {image 'node:16-alpine'}
  }

  stages {
    stage ('check agent') {
      steps {
        sh "node --version"
      }
    }
  }

}
