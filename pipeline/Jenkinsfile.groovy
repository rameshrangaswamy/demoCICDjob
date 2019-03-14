node ('testnode') 
{

stage('stage1')
{
    //throttle(['test_1'])
    //{
        //node ('testnode') 
        //{
            checkout scm
       //} 
    //}
}
/*def mavenHome = tool(name: 'maven', type: 'maven')
withEnv([
            'MAVEN_HOME=' + mavenHome,
            "PATH=${mavenHome}/bin:${env.PATH}"
        ]){*/
                stage('stage2-build')
                {
                    throttle(['test_1'])
                    {
                        node ('testnode') 
                        {   
                            sh "echo $mavenHome"
                            sh "mvn clean package"
                        
                        }
                    }         
                }
            //}
stage('stage3')
{
    throttle(['test_1'])
    {
        node ('testnode') 
        {
            sh "touch one.java"
            sh "pwd"
        } 
    }
}

stage('stage4')
{
   // throttle(['test_1'])
   // {
        //node ('testnode') 
        //{
            sh "touch two.java"
            sh "pwd"
       //} 
    //}
}
}
