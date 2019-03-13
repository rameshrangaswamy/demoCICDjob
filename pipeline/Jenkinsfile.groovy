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

stage('build')
{
    def mavenHome = tool(name: 'maven-3.6.0', type: 'maven')
    throttle(['test_1'])
    {
        node ('testnode') 
        {   
            sh '''mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true || true'''
        
        }
    }         
}
}
