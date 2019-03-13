node ('testnode') 
{

stage('checkout')
{
    throttle(['test_1'])
    {
        node ('testnode') 
        {
            checkout scm
        } 
    }
}
def mavenHome = tool(name: 'maven', type: 'maven')
withEnv([
            'MAVEN_HOME=' + mavenHome,
            "PATH=${mavenHome}/bin:${env.PATH}"
        ]) {
                stage('build')
                {
                    throttle(['test_1'])
                    {
                        node ('testnode') 
                        {   
                            sh "echo $mavenHome"
                            sh "${mavenHome}/bin/mvn clean package"
                        
                        }
                    }         
                }
            }
}
