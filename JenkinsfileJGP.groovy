pipeline {
    agent 'windows'

    stages {
        stage('build and deploy on Windows and Linux') {
            parallel {
                stage('windows') {
                    agent {
                        label 'windows'
                    }
                    stages {
                        stage('build') {
                            steps {
                            }
                        }
                        stage('deploy') {
                            when {
                            }
                            steps {
                            }
                        }
                    }
                }

                stage('linux') {
                    agent {
                        label 'linux'
                    }
                    stages {
                        stage('build') {
                            steps {
                            }
                        }
                        stage('deploy') {
                            when {
                            }
                            steps {
                            }
                        }
                    }
                }
            }
        }
    }
}
