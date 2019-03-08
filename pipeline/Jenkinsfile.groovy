/*import hudson.model.*  
def q = jenkins.model.Jenkins.getInstance().getQueue()   
def items = q.getItems()  
for (i=0;i<items.length;i++){  
  if(items[i].task.getName() == "job_name"){  
  items[i].doCancelQueue()  
}   
} */
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

node('node2')
{
  // This limits build concurrency to 1 per branch
  properties([disableConcurrentBuilds()])

  stage('checkout') 
  {
            //steps {
                 //coverage tests initialization script
                  //sh '''mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent \
                  //install -Dmaven.test.failure.ignore=true || true'''
                  git url: 'https://github.com/JeffLi1993/springboot-learning-example.git', branch: 'master'
            //}
    unstash 'name-of-the-stash'
    sh 'echo "test"'
  }
}
}
