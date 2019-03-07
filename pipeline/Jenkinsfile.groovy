node('node1') 
{
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
                 sh 'export $M2_HOME=/home/rameshrangaswamy1/apache-maven-3.6.0/bin'
                sh '''mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent \
                  install -Dmaven.test.failure.ignore=true || true'''
            //}
    unstash 'name-of-the-stash'
    sh 'echo "test"'
  }
}
