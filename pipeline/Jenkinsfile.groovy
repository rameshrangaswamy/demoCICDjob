

stages('checkout')
{
    throttle(['test_1'])
    {
        node('node1') 
        {
            checkout scm
        } 
    }
}

stage('build')
{
    def mavenHome = tool(name: 'maven-3.6.0', type: 'maven');
    withEnv([
            'M2_HOME=' + mavenHome,
            "PATH=${mavenHome}/bin:${env.PATH}"
        ]) 

    throttle(['test_1'])
    {
        node('node1') 
        {   
            sh '''mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true || true'''
        
        }
    }         
}
