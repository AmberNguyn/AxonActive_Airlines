pipeline {
  agent {
    dockerfile true
  }

  stages {
    stage ('check agent') {
      steps {
        sh "mvn --version"
      }
    }
  }

}
