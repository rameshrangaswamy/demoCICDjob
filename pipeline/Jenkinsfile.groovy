stage('checkout') 
{
    throttle(['test_1']) {
    node('node1') {
        
       git url: 'https://github.com/JeffLi1993/springboot-learning-example.git', branch: 'master'
     
        }
    }
}
