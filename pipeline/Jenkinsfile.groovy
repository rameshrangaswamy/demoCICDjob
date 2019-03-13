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
 def mvn_version = 'M2'
 withEnv( [
                "PATH+MAVEN=${tool mvn_version}/bin"
        ] ) 

    throttle(['test_1'])
    {
        node ('testnode') 
        {   
            sh '''mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true || true'''
        
        }
    }         
}
}
