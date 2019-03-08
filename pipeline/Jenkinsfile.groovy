def mvnHome
mvnHome = tool 'maven'
stage('checkout') 
{
    throttle(['test_1']) {
    node('node1') {
                 git url: 'https://github.com/spring-projects/spring-boot.git', branch: 'master'
stage('build')
{
    sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
}
}
}
