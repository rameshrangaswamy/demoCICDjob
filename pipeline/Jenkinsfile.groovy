/*import hudson.model.*  
def q = jenkins.model.Jenkins.getInstance().getQueue()   
def items = q.getItems()  
for (i=0;i<items.length;i++){  
  if(items[i].task.getName() == "job_name"){  
  items[i].doCancelQueue()  
}   
} */
stage('checkout') 
  {  
      // Throttle of a single operation
throttle(['test_1']) {
    node('node1') {
        sh "sleep 500"
        echo "Queued"
    }
}
 //     node('node1') 
  //    {
            //steps {
                // clone project and install dependencies
                git url: 'https://github.com/rameshrangaswamy/demoCICDjob.git', branch: 'master'
            //}

  }
  
  stage('checkout') 
    // This limits build concurrency to 1 per branch
  {
      node('node2')
      {
            //steps {
                 //coverage tests initialization script
                  //sh '''mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent \
                  //install -Dmaven.test.failure.ignore=true || true'''
                  git url: 'https://github.com/JeffLi1993/springboot-learning-example.git', branch: 'master'
            //}
    
    sh 'echo "test"'
  }
}
//
