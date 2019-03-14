node ('testnode')
{
def mavenHome = tool(name: 'maven', type: 'maven')
withEnv([
            'MAVEN_HOME=' + mavenHome,
            "PATH=${mavenHome}/bin:${env.PATH}"
        ]){
                stage('checkout & build')
                {
                    throttle(['test_1'])
                    {
                        node ('testnode') 
                        {   
                            //sh "echo $mavenHome"
                            checkout scm
                                    sh "${mavenHome}/bin/mvn clean package"
                        
                        }
                    }         
                }
            }
}
