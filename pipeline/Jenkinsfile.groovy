node ('testnode')
{
    stage('stage1')
    {
            checkout scm     
    }
}
    stage('stage2')
    {
        throttle(['test_1'])
        {
            node ('testnode') 
            {   
                checkout scm
            
            }
        }         
    }
    stage('stage3')
    {
        throttle(['test_1'])
        {
            node ('testnode') 
            {   
                checkout scm
            
            }
        }         
    }
node ('testnode')
  {
        stage('stage4')
    {
         sh "echo $M2_HOME"         
    }
  }
