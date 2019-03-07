node('node1') 
{
def mvnHome = tool name: 'maven 3_6_0', type: 'hudson.tasks.Maven$MavenInstallation'
env.M2_HOME = mvnHome
  stage('checkout') 
  {  
            //steps {
                // clone project and install dependencies
                git url: 'https://github.com/rameshrangaswamy/demoCICDjob.git', branch: 'master'
            //}
    stash 'name-of-the-stash'
  }

//node('node1') {

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
