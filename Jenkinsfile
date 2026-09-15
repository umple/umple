pipeline {
  agent { label 'umple-host' }

  options {
    timeout(time: 2, unit: 'HOURS')
    timestamps()
    buildDiscarder(logRotator(numToKeepStr: '40'))
    disableConcurrentBuilds()
  }

  tools {
    jdk 'jdk17'   // Gradle 8 does not run on the JDK 25 the host defaults to
  }

  stages {
    stage('Versions') {
      steps {
        sh '''
          java -version
          ant -version
          php --version | head -1
          ruby --version
          python3 --version
          gcc --version | head -1
          txl -v 2>&1 | head -1
        '''
      }
    }
    stage('Build') {
      steps {
        sh './gradlew --no-daemon fullbuild'
      }
    }
  }

  post {
    always {
      junit allowEmptyResults: true, testResults: 'dist/**/TEST-*.xml'
    }
  }
}
