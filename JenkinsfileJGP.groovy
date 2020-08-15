node {

    stage('Preparation') { // for display purposes

    }
    stage('Build') {
     
    }
    stage('Results') {

    }
    stage('run-parallel-branches') {
        steps {
            parallel(
            a: {
                echo "This is branch a"
            },
            b: {
                echo "This is branch b"
            }
            )
        }
}




}












/* groovylint-disable-next-line CompileStatic 
pipeline {
    agent any
          /* https://www.journaldev.com/33645/maven-commands-options-cheat-sheet  
    environment {
        gitURL = 'https://perezjuang:86100252807aA*@github.com/perezjuang/gabriel-coding-tips.git'
        branchDEV = 'dev'
        branchQA = 'qa'
        branchPRD = 'master'
        projectName = 'demojgpback'
    }

    stages {
        stage('GET-CODE') {
            steps {
                echo 'GET-CODE================================================'
                catchError(buildResult: 'SUCCESS', stageResult: 'SUCCESS')
            {
                    bat  '''
                              mkdir DEV
                             '''.stripIndent().trim()
            }

                dir ('DEV') {
                    git branch: env.branchPRD, url: env.gitURL
                }
            }
        }

        stage('TEST_UNIT') {
            steps {
                echo 'TEST ============================================'
                dir ('DEV') {
                    dir (env.projectName) {
                        bat  '''
                        mvn verify
                        '''.stripIndent().trim()
                    }
                }
            }
        }

        stage('COMPILE') {
            steps {
                echo '====================================================='
                echo 'COMPILE'
                echo '====================================================='
                dir ('DEV') {
                    dir (env.projectName) {
                        bat  '''
                      mvn package
                      mvn install
                     '''.stripIndent().trim()
                    }
                }
            }
        }

        stage('GENERATE_ARTIFACTS') {
            steps {
                parallel(
                    a: 'GENERATE_ARTIFACTS_GIT' {
                            //git branch: env.branchPRD, url: env.gitURL
                            dir ('DEV') {
                                dir (env.projectName) {
                            script {
                                def date = new Date()
                                println date
                                println date.format('yyyy/MM/dd_HH:mm', TimeZone.getTimeZone('IST'))
                                bat 'git config --global user.email "perezjuang@hotmail.com"'
                                bat 'git config --global user.name "perezjuang"'
                                bat 'git tag -a ' + date.format('yyyy_MM_dd_HH_mm', TimeZone.getTimeZone('IST')) + " -m 'Jenkins'"
                                bat 'git push ' + env.gitURL + ' --tags'
                            }
                                }
                            }
                },
                b: 'GENERATE_ARTIFACTS_BACKUP' {
                            echo 'world'
                }

                )
            }
        }


        stage('ACEPTED_FUNCTIONAL_AUTOMATICS_TEST') {
            steps {
                parallel(
                c: 'RUN_CUCUMBER_SELENIUM' {

                },

                d: 'GENERATE_METRICS' {
                            echo 'world'
                }

                )
            }
        }

        stage('DESPLOY_TEST_ENVIROMENT') {
            steps {
                parallel(e: 'DEV' {

                },
                f: 'QA' {
                            echo 'world'
                }

                )
            }
        }
        stage('DESPLOY_MANUAL_CHECK APROBACION') {
            steps {
                parallel(g: 'CHECK_APPROVER1' {
                       timeout(time: 2, unit: 'HOURS') {
                        input message: 'Approve Deploy?', ok: 'Yes'
                       }
                },

                h: 'CHECK_APPROVER2' {
                          timeout(time: 2, unit: 'HOURS') {
                            input message: 'Approve Deploy?', ok: 'Yes'
                          }
                }

                )
            }
        }

        stage('DESPLOY_PRODUCTION_ENVIROMENT') {
            steps {
                parallel(a: 'NODE1_DOCKER' {

                },
                i: 'NODE2_DOCKER' {
                            echo 'world'
                },
                 j: 'NODE3_DOCKER' {
                            echo 'world'
                }

                )
            }

        }
    }
}
*//