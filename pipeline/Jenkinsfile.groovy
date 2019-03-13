node ('testnode') 
{
            def mavenHome = tool(name: 'maven-3.6.0', type: 'maven')
            withEnv([
            'M2_HOME=' + mavenHome,
            "PATH=${mavenHome}/bin:${env.PATH}"
            ])
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
    throttle(['test_1'])
    {
        node ('testnode') 
        {   
            sh '''mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true || true'''
        
        }
    }         
}
}
