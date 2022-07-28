pipeline {
  agent {
    docker {image 'maven:3.8.6-openjdk-11' }
  }

  stages {
    stage ('check agent') {
      steps {
        sh "mvn --version"
      }
    }
  }

}
