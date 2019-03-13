stage('stage1-checkout') 
 {  
    throttle(['test_1'])
    {
        node('node1') 
        {
            git url: 'https://github.com/rameshrangaswamy/demoCICDjob.git', branch: 'master'
        } 
    }
}

 //stage 2

 stage('stage2-checkout') 
 {  
    throttle(['test_1'])
    {
        node('node1') 
        {
            git url: 'https://github.com/JeffLi1993/springboot-learning-example.git', branch: 'master'
        } 
    }
 }
//
