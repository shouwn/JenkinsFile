node {
    stage('git') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/shouwn/graduation.skhu.net-back.git'
    }
    stage('build') {
        sh "./gradlew clean build"
    }
    stage('deploy') {
        withEnv(['JENKINS_NODE_COOKIE=dontkill']){
            sh "sudo /app/nonstop/deploy.sh"
        }
    }
    stage('switch') {
        sh 'sudo /app/nonstop/switch.sh'
    }
}