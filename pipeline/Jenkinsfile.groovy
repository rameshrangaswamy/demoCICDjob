/*tools
{
    maven 'maven'
}*/

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
    throttle(['test_1'])
    {
        node('node1') 
        {
            sh '''mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true || true'''
        
        }
    }         
}
