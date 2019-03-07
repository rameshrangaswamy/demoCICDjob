node('node1') {
def mavenHome
mavenHome = tool(name: 'maven-3.6.0', type: 'maven');

  stage('checkout') 
  {
      
            //steps {
                // clone project and install dependencies
                git url: 'https://github.com/rameshrangaswamy/demoCICDjob.git', branch: 'master'
            //}
    stash 'name-of-the-stash'
  }

//node('node1') {
withEnv([
        'MAVEN_HOME=' + mavenHome,
        "PATH=${mavenHome}/bin:${env.PATH}"
        ])
  stage('build') 
  {
            //steps {
                 //coverage tests initialization script
                sh '''mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent \
                  install -Dmaven.test.failure.ignore=true || true'''
            //}
    unstash 'name-of-the-stash'
    sh 'echo "test"'
  }
}
