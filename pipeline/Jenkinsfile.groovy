node ('node1')
{
    stage('stage1')
    {
            checkout scm     
    }

    stage('stage2')
    { 
                checkout scm   
    }

    stage('stage3')
    { 
                checkout scm   
    }
}
    stage('stage4')
    {
        throttle(['test_1'])
        {
            node ('node1') 
            {   
                git url: 'https://github.com/spring-projects/spring-petclinic.git', branch: 'master'
            
            }
        }         
    }
     stage('stage5')
    {
               throttle(['test_1'])
        {
            node ('node1') 
            { 
         sh "echo $M2_HOME"         
    }
}
    }
